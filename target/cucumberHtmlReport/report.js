$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/freeCarCheck.feature");
formatter.feature({
  "line": 1,
  "name": "Free Car Check website - Any user can Free Car Check from Website",
  "description": "",
  "id": "free-car-check-website---any-user-can-free-car-check-from-website",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1419624404,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Browse Free Car tax Check website",
  "description": "",
  "id": "free-car-check-website---any-user-can-free-car-check-from-website;browse-free-car-tax-check-website",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I have registration numbers from a file",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I navigate to \"https://cartaxcheck.co.uk/\" website",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I check registration numbers",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Vehicle identity results are as expected",
  "keyword": "Then "
});
formatter.match({
  "location": "UserStepDefinitions.I_Have_registration()"
});
formatter.result({
  "duration": 72856098,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://cartaxcheck.co.uk/",
      "offset": 15
    }
  ],
  "location": "UserStepDefinitions.navigate_to(String)"
});
formatter.result({
  "duration": 931378019,
  "status": "passed"
});
formatter.match({
  "location": "UserStepDefinitions.iEnterRegistrationNumbers()"
});
formatter.result({
  "duration": 34378070645,
  "status": "passed"
});
formatter.match({
  "location": "UserStepDefinitions.iMatchTheNumberWithFile()"
});
formatter.result({
  "duration": 85922256,
  "error_message": "java.lang.AssertionError: \nExpecting ArrayList:\n \u003c[{\"Registration\":\"DN09HRM\",\"Make\":\"BMW\",\"Colour\":\"Black\",\"Year\":2009},\n    {\"Registration\":\"KT17DLX\",\"Make\":\"Skoda\",\"Colour\":\"White\",\"Year\":2017},\n    {\"Registration\":\"SG18HTN\",\"Make\":\"Volkswagen\",\"Colour\":\"White\",\"Year\":2018}]\u003e\nto contain:\n \u003c[{\"Registration\":\"SG18HTN\",\"Make\":\"Volkswagen\",\"Colour\":\"White\",\"Year\":2018},\n    {\"Registration\":\"DN09HRM\",\"Make\":\"BMW\",\"Colour\":\"Black\",\"Year\":2009},\n    {\"Registration\":\"BW57BOF\",\"Make\":\"Toyota\",\"Colour\":\"Black\",\"Year\":2010},\n    {\"Registration\":\"KT17DLX\",\"Make\":\"Skoda\",\"Colour\":\"White\",\"Year\":2017}]\u003e\nbut could not find the following element(s):\n \u003c[{\"Registration\":\"BW57BOF\",\"Make\":\"Toyota\",\"Colour\":\"Black\",\"Year\":2010}]\u003e\n\n\tat stepDefintions.UserStepDefinitions.iMatchTheNumberWithFile(UserStepDefinitions.java:112)\n\tat ✽.Then Vehicle identity results are as expected(features/freeCarCheck.feature:7)\n",
  "status": "failed"
});
formatter.after({
  "duration": 85309574,
  "status": "passed"
});
});