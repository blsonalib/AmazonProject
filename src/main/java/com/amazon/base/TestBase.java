package com.amazon.base;
import com.amazon.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public TestBase() {
        prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\HP\\Documents\\AmazonProject\\src\\main\\java\\com\\amazon\\config\\config.properties");
            prop.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialize(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\HP\\Documents\\AmazonProject\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIME_OUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
