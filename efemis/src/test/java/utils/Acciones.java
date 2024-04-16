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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;

import efemispruebas.efemis;

public class Acciones extends efemis{

	
	private static File captura;
	private static File destino;
	private ExtentReports extent;
	private static ExtentTest screen;
	
	public Acciones(WebDriver driver,ExtentTest screen) {
		super(driver);
		this.screen =screen;
		// TODO Auto-generated constructor stub
	}
	
	public static void BuscarporXpath(String xpath,String elementName) throws IOException {
		
		try {
			WebElement elemento = esperarAClickeable(By.xpath(xpath));
            click(elemento, elementName);
        } catch (Exception e) {
            screen.info("[DEBUG][ERROR] [No ha sido posible realizar 'click' sobre el elemento]");
            screen.fail("El clic en el elemento '" + elementName + "' ha fallado.");
            e.printStackTrace();
            tomarCapturaDePantalla("Error en "+elementName);
            throw e;
        }     
	}
	public static void escribirCSS(String css, String elementName,String opcion) throws IOException {
		try {
			WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
            //click(elemento, elementName);
			elemento.sendKeys(opcion);
            
        } catch (Exception e) {
            screen.info("[DEBUG][ERROR] [No ha sido posible realizar 'click' sobre el elemento]");
            screen.fail("El clic en el elemento '" + elementName + "' ha fallado.");
            e.printStackTrace();
            tomarCapturaDePantalla("Error en "+elementName);

            throw e;
        }   
	}
	
	public static void escribirXpathString(String xpath,String elementName,String opcion) throws IOException {
		
		try {
			WebElement elemento = esperarAClickeable(By.xpath(xpath));
			elemento.sendKeys(opcion);
        } catch (Exception e) {
            screen.info("[DEBUG][ERROR] [No ha sido posible realizar 'click' sobre el elemento]");
            screen.fail("El clic en el elemento '" + elementName + "' ha fallado.");
            e.printStackTrace();
            tomarCapturaDePantalla("Error en "+elementName);

            throw e;
        }     
	}
public static void escribirClass(String clas,String elementName,String opcion) throws IOException {
		
		try {
			WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(clas)));
			elemento.sendKeys(opcion);
        } catch (Exception e) {
            screen.info("[DEBUG][ERROR] [No ha sido posible realizar 'click' sobre el elemento]");
            screen.fail("El clic en el elemento '" + elementName + "' ha fallado.");
            e.printStackTrace();
            tomarCapturaDePantalla("Error en "+elementName);

            throw e;
        }     
	}
	
public static void clickVisibility(String xpath,String elementName) throws IOException {
	
	try {
		WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		click(elemento, elementName);
		} catch (Exception e) {
        screen.info("[DEBUG][ERROR] [No ha sido posible realizar 'click' sobre el elemento]");
        screen.fail("El clic en el elemento '" + elementName + "' ha fallado.");
        e.printStackTrace();
        tomarCapturaDePantalla("Error en "+elementName);

        throw e;
    }     
}
	
	
	private static WebElement esperarAClickeable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
	 public static void click(WebElement element, String elementName) {
		 try {
	            element.click();
	            screen.log(Status.PASS, "Realizando 'click' sobre el elemento: " + elementName);
	        } catch (Exception e) {
	            screen.log(Status.FAIL, "No ha sido posible realizar 'click' sobre el elemento");
	            e.printStackTrace();
	        }  
		 
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
	
	public static void tomarCapturaDePantalla(String nombreArchivo) throws IOException {
		//extent = new ExtentReports();
		//ExtentTest screen = extent.createTest("Captura"); 
		captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         destino = new File("efemis/target/" + nombreArchivo + ".png");
         FileUtils.copyFile(captura, destino);
         screen.fail(MediaEntityBuilder.createScreenCaptureFromPath(destino.getAbsolutePath()).build());
   
	}
}
