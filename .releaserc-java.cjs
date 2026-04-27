// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  First run `make setup_semantic_release` to install the required dependencies.

  Using this config semantic-release will search for the latest tag
  evaluate all commits after that tag
  generate release notes and a version bump.
  It will commit these changes, push these changes, and publish a new version tag.

  This file requires a `--branches` option to function.
  This is to facilitate point releases if needed.

  `npx semantic-release --branches main`
*/

const fs = require("fs");

/**
 * Function to parse a simple properties file
 * @param {string} filePath - Path to the properties file
 * @returns {Object} Parsed properties as key-value pairs
 */
function parsePropertiesFile(filePath) {
  const content = fs.readFileSync(filePath, "utf8");
  const properties = {};

  content.split("\n").forEach((line) => {
    if (line && !line.startsWith("#") && line.includes("=")) {
      const [key, ...valueParts] = line.split("=");
      properties[key.trim()] = valueParts.join("=").trim();
    }
  });

  return properties;
}

// Read your project.properties file
const props = parsePropertiesFile("./project.properties");

// This project has several runtimes
// each one has files that need to be updated.
// We model all the files and the runtimes here in this structure
const Runtimes = {
  java: {
    "project.properties": {
      dependencies: [],
    },
  },
};

/**
 * @type {import('semantic-release').GlobalConfig}
 */
