$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Petstore.feature");
formatter.feature({
  "line": 1,
  "name": "Petstore",
  "description": "",
  "id": "petstore",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Perform an order placed request",
  "description": "",
  "id": "petstore;perform-an-order-placed-request",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@POST"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "Pets exist in the inventory",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I place an order for a pet",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I receive the response code 200",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "My order details are returned",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 9,
  "name": "Perform an invalid order placed request",
  "description": "",
  "id": "petstore;perform-an-invalid-order-placed-request",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "Pets exist in the inventory",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I place an invalid order for a pet",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I receive the response code 400",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 15,
  "name": "Return order by order ID",
  "description": "",
  "id": "petstore;return-order-by-order-id",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@GET"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "Orders exist in the inventory",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I perform a get request for my order",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I receive the response code 200",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 20,
  "name": "Request an order that does not exist",
  "description": "",
  "id": "petstore;request-an-order-that-does-not-exist",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "Orders exist in the inventory",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I perform a get request for an order that does not exist",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I receive the response code 404",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 26,
  "name": "Perform a delete request",
  "description": "",
  "id": "petstore;perform-a-delete-request",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 25,
      "name": "@DELETE"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "Orders exist in the inventory",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "I delete a purchase order by Id",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "I receive the response code 200",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "The correct order has been deleted",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 32,
  "name": "Perform a delete request with an invalid ID",
  "description": "",
  "id": "petstore;perform-a-delete-request-with-an-invalid-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "Orders exist in the inventory",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "I send a delete request for an invalid order Id",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "I receive the response code 404",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});