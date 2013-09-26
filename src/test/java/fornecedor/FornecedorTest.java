package fornecedor;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.BaseTest;
import util.Propriedade;

public class FornecedorTest extends BaseTest {

	@Test
	public void testFirefox() throws FileNotFoundException, IOException, InterruptedException{
		FirefoxDriver firefoxDriver = new FirefoxDriver();
		init(firefoxDriver);
		testFlow(firefoxDriver);
	}
	
	@Test
	@Ignore
	public void testChrome() throws FileNotFoundException, IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		testFlow(new ChromeDriver());
	}
	
	public void testFlow(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException{
		String urlAcesso = Propriedade.getPropriedade("url.listafornecedor");
		driver.get(urlAcesso);
		int size = driver.findElements(By.className("item_email_fornecedor")).size();
		
		driver.findElement(By.className("btnNovoFornecedor")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("txtNome")).sendKeys("Fornecedor Teste");
		Thread.sleep(1000);
		driver.findElement(By.className("txtTelefone")).sendKeys("(12)12345432");
		Thread.sleep(1000);
		driver.findElement(By.className("txtEndereco")).sendKeys("Rua Fulano teste selenium");
		Thread.sleep(1000);
		driver.findElement(By.className("txtEmail")).sendKeys("fulano@teste.com.br");
		Thread.sleep(1000);
		driver.findElement(By.className("btnSalvar")).click();
		
		Thread.sleep(2000);
		
		Assert.assertEquals(size+1, driver.findElements(By.className("item_email_fornecedor")).size());
		
		Thread.sleep(2000);
		driver.close();
	}	

}
