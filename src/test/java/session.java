import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class session {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }

    @Test
      public void Session(){
        driver.navigate().refresh();


        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.contains("inventory")) {
            System.out.println("Session is ACTIVE after refresh");
        } else {
            System.out.println("Session LOST");
        }
    }
    @AfterMethod
    public void  tearDown(){
        driver.quit();
    }
}
