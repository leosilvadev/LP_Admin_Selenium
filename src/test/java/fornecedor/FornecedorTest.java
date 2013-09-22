package fornecedor;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.Propriedade;

public class FornecedorTest {

	@Test
	public void testFirefox() throws FileNotFoundException, IOException{
		testFlow(new FirefoxDriver());
	}
	
	@Test
	public void testChrome() throws FileNotFoundException, IOException{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		testFlow(new ChromeDriver());
	}
	
	public void testFlow(WebDriver driver) throws FileNotFoundException, IOException{
		String urlAcesso = Propriedade.getPropriedade("url.listafornecedor");
		driver.get(urlAcesso);
	}
	
	

}
