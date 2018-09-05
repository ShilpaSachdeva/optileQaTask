# optileQaTask
coding challenge 

# test-automation-quickstart

This Project contains the various tests related to Dropbox web application.

## Concepts Included

* Test runs using TestNg.xml
* Contracts and implementation for selenium functions
* Dependency injection
* Page factory design pattern
* Common web page interaction methods
* Maven Project
* Externalised test configuration using config file
* Commonly used test utility classes
* Data driven Tests using Testng dataprovider class
* Simple reporting Feature using Extent report

## Software

* Maven
* TestNg
* Selenium Webdriver
* Java
* Eclipse

## Project setup:-

Pre-requisites: Eclipse IDE installation is required.

The project setup can be done in either of the below mentioned ways:

First Method:
#Download the project from the GitHub link:  “https://github.com/ShilpaSachdeva/optileQaTask.git”
#Import this project in Eclipse with below steps:
*  In the Eclipse menu, choose File -> Import.
*  Expand the General folder and select Existing Projects into Workspace, then click Next. ...
*  You should now see the Import Projects dialog. ...
*  Select Finish.

#Run the Testng tests using testng.xml. 
- Right click testng.xml under optileQaTask
- Click on Run As -> TestNG Suite



Second Method:
* GitHub Project location: https://github.com/ShilpaSachdeva/optileQaTask.git
* Import GitHub Project into Eclipse: https://github.com/collab-uniba/socialcde4eclipse/wiki/How-to-import-a-GitHub-project-into-Eclipse
* As it is maven project, all the dependencies will be downloaded on its own
* Run the Testng tests using testng.xml. 
- Right click testng.xml under optileQaTask
- Click on Run As -> TestNG Suite

## Reporting

* Extent Report is used to create reports
* After running testng.xml, refresh the project
* Open the latest report generated under reports folder 
- Right click  DropboxTestScenariosReport.html
- Open with Web Browser
* Screenshots of failed steps are attached to reports, which are also placed under screenshots folder


## Requirements

In order to utilise this project you need to have the following installed locally:

* The scripts are made operating system independent. You can use windows 64 bit or Mac-os.
* The test scripts supports cross browser testing. Currently supporting Chrome and Firefox browsers.( UI tests use Chrome by default, can be changed in config)
* Java 1.8
* Eclipse
* Since it is maven Project, it will auto install all dependencies


## Framework

*Hybrid Test Automation Framework. Through this type of test automation framework, you can quickly execute your tests through different test automation frameworks without changing a single line of code, using only configuration switches.

*Page factory design pattern to make code reusable, reliable, maintainable, readable and to eliminate duplicity.

*Interface Segregation SOLID Principle is followed for contracts and its implementation. The principle states that no client should be forced to depend on methods that it does not use so we split the big interface in several smaller logically separated parts.

*The framework will be capable of creating interactive reports using extent reports.Also, the framework will also use Data Driven testing by taking input from excel sheet. 
