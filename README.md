Using @RequestParam: 
    The @RequestParam annotation indicates that the value should be taken from the query parameters of the URL. For example, you would access it like this: http://localhost:8080/product/vendor?value=Khadi.

Accessing the Endpoint: After making this change, you should access the endpoint using a query parameter:  http://localhost:8080/product/vendor?value=Khadi

If you want to use a query parameter, use @RequestParam and access the endpoint as http://localhost:8080/product/vendor?value=Khadi.
If you want to use a path variable, use @PathVariable and access the endpoint as http://localhost:8080/product/vendor/Khadi
