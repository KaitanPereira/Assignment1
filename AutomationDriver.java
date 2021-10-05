
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Assignment\\Driver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		AutomationDriver.exercise1(driver);
		AutomationDriver.exercise2(driver);
		AutomationDriver.exercise3(driver);
		AutomationDriver.exercise4(driver);
		AutomationDriver.exercise4Point1(driver);
		AutomationDriver.exercise4Point2(driver);
		AutomationDriver.exercise5(driver);
		AutomationDriver.exercise6(driver);
		AutomationDriver.exercise7(driver);
	}
	
	static void exercise1(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@value='radio3']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio3']")).isSelected());
		
	}
	
	static void exercise2(WebDriver driver) throws InterruptedException{
		driver.findElement(By.id("autocomplete")).sendKeys("United State");
		List<WebElement> options = driver.findElements(By.xpath("//input[@type='text']"));
		for (WebElement option : options) {
			if(option.getText().equalsIgnoreCase("United State")) {
				option.click();
				break;
			}
			
		}
	}
	static void exercise3(WebDriver driver) throws InterruptedException{
		System.out.println("exercise3");
		driver.findElement(By.name("dropdown-class-example")).click();
		driver.findElement(By.xpath("//option[@value='option1']")).click();
		System.out.println(driver.findElement(By.xpath("//option[@value='option1']")).isSelected());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//option[@value='option2']")).click();
		System.out.println(driver.findElement(By.xpath("//option[@value='option2']")).isSelected());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//option[@value='option3']")).click();
		System.out.println(driver.findElement(By.xpath("//option[@value='option3']")).isSelected());
		Thread.sleep(1000);
	}
	
	static void exercise4(WebDriver driver) throws InterruptedException{
		System.out.println("exercise4");
		driver.findElement(By.name("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.name("checkBoxOption1")).isSelected());
		Thread.sleep(1000);
		//deselect option1
		driver.findElement(By.name("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.name("checkBoxOption1")).isSelected());//expected false
		Thread.sleep(1000);
		
		driver.findElement(By.name("checkBoxOption2")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption2")).isSelected());
		Thread.sleep(1000);
		//deselect option2
		driver.findElement(By.name("checkBoxOption2")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption2")).isSelected());
		Thread.sleep(1000);
		
		driver.findElement(By.name("checkBoxOption3")).click();
		System.out.println(driver.findElement(By.name("checkBoxOption3")).isSelected());
		Thread.sleep(1000);
		//deselect option3
		driver.findElement(By.name("checkBoxOption3")).click();
		System.out.println(driver.findElement(By.name("checkBoxOption3")).isSelected());//expected false
		
	}
	
	static void exercise4Point1(WebDriver driver) throws InterruptedException{
		List<WebElement> checkboxes = driver.findElements(By.xpath("//fieldset/label/input[@type='checkbox']"));
		for(WebElement checkbox : checkboxes) {
			checkbox.click();
			Thread.sleep(1000);	
		}	
		
	}

	static void exercise4Point2(WebDriver driver) throws InterruptedException{
		List<WebElement> checkboxes = driver.findElements(By.xpath("//fieldset/label/input[@type='checkbox']"));
		for(WebElement checkbox : checkboxes) {
			checkbox.click();
			Thread.sleep(1000);	
		}	
	}
	
	static void exercise5(WebDriver driver) throws InterruptedException{
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(3000);
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
		driver.switchTo().window(parent);
	}
	
	static void exercise6(WebDriver driver) throws InterruptedException{
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(2000);
		Set<String> Windows1 = driver.getWindowHandles();
		Iterator<String> it = Windows1.iterator();
		String parent1 = it.next();
		String child1 = it.next();
		driver.switchTo().window(parent1);
		Thread.sleep(2000);
		driver.switchTo().window(child1);
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(parent1);
	}
	
	static void exercise7(WebDriver driver) throws InterruptedException{
		driver.findElement(By.id("name")).sendKeys("Kaitan");
		Thread.sleep(2000);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println("Eercise7 alert output");
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
	}
	
	static void exercise8(WebDriver driver) throws InterruptedException{
		
	}
	
}
