![alt tag](http://d379ifj7s9wntv.cloudfront.net/reactivemanifesto/images/ribbons/we-are-reactive-black-left.png) 
# Application Dictionary Reactive System 
## About 

The Application Dictionary Reactive System allows you to build an application based on an active data dictionary.

The architecture of this application is based on Domain Driven Design which will allow an efficient development, extension and maintenance for the future.

### The layers for a software build based on DDD are:

- User Interface
- Application Layer
- Domain Layer
- Infrastructure Layer

![alt tag](https://cloud.githubusercontent.com/assets/786968/23190369/0bce29f0-f85d-11e6-9512-20853ca6e2b5.png)

### The DDD Map Image:

![alt tag](https://cloud.githubusercontent.com/assets/786968/23190343/ec0f3c80-f85c-11e6-8923-1169be63e703.png)

The components that integrate this application are built under the philosophy of reactive systems which must fulfill four premises that form the pillars of a reactive system.

- Responsive 
- Resilient 
- Elastic 
- Message Driven
	
The Application Dictionary Reactive System is the foundation for building a high-availability, scalable, and ready-to-run application in the cloud.


# Element service

This service exposes application dictionary elements using a Restful API

## Queries handled

* **/api/v1_0_0/element/:id** - Get an Element by an ID.
* **/api/v1_0_0/element/:uuid** - Get an Element by an UUID
* **/api/v1_0_0/element?pageNo&pageSize** Gets a list of Element with paginating.

# Entity service

This service exposes application dictionary entities using a Restful APi

## Queries handled

* **/api/v1_0_0/entity/:id** - Get an Dictionary Entity by an ID.
* **/api/v1_0_0/entity/:uuid** - Get an Dictionary Entity by an UUID
* **/api/v1_0_0/entity/all** - Get an Dictionary Entities 
* **/api/v1_0_0/entity?pageNo&pageSize** Gets a list of Dictionary Entities with paginating.

# Step to Install

    git clone  https://github.com/adempiere/adempiereReactiveMicroservices.git
        
Installing SBT based on this steps http://www.scala-sbt.org/0.13/docs/Setup.html
    
# Setup 
    
Edit the ./dictionary-impl/src/main/resources/application.confapplication.conf file and set Database parameters:
 
    db.default {
        driver = "org.postgresql.Driver"
        url = "jdbc:postgresql://localhost:5432/adempiere"
        username = "adempiere"
        password = "adempiere"
     }

    ctx.dataSource.user=adempiere
    ctx.dataSource.password=adempiere
    ctx.dataSource.databaseName=adempiere
    ctx.dataSource.portNumber=5432
    ctx.dataSource.serverName=localhost
# Execute 

    #sbt compile
    #sbt runAll
    
open your web browser and call this url

    http://localhost:52182/api/v1_0_0/entity/all

# Project Status

Under development
