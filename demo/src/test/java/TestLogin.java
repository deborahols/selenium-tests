import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLogin {

    private WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Dev\\drivers\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
	    options.setCapability("browserVersion", "136.0.7103.49");
		
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
	}

	@AfterEach
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void testLogin() {
		
		WebElement campoUsuario = driver.findElement(By.id("user-name"));
		WebElement campoSenha = driver.findElement(By.id("password"));
		WebElement botaoLogin = driver.findElement(By.id("login-button"));
	
		campoUsuario.sendKeys("standard_user");
		campoSenha.sendKeys("secret_sauce");
		
		assertEquals("standard_user", driver.findElement(By.id("user-name")).getDomAttribute("value"));
		assertEquals("secret_sauce", driver.findElement(By.id("password")).getDomAttribute("value"));
		botaoLogin.click();
	}

    @Test
	public void testUserInvalido() {
		
		WebElement campoUsuario = driver.findElement(By.id("user-name"));
		WebElement campoSenha = driver.findElement(By.id("password"));
		WebElement botaoLogin = driver.findElement(By.id("login-button"));
	
		campoUsuario.sendKeys("standard_use");
		campoSenha.sendKeys("secret_sauce");
		
		assertEquals("standard_use", driver.findElement(By.id("user-name")).getDomAttribute("value"));
		assertEquals("secret_sauce", driver.findElement(By.id("password")).getDomAttribute("value"));
		botaoLogin.click();
	}

    @Test
	public void testPasswordInvalido() {
		
		WebElement campoUsuario = driver.findElement(By.id("user-name"));
		WebElement campoSenha = driver.findElement(By.id("password"));
		WebElement botaoLogin = driver.findElement(By.id("login-button"));
	
		campoUsuario.sendKeys("standard_user");
		campoSenha.sendKeys("Secret_sauce");
		
		assertEquals("standard_user", driver.findElement(By.id("user-name")).getDomAttribute("value"));
		assertEquals("Secret_sauce", driver.findElement(By.id("password")).getDomAttribute("value"));
		botaoLogin.click();
	}
    
}
