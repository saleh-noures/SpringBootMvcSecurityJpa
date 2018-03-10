# SpringBootMvcSecurityJpa

**Application Link:** http://localhost:8080/SpringBootMvcSecurityJpaApplication/

**This is a Spring Boot Application, contains two examples:**

   1- Member: spring MVC (interface and Rest) --> User: member/123
    
   2- Company:  Angular, Spring REST services --> User: emp/123
   
   3- Users to access the examples above are defined in SecurityConfig.java 

**The following tools technologies have been used**

   1- Spring MVC (interface and Rest)

   2- Spring Security

   3- Spring DATA JPA

   4- Embedded Apache Tomcat 

   5- H2 database accessed by (configurations are in application.properties): 
   
    user: sa 
   
    passeword: sa
    
    link: http://localhost:8080/SpringBootMvcSecurityJpaApplication/h2

**Spring Boot does not support JSP as views by default the below link tells how to do it:**

   http://www.logicbig.com/tutorials/spring-framework/spring-boot/boot-serve-dynamic/

TO DO:
1- Use hashing to encode passwords
2- create Unit Tests