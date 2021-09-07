**Setup**

1. Clone the project from github
2. Open Intellij and click file then open
3. Browse to the folder where the cloned project is, select the project and click ok
4. Maven should automatically handle all the dependencies (included in the POM file) when loading the project

**To Run**
1. Individual scenario/scenarios: 
- Right click a scenario and click run
- Enter the tag in the runnerclass and run from runner class

2. Feature file:
- Right click the feature file and select run
- Go into the feature file and right click the feature label and select run
- Run the runner class as is

**Assumptions**
1. For my negative test for POST. To get an invalid order response, the request must have an invalid input i.e. string in a number field 
2. If the order exists when retrieving it by ID then you should be able
to send a delete request for the same order ID
   
3. The order id 76543211234567 does not exist
4. 
   
**Issues**
1. The above first two assumptions are not the case with this endpoint. I was not always able to delete an existing order by ID and I receieve a 500 error for
an invalid order.
   
2. My test runner seems to be ignoring tests and I can not figure out why. You are able to run the tests using the other methods described above

