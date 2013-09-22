package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propriedade {

	private static Properties properties;
	
	public static String getPropriedade(String chave) throws FileNotFoundException, IOException{
		if(properties==null) inicializarPropriedade();
		return properties.getProperty(chave);
	}

	private static void inicializarPropriedade() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(Propriedade.class.getClassLoader().getResourceAsStream("config.properties"));
	}
	
}
