package venda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.BaseTest;
import util.Propriedade;

/**
 * @author HEITOR
 *
 */
public class VendaTest extends BaseTest{

	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test 
	public void testFirefox() throws FileNotFoundException, IOException, InterruptedException {
		FirefoxDriver firefoxDriver = new FirefoxDriver();
		init(firefoxDriver);
		testFlow(firefoxDriver);
	}

	private void testFlow(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException{
		String urlAcesso = Propriedade.getPropriedade("url.listaVenda");
		driver.get(urlAcesso);
		
		driver.findElement(By.className("btnNovaVenda")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("txtDesconto")).sendKeys("50");
		Thread.sleep(1000);
		driver.findElement(By.className("txtQuantidade")).sendKeys("2");
		
		// TODO - Selecionar a forma de pagamento no combobox
		
		// TODO - Selecionar o produto no combobox
		
		Thread.sleep(2000);
		driver.findElement(By.className("btnAdicionarProduto")).click();
		
		// TODO - Verificar o preço total da venda
		
		
		Thread.sleep(2000);
		driver.findElement(By.className("btnCancelar")).click();
		
		
		// TODO - Salvar a venda
		//Thread.sleep(2000);
		//driver.findElement(By.className("btnCancelar")).click();
		
	}
}
