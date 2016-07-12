# rabbit sample
I'm using https://www.cloudamqp.com/ account for testing

# mongodb & rest controller sample
Inspired by https://spring.io/guides/gs/accessing-mongodb-data-rest/

Get all persons [GET]:
http://localhost:8080/persons

Get person by id [GET]:
http://localhost:8080/persons/{id}

Create person [PUT]:
Content-Type : application/json
{  "firstName" : "Frodo",  "lastName" : "Baggins" }

# spring rest docs

http://localhost:8080/docs/api-guide.html

# spring data rest with evens

curl -i -X POST -d '{"id":"26","name":"name","type":"type"}' -H 'Content-Type: application/json' http://localhost:8080/assets
POST = create
@HandleBeforeCreate
@HandleAfterCreate
onBeforeCreate
onAfterCreate

curl -i -X PUT -d '{"id":"26","name":"name-1","type":"type"}' -H 'Content-Type: application/json' http://localhost:8080/assets/26
PUT = update
@HandleBeforeSave
@HandleAfterSave
onBeforeSave
onAfterSave
