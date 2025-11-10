# 📌 Rest Assured Learning Plan
## Build new Project
- Create a Maven Java Project.
- Add Maven dependency of REST Assured in pom.xml
- Add Maven dependency of TestNG/JUNIT in pom.xml ( Required to manage and run tests effectively)
- Add Maven dependency of JSON Schema Validator in pom.xml ( Needed for JSON schema validator)
- Add Maven dependency of Jackson JSON Java parser ( Needed for mapping Java objects to and from JSON )
- Add Maven dependency of JAXB XML Java parser ( Needed for mapping Java objects to and from XML )
## Static Import 
- Purpose: Makes code cleaner by removing class name prefixes for static members.

- Syntax: import static package.ClassName.*; or import static package.ClassName.MEMBER;

- Use with care: Too many static imports can reduce readability if overused.

## First API in RestAssured
- RestAssured is a class which consists many static fields and methods.
- It supports POST, GET, PUT, DELETE, HEAD, PATCH and OPTIONS requests and to verify the response of these requests.
- RestAssured has a static overloaded method named get() which returns a reference of Response interface. In fact return type of all http methods in RestAssured class is of type **Response**. 
This response contains every details returned by hitting request i.e. response body, response headers, status code, status lines, cookies etc.
To validate response like status code or value , we need to get reference of type ValidatableResponse. ValidatableResponse is an interface. Response interface has a method named “then()” which returns ValidatableResponse. 
- In fact there is an interface called “Validatable” which has “then()” method. Response interface extends
Validatable Interface. The implemented class of Response interface is RestAssuredResponseImpl. We will see hierarchy of classes and interfaces later.
- Once we get ValidatableResponse reference, we can do many assertions.

### NonBDDStyle Get request
- RequestSpecification : to build on request as sometimes the request needs specific headers or queryparams
- ValidatableResponse : is an interface to make assertions on response
### BDDStyle Get request:
- Given() : to set up the request
- When() : technically it has no user
- Then() : to return validatable response
### Request Specification:
- DRY principle
- RequestSpecification is an interface that allows you to specify how the request will look like.
- This interface has readymade methods to define base URL, base path, headers, etc. We need to use given() method of RestAssured class to get a reference for RequestSpecification. 
- There are two methods in RestAssured class to start creating Request specifications:-
      *given()
      *with()
- The return type of both methods is RequestSpecification. There is no difference between the above two methods. The only difference is syntactical. but functionally they are equal
- Rest Assured provides a way to set a default Request Specification so that it can be sent to each request if no other Request Specification is set.
  ```
  RestAssured.requestSpecification = request1;
  ```

#### RequestSpecBuilder:
- There is another way of creating RequestSpecification in Rest Assured and that is by using class RequestSpecBuilder.
- RequestSpecBuilder is a class in Rest Assured, which contains methods to set cookies, headers, multipart details, body, authentication, form parameters, query parameters, path parameters, base path, base URI, proxy, etc.
- After adding all required details, we need to use “build()” method of RequestSpecBuilder class to get a RequestSpecification reference.

## Defaults Rest Assured
- By default REST assured assumes host localhost and port 8080 when doing a request. It means if we not provide any host and port, it will take default values. 
- When a request is sent to a server, it responds with a response. The amount of time taken between sending a request to server and retrieving a response back form a server is called Response Time. this time in milliseconds by default
- you need to use time(), getTime(), timeIn(TimeUnit timeunit), getTimeIn( TimeUnit timeunit ) from Response interface. 
- Response interface inherits these methods from ResponseOptions. 
- You can not use Matchers in above methods.
- If you want to use Matchers i.e. assertion like response time is greater than a specific value, 
you need to use overloaded **time() methods from ValidatableResponse** which inherits time() method from ValidatableResponseOptions interface.
- This interface contains four methods :-
     1. getTime() – The response time in milliseconds (or -1 if no response time could be measured)
     2. getTimeIn(TimeUnit timeunit) – The response time in the given time unit (or -1 if no response time could be measured)
     3. time() – The response time in milliseconds (or -1 if no response time could be measured)
     4. timeIn( TimeUnit timeunit ) – The response time in the given time unit (or -1 if no response time could be measured)
- Technically, getTime() and time() both are same and getTimeIn() and timeIn() both are same. Difference is Syntactic sugar.
- Interface ValidatableResponseOptions :-
  This interface has overloaded time() methods which accepts Matcher.
    
  1. time(Matcher matcher) – Validate that the response time (in milliseconds) matches the supplied matcher.
  2. time(Matcher macther, TimeUnit timeunit) – Validate that the response time matches the supplied matcher and time unit.