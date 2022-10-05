# How to execute

- This project will be executed by Docker, in this case we can avoid the use of a local database in develop enviroment.

After changes use this comands before execute on docker

- First create a new executable file.
``./mvnw clean package -DskipTests``

- Copy the new executable file to the docker page
``cp target/demo-0.0.1-SNAPSHOT.jar src/main/docker``

- Them go to the docker directory and execute the following comand:
 ``docker-compose down``
 
 - Make the container run the new version of your code using:
``docker rmi docker-spring-boot-postgres:latest``

- Finally put your container up, using:
``docker-compose up``

The application will be running localy on door 8080, who is map in the dor with the same number on container.