
  
## Running Petclinic tests locally  

### Install JDK 21 or higher

Please refer to official [Installation guide page](https://docs.oracle.com/en/java/javase/22/install/overview-jdk-installation.html)

 -  Make sure to verify/configure the JAVA_HOME environment variable.
 - Add the JDK’s \bin directory to the PATH of the OS.
 - Issue a  _java -version_  command to ensure the Java 21 install succeeded.
  
### Install Maven

from the [official website](https://maven.apache.org/download.cgi)

[Official instalation guide](https://maven.apache.org/install.html) 

[Extended instruction](https://www.baeldung.com/install-maven-on-windows-linux-mac)

### Alternatively: Intellij IDEA

If you have [Intellij IDEA](https://www.jetbrains.com/idea/) installed, latest Maven version and JDK will automatically be installed on your machine.
  
### With maven command line  

 1. Clone repository: <br>
 ```
git clone https://github.com/spring-petclinic/spring-petclinic-rest.git  
```  
2. Start Petclinic application:<br>
 ```
cd spring-petclinic-rest  
mvn spring-boot:run  
```
- You can then access Petclinic Swagger here: [http://localhost:9966/petclinic/]
3. After application starts, run tests with maven:
 ```
mvn clean test  
```
4. To see execution report after tests are completed, initiate allure service:
```
mvn allure:serve 
```
5. Terminate allure service and application in console (Ctrl+C)

Note: currently generation of static allure report with plugin use is not working due to configuration issue.


