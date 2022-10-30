package selenium;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Teste {
	
	/*
	// Teste de cadastro válido - Após registro alterar CPF.
	@Test
	public void testValid() {
		PageObject page = new PageObject();
		page.inserirDados("05641479403", "Português", "Alexandre Dantas", "24/11/1984", "Masculino", "Casado",
				"Mestrado", "Rio Grande do Norte", "Natal", "59141730", "1200", "84", "999494971",
				"allexsantosrn@gmail.com", "allexsantosrn@gmail.com", "123456", "123456");
	}
	*/
	// Teste de cadastro inválido.
	@Test 
	public void testInvalid() {
		PageObject page = new PageObject();
		page.inserirDados("58348257020", "Português", "Ronaldo Nazario", "24/11/1984", "Masculino", "Casado",
				"Mestrado", "Rio Grande do Norte", "Natal", "59141730", "1200", "84", "999494971",
				"Ronaldinho@gmail.com", "allexsantosrn@gmail.com", "123456", "123456");
	}
	
	@After
	public void tearDown() throws Exception {
		// driver.close();
	}
}
