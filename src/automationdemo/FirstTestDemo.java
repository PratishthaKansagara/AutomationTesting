package automationdemo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestDemo{
	 private WebDriver driver;
	 private String baseUrl;
	 
	 //Initialization of variable and driver
	@Before
	 public void setUp() throws Exception {		
	   driver = new FirefoxDriver();
	   baseUrl = "http://test.peddle.com";
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	//Test start from URL and at the end of offer value.
	@Test
	  public void testExample() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.xpath("//button[contains(text(),'Get your offer')]")).click();
	    driver.findElement(By.id("yearInput")).sendKeys("2014");
	    driver.findElement(By.id("makeInput")).sendKeys("BMW");
	    driver.findElement(By.id("modelInput")).sendKeys("228i");
	    driver.findElement(By.id("trimInput")).sendKeys("I");
	    driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[5]/div[1]/div/table/tbody/tr/td[3]/a/strong")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[7]/div/div[2]/a[1]/table/tbody/tr/td[1]/div/div/ins")).click();
	    driver.findElement(By.id("zipInput")).sendKeys("10001");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[9]/div/div[1]/table/tbody/tr/td[3]/a/strong")).click();
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[10]/div/div[2]/a[1]/table/tbody/tr/td[1]/div/div/ins")).click();
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[11]/div/div[2]/a[1]/table/tbody/tr/td[1]/div/div/ins")).click();
	    driver.findElement(By.id("mileageInput")).sendKeys("33");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[14]/div/div[1]/table/tbody/tr/td[3]/a/strong")).click();
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[15]/div/div[2]/a[1]/table/tbody/tr/td[1]/div/div/ins")).click();
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[16]/div/div[2]/a[1]/table/tbody/tr/td[1]/div/div/ins")).click();
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[17]/div/div[2]/a[1]/table/tbody/tr/td[1]/div/div/ins")).click();
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[18]/div/div[2]/a[1]/table/tbody/tr/td[1]/div/div/ins")).click();
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[19]/div[1]/div[1]/div/div/div[19]/div/div[2]/a[1]/table/tbody/tr/td[1]/div/div/ins")).click();
		Thread.sleep(6000);
		String offervalue=driver.findElement(By.id("checkOfferText")).getText();
		System.out.println(offervalue);
		//call csvfile method 
		csvFile(offervalue);
	}
	//close the driver
	@After
	public void tearDown() throws Exception {
	     driver.quit();	
	}
	//code to generate csv file and save it in e:\\ drive 
	private void csvFile(String offerval){
	  	String csv = "e:\\output.csv";
		FileWriter writer;
		try {
			writer = new FileWriter(csv);
			writer.append("offervalue:\n"+offerval);
			writer.close();
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

