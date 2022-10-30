package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageObject {

	private WebDriver driver;
	//private String baseUrl = "https://sigrh-balancer-treinamento.info.ufrn.br/sigrh/public/concursos/area_candidato/dados_cadastrais/form.jsf";
	private String baseUrl = "https://cooperacao.info.ufrn.br/sigrh/public/concursos/area_candidato/dados_cadastrais/form.jsf";
	
	public PageObject() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
	}

	public void inserirDados(String cpf, String idiomaPreferencial, String nome, String dataNascimento,
			String sexo, String estadoCivil, String formacaoInformada, String ufNaturalidade,
			String municipioNaturalidade, String cep, String numero, String dddCelular, String celular, String email,
			String confirmacaoEmail, String senha, String confirmacaoSenha) {

		driver.findElement(By.name("form:cpf")).sendKeys(cpf);
		driver.findElement(By.name("form:idiomaPreferencial")).sendKeys(idiomaPreferencial);
		driver.findElement(By.name("form:nomeOficial")).sendKeys(nome);
		driver.findElement(By.name("form:dataNascimento")).sendKeys(dataNascimento);
		driver.findElement(By.name("form:sexo")).sendKeys(sexo);
		driver.findElement(By.name("form:estadoCivil")).sendKeys(estadoCivil);
		driver.findElement(By.name("form:formacaoInformada")).sendKeys(formacaoInformada);
		driver.findElement(By.name("form:ufNaturalidade")).sendKeys(ufNaturalidade);
		driver.findElement(By.name("cep")).sendKeys(cep);
		driver.findElement(By.name("numero")).sendKeys(numero);
		driver.findElement(By.name("form:dddCelular")).sendKeys(dddCelular);
		driver.findElement(By.name("form:celular")).sendKeys(celular);
		driver.findElement(By.name("form:email")).sendKeys(email);
		correctBugEmail(confirmacaoEmail);
		driver.findElement(By.name("form:senha")).sendKeys(senha);
		driver.findElement(By.name("form:confirmacaoSenha")).sendKeys(confirmacaoSenha);
		driver.findElement(By.name("form:municipioNaturalidade")).sendKeys(municipioNaturalidade);
		driver.findElement(By.name("form:municipioNaturalidade")).sendKeys(Keys.ENTER);
	}

	private void correctBugEmail(String Email) {
		By confirmacaoEmail = By.id("form:confirmacaoEmail");
		retryingFindClick(confirmacaoEmail, Email);
	}

	public boolean retryingFindClick(By by, String Email) {
		String email = Email;
		boolean result = false;
		int attempts = 0;
		while (attempts < 10000) {
			try {
				driver.findElement(by).sendKeys(email);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

}
