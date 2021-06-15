# Exploratory charters for Monefy application

https://github.com/gayatrithakare/pet-store/blob/main/exploratoryTests.md



# Pet store API verification application

It's a simple maven based java application. It contains automated test cases for testing pet related API's. Test are
written using cucumber & rest assured.

libraries used

1. rest-assured
2. json-path
3. cucumber
4. lombok
5. jackson

**How to run test cases**

As it's maven project, Tests can be run using maven commands.Run below command from project root directory.  
``mvn clean install``
Alternative You can also import project any java editor and run ``RunCucumberTest`` class to run all tests.

**Reports**

Test execution report will be generated in ``reports`` directory in room folder.

**Dependency**

Need to pet store swagger application locally on port 8080. you can configure pet server host in ``test.properties``

# TODO

Currently all step definition are in single file. need to split them in to multiple small step definition files.  
