import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class swipedemo extends base {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver= base.Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
    driver.findElementByXPath("//*[@content-desc='9']").click();
        TouchAction t=new TouchAction(driver);
        // long press // on element // 2 sec// and then move to another element and realese
        WebElement first=driver.findElementByXPath("//*[@content-desc='15']");
        WebElement second=driver.findElementByXPath("//*[@content-desc='45']");
        //t.longPress(LongPressOptions.longPressOptions().withElement(element(first)).withDuration(Duration.ofSeconds(2))).moveTo(element(second)).release().perform();
    }
}
