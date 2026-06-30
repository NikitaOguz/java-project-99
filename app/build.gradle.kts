buildscript {
	repositories {
		mavenCentral()
	}
}
plugins {
	application
	checkstyle
	jacoco
	id("org.springframework.boot") version "3.5.6"
	id("io.spring.dependency-management") version "1.1.7"
	id("io.freefair.lombok") version "8.6"
	id("org.sonarqube") version "7.3.1.8318"
	id("io.sentry.jvm.gradle") version "6.13.0"
}

group = "hexlet.code"
version = "0.0.1-SNAPSHOT"

application {
	mainClass.set("hexlet.code.Application")
}

tasks.test {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)

	reports {
		xml.required.set(true)
		html.required.set(true)
	}
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation("org.springframework.security:spring-security-test")

	annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")

	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	implementation("org.instancio:instancio-junit:5.0.2")
	implementation("net.javacrumbs.json-unit:json-unit-assertj:4.0.0")
	implementation("net.datafaker:datafaker:2.4.3")

	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	implementation("org.mapstruct:mapstruct:1.6.3")
	implementation("io.sentry:sentry-spring-boot-starter-jakarta:8.46.0")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter")

	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
sentry {
	// Generates a JVM (Java, Kotlin, etc.) source bundle and uploads your source code to Sentry.
	// This enables source context, allowing you to see your source
	// code as part of your stack traces in Sentry.
	includeSourceContext = true

	org = "java-project-99"
	projectName = "java"
	authToken = System.getenv("SENTRY_AUTH_TOKEN")
}
sonar {
	properties {
		property("sonar.projectKey", "NikitaOguz_java-project-99")
		property("sonar.organization", "nikitoguzkov")
	}
}
