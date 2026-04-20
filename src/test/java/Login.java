import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
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
    @Test
      public  void InvalidatePasswordTest(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("sauce");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div ")).click();
        String msg =driver.findElement(By.cssSelector("h3")).getText();
       // System.out.print(msg);
        Assert.assertTrue(msg.contains("Username and password do not match any user in this service"),"invalid Credentials");
    }
    @Test
     public void InvalidUsernameTest(){
        driver.findElement(By.id("user-name")).sendKeys("Nitish");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div ")).click();
        String msg =driver.findElement(By.cssSelector("h3")).getText();
        Assert.assertTrue(msg.contains("Username and password do not match any user in this service"),"Invalid Credentials");
    }
    @Test
    public void InvalidateLoginTest()  {
        driver.findElement(By.id("user-name")).sendKeys("standard");
        driver.findElement(By.id("password")).sendKeys("secret");
        driver.findElement(By.id("login-button")).click();
        String errormsg = driver.findElement(By.cssSelector("h3")).getText();
       Assert.assertTrue(errormsg.contains("Username and password do not match"),"Invalid Message");
    }


  @Test
    public void emptyField(){
        driver.findElement(By.id("user-name")).sendKeys(" ");
        driver.findElement(By.id("password")).sendKeys(" ");
        driver.findElement(By.id("login-button")).click();
        String errormsg =driver.findElement(By.cssSelector("h3")).getText();
        Assert.assertTrue(errormsg.contains("Username and password do not match"),"Invalid emptyfield msg");
  }
  @Test
    public void lockedOutUser(){
      driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
      driver.findElement(By.id("password")).sendKeys("secret_sauce");
      driver.findElement(By.id("login-button")).click();
      String Lockedmsg =driver.findElement(By.cssSelector("h3")).getText();
      Assert.assertTrue(Lockedmsg.contains("Sorry, this user has been locked out."),"Invalid Locked out msg");
  }



    @AfterMethod
      public void tearDown()  {
        driver.quit();
    }
}
