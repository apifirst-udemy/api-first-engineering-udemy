# api-first-engineering-udemy

## Commands


mvn archetype:generate -DgroupId=com.rsouza01 -DartifactId=apifirst-sb-server -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.rsouza01 -DartifactId=apifirst-api -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.rsouza01 -DartifactId=apifirst-server -DinteractiveMode=false

## Build commands

* Build
mvn clean install {-Dmaven.test.skip=true}
mvn clean install -f ./apifirst-server/pom.xml -Dmaven.test.skip=true


* Full build + tests
mvn test-compile -f "/workspaces/api-first-engineering-udemy/src/pom.xml"

* Start the server
mvn spring-boot:run -f "./src/apifirst-server/pom.xml"


# Remote
git remote set-url origin https://github.com/apifirst-udemy/api-first-engineering-udemy.git

# Dev Container

* https://docs.github.com/en/codespaces/setting-up-your-project-for-codespaces/adding-a-dev-container-configuration/setting-up-your-java-project-for-codespaces

# References

* https://www.udemy.com/course/api-first-engineering-with-spring-boot
* https://www.baeldung.com/maven-multi-module
* https://www.baeldung.com/spring-boot-rest-client-swagger-codegen
* https://github.com/Redocly/create-openapi-repo?tab=readme-ov-file


# Course Progress

Continue from:
70. Customer Entity