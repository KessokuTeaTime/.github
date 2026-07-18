> [!CAUTION]
> Workflows under this directory should be called remotely.

`build.yml` and `release.yml` accept an optional `java-version` input. It
defaults to Java 21 for existing callers; projects that target a newer Java
release should pass that version explicitly.

The workflows use the Gradle wrapper, validate it, and cache dependencies with
the official `gradle/actions/setup-gradle` action.
