package pages;

import env.DriverUtil;
import org.openqa.selenium.By;

public class CarTaxCheckHomePage {
    public static void registrationNumber(String registrationNumber) {
        DriverUtil.getDriver().findElement(By.xpath("//input[@id='vrm-input']")).sendKeys(registrationNumber);
    }
    public static void freeCarCheck() {
        DriverUtil.getDriver().findElement(By.xpath("//button[contains(text(), 'Free Car Check')]")).click();
    }
}
