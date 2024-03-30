plugins {
    id("java-library")
    id("maven-publish")
    id("xyz.jpenilla.run-paper") version "2.2.0"
}

group = "me.dalynkaa.bedwars"
version = "1.0-SNAPSHOT"

allprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "java-library")

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    repositories {
        mavenCentral()
        maven {url= uri("https://dalynkaa.me/repository/maven-snapshots/")}
        maven(url = "https://repo.smrt-1.com/releases")
        maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    }
}
val nexusUser = rootProject.findProperty("nexusUser")
val nexusPassword = rootProject.findProperty("nexusPassword")
subprojects {
    version = rootProject.version
    group = rootProject.group.toString()+".${project.name}"
    publishing {
        publications.create<MavenPublication>("maven${project.name}") {
            groupId = project.group.toString()
            artifactId = "${rootProject.name}-${project.name}".lowercase()
            version = project.version.toString()
            from(components["java"])
        }

        val isSnapshot = rootProject.version.toString().endsWith("SNAPSHOT")
        val repoUrl = if (isSnapshot) {
            "https://dalynkaa.me/repository/maven-snapshots/"
        } else {
            "https://dalynkaa.me/repository/maven-releases/"
        }
        if (nexusUser!=null && nexusPassword!=null) {
            repositories.maven(url = uri(repoUrl)) {
                name = "maven"
                credentials {
                    username = nexusUser.toString()
                    password = nexusPassword.toString()
                }
            }
        }
    }
}

dependencies {
    implementation(project(":api"))
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")

}
tasks {
    runServer {
        downloadPlugins {
            url("https://github.com/plasmoapp/plasmo-voice/releases/download/2.1.0-SNAPSHOT/PlasmoVoice-Paper-2.1.0+b0f5364-SNAPSHOT.jar")
        }
        minecraftVersion("1.20.1")
    }
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

