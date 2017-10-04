Required to build project:
--------------------------
1. JDK 1.8
2. latest maven

How to build:
---------------
1. open command prompt
2. cd to captcha-service folder
   run mvn clean install
   
How to run binary:
------------------
Assumption: JDK 1.8 is your default jdk  ( How to check ? Go to command prompt and run java -varsion)

Go to captcha-service\bin folder and click on RunCaptchaService.bat
      - this would start captcha-service application and open chrome to  http://localhost:8011/index.html
      
Service Information:
 ----------------------
 
 to get question : http://localhost:8080/api/GetQuestion
                   - GET request
                   - No parameter
                   - sample response : 
                   {
                       "question": "Please sum the numbers 3,7,2",
                       "token": "0Ufm8xcrsg2uYNqzddPEb2YC8+jfcB7/FA+ZLYXNyHLxkZc3bQSrmA==",
                   }
                   
 answer question : http://localhost:8080/api/AnswerQuestion
                  - POST request
                  - sample body parameter, content type application/json
                  {
                      "question": "Please sum the numbers 3,7,2",
                      "token": "0Ufm8xcrsg2uYNqzddPEb2YC8+jfcB7/FA+ZLYXNyHLxkZc3bQSrmA==",
                      "answer":1
                  }
                  - 200 response for SUCCESS
                  - 400 response for ERROR
                  
 Postman sample :
            check captcha-service/doc folder
            check captcha-service/doc folder
                              
