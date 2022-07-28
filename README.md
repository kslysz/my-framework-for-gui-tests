# Test execution

* Run all scenarios from all features on default environment and default browser
  ```shell
  $ .\gradlew clean test
  ```
* Run scenarios with tag @sample on "test" environment and "chrome" browser
  ```shell
  $ .\gradlew clean test -Denv="test" -Dbrowser="chrome" -Dtags="@sample"
  ```
* Run scenarios with tag @sample on "test" environment and "chrome" browser and generate allure report
  ```shell
  $ .\gradlew clean test -Denv="test" -Dbrowser="chrome" -Dtags="@sample" allureReport
  ```
* Run scenarios with tag @sample on "test" environment and "chrome" browser on 6 threads
  ```shell
  $ .\gradlew clean test -Denv="test" -Dbrowser="chrome" -Dtags="@sample" -Dthreads="6"
  ```