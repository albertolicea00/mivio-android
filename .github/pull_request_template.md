## Description
Provide a brief summary of the changes introduced by this Pull Request, including the problem solved and the implementation details.

## Related Issues
Closes # (issue number)

## Type of Change
- [ ] Bug fix (non-breaking change which fixes an issue)
- [ ] New feature (non-breaking change which adds functionality)
- [ ] Breaking change (fix or feature that would cause existing functionality to not work as expected)
- [ ] Refactoring (no functional changes, code cleanup)
- [ ] Documentation update

## Affected Areas
Select the parts of the codebase this change affects:
- [ ] Core / Scanner Engine (`media-scanner`)
- [ ] Database / Storage Configuration (`database`)
- [ ] Network API Integration (`network`)
- [ ] User Interface (`ui` / Jetpack Compose Components)
- [ ] Playback & Media Player Module (ExoPlayer)
- [ ] Project Build Configuration (Gradle scripts, plugins, dependencies)

## Verification Plan
Describe the tests that you ran to verify your changes. Provide instructions so we can reproduce.

### Automated Tests
- [ ] Android Local Unit Tests
  - Run command: `./gradlew test`
- [ ] Android Instrumented Tests
  - Run command: `./gradlew connectedAndroidTest`

### Manual Verification
- [ ] Tested on Android Emulator (specify Android version and API level)
- [ ] Tested on physical device (specify device model and Android version)
- [ ] Verified UI layouts against light/dark themes and dynamic themes (Material You)

## Checklist
- [ ] My code follows the code style guidelines of this project (Kotlin Style Guide)
- [ ] My commits follow the [Conventional Commits](https://www.conventionalcommits.org/) standards
- [ ] All technical terms and discussions are in English
- [ ] I have performed a self-review of my own code
- [ ] I have commented my code, particularly in hard-to-understand areas
- [ ] I have made corresponding changes to the documentation
- [ ] My changes generate no new compilation warnings or lint errors
- [ ] New and existing unit tests pass locally with my changes
