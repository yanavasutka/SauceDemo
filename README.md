#### Maven Homework

1. **mvn versions:display-dependency-updates**

*_команда для просмотра доступных версий библиотек в проекте_

[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   io.github.bonigarcia:webdrivermanager ................. 5.1.0 -> 5.1.1
[INFO]   org.testng:testng ....................................... 7.4.0 -> 7.5

2. **mvn versions:use-latest-versions**

*_команда для обновления всех версий библиотек в проекте_

[INFO] Major version changes allowed
[INFO] Updated org.testng:testng:jar:7.4.0 to version 7.5
[INFO] Updated io.github.bonigarcia:webdrivermanager:jar:5.1.0 to version 5.1.1

3. **mvn clean test**

*_команда для запуска всех тестов_

[INFO] Tests run: 24, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 181.166 s - in TestSuite

4. **mvn test -Dtest=CartTest**

*_команда для запуска тестов из одного класса, на примере CartTest_

[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 106.064 s - in tests.CartTest

5. **mvn -Dtest=CartTest#productShouldBeAddedIntoTheCart test** 

*_команда для запуска одного метода класса_

[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 47.646 s - in tests.CartTest

6. **mvn -Dtest=CartTest#productShouldBeAddedIntoTheCart+productShouldBeRemovedFromTheCart test**

*_команда для запуска нескольких методов класса_

[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 132.957 s - in tests.CartTest

7. **mvn clean test -DsuiteXmlFile=src/test/resources/regression.xml** 

*_команда для запуска файла regression.xml_

[ERROR] Unknown lifecycle phase ".xml".

8. **mvn test -Duser=performance_glitch_user**

*_команда для запуска тестов через параметр_

[INFO] Tests run: 24, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 113.398 s - in TestSuite