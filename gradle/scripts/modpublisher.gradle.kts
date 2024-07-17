plugins {
    id("com.hypherionmc.modutils.modpublisher") version("2.1.0")
}

class Display {
    lateinit var name: String
    lateinit var loader: String
    lateinit var version: String
}

publisher {
    apiKeys {
        modrinth(System.getenv("MODRINTH_TOKEN"))
        curseforge(System.getenv("CURSEFORGE_TOKEN"))
    }

    modrinthID.set(libs.versions.id.modrinth)
    curseID.set(libs.versions.id.curseforge)

    versionType.set(libs.versions.modpublisher.version.type)
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

    val display = ext.get("display") as Display

    displayName.set("${display.name} ${libs.versions.mod.get()} for ${display.loader} ${display.version}")

    artifact.set(tasks.getByName("remapJar"))
    addAdditionalFile(tasks.getByName("remapSourcesJar"))

    changelog.set(file("CHANGELOG.md"))
}