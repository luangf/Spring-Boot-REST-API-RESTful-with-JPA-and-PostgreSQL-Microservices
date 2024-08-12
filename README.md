Back-end Java application to learn: Spring Boot | REST API | PostgreSQL | Postman | Swagger | WebService ViaCep (search address) | Hikari | Spring Security | Token JWT | Cross Origin

### Spring Security | Token JWT:

Taking the authentication token by Postman, simulating a user login:

![image](https://github.com/user-attachments/assets/5387cc97-c940-44be-9cde-9340430f010d)

Sending the Bearer Token obtained through Postman's Authorization tab:

![image](https://github.com/user-attachments/assets/59c73e86-3f8d-4bf6-a61d-6026c4102f55)

Saving a user via the POST method to test whether Spring Security has released it:

![image](https://github.com/user-attachments/assets/39332192-b88c-48fa-a8d3-2de14753f824)

### Using Hikari to improve application performance:

![image](https://github.com/user-attachments/assets/042797e4-c691-4626-8bb2-465953d2ae6a)

![image](https://github.com/user-attachments/assets/f1b78df5-bfc5-418b-a6e9-6856b7436667)

### Testing HTTP Methods:

The IndexController class has the @RequestMapping("/usuario") annotation, which would be the root for our RESTful methods;

`http://localhost:8080/cursospringrestaupi/usuario`

By adding '/' at the end and selecting the POST method in POSTMAN, you can access the REST service created to save users:

http://localhost:8080/cursospringrestapi/usuario/

![foto xyz](https://github.com/user-attachments/assets/91258aab-546a-465c-83c9-587df960714d)




