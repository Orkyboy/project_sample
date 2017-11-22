# Test project skeleton for UI TA of native mobile application

### Required Software and Tools
* Java Version: Oracle Java 8 (Execute **_java -version_** in command line after installation)
* Apache Maven Version: 3.3.X (Execute **_mvn -version_** in command line after installation)
* Integrated Development Environment: Any version IntelliJ Idea or Eclipse

### Conventions followed in this guide
* **{PROJECT_ROOT}** refers to top or root directory of this project

### Run tests
* Run appium server and provide url to property file in project_gui_autotests_config module (http://0.0.0.0:4723/wd/hub by default)
* Connect Android device or run emulator
* Open a terminal or command prompt
* Go to **{PROJECT_ROOT}**
* Execute `mvn clean verify` for one thread test execution
* Parallel test execution will be added later (eg. with Sauce Labs)

### Reporting
* Report generated to `functional_autotests/target/site` folder
* Run `index.html` from IDE to see the report

### Logs
* Logs can be found in `functional_autotests/target/logs` folder

### Notes
* Application stored in resources folder, but there is a property for app path for external application delivery (`path.to.app` property)

###Project structure
* Project contains 3 modules: configuration, core and tests module
* Cucumber feature files stored in resources folder in tests module
