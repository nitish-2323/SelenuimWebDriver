import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateLogin {
     WebDriver driver;
    @BeforeMethod
      public void driverSetUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @Test
      public void validateLoginTest() throws InterruptedException {

        String title =driver.getTitle();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(title,"Swag Labs","Invalid Title");
        Assert.assertEquals(url,"https://www.saucedemo.com/","Invalid Url");
      //  Thread.sleep(8000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div ")).click();
        String titlemsg =driver.findElement(By.className("title")).getText();
        Assert.assertEquals(titlemsg,"Products","Unsucessfully Validated");
    }
    @AfterMethod
      public void tearDown()  {

        driver.quit();
    }
}
