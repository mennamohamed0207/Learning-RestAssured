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
