# blog-app-angularjs
Sample Blog App - Fun with Angularjs and Spring Boot

### Tech Stack
Component         | Technology
---               | ---
Frontend          | [Angularjs]
Backend (REST)    | [SpringBoot](Java)
Security          | Basic Auth(Spring Security Basic Auth)
In Memory DB      | H2 
Persistence       | JPA (Using Spring Data)
Client Build Tools| Bower ,gulp
Server Build Tools| Maven(Java)

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

* Features Status
  a. Ability to register to the blogging portal and create a
  personal blogging space  - WIP
  b. Ability to publish multiple blog posts to the blogging space - Implemented
   i. Blog content should contain a title and a description - Implemented
  c. Ability to anonymously view other blog posts - Implemented
  d. Ability to login and comment on other’s blog posts - Implemented

  Note: One single user is available user:users and password:password now and once it logs in it can perform b and d tasks above.
        If not logged in then c task holds good.

### REST Endpoints

Header Info : Basic Auth
- /user GET - Login
- /posts POST - Add new post when logged in
- /posts/id GET - Get a post
- /posts GET - Get all posts
- /comments POST - Posts a comment


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
mvn clean 1.5 T install  && java -jar target/blog-app-0.1.0.jar

note:1.5 T to speed up the install
```

### Start the API and WebUI server
```bash
# Start the server (9119)
# port and other configurations for API servere is in [./src/main/resources/application.properties](/src/main/resources/application.properties) file


### Accessing Application
Component         | URL                                      | Credentials
---               | ---                                      | ---
Frontend          |  http://localhost:9119                   | `user/password`
H2 Database       |  http://localhost:9119/h2-console        |  Driver:`org.h2.Driver` <br/> JDBC URL:`jdbc:h2:mem:demo` <br/> User Name:`sa`


### Test Suite
- Backend test suite is being SpringRunner and TestRestTemplate
- Few test conditions are breaking due to CSRF token injection. Need to find a work around or disable it for testing.



### TODO features
1.User Registration - Currently single user session 
2.Edit Post
3.Search Post
4.Personalize post search
5.Log Out
6.Gulpify the project for minification
7.Front End test cases

### References
https://github.com/BlackrockDigital/startbootstrap-blog-home/blob/master/index.html - Web template
http://blog.angular-university.io/developing-a-modern-java-8-web-app-with-spring-mvc-and-angularjs/
https://github.com/jhades/spring-mvc-angularjs-sample-app
https://github.com/googlearchive/appengine-angular-guestbook-java/blob/master/src/main/java/com/google/appengine/samples/angularjs_guestbook/rest/GsonMessageBodyHandler.java
https://docs.angularjs.org/guide/production
http://www.baeldung.com/rest-api-spring-oauth2-angularjs - mysql
https://github.com/mrin9/Angular-SpringBoot-REST-JWT - security and sql scripts during start up
https://spring.io/guides/tutorials/spring-security-and-angular-js/ - security
https://www.thoughtworks.com/insights/blog/good-practices-build-your-angularjs-application - angular best practices
https://github.com/spring-guides/tut-spring-security-and-angular-js/tree/master/single - authentication
https://www.sitepoint.com/write-modular-code-angular-ui-router-named-views/ — layout
https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html - spring config
https://codepen.io/nickmoreton/pen/mgtLK  - useful
https://mindthecode.com/lets-build-an-angularjs-app-with-browserify-and-gulp/ — build gulp
