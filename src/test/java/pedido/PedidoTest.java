package pedido;

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

public class PedidoTest extends BaseTest{

	private WebDriver driver;

	@Before
	public void testFirefox() throws FileNotFoundException, IOException, InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testeCadastroPedido() throws Exception{
		
		String urlAcesso = Propriedade.getPropriedade("url.listapedido");
		driver.get(urlAcesso);
		
		driver.findElement(By.className("txtLogin")).sendKeys("admin");
		Thread.sleep(100);
		
		driver.findElement(By.className("txtSenha")).sendKeys("admin123");
		Thread.sleep(100);
		
		driver.findElement(By.className("btnEntrar")).click();
		Thread.sleep(100);
		
		driver.findElement(By.className("btnNovoPedido")).click();
		
		Thread.sleep(100);
	
		Select selectFormaPagamento = new Select(driver.findElement(By.className("lstFormasPagamento")));
		selectFormaPagamento.selectByIndex(0);
		Thread.sleep(100);
		
		Select selectForneedor = new Select(driver.findElement(By.className("lstFornecedores")));
		selectForneedor.selectByIndex(0);
		Thread.sleep(100);
		
		Select selectProduto = new Select(driver.findElement(By.className("lstProdutosDisponiveis")));
		selectProduto.selectByIndex(0);
		Thread.sleep(100);
		
		driver.findElement(By.className("txtQuantidade")).sendKeys("2");
		Thread.sleep(100);
		
		driver.findElement(By.className("btnAdicionarProduto")).click();
		
		Thread.sleep(100);		
		
		Select selectFormaPagamento2 = new Select(driver.findElement(By.className("lstFormasPagamento")));
		selectFormaPagamento2.selectByIndex(1);
		Thread.sleep(100);
		
		Select selectForneedor2 = new Select(driver.findElement(By.className("lstFornecedores")));
		selectForneedor2.selectByIndex(1);
		Thread.sleep(100);
		
		Select selectProduto2 = new Select(driver.findElement(By.className("lstProdutosDisponiveis")));
		selectProduto2.selectByIndex(1);
		Thread.sleep(100);
		
		driver.findElement(By.className("txtQuantidade")).clear();
		driver.findElement(By.className("txtQuantidade")).sendKeys("4");
		Thread.sleep(100);
		
		driver.findElement(By.className("btnAdicionarProduto")).click();
		Thread.sleep(100);	
		
		driver.findElement(By.className("btnSalvar")).click();
		Thread.sleep(100);
		
		driver.close();
	}
}
