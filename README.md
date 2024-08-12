Back-end Java application to learn: Spring Boot | REST API | PostgreSQL | Postman | Swagger | WebService ViaCep (search address) | Hikari | Spring Security | Token JWT | Cross Origin

Showing some application features in the Readme:

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

`http://localhost:8080/cursospringrestapi/usuario/`

![foto xyz](https://github.com/user-attachments/assets/258fd27b-acb7-4865-acd5-e47c8807719c)

So let's see if it works:

<img src="https://github.com/user-attachments/assets/e1e10cfc-0a9b-487f-afd7-945979343b00" width="500"/>

It works! :D

I just hid the zip code generated by a zip code generator as a precaution so that no one's address would appear.

We can see that the password has been saved in the PostgreSQL database already encrypted.

![image](https://github.com/user-attachments/assets/315aa6f7-0aa3-4d01-bc88-b41f2724f84a)




