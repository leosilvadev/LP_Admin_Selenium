package fornecedor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.BaseTest;
import util.Propriedade;

public class PesquisaFornecedorTest extends BaseTest {

	private WebDriver driver;

	@Before
	public void testFirefox() throws FileNotFoundException, IOException, InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testPesquisaFornecedor() throws Exception {
		
		String urlAcesso = Propriedade.getPropriedade("url.listafornecedor");
		driver.get(urlAcesso);

		driver.findElement(By.className("txtLogin")).sendKeys("admin");
		Thread.sleep(1000);
		
		driver.findElement(By.className("txtSenha")).sendKeys("admin123");
		Thread.sleep(1000);
		
		driver.findElement(By.className("btnEntrar")).click();
		Thread.sleep(1000);

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
		Thread.sleep(1000);

		driver.findElement(By.className("txtPesquisaNome")).sendKeys("este");
		Thread.sleep(1000);
		
		driver.findElement(By.className("btnProcurarPorNome")).click();
		Thread.sleep(1000);

		driver.close();
	}
}
