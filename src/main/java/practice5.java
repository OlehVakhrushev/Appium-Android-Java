import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class practice5 extends base {

    public static void main(String[] device) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
        driver.hideKeyboard();

        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        //driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
        driver.findElementByXPath("//*[@text='Australia']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(4000);

        WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction t=new TouchAction(driver);
        t.tap((WebElement) tapOptions().withElement(element(checkbox))).perform();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(7000);
        Set<String> contexts=driver.getContextHandles();
        for(String contextName :contexts)
        {
        System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello");
        driver.context("NATIVE_APP");
    }


}