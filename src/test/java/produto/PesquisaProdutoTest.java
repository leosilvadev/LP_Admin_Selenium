package produto;

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

public class PesquisaProdutoTest extends BaseTest {

	private WebDriver driver;

	@Before
	public void testFirefox() throws FileNotFoundException, IOException, InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testePesquisaProduto() throws Exception {
		
		String urlAcesso = Propriedade.getPropriedade("url.listaproduto");
		driver.get(urlAcesso);
		
		driver.findElement(By.className("txtLogin")).sendKeys("heitor");
		Thread.sleep(500);
		
		driver.findElement(By.className("txtSenha")).sendKeys("heitor123");
		Thread.sleep(500);
		
		driver.findElement(By.className("btnEntrar")).click();
		Thread.sleep(500);

		driver.findElement(By.className("txtPesquisaDescricao")).sendKeys("Prod");
		Thread.sleep(500);
		
		driver.findElement(By.className("btnProcurarPorDescricao")).click();
		Thread.sleep(500);

		driver.findElement(By.className("txtPesquisaDescricao")).clear();
		Thread.sleep(500);

		driver.findElement(By.className("txtPesquisaDescricao")).sendKeys("");
		Thread.sleep(500);
		
		driver.findElement(By.className("btnProcurarPorDescricao")).click();
		Thread.sleep(500);

		driver.findElement(By.className("txtPesquisaDescricao")).clear();
		Thread.sleep(500);

		driver.findElement(By.className("txtPesquisaDescricao")).sendKeys("este");
		Thread.sleep(500);
		
		driver.findElement(By.className("btnProcurarPorDescricao")).click();
		Thread.sleep(500);

		driver.close();
	}
}
