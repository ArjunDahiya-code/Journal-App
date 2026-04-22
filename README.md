****Journal App - Scalable Backend Ecosystem** :-**

A production-ready Spring Boot backend for personal journaling, featuring a distributed architecture, automated sentiment analysis, and secure authentication.

****🚀 Key Technical Features** :-**

Security & Auth: Implemented Spring Security with JWT for stateless authentication and Google OAuth2 for seamless social login.

Distributed Systems: Integrated Apache Kafka for asynchronous processing of journal entries and Redis for high-speed caching of user data and weather information.

Database Management: Utilizes MongoDB Atlas for flexible document storage with automated indexing.

External Integrations: Built a Weather Service using RestTemplate to fetch real-time atmospheric data based on user location.

Automated Workflows: Configured a User Scheduler and Email Service for weekly sentiment reports and activity reminders.

Reliability: Included a comprehensive test suite (JUnit & Mockito) covering services, repositories, and scheduling logic.

**🛠 Tech Stack :- **

Language: Java 17+

Framework: Spring Boot 3.x (Data MongoDB, Security, Mail, Web)

Messaging: Apache Kafka

Caching: Redis Cloud

Database: MongoDB

Tools: Maven, Lombok, Swagger UI (OpenAPI), Git

****📂 Architecture Overview** :-**

The project follows a clean Controller-Service-Repository pattern:

controller/: REST endpoints for User, Admin, and Journal management.

service/: Core business logic, including Redis caching and Kafka production.

filter/: JWT filtering for secure request interception.

scheduler/: Cron-based jobs for automated email dispatches.

****🔧 How to Run** :-**

Clone the repo: git clone https://github.com/ArjunDahiya-code/Journal-App.git

Setup Environment: Add your MongoDB URI, Redis credentials, and Google Client IDs to application-dev.yml.

Build & Run: ```bash
mvn clean install
mvn spring-boot:run

**API Documentation :-**
<img width="1900" height="906" alt="image" src="https://github.com/user-attachments/assets/88fd1c36-edd6-4ea3-ab69-e42c6bcc1d5f" />
<img width="1897" height="823" alt="image" src="https://github.com/user-attachments/assets/e2fb745b-2b4f-4c1e-b958-5831abd3faca" />
<img width="1892" height="662" alt="image" src="https://github.com/user-attachments/assets/64386159-9515-4d7b-9e61-add9d7cf8872" />



