# 项目模板

[spring项目](#spring模板生成)

[maven项目](#maven模板生成)



# spring模板生成

[Spring Initializr](https://start.spring.io/)

    type `Maven Project` / `Gradle Project`
    language  `Java` / `Kotlin` / `Groovy`
    bootVersion  `2.0.5` / `1.5.16`
    lib  min 最小依赖 max 全部依赖
 
	
    Generate a `Gradle Project` with `Groovy` and Spring Boot `2.0.5`  gradle-groovy-boot2
    Generate a `Gradle Project` with `Java` and Spring Boot `2.0.5`  gradle-java-boot2
    Generate a `Gradle Project` with `Kotlin` and Spring Boot `2.0.5`  gradle-kotlin-boot2
    Generate a `Maven Project` with `Java` and Spring Boot `1.5.16`  maven-java-boot1
    Generate a `Maven Project` with `Java` and Spring Boot `1.5.16`  maven-java-boot1-all
    Generate a `Maven Project` with `Java` and Spring Boot `2.0.5`  maven-java-boot2
    Generate a `Maven Project` with `Java` and Spring Boot `2.0.5`  maven-java-boot2-all
    

# maven模板生成

[Maven – Introduction to Archetypes](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html)

    # mvn archetype:generate
    ...
    ...
    ...
    2258: remote -> xyz.luan.generator:xyz-generator (-)
    Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 1265:


生成官方的11个模板
		
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-archetype      -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-archetype -DarchetypeVersion=1.3
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-j2ee-simple    -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-j2ee-simple -DarchetypeVersion=1.3
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-plugin         -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-plugin -DarchetypeVersion=1.3
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-plugin-site    -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-plugin-site -DarchetypeVersion=1.3
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-portlet        -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-portlet -DarchetypeVersion=1.3
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-quickstart     -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.3
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-simple         -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-simple -DarchetypeVersion=1.3	
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-site           -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-site -DarchetypeVersion=1.3
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-site-simple    -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-site-simple -DarchetypeVersion=1.3
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-site-skin      -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-site-skin -DarchetypeVersion=1.3
    mvn archetype:generate -B -DgroupId=com.xy2401.examples.project.maven.archetypes -Dversion=1.0-SNAPSHOT -Dpackage=com.xy2401.examples  -DartifactId=maven-archetype-webapp         -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.3

