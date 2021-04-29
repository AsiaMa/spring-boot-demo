import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
}

group = "com.oasis"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    // kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // spring web
    implementation("org.springframework.boot:spring-boot-starter-web")
    // mybatis-plus
    implementation("com.baomidou:mybatis-plus-boot-starter:3.4.2")
    // mysql driver
    runtimeOnly("mysql:mysql-connector-java")
    // print sql log
    implementation("p6spy:p6spy:3.9.1")
    // mock
    testImplementation("io.mockk:mockk:1.10.4")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
