import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.net.MalformedURLException;

public class browse extends baseChrome {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=Capabilities();

    /*driver.get("https://www.facebook.com/");
    driver.findElementByXPath("//*[@id=\"m_login_email\"]").sendKeys("oleh.vakhrushev@gmail.com");
    driver.findElementByXPath("//*[@id=\"m_login_password\"]").sendKeys("Z4055966z");
    driver.findElementByXPath("//button[@value='Log In']").click();*/

    driver.get("https://m.cricbuzz.com/");
    driver.findElementByXPath("//a[@href='#menu']").click();
    driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
    System.out.println(driver.getCurrentUrl());
        JavascriptExecutor jse=(JavascriptExecutor) driver;
            jse.executeScript("window,scrollBy(0,480)","");
            Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));
    // adb devices - Unautarized
    // adb kill server
    // adb srart-server
    // adb devices
    }
}
