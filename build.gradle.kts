plugins {
    id("java")
    id("war")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Servlet API
    providedCompile ("javax.servlet:javax.servlet-api:4.0.1")

    // Hibernate
    implementation ("org.hibernate.orm:hibernate-core:6.4.4.Final")

    // H2 Database
    implementation ("com.h2database:h2:2.2.224")
}

tasks.test {
    useJUnitPlatform()
}