import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddtoCart {
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
    public void oneProductValidate(){
      driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
      String count = driver.findElement(By.className("shopping_cart_badge")).getText();
      System.out.print("no of Element: "+count);
      String button = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
      Assert.assertEquals(button,"Remove","Button not work");

    }

    @Test
    public void multipleProductValidate(){
        List<WebElement> button = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
        for(WebElement but:button){
            but.click();
        }
        String cartName =driver.findElement(By.className("shopping_cart_badge")).getText();
        System.out.println("Total item added:"+cartName);
        Assert.assertEquals(Integer.parseInt(cartName), button.size(), "Not all items added");
    }
    @Test
    public void checkoutButton() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("rajput");
        Thread.sleep(5000);
        driver.findElement(By.id("last-name")).sendKeys("$3245Tg");
        driver.findElement(By.id("postal-code")).sendKeys("123456");
        String beforetitle=  driver.findElement(By.className("title")).getText();
        Assert.assertEquals(beforetitle,"Checkout: Your Information" ,"Title of before page is wrong");
        driver.findElement(By.id("continue")).click();
        String title=  driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title,"Checkout: Overview" ,"Title of page is wrong");
        driver.findElement(By.id("finish")).click();
        String msg=driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(msg,"Thank you for your order!","You are not able to checkout product");
    }
    @AfterMethod
    public void  tearDown(){
        driver.quit();
    }
}
