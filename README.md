# cb-gw-alerts
Gateway Alert microservice Pre-requisites

**Pre-requisites**

* Java version 1.8.0_202
* MySQL version 8.0.21
* Spring Boot version 2.6.4
* Freemarker version 2.6.5
* Mail version 2.2.0

**Setup**
* Clone this repo.
* Verify that Language: Java,Type: Gradle,Project SDK:17 Eclipse Temurin version 17.0.1,Java:8,Package: War 
* Spring Boot DevTools,Lombok, Spring Web, JPA,MySQL Driver,Java Mail Sender, Apache Freemarker are the dependencies that are being used.
* Check the build.gradle and make sure freemarker and spring-boot-starter-mail versions are up-to-date 
    implementation 'org.springframework.boot:spring-boot-starter-freemarker:2.6.5'
    implementation 'org.springframework.boot:spring-boot-starter-mail:2.2.0.RELEASE'
* Before running make sure docker is running properly
* Go to application.properites and add the properties to run the application properly. 

**Configuring Email**

Add the following details to Application.property for email service to work
* spring.mail.host=your-host-name
* spring.mail.port=your-port
* spring.mail.username=your-username
* spring.mail.password=your-password
* spring.mail.to=recipients-mail-separatedByComma
* spring.mail.from=sender-email
* spring.mail.subject=subject
* spring.mail.name=name

**Confluence Link-** https://mychargebee.atlassian.net/wiki/spaces/~914783137/pages/2765750340/Gateway+Transaction+Payment+Source+Alert


