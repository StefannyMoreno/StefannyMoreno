package br.com.e2etreinamentos.TesteSte;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomacaoOriginal {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		 
		System.setProperty("webdriver.chrome.driver" , "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.original.com.br/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		WebElement clicarCriarConta = driver.findElement(By.xpath("//*[@id=\"section-1\"]/div[2]/a"));
		clicarCriarConta.click();
		
		WebElement preencherNome = driver.findElement(By.name("cliente.nome"));
		preencherNome.sendKeys("Stefanny Moreno");
		
		WebElement preencherCelular = driver.findElement(By.name("cliente.telefone"));
		preencherCelular.sendKeys("(11)959704594");
		
		WebElement preencherEmail = driver.findElement(By.name("cliente.email"));
		preencherEmail.sendKeys("stefanny.moreno@hotmail.com");
		
		WebElement preencherCpf =  driver.findElement(By.name("cliente.cpf"));
		preencherCpf.sendKeys("416.746.898-02");		
		 
		WebElement clicarEnviar = driver.findElement(By.xpath("//*[@id=\"btnEnviar\"]"));
		clicarEnviar.click();
		
		String mensagem = driver.findElement(By.xpath("//*[@id=\"send-sms\"]/label/text()")).getText();
		System.out.println (mensagem);
		assertEquals("Agora você receberá um SMS para baixar o app Seja Original e concluir sua solicitação de abertura de conta!", mensagem);

}
}
