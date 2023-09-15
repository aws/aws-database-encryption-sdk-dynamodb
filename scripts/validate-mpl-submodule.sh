#!/bin/bash

# A tiny script to verify that the MPL submodule points to a valid release,
# and that this release matches the MPL dependency defined in this repo's gradle projects.
# Run this script from the root of the repo.

# Get the MPL version used in DB-ESDK's build.gradle
DBESDK_MPL_VERSION=$(cat project.properties | grep "mplDependencyJavaVersion" | sed 's/^.*=//')

# Get version from tag of HEAD in MaterialProviders submodule
cd submodules/MaterialProviders
MPL_SUBMODULE_VERSION=$(git tag --points-at HEAD | sed 's/v//');
if [ "$MPL_SUBMODULE_VERSION" == "" ]; then
  echo "Invalid MaterialProviders submodule. The submodule must be set to a commit that is tagged as a release.";
  exit 1;
fi

# Validate this version matches the version used in the DB-ESDK's build.gradle
if [ "$DBESDK_MPL_VERSION" != "$MPL_SUBMODULE_VERSION" ]; then
  echo "Invalid MaterialProviders submodule. Mismatch between the submodule version ("$MPL_SUBMODULE_VERSION") and the version of the configured dependency in project.properties ("$DBESDK_MPL_VERSION").";
  exit 1;
fi
