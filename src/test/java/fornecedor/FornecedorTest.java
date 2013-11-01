package fornecedor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.BaseTest;
import util.Propriedade;

public class FornecedorTest extends BaseTest {

	private WebDriver driver;

	@Before
	public void testFirefox() throws FileNotFoundException, IOException, InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testeCadastroFornecedor() throws Exception {
		
		String urlAcesso = Propriedade.getPropriedade("url.listafornecedor");
		driver.get(urlAcesso);
		
		driver.findElement(By.className("txtLogin")).sendKeys("admin");
		Thread.sleep(100);
		
		driver.findElement(By.className("txtSenha")).sendKeys("admin123");
		Thread.sleep(100);
		
		driver.findElement(By.className("btnEntrar")).click();
		Thread.sleep(100);
		
		int size = driver.findElements(By.className("item_email_fornecedor")).size();

		driver.findElement(By.className("btnNovoFornecedor")).click();
		Thread.sleep(100);

		driver.findElement(By.className("txtNome")).sendKeys("Fornecedor Teste");
		Thread.sleep(100);
		
		driver.findElement(By.className("txtTelefone")).sendKeys("(12)12345432");
		Thread.sleep(100);
		
		driver.findElement(By.className("txtEndereco")).sendKeys("Rua Fulano teste selenium");
		Thread.sleep(100);
		
		driver.findElement(By.className("txtEmail")).sendKeys("fulano@teste.com.br");
		Thread.sleep(100);
		
		driver.findElement(By.className("btnSalvar")).click();
		Thread.sleep(100);
		
		Assert.assertEquals(size + 1, driver.findElements(By.className("item_email_fornecedor")).size());
		Thread.sleep(100);

		driver.close();
	}

}
