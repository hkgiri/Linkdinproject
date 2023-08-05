package linkedin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SayHelloInLInkedin {
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://in.linkedin.com/home");
		driver.navigate().refresh();
		FileLibrary f=new FileLibrary();
		String email = f.getPropertyData("Email");
		String password = f.getPropertyData("Password");
		String searchName = f.getPropertyData("SearchName");
		String lastName = f.getPropertyData("LastName");
		
		driver.findElement(By.id("session_key")).sendKeys(email);
		driver.findElement(By.id("session_password")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(.,'Sign in')]")).click();
		driver.findElement(By.xpath("//span[text()='Messaging']/../../child::a")).click();
		driver.findElement(By.id("search-conversations")).sendKeys("Sandeep kumar yadav");
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(By.xpath("(//div[@class='msg-conversation-card__rows']/../div)[1]")).click();
        driver.findElement(By.xpath("//div[@aria-label='Write a message…']")).sendKeys("Hello");
        driver.findElement(By.xpath("//button[text()='Send']/parent::div")).click();
        
        
		
		
	}

}
