plugins {
	application
	checkstyle
	jacoco
	id("org.springframework.boot") version "4.1.0"
	id("io.spring.dependency-management") version "1.1.7"
	id("io.freefair.lombok") version "8.14.2"
	id("org.sonarqube") version "7.3.1.8318"
	id("io.sentry.jvm.gradle") version "6.13.0"
}

group = "hexlet.code"
version = "0.0.1-SNAPSHOT"

application {
	mainClass.set("hexlet.code.Application")
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")

	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

	implementation("org.mapstruct:mapstruct:1.6.3")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")

	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	implementation("org.instancio:instancio-junit:5.0.2")
	implementation("net.javacrumbs.json-unit:json-unit-assertj:4.0.0")
	implementation("net.datafaker:datafaker:2.4.3")

	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
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

sentry {
	includeSourceContext = System.getenv("SENTRY_AUTH_TOKEN") != null
	org = "java-project-99"
	projectName = "java"
	authToken = System.getenv("SENTRY_AUTH_TOKEN")
}

tasks.named("sentryUploadSourceBundleJava") {
	onlyIf { System.getenv("SENTRY_AUTH_TOKEN") != null }
}

sonar {
	properties {
		property("sonar.projectKey", "NikitaOguz_java-project-99")
		property("sonar.organization", "nikitoguzkov")
		property(
			"sonar.coverage.exclusions",
			"**/dto/**,**/model/**,**/Application.java"
		)
	}
}