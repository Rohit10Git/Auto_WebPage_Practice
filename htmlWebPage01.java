package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class htmlWebPage01 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Applications\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		
// Web-site opening		
		          driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		          driver.manage().window().maximize();
		          Thread.sleep(2000);
		          System.out.println("Web-site Successfully opened");
		          
// Getting Title of page
		          String Title = driver.getTitle();
		          System.out.println("Web-page Title is = " +Title);
		          
		          if(Title.equals("Web form"))
		          {
		        	  System.out.println("Title Test Passed");
		          }
		          else
		          {
		        	  System.out.println("Title Test Failed");
		          }
		          
// Text Input Checking	
		          WebElement w1 = driver.findElement(By.id("my-text-id"));                  // UserName Box
		                     w1.sendKeys("Rohit");
		                     System.out.println("UserName printed successfully");
		                     Thread.sleep(1000);
		          WebElement w2 = driver.findElement(By.name("my-password"));               // Password Box
		                     w2.sendKeys("12345");
		                     System.out.println("Password printed successfully");
		                     Thread.sleep(1000);
		          WebElement w3 = driver.findElement(By.name("my-textarea"));               // TextArea Box
		                     w3.sendKeys("Hello from Rohit");
		                     System.out.println("TextArea working properly");
		                     Thread.sleep(1000);
		                     
// Disable input checking
		             boolean w4 = driver.findElement(By.name("my-disabled")).isEnabled();   // Disabled Box
		                     System.out.println("Input Box is Enabled = " +w4);             // False Expected
		                     Thread.sleep(1000);
		             boolean w5 = driver.findElement(By.name("my-readonly")).isEnabled();   // ReadOnly Box
		                     System.out.println("ReadBox is Enabled = " +w5);               // True Expected
		                     Thread.sleep(1000);
		                     
		             String ReadBox = driver.findElement(By.name("my-disabled")).getAttribute("name"); //Attribute value
		                    System.out.println("ReadBox contains = " +ReadBox);
		                    Thread.sleep(1000);
		                    
// Link check
		           WebElement w6 = driver.findElement(By.linkText("Return to index"));        // Link
		                      w6.click();
		                      Thread.sleep(2000);
		                      driver.navigate().back();
		                      System.out.println("Back to Home Page");
		                      Thread.sleep(2000);
	
// Drop-down check
		           WebElement w7 = driver.findElement(By.name("my-select"));                  // drop-down
		           
		           Select opt = new Select(w7);
		                  opt.selectByIndex(1);
		                  System.out.println("First value = one");
		                  Thread.sleep(2000);
		                  opt.selectByValue("2");
		                  System.out.println("Second value = Two");
		                  Thread.sleep(2000);
		                  opt.selectByVisibleText("Three");
		                  System.out.println("Third value = Three");
		                  Thread.sleep(2000);
		                  
// Drop-down data-list check	
		                  
		           WebElement w8 = driver.findElement(By.name("my-datalist"));                // Data list
		                      w8.sendKeys("Bangalore");
		                      System.out.println("City selected = Bangalore");
		                      Thread.sleep(2000);
		                      
// File upload check
		           WebElement w9 = driver.findElement(By.name("my-file"));                     // File upload
		                      w9.sendKeys("C:\\Users\\ROHIT\\Documents\\Testing File.txt");
		                      Thread.sleep(2000);
		                      
// Check box validation
		              boolean w10 = driver.findElement(By.id("my-check-1")).isSelected();      // Check box 1
		                      System.out.println("Checkbox 1 is selected = " +w10);            // True expected
		                      Thread.sleep(2000);
		                      
		              boolean w11 = driver.findElement(By.id("my-check-2")).isSelected();      // Check box 2
		                      System.out.println("Checkbox 1 is selected = " +w11);            // False expected
		                      Thread.sleep(2000);       
		                
		                      if(w11 == false)
		                      {
		                    	  driver.findElement(By.id("my-check-2")).click();
		                      }
		                      Thread.sleep(1000);
		                      
// Radio button validation
		              boolean w12 = driver.findElement(By.id("my-radio-1")).isSelected();      // Radio button 1
		                      System.out.println("Radio button 1 is selected = " +w12);        // True expected
		                      Thread.sleep(2000); 
		                      
		              boolean w13 = driver.findElement(By.id("my-radio-2")).isSelected();      // Radio button 2
		                      System.out.println("Radio button 2 is selected = " +w13);        // False expected
		                      Thread.sleep(2000);
		                      
// Color picker check	
		           WebElement w14 = driver.findElement(By.name("my-colors"));                  // Color box
		                      String paint = w14.getCssValue("color");
		                      System.out.println("Color code = " +paint);
		                      Thread.sleep(1000);
		                      
// Range bar check
		           WebElement w15 = driver.findElement(By.name("my-range"));                   //  Range bar
		                      
		              Actions act = new Actions(driver);
		                      act.clickAndHold(w15).moveToLocation(1250, 0).release().build().perform();
		                      Thread.sleep(2000);
		                      System.out.println("Range bar moved Successfully");
		                   
// Date picker check
		           WebElement w16 = driver.findElement(By.name("my-date"));                     // Date picker
		                      w16.click();
		                      Thread.sleep(2000);
		           String Month_Year = driver.findElement(By.xpath("//*[@class='datepicker-days']//*[@class='datepicker-switch']")).getText();   // Month_Year
		                      Thread.sleep(2000);		           
		                      System.out.println(Month_Year);
		          
		           WebElement w17 =  driver.findElement(By.xpath("//*[@class='datepicker-days']//*[@class='datepicker-switch']"));   
		           
		           while(true)
		           {
		        	   if(w17.getText().equals("October 2024"))
		        	   {
		        		   System.out.println(w17.getText());
		        		   Thread.sleep(2000);
		        		   break;		        		   
		        	   }		        	  
		        	   else
		        	   {
		        		   Thread.sleep(2000);
		        		   driver.findElement(By.xpath("//*[@class='datepicker-days']//*[@class='next']")).click();
		        	   }
		           }
		           
		                      Thread.sleep(2000);
		           WebElement w18 =  driver.findElement(By.xpath("//*[@class='datepicker-days']//*[text()='10']")); 	 // Date	                     
		                      System.out.println(w18.getText());
		                      w18.click();
		                      Thread.sleep(2000);  
		                      
		           boolean w19 = driver.findElement(By.xpath("//*[text()='Submit']")).isEnabled();   // Submit Button
			               System.out.println("Submit Button is Enabled = " +w19);             // True Expected
			               Thread.sleep(1000);            
			               
			               driver.findElement(By.xpath("//*[text()='Submit']")).click();
			               Thread.sleep(1000);			              			               
	                      
	}

}
