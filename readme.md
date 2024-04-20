# Email microservice

## Description
This microservice has responsibility to send e-mail using gmail service and Spring boot.

## Use mode

To use this service, you just need to configure application.properties file with your credentials. You must get that credentials in gmail configuration.
### Here is an example.
> You just need to change username and password. Remember this password is not your email password, it is generated for Google.
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=*******@gmail.com
spring.mail.password=************
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

## Routes
### POST
```
http://localhost:8090/email/send
```