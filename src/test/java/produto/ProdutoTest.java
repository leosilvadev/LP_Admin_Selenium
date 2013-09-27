package produto;

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
public class ProdutoTest extends BaseTest{

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
		String urlAcesso = Propriedade.getPropriedade("url.listaProduto");
		driver.get(urlAcesso);
		
		
		
		driver.findElement(By.className("btnNovoProduto")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("txtCodigo")).sendKeys("00001");
		Thread.sleep(1000);
		driver.findElement(By.className("txtDescricao")).sendKeys("Produto Teste");
		Thread.sleep(1000);
		driver.findElement(By.className("txtMarca")).sendKeys("Marca 1");
		Thread.sleep(1000);
		driver.findElement(By.className("txtUnidade")).sendKeys("Unidade Teste");
		Thread.sleep(1000);
		
		// TODO - Setar o valor do preço (doublespinner)
		//driver.findElement(By.className("dbPreco")).sendKeys("10");
		//Thread.sleep(1000);
		
		// TODO - Setar o valor da quantidade (spinner)
		//driver.findElement(By.className("intQuantidade")).sendKeys("10");
		
		// TODO - Selecionar o fornecedor
		List<WebElement> allOptions = driver.findElements(By.className("lstFornecedorProduto"));
		allOptions.get(0).click();
		//allOptions.get(1).click();
		Assert.assertEquals(1, allOptions.size());
		
		// TODO - Salvar o produto
		//driver.findElement(By.className("btnNovoProduto")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("btnCancelar")).click();
		
		
		
	}
}
