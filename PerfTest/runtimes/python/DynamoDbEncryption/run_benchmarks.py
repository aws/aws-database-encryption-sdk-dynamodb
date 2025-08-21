#!/usr/bin/env python3
"""Run performance benchmarks for DDBEC v3 vs DB-ESDK v4."""

import argparse
import json
import os
import subprocess
import sys
from datetime import datetime
from pathlib import Path

import pandas as pd
from tabulate import tabulate


def run_pytest_benchmarks(args):
    """Run pytest benchmarks with specified options."""
    cmd = [
        sys.executable,
        "-m",
        "pytest",
        "-v",
        "--benchmark-only",
        "--benchmark-json=benchmark_results.json",
        "--benchmark-autosave",
    ]

    # Add markers based on version
    if args.version:
        if args.version == "v3":
            cmd.append("-m v3")
        elif args.version == "v4":
            cmd.append("-m v4")

    # Add specific test filter
    if args.test:
        cmd.append(f"-k {args.test}")

    # Add custom pytest options
    if args.pytest_args:
        cmd.extend(args.pytest_args.split())

    print(f"Running command: {' '.join(cmd)}")
    result = subprocess.run(cmd, capture_output=True, text=True)

    if result.returncode != 0:
        print(f"Error running benchmarks:\n{result.stderr}")
        sys.exit(1)

    print(result.stdout)

    return "benchmark_results.json"


def parse_benchmark_results(json_file):
    """Parse pytest-benchmark JSON results."""
    with open(json_file, "r") as f:
        data = json.load(f)

    results = []
    for benchmark in data["benchmarks"]:
        # Parse group name properly for multi-part provider names
        group_parts = benchmark["group"].split("-")
        version = "v3" if "v3" in benchmark["group"] else "v4"

        # Handle multi-part provider names
        if version == "v3":
            # v3 format: "v3-{provider}-{operation}"
            if len(group_parts) >= 4 and group_parts[1] == "most" and group_parts[2] == "recent":
                provider = "most-recent"
                operation = group_parts[3]
            else:
                provider = group_parts[1]
                operation = group_parts[2]
        else:
            # v4 format: "v4-{provider}-{operation}" where provider might be "raw-aes"
            if len(group_parts) >= 4 and group_parts[1] == "raw" and group_parts[2] == "aes":
                provider = "raw-aes"
                operation = group_parts[3]
            else:
                provider = group_parts[1]
                operation = group_parts[2]

        result = {
            "name": benchmark["name"],
            "group": benchmark["group"],
            "version": version,
            "provider": provider,
            "operation": operation,
            "data_type": benchmark["params"]["data_type"],
            "min": benchmark["stats"]["min"],
            "max": benchmark["stats"]["max"],
            "mean": benchmark["stats"]["mean"],
            "stddev": benchmark["stats"]["stddev"],
            "median": benchmark["stats"]["median"],
            "ops": benchmark["stats"]["ops"],
            "rounds": benchmark["stats"]["rounds"],
        }

        # Add size information if available
        if "extra_info" in benchmark:
            result.update(benchmark["extra_info"])

        results.append(result)

    return pd.DataFrame(results)


def generate_comparison_report(df, output_format="console"):
    """Generate comparison report between v3 and v4."""
    # Group by operation type and data type
    comparison_data = []

    for operation in ["encrypt", "decrypt"]:
        for data_type in df["data_type"].unique():
            # Filter data
            v3_data = df[(df["version"] == "v3") & (df["operation"] == operation) & (df["data_type"] == data_type)]
            v4_data = df[(df["version"] == "v4") & (df["operation"] == operation) & (df["data_type"] == data_type)]

            # Compare each provider type
            providers = {
                "aes": ("aes", "raw-aes"),
                "kms": ("kms", "kms"),
                "most-recent/hierarchy": ("most-recent", "hierarchy"),
            }

            for provider_name, (v3_provider, v4_provider) in providers.items():
                v3_row = v3_data[v3_data["provider"] == v3_provider]
                v4_row = v4_data[v4_data["provider"] == v4_provider]

                if not v3_row.empty and not v4_row.empty:
                    v3_mean = v3_row["mean"].values[0]
                    v4_mean = v4_row["mean"].values[0]

                    # Convert to milliseconds for better readability
                    v3_mean_ms = v3_mean * 1000
                    v4_mean_ms = v4_mean * 1000
                    diff_ms = v4_mean_ms - v3_mean_ms

                    comparison = {
                        "Operation": operation.upper(),
                        "Data Type": data_type,
                        "Provider": provider_name,
                        "DDBEC(v3) Mean (ms)": f"{v3_mean_ms:.3f}",
                        "DB ESDK(v4) Mean (ms)": f"{v4_mean_ms:.3f}",
                        "Difference (ms)": f"{diff_ms:.3f}",
                        "DB ESDK(v4) vs DDBEC(v3) (%)": f"{((v4_mean / v3_mean) - 1) * 100:.2f}%",
                    }

                    # Add size information based on operation type
                    # For encrypt: show plaintext size, for decrypt: show encrypted size
                    size_column = "original_size_bytes" if operation == "encrypt" else "encrypted_size_bytes"

                    if size_column in v3_row.columns and not pd.isna(v3_row[size_column].values[0]):
                        comparison["DDBEC(v3) Size (bytes)"] = v3_row[size_column].values[0]
                    if size_column in v4_row.columns and not pd.isna(v4_row[size_column].values[0]):
                        comparison["DB ESDK(v4) Size (bytes)"] = v4_row[size_column].values[0]

                    comparison_data.append(comparison)

    comparison_df = pd.DataFrame(comparison_data)

    if output_format == "console":
        print("\n" + "=" * 80)
        print("PERFORMANCE COMPARISON: DDBEC v3 vs DB-ESDK v4")
        print("=" * 80 + "\n")
        print(tabulate(comparison_df, headers="keys", tablefmt="grid", showindex=False))
        print("\n" + "=" * 80)
        print("SUMMARY:")
        print("- Negative percentages indicate v4 is faster than v3")
        print("- Positive percentages indicate v4 is slower than v3")
        print("=" * 80 + "\n")

    return comparison_df


