# Mockito
mockito and junit related functionalities

# Build and Run
* build >> ./gradlew clean build
* Run   >> ./gradlew bootRun

# mockito setup
* Download a project from https://start.spring.io/
* selected spring-boot-starter-web & spring-boot-devtools(for Hot swap functionality)
* Junit is automatically included by springInitializer
* Make sure following import statement is present in the test class
        import org.mockito.Mockito;
        import org.junit.jupiter.api.Test;

# What are all can be mocked?
* Class
* Method inside the class
* Bean Mock (helps in Integration testing)

# How can it be mocked?
* Mock the class - by adding @Mock (or) Mockito.mock(classname.class)
* Mock the method - by adding when(classname.methodname).then(returnvalue);
        **Use above two steps when you are constructing something with respect to other module output**
        **For Example building service class based on the Respository class output**
* Mock the Bean - by adding @MockBean - Useful for Integration test
        **This mock will replace the exsisting bean in application context**
        **for example, an external service – needs to be mocked**
        **Mockito.verify - verify if there is interaction with the mockBean methods**
* **@Spy** - When the real class should be used for validation 
    * For example - To test any libs(like ArraryList)
    * Spy used for spying the real class and verify if respective method is been called
    * @Mock Vs @Spy
        * @Mock - is not dealing with real class
        * @Spy - deals with the real class
    * Refer Spytest() in the test class in this project
* **@Captor** - When the method arguments needs to be captured
    * Refer Captortest() in the test class in this project
* **@InjectMocks** - For automatically injecting the mocks to the test class
    * Refer injectMocksTest() in the test class in this project

# Others
## Markup Cheat sheet
[Cheatsheet Link] https://github.com/tchapi/markdown-cheatsheet/blob/master/README.md

## Live Reload (Hot Swap)
1).Open the Settings --> Build-Execution-Deployment --> Compiler --> Build Project Automatically(Enable)
