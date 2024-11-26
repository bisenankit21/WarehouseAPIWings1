Using @RequestParam: 
    The @RequestParam annotation indicates that the value should be taken from the query parameters of the URL. For example, you would access it like this: http://localhost:8080/product/vendor?value=Khadi.

Accessing the Endpoint: After making this change, you should access the endpoint using a query parameter:  http://localhost:8080/product/vendor?value=Khadi

If you want to use a query parameter, use @RequestParam and access the endpoint as http://localhost:8080/product/vendor?value=Khadi.
If you want to use a path variable, use @PathVariable and access the endpoint as http://localhost:8080/product/vendor/Khadi

you do not need to explicitly annotate your repository interface with @Repository when it extends JpaRepository or any other Spring Data repository interface.
Explanation:
Spring Data JPA: When you extend JpaRepository (or any Spring Data repository interface), Spring automatically recognizes it as a repository bean. This is because Spring Data JPA already includes the necessary annotations and configurations to handle repository behavior.

@Data: A convenience annotation that bundles @Getter, @Setter, @RequiredArgsConstructor, @ToString, and @EqualsAndHashCode.

To use Lombok
Enable Annotation Processing
Make sure that annotation processing is enabled in your IDE. For example, in IntelliJ IDEA:

Go to File | Settings | Build, Execution, Deployment | Compiler | Annotation Processors.

Check the Enable annotation processing checkbox.