plugins {
    id("java")
    id("io.qameta.allure") version "2.9.6"
}

group = "ru.kion"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("junit:junit:4.13.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    testImplementation("org.assertj:assertj-core:3.21.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.2.0")
    testImplementation("org.seleniumhq.selenium:selenium-java:2.41.0")
    testImplementation("io.qameta.atlas:atlas-webdriver:1.8.0")
    testImplementation("io.qameta.allure:allure-junit5:2.12.1")
    testImplementation("io.qameta.allure:allure-commandline:2.12.1")
    testImplementation("io.qameta.allure:allure-java-commons:2.12.1")
    testImplementation("io.qameta.allure:allure-assertj:2.12.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}