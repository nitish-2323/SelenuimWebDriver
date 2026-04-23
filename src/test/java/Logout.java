import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logout {
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
    public void logoutTitle() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        String title= driver.getTitle();
        Assert.assertEquals(title,"Swag Labs","Not sucessfully Logout with correct title");
    }
    @Test
    public void logoutUrl() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        String url =driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.saucedemo.com/","Not Corect url after logout");
    }
    @Test
    public void logout() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed(),"Not Suceesfully logout ");
    }
    @AfterMethod
    public void  tearDown(){
        driver.quit();
    }
}
