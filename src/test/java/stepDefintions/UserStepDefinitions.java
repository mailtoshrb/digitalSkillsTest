package stepDefintions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.VehicleIdentity;
import env.DriverUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.assertj.core.api.Assertions;
import pages.CarTaxCheckHomePage;
import pages.CarTaxCheckResultPage;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class UserStepDefinitions {

    private static List<String> registrationNumbers;
    private static List<VehicleIdentity> actualRegistrationResults = new ArrayList<>();

    @And("^I have registration numbers from a file$")
    public void I_Have_registration() {
        File file = new File("src/test/resources/car_input.txt");

        String content = null;
        try {
            try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
                content = scanner.useDelimiter("\\A").next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        registrationNumbers = findAll("[A-Z]{2}\\d{2} ?[A-Z]{3}", content);
        registrationNumbers = registrationNumbers.stream().map(el -> el.replaceAll(" ", "")).collect(Collectors.toList());

    }

    private static List<String> findAll(String regex, String content) {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile(regex)
                .matcher(content);
        while (m.find()) {
            allMatches.add(m.group());
        }

        return allMatches;
    }


    @Then("^I navigate to \"([^\"]*)\" website$")
    public void navigate_to(String link) {
        DriverUtil.getDriver().get(link);
    }



    @When("^I check registration numbers$")
    public void iEnterRegistrationNumbers() throws InterruptedException {
        registrationNumbers.forEach(reg -> {
            CarTaxCheckHomePage.registrationNumber(reg);
            CarTaxCheckHomePage.freeCarCheck();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (CarTaxCheckResultPage.vehicleFound()) {
                actualRegistrationResults.add(CarTaxCheckResultPage.vehicleIdentity());
            }

            DriverUtil.getDriver().navigate().back();
          /*  try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        });

        System.out.println(actualRegistrationResults);
    }

    @And("^Vehicle identity results are as expected$")
    public void iMatchTheNumberWithFile() throws IOException {
        List<VehicleIdentity> expectedVehicleResults = new ArrayList<>();

        CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(new InputStreamReader(new FileInputStream("src/test/resources/car_output.txt")));
        for (CSVRecord record : csvParser) {
            VehicleIdentity expectedVehicleResult = new VehicleIdentity()
                    .setRegistration(record.get(0))
                    .setMake(record.get(1))
                    .setModel(record.get(2))
                    .setColour(record.get(3))
                    .setYear(Integer.parseInt(record.get(4)));
            expectedVehicleResults.add(expectedVehicleResult);
        }

        Assertions.assertThat(actualRegistrationResults).containsAll(expectedVehicleResults);

    }
}