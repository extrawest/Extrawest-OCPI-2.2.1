<a href="https://www.extrawest.com/"><img src="https://drive.google.com/uc?export=view&id=1kXfNj5WfW2oSMzQR82xYBI6Bw_W8-LpK" width="20%"></a>
# Extrawest-OCPI-2.2.1

## Badges

![build](https://img.shields.io/github/actions/workflow/status/extrawest/Extrawest-OCPI-2.2.1/docker-image.yml?style=for-the-badge)
![release](https://img.shields.io/github/v/release/extrawest/Extrawest-OCPI-2.2.1?style=for-the-badge)
[![Java CI with Maven](https://github.com/extrawest/Extrawest-OCPI-2.2.1/actions/workflows/release-publish.yml/badge.svg)](https://github.com/extrawest/Extrawest-OCPI-2.2.1/actions/workflows/snapshot-publish.yml)
![contr](https://img.shields.io/github/contributors/extrawest/Extrawest-OCPI-2.2.1?style=for-the-badge)
![commits](https://img.shields.io/github/commit-activity/m/extrawest/Extrawest-OCPI-2.2.1?style=for-the-badge)
![lastcommit](https://img.shields.io/github/last-commit/extrawest/Extrawest-OCPI-2.2.1?style=for-the-badge)
![OCPI](https://img.shields.io/badge/OCPI-2.2.1-yellowgreen?style=for-the-badge)
![JDK](https://img.shields.io/badge/JDK-17-yellow?style=for-the-badge)
![social](https://img.shields.io/github/forks/extrawest/Extrawest-OCPI-2.2.1?style=for-the-badge)

## Field of use
Open Charge Point Interface (OCPI) is an open protocol used for connections between charging station operators and service providers. Simply put, this protocol facilitates automated roaming for EV drivers between different EV charging networks. This interface supports the affordability and accessibility of charging infrastructure for EV owners, allowing drivers to charge across different networks. The protocol provides accurate data on charging stations, such as location, accessibility and pricing, and takes into account real-time billing and mobile access to charging stations.
The OCPI protocol is managed and maintained by the EVRoaming Foundation, making it freely available to software vendors.

## How is OCPI being used?
OCPI consists of several modules. The role of a company in the EV landscape determines which modules of OCPI you need and how you use it.


Description
=============

A CPO and EMSP library of Open Charge-Point Interface. This library that is designed to make life easier for those who want to implement a CPO or EMSP application. 

With this library, you can easily get started with the Open Charge-Point Interface.
The design is driven by test, which will ensure premium software that is easy to adapt and modify to your needs.

Please note, this is a library and not an application, so there is no main method. 

Currently we support 2.2.1 OCPI version.

At 2.2.1 ypu can choose what kind of events will be supported by CPO or EMSP.

Maven
=====

Find the maven repo here: https://mvnrepository.com/artifact/com.extrawest/Extrawest-OCPI-2.2.1

Dependencies
============

Java-OCA-OCPP uses the following libraries:

* [springdoc](https://springdoc.org)
* [mapstruct](https://mapstruct.org)
* [lombok](https://projectlombok.org)
* [spock-core-0.7-groovy-2.0](http://spockframework.org)
* [javax.validation](https://mvnrepository.com/artifact/javax)
* [javax.servlet-api](https://mvnrepository.com/artifact/javax)
* [javax.annotation-api](https://mvnrepository.com/artifact/javax)
* [springdoc-openapi-starter-webmvc-ui](https://springdoc.org/)
* [springdoc-openapi-ui](https://springdoc.org/)
* [swagger-annotations](https://swagger.io/)
* [jackson-databind-nullable](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)

## Requirements
- Java 17 or higher
- Maven 3.6 or higher

License
=======

[MIT License](LICENSE)

About Extrawest.com
=======

We are devoted to push the marked for vehicles charging forward.
There are many standards out there, we intend to implement and share them. Any help is much appreciated!

The market is in its defining state, the practices and standards we come up with now, may very well stick around for decades to come.

See our vision at https://www.extrawest.com/