def save_results(df, comparison_df, output_dir):
    """Save results in multiple formats."""
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")

    # Create output directory
    output_path = Path(output_dir)
    output_path.mkdir(exist_ok=True)

    # Save raw results
    df.to_csv(output_path / f"raw_results_{timestamp}.csv", index=False)
    df.to_json(output_path / f"raw_results_{timestamp}.json", orient="records", indent=2)

    # Save comparison
    comparison_df.to_csv(output_path / f"comparison_{timestamp}.csv", index=False)
    comparison_df.to_json(output_path / f"comparison_{timestamp}.json", orient="records", indent=2)

    # Generate HTML report
    html_content = f"""
    <html>
    <head>
        <title>DDBEC v3 vs DB-ESDK v4 Performance Report</title>
        <style>
            body {{ font-family: Arial, sans-serif; margin: 20px; }}
            h1 {{ color: #333; }}
            table {{ border-collapse: collapse; width: 100%; }}
            th, td {{ border: 1px solid #ddd; padding: 8px; text-align: left; }}
            th {{ background-color: #f2f2f2; }}
            tr:nth-child(even) {{ background-color: #f9f9f9; }}
            .negative {{ color: green; }}
            .positive {{ color: red; }}
        </style>
    </head>
    <body>
        <h1>Performance Comparison Report</h1>
        <p>Generated: {datetime.now().strftime("%Y-%m-%d %H:%M:%S")}</p>
        {comparison_df.to_html(index=False, classes="comparison-table")}
    </body>
    </html>
    """

    with open(output_path / f"report_{timestamp}.html", "w") as f:
        f.write(html_content)

    print(f"\nResults saved to: {output_path}")
    print(f"- Raw results: raw_results_{timestamp}.csv/json")
    print(f"- Comparison: comparison_{timestamp}.csv/json")
    print(f"- HTML report: report_{timestamp}.html")


def main():
    """Main entry point."""
    parser = argparse.ArgumentParser(description="Run performance benchmarks for DDBEC v3 vs DB-ESDK v4")
    parser.add_argument(
        "--version",
        choices=["v3", "v4", "all"],
        default="all",
        help="Which version to benchmark (default: all)",
    )
    parser.add_argument(
        "--test",
        help="Run specific test pattern (e.g., 'aes' or 'encrypt')",
    )
    parser.add_argument(
        "--output-dir",
        default="benchmark_results",
        help="Directory to save results (default: benchmark_results)",
    )
    parser.add_argument(
        "--no-save",
        action="store_true",
        help="Don't save results to files",
    )
    parser.add_argument(
        "--pytest-args",
        help="Additional pytest arguments",
    )

    args = parser.parse_args()

    # Run benchmarks
    json_file = run_pytest_benchmarks(args)

    # Parse results
    df = parse_benchmark_results(json_file)

    # Generate comparison report
    if args.version == "all" or not args.version:
        comparison_df = generate_comparison_report(df)

        # Save results
        if not args.no_save:
            save_results(df, comparison_df, args.output_dir)
    else:
        # Just show the results for single version
        print("\n" + "=" * 80)
        print(f"BENCHMARK RESULTS: {args.version.upper()}")
        print("=" * 80 + "\n")
        print(tabulate(df, headers="keys", tablefmt="grid", showindex=False))

    # Clean up
    if os.path.exists(json_file):
        os.remove(json_file)


if __name__ == "__main__":
    main()
