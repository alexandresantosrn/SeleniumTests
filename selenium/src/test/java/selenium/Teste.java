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

	// Teste de cadastro com e-mail inválido.

	@Test
	public void testInvalidDate() {
		PageObject page = new PageObject();
		page.insertDataRegister("58348257020", "Português", "Alexandre Dantas dos Santos", "01/12/1793", "Masculino",
				"Casado", "Mestrado", "Rio Grande do Norte", "Natal", "59141730", "1200", "84", "999494971",
				"allexsantosrn@gmail.com", "allexsantosrn@gmail.com", "123456", "123456");

		assertTrue(page.hasText("dataNascimento: esta data deve ser igual ou posterior a 1900."));
	}

	// Teste de login com cpf vazio.

	@Test
	public void testUserLoginEmpty() {
		PageObject page = new PageObject();
		page.insertDataLogin("", "123456");

		assertTrue(page.hasText("CPF: Campo obrigatório não informado."));
	}

	// Teste de login com senha vazia.

	@Test
	public void testUserPasswordEmpty() {
		PageObject page = new PageObject();
		page.insertDataLogin("05641479403", "");

		assertTrue(page.hasText("Senha: Campo obrigatório não informado."));
	}

	// Teste de cpf não encontrado.

	@Test
	public void testUserNoRegister() {
		PageObject page = new PageObject();
		page.insertDataLogin("12345678911", "123456");

		assertTrue(page.hasText("Não foi encontrado cadastro para o CPF informado."));
	}

	// Teste de senha inválida.

	@Test
	public void testUserInvalidPassword() {
		PageObject page = new PageObject();
		page.insertDataLogin("11111111111", "11111111");

		assertTrue(page.hasText("A senha informada não está correta."));
	}

	// Teste de cancelamento.
	@Test
	public void testCancelLogin() {
		PageObject page = new PageObject();
		page.insertDataLogin2("11111111111", "11111111");
	}

}
