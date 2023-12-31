plugins {
    `java-library`
}

group = "cg.vsu.render.mathlib"
version = "2.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        with(attributes) {
            this["Automatic-Module-Name"] = "cg.vsu.math"
        }
    }
}
