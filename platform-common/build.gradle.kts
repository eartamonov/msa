import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	//id("org.springframework.boot")
	id("io.spring.dependency-management")
	id("org.asciidoctor.convert")
	kotlin("jvm")
	kotlin("plugin.spring")
}

group = "com.haulmont"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

val snippetsDir by extra { file("build/generated-snippets") }
extra["springCloudVersion"] = "Hoxton.SR8"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-hateoas")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.springframework.cloud:spring-cloud-starter")
	implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j")
	//developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("io.r2dbc:r2dbc-h2")
	runtimeOnly("io.r2dbc:r2dbc-postgresql")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.security:spring-security-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot:spring-boot-dependencies:2.3.3.RELEASE")
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.test {
	outputs.dir(snippetsDir)
}

tasks.asciidoctor {
	inputs.dir(snippetsDir)
	dependsOn(tasks.test)
}
