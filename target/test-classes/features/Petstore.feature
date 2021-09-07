Feature: Petstore
  @POST
    Scenario: Perform an order placed request
      Given Pets exist in the inventory
      When I place an order for a pet
      Then I receive the response code 200
      And My order details are returned

    Scenario: Perform an invalid order placed request
      Given Pets exist in the inventory
      When I place an invalid order for a pet
      Then I receive the response code 400

  @GET
    Scenario: Return order by order ID
      Given Orders exist in the inventory
      When I perform a get request for my order
      Then I receive the response code 200

    Scenario: Request an order that does not exist
      Given Orders exist in the inventory
      When I perform a get request for an order that does not exist
      Then I receive the response code 404

  @DELETE
    Scenario: Perform a delete request
      Given Orders exist in the inventory
      When I delete a purchase order by Id
      Then I receive the response code 200
      And The correct order has been deleted

    Scenario: Perform a delete request with an invalid ID
      Given Orders exist in the inventory
      When I send a delete request for an order that does not exist
      Then I receive the response code 404