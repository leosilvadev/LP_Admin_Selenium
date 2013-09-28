package venda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import util.BaseTest;
import util.Propriedade;

public class VendaTest extends BaseTest{

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
		String urlAcesso = Propriedade.getPropriedade("url.listavenda");
		driver.get(urlAcesso);
		
		driver.findElement(By.className("btnNovaVenda")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("txtDesconto")).sendKeys("50");
		Thread.sleep(1000);
		
		Select selectFormaPagamento = new Select(driver.findElement(By.className("lstFormasPagamento")));
		selectFormaPagamento.selectByIndex(1);
		Thread.sleep(1000);
		
		Select selectProduto = new Select(driver.findElement(By.className("lstProdutosDisponiveis")));
		selectProduto.selectByVisibleText("Produto Teste");
		Thread.sleep(1000);
		
		driver.findElement(By.className("txtQuantidade")).sendKeys("2");
		Thread.sleep(2000);
		
		driver.findElement(By.className("btnAdicionarProduto")).click();
		
		// TODO - Verificar o preço total da venda
		
		Thread.sleep(2000);		
		
		driver.findElement(By.className("btnSalvar")).click();
		//driver.findElement(By.className("btnCancelar")).click();
		Thread.sleep(2000);
		
		driver.close();
		
	}
}
