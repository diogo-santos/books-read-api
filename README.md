# books-read-api
Rest service for reading books domain with pagination from MySql database

## Getting the code on your computer
- [ ] Java 8
- [ ] Maven 3+
- [ ] MySql
- [ ] Import the project from GitHub https://github.com/diogo-santos/books-read-api

Set MySql database properties - application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/books
spring.datasource.username=root
spring.datasource.password=mysqlpasswd
```

Run the app
```
cd books-read-api
mvn spring-boot:run
```

Execute tests
```
mvn clean test
```

## Test the App
Check API documentation at http://localhost:5000
