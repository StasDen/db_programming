# db_programming

### db_labs

Studying relational databases

Learning about relational databases  
Implementing university labs  
Using MySQL Workbench 8.0.30, MySQL 8.0.30, Java 17, Spring Boot(2.7+)

Download the latest version of MySQL Installer(MySQL Workbench + MySQL) [here](https://dev.mysql.com/downloads/mysql/)

***

To use **lab4**(JdbcTemplate) you need to:
* Download the latest version of Java(you can do it [here](https://www.oracle.com/java/technologies/downloads/))
* In MySQL Workbench create db server, set user(name "root") and password("Most_secure_root_password1")
* Create db sheme "party_animators_scheme". Here, create .sql file and insert code from project file "db.sql"(to create tables and do inserts). Run it
* Run "App"

To use **lab5**(JPA and Hibernate) you need to:

So, you have already got Java. Also you have setted up MySQL db server. Do the next steps:  
* Create db sheme "party_animators". Here, create some .sql file and insert code from project file "scheme.sql". Run it
* Run "SpringBootApp"
* Go to http://localhost:8080/swagger-ui/index.html and use the controllers

To use **lab6**(stored programs) you need to:

So, now you definitely have Java and db server, have you? Do the following:

* Create some .sql files in MySQL Workbench and insert code from "functions.sql", "procedures.sql", "triggers.sql". Run them
* Run "SpringBootApp"
* Go to http://localhost:8080/swagger-ui/index.html and use new controllers. If you can't use any stored program - use it directly in Workbench
