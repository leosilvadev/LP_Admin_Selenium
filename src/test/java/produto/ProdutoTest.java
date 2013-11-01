package produto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import util.BaseTest;
import util.Propriedade;

public class ProdutoTest extends BaseTest {

	private WebDriver driver;
	

	@Before
	public void testFirefox() throws FileNotFoundException, IOException, InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCadastroProduto() throws Exception {
		
		String urlAcesso = Propriedade.getPropriedade("url.listaproduto");
		driver.get(urlAcesso);
		
		driver.findElement(By.className("txtLogin")).sendKeys("allan");
		Thread.sleep(200);
		
		driver.findElement(By.className("txtSenha")).sendKeys("allan123");
		Thread.sleep(200);
		
		driver.findElement(By.className("btnEntrar")).click();
		Thread.sleep(200);
		
		driver.findElement(By.className("btnNovoProduto")).click();
		Thread.sleep(200);

		driver.findElement(By.className("txtCodigo")).sendKeys("BR001");
		Thread.sleep(200);
		
		driver.findElement(By.className("txtDescricao")).sendKeys("Produto Teste");
		Thread.sleep(200);
		
		driver.findElement(By.className("txtMarca")).sendKeys("Marca 1");
		Thread.sleep(200);
		
		Select selectUnidade = new Select(driver.findElement(By.className("lstUnidade")));
		selectUnidade.selectByIndex(1);
		Thread.sleep(200);
		
		driver.findElement(By.className("dbPreco")).sendKeys("10,99");
		Thread.sleep(200);
		
		driver.findElement(By.className("intQuantidade")).findElement(By.className("z-spinner-btn-upper")).click();
		Thread.sleep(200);

		Select selectFornecedor = new Select(driver.findElement(By.className("lstFornecedorProduto")));
		selectFornecedor.selectByIndex(1);
		Thread.sleep(200);

		driver.findElement(By.className("btnSalvar")).click();
		Thread.sleep(200);

		driver.close();

	}

}
