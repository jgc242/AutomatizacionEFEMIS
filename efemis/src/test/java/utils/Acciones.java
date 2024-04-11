package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import efemispruebas.efemis;

public class Acciones extends efemis{

	
	private static File captura;
	private static File destino;
	private ExtentReports extent;
	private ExtentTest screen;
	
	public Acciones(WebDriver driver,ExtentTest screen) {
		super(driver);
		this.screen =screen;
		// TODO Auto-generated constructor stub
	}
	
	public static void BuscarporXpath(String xpath) {
		WebElement elemento = esperarAClickeable(By.xpath(xpath));
        elemento.click();
	}
	private static WebElement esperarAClickeable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	private boolean estadoDespuesDeInicioSesionEsCorrecto() {
	    // Verificar si la página de inicio después de iniciar sesión se ha cargado correctamente
	    String tituloEsperado = "Página de inicio"; // Aquí debes poner el título esperado de la página de inicio
	    String tituloActual = driver.getTitle(); // Obtener el título actual de la página

	    if (tituloActual.equals(tituloEsperado)) {
	        // La página de inicio se ha cargado correctamente
	        return true;
	    } else {
	        // La página de inicio no se ha cargado correctamente
	        return false;
	    }
	}
	
	/*private boolean campoUsuarioRelleno(String nombre) {
	    try {

	        WebElement elemento1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(nombre)));
	        String valorCampoUsuario = elemento1.getAttribute("value");
	        return !valorCampoUsuario.isEmpty(); // Devuelve true si el campo está relleno, false si está vacío
	    } catch (TimeoutException e) {
	        return false; // El campo de usuario no es visible dentro del tiempo de espera especificado
	    }
	}*/
	
	public void tomarCapturaDePantalla(String nombreArchivo) throws IOException {
		//extent = new ExtentReports();
		//ExtentTest screen = extent.createTest("Captura"); 
		captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         destino = new File("efemis/efemis/target/" + nombreArchivo + ".jpg");
         FileUtils.copyFile(captura, destino);
         screen.fail(MediaEntityBuilder.createScreenCaptureFromPath(destino.getAbsolutePath()).build());
   
	}
}
