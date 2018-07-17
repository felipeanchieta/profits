import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    java
    kotlin("jvm") version "1.2.51"
    kotlin("plugin.spring") version "1.2.51"
}

application {
    mainClassName = "io.github.felipeanchieta.profits.Boot"
}

group = "io.github.felipeanchieta"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))

    compile("ch.qos.logback:logback-classic:1.2.3")
    compile("com.google.code.gson:gson:2.8.5")
    compile("org.springframework:spring-context:5.0.6.RELEASE")
    compile("redis.clients:jedis:2.9.0")
    compile("ro.pippo:pippo-core:1.9.0")
    compile("ro.pippo:pippo-controller:1.9.0")
    compile("ro.pippo:pippo-gson:1.9.0")
    compile("ro.pippo:pippo-jetty:1.9.0")
    compile("ro.pippo:pippo-test:1.9.0")

    testCompile("junit:junit:4.12")
    testCompile("org.mockito:mockito-core:2.18.3")
    testCompile("com.nhaarman:mockito-kotlin:1.5.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}