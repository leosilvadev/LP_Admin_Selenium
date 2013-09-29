package produto;

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

public class ProdutoTest extends BaseTest{

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
		String urlAcesso = Propriedade.getPropriedade("url.listaproduto");
		driver.get(urlAcesso);
		
		driver.findElement(By.className("btnNovoProduto")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("txtCodigo")).sendKeys("BR001");
		Thread.sleep(1000);
		driver.findElement(By.className("txtDescricao")).sendKeys("Produto Teste");
		Thread.sleep(1000);
		driver.findElement(By.className("txtMarca")).sendKeys("Marca 1");
		Thread.sleep(1000);
		Select selectUnidade = new Select(driver.findElement(By.className("lstUnidade")));
		selectUnidade.selectByIndex(1);
		Thread.sleep(1000);
		driver.findElement(By.className("dbPreco")).sendKeys("10,99");
		Thread.sleep(1000);
		driver.findElement(By.className("intQuantidade")).findElement(By.className("z-spinner-btn-upper")).click();
		Thread.sleep(1000);
		
		Select selectFornecedor = new Select(driver.findElement(By.className("lstFornecedorProduto")));
		selectFornecedor.selectByIndex(1);
		Thread.sleep(1000);
		
		//List<WebElement> allOptions = driver.findElements(By.className("lstFornecedorProduto"));
		//allOptions.get(0).click();
		//Assert.assertEquals(1, allOptions.size());
		
		driver.findElement(By.className("btnSalvar")).click();
		//driver.findElement(By.className("btnCancelar")).click();
		Thread.sleep(2000);
		
		driver.close();
		
	}
}
