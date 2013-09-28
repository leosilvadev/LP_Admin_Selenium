package fornecedor;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.BaseTest;
import util.Propriedade;

public class PesquisaFornecedorTest extends BaseTest{

	@Test 
	public void testFirefox() throws FileNotFoundException, IOException, InterruptedException {
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

	private void testFlow(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException{
		String urlAcesso = Propriedade.getPropriedade("url.listafornecedor");
		driver.get(urlAcesso);
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("txtPesquisaNome")).sendKeys("Fornec");
		Thread.sleep(1000);
		driver.findElement(By.className("btnProcurarPorNome")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.className("txtPesquisaNome")).clear();
		Thread.sleep(2000);
		
		driver.findElement(By.className("txtPesquisaNome")).sendKeys("");
		Thread.sleep(1000);
		driver.findElement(By.className("btnProcurarPorNome")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.className("txtPesquisaNome")).clear();
		Thread.sleep(2000);
		
		driver.findElement(By.className("txtPesquisaNome")).sendKeys("este");
		Thread.sleep(1000);
		driver.findElement(By.className("btnProcurarPorNome")).click();
		Thread.sleep(2000);
		
		driver.close();
		
	}
}

