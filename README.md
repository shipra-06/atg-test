# ATG V4 Race Automation Testing

I did automation testing in 2 ways

 - Cypress (atg-test-cypress)
 -  Selenium (atg-test-selenium)

## Automation using cypress.io

 - To Execute the automation tests as prerequistie  you just need to do **install npm**.
 - Once its npm installed you can start the cypress in windows with below command
 - Windows: npx cypress open
 - Linux: npm cypress open
 - It will open the cypress console where you have testcases for V4Race
 - Location of testcases is in atg-test-cypress/cypress/integration
 - Videos of testcase is found at atg-test-cypress/cypress/video

## Automation using Selenium
It's a maven project written using Junit and Selenium.

 - I have used default browser as chrome, but you can pass browser option as maven command line argument.
 - Command to run test from atg-test-selenium as :   mvn test
 - I have tested using firefox and chrome, you can provide driver option while running testcases as given below
 - command : mvn test -DdriverType=firefox