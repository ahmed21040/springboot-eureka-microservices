# springboot-eureka-microservices
## Technology used in project
1. Spring boot
2. Spring data
3. JWT for Authentication
4. mysql DataBase
5. Maven
6. eureka 
7. docker

## How To Run Project

- create database schema name `extremedb` 

# eureka-server (Spring boot for eureka server)
- build
1. build project by `mvn install`
2. open terminal and go to Dockerfile location 
3. `docker build -t eureka-server .`
5. `docker run --name eureka-server -d -p 8081:8081 eureka-server`



# doctor-service (Spring boot service used to register , login , find doctor by token)
- build
1. change ip adress (DB ,serverurl, instance ip) to your ip address and and db (username,password) from application.properties
2. build project by `mvn install`
3. open terminal and go to Dockerfile location 
4. `docker build -t doctor-service .`
5. `docker run --name doctor-service -d -p 8081:8081 doctor-service`


# patient-service (Spring boot service used to register , login , find patient by token)
- build
1. change ip adress (DB ,serverurl, instance ip) to your ip address and and db (username,password) from application.properties
2. build project by `mvn install`
3. open terminal and go to Dockerfile location 
4. `docker build -t patient-service .`
5. `docker run --name patient-service -d -p 8081:8081 patient-service`



# appointment-service (Spring boot service used to register , login , find appointment by token)
- build
1. change ip adress (DB ,serverurl, instance ip) to your ip address and and db (username,password) from application.properties
2. build project by `mvn install`
3. open terminal and go to Dockerfile location 
4. `docker build -t appointment-service .`
5. `docker run --name appointment-service -d -p 8081:8081 appointment-service`
