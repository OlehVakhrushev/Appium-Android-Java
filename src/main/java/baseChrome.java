import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class baseChrome {

    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
        //File f=new File("src");
        //File fs=new File(f, "ApiDemos-debug.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability("chromedriverExecutable", "C:\\Users\\Oleg\\IdeaProjects\\Appium-Android-Java\\src\\chromedriver.exe");

        //cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
            return driver;
        // AndroidUIAutomator



    }
}