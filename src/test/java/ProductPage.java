import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ProductPage {
    WebDriver driver;
    @BeforeMethod
        public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void productName(){

        String title = driver.findElement(By.className("title")).getText();
        System.out.println(title);
        Assert.assertEquals(title,"Products","Title is invalid ");

        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        int size = products.size();
        System.out.println("No of products are "+size);
        Assert.assertTrue(size>0,"No of item is zero");
        for(WebElement product:products){
            String name= product.findElement(By.className("inventory_item_name")).getText();
            System.out.println("Product name is:"+name);
            Assert.assertFalse(name.isEmpty(),"Product name is empty");
        }
    }
 @Test
   public void productPrice(){
     List<WebElement> product = driver.findElements(By.className("inventory_item"));
        for(WebElement item:product){
            String price =item.findElement(By.className("inventory_item_price")).getText();
            System.out.println("Price of item is : "+ price);
            Assert.assertFalse(price.isEmpty(),"Price of item is empty");
            Assert.assertTrue(price.contains("$"),"Invalid price format");

            if(price != null && price.contains("$")) {
                double priceValue = Double.parseDouble(price.replace("$", ""));
                Assert.assertTrue(priceValue > 0);
            }

        }

 }

 @Test
    public void ButtonChange(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String button = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
        Assert.assertEquals(button,"Remove","Validate unsucessfull");
 }
 @Test
    public void imageValidation(){
      List<WebElement> images =driver.findElements(By.className("inventory_item_img"));

     for(WebElement img:images){
         Assert.assertTrue(img.isDisplayed(),"No image is found");
     }
 }
 @Test
   public void addToCartValidate(){
      List<WebElement> buttons = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));

      for (WebElement btn : buttons) {
          Assert.assertTrue(btn.isDisplayed(), "Add to cart button missing");
      }
  }
    @AfterMethod
     public void tearDown(){
        driver.quit();
    }
}
