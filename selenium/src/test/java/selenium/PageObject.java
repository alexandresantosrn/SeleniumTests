package selenium;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
	private String baseUrl = "https://sigrh-balancer-treinamento.info.ufrn.br/sigrh/public/concursos/area_candidato/dados_cadastrais/form.jsf";
	// private String baseUrl =
	// "https://cooperacao.info.ufrn.br/sigrh/public/concursos/area_candidato/dados_cadastrais/form.jsf"
	private String baseUrl2 = "https://sigrh-balancer-treinamento.info.ufrn.br/sigrh/public/concursos/area_candidato/form_login.jsf";

	public PageObject() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.get(baseUrl);
	}

	public void insertDataRegister(String cpf, String idiomaPreferencial, String nome, String dataNascimento,
			String sexo, String estadoCivil, String formacaoInformada, String ufNaturalidade,
			String municipioNaturalidade, String cep, String numero, String dddCelular, String celular, String email,
			String confirmacaoEmail, String senha, String confirmacaoSenha) {

		driver.get(baseUrl);

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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("form:confirmacaoEmail")).sendKeys(email);
		driver.findElement(By.name("form:senha")).sendKeys(senha);
		driver.findElement(By.name("form:confirmacaoSenha")).sendKeys(confirmacaoSenha);
		driver.findElement(By.name("form:municipioNaturalidade")).sendKeys(municipioNaturalidade);
		driver.findElement(By.name("form:municipioNaturalidade")).sendKeys(Keys.ENTER);
	}

	public void insertDataLogin(String cpf, String senha) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(baseUrl2);
		driver.findElement(By.name("j_id_jsp_1791051872_1:cpfCandidato")).sendKeys(cpf);
		driver.findElement(By.name("j_id_jsp_1791051872_1:senhaCandidato")).sendKeys(senha);
		driver.findElement(By.name("j_id_jsp_1791051872_1:btnLogin")).sendKeys(Keys.ENTER);
	}

	public void insertDataLogin2(String cpf, String senha) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(baseUrl2);
		driver.findElement(By.name("j_id_jsp_1791051872_1:cpfCandidato")).sendKeys(cpf);
		driver.findElement(By.name("j_id_jsp_1791051872_1:senhaCandidato")).sendKeys(senha);
		driver.findElement(By.name("j_id_jsp_1791051872_1:btnCancelar")).sendKeys(Keys.ENTER);	
		sendEnter();
	}

	public boolean hasText(String msg) {
		boolean b = false;
		if (driver.findElement(By.className("erros")).getText().equals(msg)) {
			b = true;
		}
		return b;
	}
	
	public void sendEnter() {
		
		try {
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
		}
		
		finally {			
		}
	}

}
