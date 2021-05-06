# SpringBoot-REST-Log-Swagger-Maven

Creating Sample project/skeleton for those who want to use spring boot and expose any service as Restfull API. 
**Learning:

1. SpringBoot app using maven (you don't have to worry about dependency, starter Jar will take care of all the dependent jars)

2. How default application.properties gets used by SpringBoot 
    a. I Have change port and context path for demo

3. How we can read properties using annotation.

4. easy way to expose as REST API using RestController annotation.
5. Multiple REST API for learning purpose with different ways of defining APIs with different ways of taking input.

  **here are the REST api which we have expose:** 
  http://localhost:9090/RestAPIDemo/api/
  
  
  http://localhost:9090/RestAPIDemo/api/hello?name=chin

6. swagger integration for documentation and use of annotation for REST APIs for documentating proper definition/description.
  http://localhost:9090/RestAPIDemo/swagger-ui/
  
  
  http://localhost:9090/RestAPIDemo/v2/api-docs
  
7. use of actuator for health monitor.
   http://localhost:9090/RestAPIDemo/actuator/
      
8. default Logger use. either properties defined in application.property  or using logback.xml  
  
9. Junit using Mockito

How to Use:

Clone this project as it is and do maven update
Run your project as SpringBoot app or Java app and On Application startup, you can hit above URL's and verify its working or not.
