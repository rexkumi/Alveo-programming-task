package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import utility.ScenarioContext;

import java.util.List;
import java.util.Map;

import static data.Data.base_url;
import static data.Data.order_id;

public class PetstoreStepDefinition {
    public ScenarioContext scenarioContext;

    @Given("Pets exist in the inventory")
    public void petsExistInTheInventory() {
        RequestSpecification request = RestAssured.given();
        scenarioContext = new ScenarioContext();

        Response response =
                request
                        .get(base_url+"/pet/findByStatus?status=available");
        List<String> ids = response.jsonPath().getList("id");
        Assert.assertTrue(ids.size() > 0);

        Map<String, Integer> petIds = response.jsonPath().getMap("category[0]");
        Integer petId = petIds.get("id");
        scenarioContext.setContext("pet.id", petId);
    }

    @When("I place an order for a pet")
    public void iPlaceAnOrderForAPet() {
        int petId = (int) scenarioContext.getContext("pet.id");

        JSONObject requestParams = new JSONObject();
        requestParams.put("id", order_id);
        requestParams.put("petId", petId);
        requestParams.put("quantity", 1);
        requestParams.put("shipDate", "2021-09-05");
        requestParams.put("status", "placed");
        requestParams.put("complete", true);

        RequestSpecification request = RestAssured.given();

        Response response =

                request
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .body(requestParams.toString())
                        .post(base_url+"/store/order");

        int statusCode = response.getStatusCode();
        scenarioContext.setContext("status.code", statusCode);

        JsonPath responseBody = response.jsonPath();
        int orderId = responseBody.get("id");
        int pet_id = responseBody.get("petId");
        String shipDate = responseBody.get("shipDate");
        scenarioContext.setContext("orderId.body", orderId);
        scenarioContext.setContext("pet_id.body", pet_id);
        scenarioContext.setContext("shipDate.body", shipDate);
    }

    @And("My order details are returned")
    public void myOrderDetailsAreReturned() {
        int petId = (int) scenarioContext.getContext("pet.id");
        int orderId = (int)scenarioContext.getContext("orderId.body");
        int pet_id = (int)scenarioContext.getContext("pet_id.body");
        String shipDate = (String)scenarioContext.getContext("shipDate.body");

        Assert.assertEquals(order_id, orderId);
        Assert.assertEquals(petId, pet_id);
        Assert.assertEquals("2021-09-05T00:00:00.000+0000", shipDate);
    }

    @When("I place an invalid order for a pet")
    public void iPlaceAnInvalidOrderForAPet() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", "test");
        requestParams.put("petId", 10);
        requestParams.put("quantity", 1);
        requestParams.put("shipDate", "2021-09-05");
        requestParams.put("status", "placed");
        requestParams.put("complete", true);

        RequestSpecification request = RestAssured.given();

        Response response =

                request
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .body(requestParams.toString())
                        .post(base_url+"/store/order");

        int statusCode = response.getStatusCode();
        scenarioContext.setContext("status.code", statusCode);
    }

    @Given("Orders exist in the inventory")
    public void ordersExistInTheInventory() {
        RequestSpecification request = RestAssured.given();
        scenarioContext = new ScenarioContext();

        Response response =
                request
                        .get(base_url+"/store/inventory");
        JsonPath responseBody = response.jsonPath();
        int availableStatus = responseBody.get("available");

        Assert.assertTrue(availableStatus>0);
    }

    @When("I perform a get request for my order")
    public void iPerformAGetRequestForMyOrder() {
        RequestSpecification request = RestAssured.given();

        Response response =
                request
                        .get(base_url+"/store/order/"+order_id);

        int statusCode = response.getStatusCode();
        scenarioContext.setContext("status.code", statusCode);
    }

    @When("I perform a get request for an order that does not exist")
    public void iPerformAGetRequestForAnOrderThatDoesNotExist() {
        RequestSpecification request = RestAssured.given();

        Response response =
                request
                        .get(base_url+"/store/order/76543211234567");

        int statusCode = response.getStatusCode();
        scenarioContext.setContext("status.code", statusCode);
    }

    @When("I delete a purchase order by Id")
    public void iDeleteAPurchaseOrderById() {
        RequestSpecification request = RestAssured.given();

        Response response =
                request
                        .delete(base_url+"/store/order/"+order_id);

        JsonPath responseBody = response.jsonPath();
        String message = responseBody.get("message");
        scenarioContext.setContext("message.body", message);

        int statusCode = response.getStatusCode();
        scenarioContext.setContext("status.code", statusCode);
    }

    @When("I send a delete request for an order that does not exist")
    public void iSendADeleteRequestForAnOrderThatDoesNotExist() {
        RequestSpecification request = RestAssured.given();

        Response response =
                request
                        .delete(base_url+"/store/order/76543211234567");

        int statusCode = response.getStatusCode();
        scenarioContext.setContext("status.code", statusCode);
    }

    @And("The correct order has been deleted")
    public void theCorrectOrderHasBeenDeleted() {
        String message = (String) scenarioContext.getContext("message.body");
        Assert.assertEquals(message, String.valueOf(order_id));
    }

    @Then("I receive the response code {int}")
    public void iReceiveTheResponseCode(int arg0) {
        int statusCode = (int)scenarioContext.getContext("status.code");
        Assert.assertEquals(arg0, statusCode);
    }
}
