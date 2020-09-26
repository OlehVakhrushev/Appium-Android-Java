import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class practice3 extends base {

    public static void main(String[] device) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElementByXPath("//*[@text='Female']").click();
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
        driver.findElementByXPath("//*[@text='Australia']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
        int count=    driver.findElementsById("com.androidsample.generalstore:id/productName").size();
        for(int i=0;i<count;i++)
        {
            String text=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
            if(text.equalsIgnoreCase("Jordan 6 Rings"))
            {
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(4000);
        String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
    Assert.assertEquals("Jordan 6 Rings", lastpageText);

    }
}