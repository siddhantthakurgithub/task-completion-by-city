# Task Completion By City - Read Me

### _API Automation_

* [Introduction](##Introduction)
* [Setup](#Setup)
* [Execution](#Execution)
* [Branching](#Branching)
* [Development](#Development)

## Introduction

This is Testing Framework based on BDD principles in Java, you can use this to

* **Document** features tests in BDD gherkin format
* **Automate** with step definitions in java
* **Execute**  easy to understand test suites results with your team




## Setup

This section details any and all prerequisites in order for the application to be run.

### Pre-requisites
Below tools/dependencies are required to be installed in the machine from where automation scripts would be triggered-

* 1.Intelij IDEA IDE
```
Download from https://www.jetbrains.com/idea/) for your OS 
```
* 2.JAVA
````
Download JDK 11 or above (preferably sdk corretto-16) for your OS
````

* 3.Gradle
````
Download Gradle 8 or above  for your OS from https://gradle.org/install/ 
````

### Installation

The installation section details steps that need to be taken in order to properly install the application.

1. Installation step 1

> Open the project in IntelliJ Idea (Or Eclipse)

This global installation is required in order for the application to function properly.

2. Installation step 2

> Build your gradle project (Go to gradle tab and build the project)


## IDE Setup

* Clone this repo
* Open the framework in IntelliJ Idea
* Build your gradle project (Go to gradle tab and build the project)
* Open the build.gradle file

## Execution

* Run the Test Runner file under Test Runner

## Features:

1. Runner class
```
To execute the suite, use the default tag in the runner and this would run all 
cases associated with the tag
```
2. Health Check
````
Health check functionality has been added in test runner as a part of the
"before class".

Health of the API is checked before the suite is initiated
````

3. Reporting
```
In Under Build --> Reports --> CucumberSpecificReport --> cucumber-html-reports
Find the newly generated Report for a test run 
```


## Branching
* Main : stable branch
* Feature : feature/<name> , for new additions to repo
* BugFix : bugfix/<name> , for fixing bugs


## Development
* Takeout Feature branch from main
* Make changes on this branch
* Feature branch -> Raise PR to Main
* Approval metrics
    * Changes that are made in the feature
    * One successful suite run with reports attached
* Merge the PR post approval