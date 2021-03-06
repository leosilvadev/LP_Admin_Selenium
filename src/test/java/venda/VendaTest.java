package venda;

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

public class VendaTest extends BaseTest{

	private WebDriver driver;

	@Before
	public void testFirefox() throws FileNotFoundException, IOException, InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testeCadastroVenda() throws Exception{
		
		String urlAcesso = Propriedade.getPropriedade("url.listavenda");
		driver.get(urlAcesso);
		
		driver.findElement(By.className("txtLogin")).sendKeys("leonardo");
		Thread.sleep(300);
		
		driver.findElement(By.className("txtSenha")).sendKeys("leonardo123");
		Thread.sleep(300);
		
		driver.findElement(By.className("btnEntrar")).click();
		Thread.sleep(300);
		
		driver.findElement(By.className("btnNovaVenda")).click();
		
		Thread.sleep(300);
		
		driver.findElement(By.className("txtDesconto")).sendKeys("50");
		Thread.sleep(300);
		
		Select selectFormaPagamento = new Select(driver.findElement(By.className("lstFormasPagamento")));
		selectFormaPagamento.selectByIndex(1);
		Thread.sleep(300);
		
		Select selectProduto = new Select(driver.findElement(By.className("lstProdutosDisponiveis")));
		selectProduto.selectByIndex(0);
		Thread.sleep(300);
		
		driver.findElement(By.className("txtQuantidade")).sendKeys("2");
		Thread.sleep(300);
		
		driver.findElement(By.className("btnAdicionarProduto")).click();
		Thread.sleep(300);		
		
		Select selectFormaPagamento2 = new Select(driver.findElement(By.className("lstFormasPagamento")));
		selectFormaPagamento2.selectByIndex(2);
		Thread.sleep(300);
		
		Select selectProduto2 = new Select(driver.findElement(By.className("lstProdutosDisponiveis")));
		selectProduto2.selectByIndex(1);
		Thread.sleep(300);
		
		driver.findElement(By.className("txtQuantidade")).clear();
		driver.findElement(By.className("txtQuantidade")).sendKeys("4");
		Thread.sleep(300);
		
		driver.findElement(By.className("btnAdicionarProduto")).click();
		Thread.sleep(300);	
		
		driver.findElement(By.className("btnSalvar")).click();
		Thread.sleep(300);
		
		driver.close();
	}
}
