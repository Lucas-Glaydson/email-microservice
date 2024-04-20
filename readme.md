# Email microservice

## Description
This microservice has responsibility to send e-mail using gmail service and Spring boot.

## Use mode

To use this service, you just need to configure application.properties file with your credentials. You must obtain these credentials from your Gmail setup.
### Here is an example.
> You just need to change username and password. Remember, this password is not your email password, it is generated for Google.
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=*******@gmail.com
spring.mail.password=************
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
## Schema MySQL
```
CREATE TABLE IF NOT EXISTS `emails` (
    `id` CHAR(36) NOT NULL,
    `owner` VARCHAR(255) NOT NULL,
    `email_from` VARCHAR(255) NOT NULL,
    `email_to` VARCHAR(255) NOT NULL,
    `subject` VARCHAR(255) NOT NULL,
    `text` TEXT NOT NULL, 
    `send_data_email` DATETIME NOT NULL,
    `status_email` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

## Routes
### POST
```
http://localhost:8090/email/send
```
