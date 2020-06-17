package pages;

import data.VehicleIdentity;
import env.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;

public class CarTaxCheckResultPage {
    public static String registration() {
        return DriverUtil.getDriver().findElement(By.xpath("//dt[text() = 'Registration']//following-sibling::dd")).getText();
    }

    public static String make() {
        return DriverUtil.getDriver().findElement(By.xpath("//dt[text() = 'Make']//following-sibling::dd")).getText();
    }
    public static String model() {
        return DriverUtil.getDriver().findElement(By.xpath("//dt[text() = 'Model']//following-sibling::dd")).getText();
    }
    public static String colour() {
        return DriverUtil.getDriver().findElement(By.xpath("//dt[text() = 'Colour']//following-sibling::dd")).getText();
    }
    public static String year() {
        return DriverUtil.getDriver().findElement(By.xpath("//dt[text() = 'Year']//following-sibling::dd")).getText();
    }

    public static boolean vehicleFound() {
        boolean found = false;
        try {
            DriverUtil.getDriver().findElement(By.xpath("//span[text() = 'Vehicle Not Found']"));
        } catch( NoSuchElementException ex) {
            found = true;
        }
        return found;
    }

    public static VehicleIdentity vehicleIdentity() {
        return new VehicleIdentity()
                .setRegistration(registration())
                .setMake(make())
                .setModel(model())
                .setColour(colour())
                .setYear(Integer.parseInt(year()));
    }
}
