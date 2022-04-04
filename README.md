# cb-gw-alerts
Gateway Alert microservice

Building Project
* Click  New->Project in IntelliJ
* Click "Spring Initializr" and click Language: Java,Type: Gradle,Project SDK:17 Eclipse Temurin version 17.0.1,Java:8,Package: War and click Next
* In Dependencies,scroll down in "Developer Tools" and check Spring Boot DevTools,Lombok,in "Web" check Spring Web,in "SQL" check Spring Data JPA,MySQL Driver,in "I/O" check Java Mail Sender, in "Template Engines" check Apache Freemarker
* Now check the build.gradle and add the following dependencies to make sure freemarker and spring-boot-starter-mail versions are up-to-date 
    implementation 'org.springframework.boot:spring-boot-starter-freemarker:2.6.5'
    implementation 'org.springframework.boot:spring-boot-starter-mail:2.2.0.RELEASE'
* Before running make sure docker is running properly
* Go to application.properites and add the properties to run the application properly. 

