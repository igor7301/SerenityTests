# SerenityTests

### Run test via maven:


##### Windows + Chrome browser
```
mvn clean integration-test -Dit.test=MySerenityTest -Dwebdriver.driver=Chrome -Dwebdriver.chrome.driver=chromedriver.exe
```

##### MAC + Chrome browser
```
mvn clean integration-test -Dit.test=MySerenityTest -Dwebdriver.driver=Chrome -Dwebdriver.chrome.driver=chromedriver_mac
```

##### Windows + Firefox browser
```
mvn clean integration-test -Dit.test=MySerenityTest -Dwebdriver.driver=Firefox -Dwebdriver.gecko.driver=geckodriver.exe
```

##### MAC + Firefox browser
```
mvn clean integration-test -Dit.test=MySerenityTest -Dwebdriver.driver=Firefox -Dwebdriver.gecko.driver=geckodriver_mac
```


### Generate a serenity report:
```
mvn serenity:aggregate
```

### Serenity results will be here:
```
/target/site/serenity/index.html
```