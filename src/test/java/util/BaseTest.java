package util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;

public class BaseTest {
	
	protected WebDriverBackedSelenium selenium;
	
	public void init(WebDriver driver) throws FileNotFoundException, IOException{
		selenium = new WebDriverBackedSelenium(driver, Propriedade.getPropriedade("url.base"));
		selenium.open(Propriedade.getPropriedade("url.app.name"));
	}

}
