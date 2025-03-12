package org.automation.testingworld.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class samples {
	

	

	    static WebDriver driver = null;

	    public static void main(String[] args) {
driver = new EdgeDriver();

	        EdgeOptions options = new EdgeOptions();
	        options.addArguments("--inprivate");
	       
	        driver = new EdgeDriver(options);
	       
	        Timer timer = new Timer();
	        TimerTask Ttask = new TimerTask() {
	            @Override
	            public void run() {
	                try {
						Upload();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        };

	        timer.schedule(Ttask, 0, 18000000);
	    }

	    public static void Upload() throws InterruptedException {

	        //defining current time
	        LocalDateTime timestamp = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
	        String formattedTimestamp = timestamp.format(formatter);



	        driver.get("https://www.naukri.com/nlogin/login?URL=https://www.naukri.com/mnjuser/homepage");
	        driver.manage().window().maximize();
Thread.sleep(2000);
	        driver.findElement(By.id("usernameField")).sendKeys("kranthig787@gmail.com");

	        driver.findElement(By.id("passwordField")).sendKeys("Kranthi@123");

	        driver.findElement(By.xpath("//button[text()='Login']")).click();

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	       
	        driver.findElement(By.xpath("//div/a[contains(@href,\"/mnjuser/profile\") and contains(text(),\"View\")]")).click();

	       // driver.findElement(By.xpath("//a[text()='Complete']")).click();

	     //   driver.findElement(By.xpath("//a[text()='Update']")).sendKeys("C:\\Users\\VISHNU VARDHAN\\Vishnu_Automation_QA_Resume.pdf");

	        driver.findElement(By.id("attachCV")).sendKeys("C:\\Users\\gollam\\Downloads\\Kranthi Netsuite Ns1 (2).docx");
	       
	       
Thread.sleep(1000);
	        //Taking and saving screenshot with timestamp
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotPath = "./" + formattedTimestamp + ".png";
	        File screenshotWithTimestamp = new File(screenshotPath);
	        try {
	            Path sourcePath = screenshotFile.toPath();
	            Path destinationPath = screenshotWithTimestamp.toPath();
	            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
	            System.out.println("Screenshot saved to: " + screenshotWithTimestamp.getAbsolutePath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	     // driver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div[1]/div")).click();
	        String updateDate = driver.findElement(By.xpath("//div[@class='updateOn typ-14Regular']")).getText();
	       
	        driver.findElement(By.xpath("//span[contains(text(),\"Resume headline\")]/following-sibling::span[contains(text(),\"editOneTheme\")]")).click();
	        Thread.sleep(1000);
	       // driver.findElement()
	        driver.findElement(By.xpath("//button[contains(text(),\"Save\") and @type=\"submit\"]")).click();

	        System.out.println(updateDate);

	        driver.quit();
	    }
	

}
