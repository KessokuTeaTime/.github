publisher {
    apiKeys {
        modrinth(System.getenv("MODRINTH_TOKEN"))
        curseforge(System.getenv("CURSEFORGE_TOKEN"))
    }

    modrinthID.set(libs.versions.id.modrinth)
    curseID.set(libs.versions.id.curseforge)

    versionType.set("release")
    projectVersion.set(project.version.toString())
    gameVersions.set(listOf("1.20"))
    loaders.set(listOf("fabric", "quilt"))
    curseEnvironment.set("both")

    modrinthDepends.required("fabric-api")
    modrinthDepends.optional()
    modrinthDepends.embedded()

    curseDepends.required("fabric-api")
    curseDepends.optional()
    curseDepends.embedded()

    displayName.set("${display.name} ${libs.versions.mod.get()} for ${display.loader} ${display.version}")

    artifact.set(tasks.remapJar)
    addAdditionalFile(tasks.remapSourcesJar)

    changelog.set(file("CHANGELOG.md"))
}