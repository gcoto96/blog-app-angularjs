# blog-app-angularjs
Sample Blog App - Fun with Angularjs and Spring Boot

### Tech Stack
Component         | Technology
---               | ---
Frontend          | [Angularjs]
Backend (REST)    | [SpringBoot](Java)
Security          | Basic Auth(Spring Security Basic Auth)
REST Documentation| [Swagger UI / Springfox](https://github.com/springfox/springfox) and [ReDoc](https://github.com/Rebilly/ReDoc)
In Memory DB      | H2 
Persistence       | JPA (Using Spring Data)
Client Build Tools| [angular-cli](https://github.com/angular/angular-cli), Webpack, npm
Server Build Tools| Maven(Java) or Gradle

## Folder Structure
```bash
PROJECT_FOLDER
│  README.md
│  pom.xml           
│  bower.json
└──[src]      
│  └──[main]      
│     └──[java]      
│     └──[resources]
│        │  application.properties # springboot cofigurations
│        │  schema.sql  # Contains DB Script         
│        │  data.sql    # seed data
│        └──[static]    # keep all html,css etc, resources that needs to be exposed to user without security
│
└──[target]              #Java build files, auto-created after running java build: mvn install
│  └──[classes]
│     └──[public]
│            
│                       
│
```

## Prerequisites
Ensure you have this installed before proceeding further
- Java 7
- Maven 3.3.9+ 
- Bower  

## About
Sample blog app using Angularjs + Spring Boot

* Build
  * How to build all in one app that includes (database, sample data, RESTfull API, Auto generated API Docs, frontend and security)


### Install Frontend
```bash
# Navigate to root folder
Add .bowerrc file with following info
{
  "directory": "src/main/resources/static/bower_components",
  "registry": "http://bower.herokuapp.com",
  "proxy":""  - Add proxy if inside corp network
}
bower install (This will put all the angular modules in bower components)


### Install Backend (SpringBoot Java)
```bash

# Maven Build : Navigate to the root folder where pom.xml is present 
mvn clean install  && java -jar target/blog-app-0.1.0.jar

```

### Start the API and WebUI server
```bash
# Start the server (8140)
# port and other configurations for API servere is in [./src/main/resources/application.properties](/src/main/resources/application.properties) file


### Accessing Application
Cpmponent         | URL                                      | Credentials
---               | ---                                      | ---
Frontend          |  http://localhost:9119                   | `demo/demo`
H2 Database       |  http://localhost:9119/h2-console        |  Driver:`org.h2.Driver` <br/> JDBC URL:`jdbc:h2:mem:demo` <br/> User Name:`sa`

