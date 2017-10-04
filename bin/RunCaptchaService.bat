start cmd /k java -jar captcha-service.jar
timeout /t 12
start C:\PROGRA~2\Google\Chrome\Application\chrome.exe http://localhost:8011/index.html