import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class practice2 extends base {

    public static void main(String[] device) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
        driver.hideKeyboard();

        driver.findElementByXPath("//*[@text='Female']").click();
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
        driver.findElementByXPath("//*[@text='Australia']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        String toastMessage=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
// name attribute fot toast will have content
        System.out.println(toastMessage);

    }
}
