# Robot-Simulation

Stand-up:
**Finished Parts:**
1. Main backend functionality is complete.
2. Solution of the assignment is designed by keeping SOLID and design principles in mind.
3. Main frontend functionality is also complete.
4. Centralized exception handler is used for exceptions.

**Next steps:** (Some of them have been implemented in another branch feature/TS-Improvements)
1. Separate the command parsing functionality to improve code maintainability.
2. Implement system-wide configurations for CORS.
3. Implement logging for issues.
4. Utilize property files to remove hardcoded variables from the code.
5. Create a separate messages file to store all messages so that they can be changed without changing code

**Could be improved:**
1. Making Grid configureable as well both on frontend and backend.
2. Proper error handling is done on backend but should be done on UI as well with proper messages.

**Tech Stack:**

1.Java 17
2.Springboot 3.0.9
3.Maven
4.React JS

**How to run:**
**backend:**

Simply move to directory "Robot-Simulation/robot-simulation" and run
```
mvn clean spring-boot:run 
```

frontend:

Simply move to directory "Robot-Simulation/robot-simulation-frontend" and run
```
npn install
```

it will install required packages. Then run
```
npm run dev
```
Hit the URL and enter the script.
