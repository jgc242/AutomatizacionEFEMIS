package efemispruebas;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Login extends efemis {

	private String valorUsuario;
	private String valorContrasena;
	
	public Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void iniciarSesion(String URL, String username, String password) {
		driver.get(URL);
		driver.manage().window().maximize();

		// Introducimos el usuario
		WebElement usuario = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("inpUsername")));
		
		// Buscamos el campo para introducir el nombre
		usuario.clear();// Lo limpiamos por si hay algo escrito
		usuario.sendKeys(username);		
	  
		
		// Introducimos contrase�a
		WebElement contrasena = driver.findElement(By.name("inpPassword"));
		contrasena.clear();
		contrasena.sendKeys(password);

		// Boton recordar contrase�a
		/**
		 * Hacemos qeu se marque y se desmarque la casilla para contemplar ese escenario
		 */

		WebElement botonRecordarContrasena = driver
				.findElement(By.xpath("//div[1]/div/div/div[2]/div[1]/form/ul/li[4]/label"));

		// Verifica el estado actual del bot�n
		boolean estaActivado = botonRecordarContrasena.isSelected();

		if (estaActivado) {
			botonRecordarContrasena.click();
		}
		
		  valorUsuario= usuario.getAttribute("value");
		  System.out.println(valorUsuario);
		  valorContrasena= contrasena.getAttribute("value");
		  System.out.println(valorContrasena);

		// Pulsamos el boton de entrar
		WebElement entrar = driver.findElement(By.name("btnSignIn"));
		entrar.click();

	}
	
	public String getUsuario() {
		return valorUsuario;
	}
	public String getContrasena() {
		return valorContrasena;
	}
}