module.exports = {
  branches: ["main"],
  repositoryUrl: "git@github.com:aws/aws-database-encryption-sdk-dynamodb.git",
  tagFormat: "v${version}-java",
  plugins: [
    // Check the commits since the last release
    [
      "@semantic-release/commit-analyzer",
      {
        preset: "conventionalcommits",
        parserOpts: {
          noteKeywords: ["BREAKING-CHANGE", "BREAKING-CHANGES"],
        },
        presetConfig: {
          types: [
            { type: "feat", section: "Features" },
            { type: "fix", section: "Fixes" },
            { type: "chore", section: "Maintenance" },
            { type: "docs", section: "Maintenance" },
            { type: "revert", section: "Fixes" },
            { type: "style", hidden: true },
            { type: "refactor", hidden: true },
            { type: "perf", hidden: true },
            { type: "test", hidden: true },
          ],
        },
        releaseRules: [
          // go is in main but not in prod. Mentioning go as we do make PR scoping Go in this repo
          // python is not in main and not in prod. Mentioning python for defensive coding.
          { scope: "python", release: false },
          { scope: "dotnet", release: false },
          { scope: ".net", release: false },
          { scope: "net", release: false },
          { scope: "go", release: false },
          { scope: "rust", release: false },
        ],
      },
    ],
    // Based on the commits generate release notes
    [
      "@semantic-release/release-notes-generator",
      {
        preset: "conventionalcommits",
        parserOpts: {
          noteKeywords: ["JAVA-BREAKING-CHANGE", "JAVA-BREAKING-CHANGES", "JAVA BREAKING CHANGE", "JAVA BREAKING CHANGES"],
        },
        presetConfig: {
          types: [
            {
              type: "feat",
              scope: "dafny",
              section: "Features -- All Languages",
              hidden: false,
            },
            {
              type: "feat",
              scope: "java",
              section: "Features -- Java",
              hidden: false,
            },
            { type: "feat", scope: ".net", hidden: true },
            { type: "feat", scope: "net", hidden: true },
            { type: "feat", scope: "dotnet", hidden: true },
            { type: "feat", scope: "python", hidden: true },
            { type: "feat", scope: "go", hidden: true },
            { type: "feat", scope: "rust", hidden: true },
            {
              type: "fix",
              scope: "dafny",
              section: "Fixes -- All Languages",
              hidden: false,
            },
            {
              type: "fix",
              scope: "java",
              section: "Fixes -- Java",
              hidden: false,
            },
            { type: "fix", scope: ".net", hidden: true },
            { type: "fix", scope: "net", hidden: true },
            { type: "fix", scope: "dotnet", hidden: true },
            { type: "fix", scope: "python", hidden: true },
            { type: "fix", scope: "go", hidden: true },
            { type: "fix", scope: "rust", hidden: true },
            {
              type: "chore",
              scope: "dafny",
              section: "Maintenance -- All Languages",
              hidden: false,
            },
            {
              type: "chore",
              scope: "java",
              section: "Maintenance -- Java",
              hidden: false,
            },
            { type: "chore", scope: ".net", hidden: true },
            { type: "chore", scope: "net", hidden: true },
            { type: "chore", scope: "dotnet", hidden: true },
            { type: "chore", scope: "python", hidden: true },
            { type: "chore", scope: "go", hidden: true },
            { type: "chore", scope: "rust", hidden: true },
            {
              type: "chore",
              section: "Miscellaneous",
              hidden: false,
            },
            {
              type: "docs",
              scope: "dafny",
              section: "Maintenance -- All Languages",
              hidden: false,
            },
            {
              type: "docs",
              scope: "java",
              section: "Maintenance -- Java",
              hidden: false,
            },
            { type: "docs", scope: ".net", hidden: true },
            { type: "docs", scope: "dotnet", hidden: true },
            { type: "docs", scope: "python", hidden: true },
            { type: "docs", scope: "go", hidden: true },
            { type: "docs", scope: "rust", hidden: true },
            {
              type: "revert",
              scope: "dafny",
              section: "Fixes -- All Languages",
              hidden: false,
            },
            {
              type: "revert",
              scope: "java",
              section: "Fixes -- Java",
              hidden: false,
            },
            { type: "revert", scope: ".net", hidden: true },
            { type: "revert", scope: "dotnet", hidden: true },
            { type: "revert", scope: "python", hidden: true },
            { type: "revert", scope: "go", hidden: true },
            { type: "revert", scope: "rust", hidden: true },
            {
              type: "feat",
              section: "Features -- All Languages",
              hidden: false,
            },
            { type: "fix", section: "Fixes -- All Languages", hidden: false },
            {
              type: "chore",
              section: "Maintenance -- All Languages",
              hidden: false,
            },
            {
              type: "docs",
              section: "Maintenance -- All Languages",
              hidden: false,
            },
            {
              type: "revert",
              section: "Fixes -- All Languages",
              hidden: false,
            },
            {
              type: "style",
              section: "Miscellaneous -- All Languages",
              hidden: false,
            },
            {
              type: "refactor",
              section: "Miscellaneous -- All Languages",
              hidden: false,
            },
            {
              type: "perf",
              section: "Miscellaneous -- All Languages",
              hidden: false,
            },
            {
              type: "test",
              section: "Miscellaneous -- All Languages",
              hidden: false,
            },
            { type: "style", section: "Miscellaneous", hidden: false },
            { type: "refactor", section: "Miscellaneous", hidden: false },
            { type: "perf", section: "Miscellaneous", hidden: false },
            { type: "test", section: "Miscellaneous", hidden: false },
          ],
        },
      },
    ],
    // Update the change log with the generated release notes
    [
      "@semantic-release/changelog",
      {
        changelogFile: "CHANGELOG-java.md",
        changelogTitle: "# Changelog",
      },
    ],

    // Bump the various versions
    [
      "semantic-release-replace-plugin",
      {
        replacements: [
          // Update the version for all Gradle Java projects
          // Does not update the dependencies
          {
            files: Object.keys(Runtimes.java),
            from: "projectJavaVersion=.*",
            to: "projectJavaVersion=${nextRelease.version}",
            results: Object.keys(Runtimes.java).map(CheckResults),
            countMatches: true,
          },
        ],
      },
    ],
    // Commit and push changes the changelog and versions bumps
    [
      "@semantic-release/git",
      {
        assets: [
          "CHANGELOG-java.md",
          ...Object.values(Runtimes).flatMap((r) => Object.keys(r)),
        ],
        message:
          "chore(release): ${nextRelease.version} \n\n${nextRelease.notes}",
      },
    ],
  ],
};

function CheckResults(file) {
  return {
    file,
    hasChanged: true,
    numMatches: 1,
    numReplacements: 1,
  };
}
