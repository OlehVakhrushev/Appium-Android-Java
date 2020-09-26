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
import java.util.concurrent.TimeUnit;

public class practice4 extends base {

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
        int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum=0;
        for(int i=0;i<count;i++)
        {
        String amount1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
        double amount=getAmount(amount1);
        sum=sum+amount;
        }

System.out.println(sum+"sum of products");
String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        total= total.substring(1);

        double totalValue=Double.parseDouble(total);
        System.out.println(totalValue+"Total value of products");
        Assert.assertEquals(sum, totalValue);
        WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction t=new TouchAction(driver);
        //t.tap(tapOptions().withElement(element(checkbox))).perform();
        WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
        //t.longPress(longPressOptions().withElement(element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    }
    public static double getAmount(String value)
    {
        value= value.substring(1);
        double amount2value=Double.parseDouble(value);
        return amount2value;

    }

}