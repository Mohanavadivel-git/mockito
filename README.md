# mockito
mockito and junit related functionalities

# Live Reload (Hot Swap)
1).Open the Settings --> Build-Execution-Deployment --> Compiler --> Build Project Automatically(Enable)

# mockito setup
1). Download a project from https://start.spring.io/
2). selected spring-boot-starter-web & spring-boot-devtools(for Hot swap functionality)
3). Junit is automatically included by springInitializer
4). Make sure following import statement is present in the test class
        import org.mockito.Mockito;
        import org.junit.jupiter.api.Test;

# What are all can be mocked?
1). Class
2). Method inside the class
3). Bean Mock (helps in Integration testing)


# How can it be mocked?
1). Mock the class - by adding @Mock (or) Mockito.mock(classname.class)
2). Mock the method - by adding when(classname.methodname).then(returnvalue);
        **Use above two steps when you are constructing something with respect to other module output**
        **For Example building service class based on the Respository class output**
3). Mock the Bean - by adding @MockBean - Useful for Integration test
        **This mock will replace the exsisting bean in application context**
        **for example, an external service – needs to be mocked**
        **Mockito.verify - verify if there is interaction with the mockBean methods**



