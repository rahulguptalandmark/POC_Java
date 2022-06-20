# CSS Automation using Rest Assured Framework

## Running

### Prerequisites

* Apache Maven 
* Java
* An IDE
* Cucumber JAVA Plugin

## Software packages

The following software packages need to be installed on your computer in order to develop the automation script

* Java 8 JDK 
* Git version control (available in Software Center in Windows Start Menu) 
* IntelliJ or Any Editor
* Apache Maven

#### Configuration Apache and JAVA JDK

Apache and JDK Jar files needs to be downloaded and configured with below environment variables

1.JAVA_HOME with a value until '\jdks\jdk-18.0.1.1' for an example 'C:\Users\rgupta\jdks\jdk-18.0.1.1'
2.MAVEN_HOME with a value until 'apache-maven-3.8.5' for an example 'C:\Users\rgupta\apache-maven-3.8.5'
3.Path variable to be appended with bin folder location for the jdk for an example 'C:\Users\rgupta\jdks\jdk-18.0.1.1\bin'
4.Path variable to be appended with bin folder location for the maven for an example 'C:\Users\rgupta\apache-maven-3.8.5\bin'

#### Downloading the dependencies

On the IDE terminal please use the command 'mvn install' to download all the pom.xml dependencies.

#### Writing Test 

1.Cucumber BDD framework has be used to write the feature file in Gherkin format.
2.Write all the scenarios in Gherkin format(Given,When ,And and Then) located @ src/test/resources/Features
3.Implement the steps in the step definition file located @ src/test/java/steps
4.Template folder @ src/test/resources/Templates is used to store all out request json formats like body of a post method etc.
5.Properties file @src/test/resources/devConfig.properties is used to config all our configurations like endpoint , any system credentials etc. 

#### Build and Run Locally
1. To run the individual scenario right-click on the scenario and click run
2. To run the entire feature file right-click on the Feature and click run

#### Build and Run in Pipeline
TBC
