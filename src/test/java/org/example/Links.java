package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Links {
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
    public void linksValidate(){
      List<WebElement> links=  driver.findElements(By.tagName("a"));

      System.out.println("Total numbers of links:"+links.size());
     int count=1;
      for(WebElement link:links){
          String url = link.getAttribute("href");
          if(url==null||url.isEmpty()){
              System.out.println("Empty link HTML: " + link.getAttribute("outerHTML"));
             System.out.println("Link is empty at index : "+count+" "+url+"no text"+link.getText());
             continue;
         }
          count++;
          System.out.println("Link is valid:"+ url);
      }
    }
  @Test
  public void LinksHttpValidate() throws IOException {
        List<WebElement> links=driver.findElements(By.tagName("a"));
        int x=1;
        for(WebElement link:links){
            String url=link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.connect();
            int status = conn.getResponseCode();
            if(status>=400) {
                System.out.println("link is broken at index: "+x+" "+status);
                System.out.println("Empty link HTML: " + link.getAttribute("outerHTML"));

            }x++;
//            else{
//                System.out.println("link is valid at index: "+x+" "+status);
//            }

        }
  }
    @AfterMethod
    public void  tearDown(){
        driver.quit();
    }
}
