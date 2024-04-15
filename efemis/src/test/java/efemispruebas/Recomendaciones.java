package efemispruebas;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import utils.Acciones;

public class Recomendaciones extends efemis {

	private String urlActual1;
	private String urlActual2;
	private String valorCampana;
	private String valorTarea;
	private String valorCultivo;

	public Recomendaciones(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void crearRecomendacion(String OpcionCampana, String fechaInicio, String fechaFin, String OpcionTarea,
			String OpcionCultivo, String OpcionGuardado) {
		// String OpcionFechaInicio, String OpFechaFin,
		// Pulsamos el boton de mas, para crear una recomendacion
		Acciones.BuscarporXpath("//div[3]/div/div/div/div/i");

		// Seleccionamos el desplegable de campa�a y lo rellenamos
		Acciones.BuscarporXpath("//div[2]/div/div/div/div[2]/div/div[3]/div[2]/div/div/div[2]/div/div/div");
		
		/**
		 * Seleccion CAMPA�A A
		 */

		// Buscamos el campo de escritura y ponemos campa�a A7
		//*[@id="treeList"]/div/div[5]/div/table/tbody/tr[2]/td/div/div[2]/div/div/div[1]/input
		WebElement escritura = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[aria-describedby='dx-col-11']")));
		escritura.clear();
		escritura.sendKeys(OpcionCampana);
		

		// Buscamos el elemento filtrado y le hacemos click
		Acciones.BuscarporXpath("//td[text()='" + OpcionCampana + "']");
		
		
		valorCampana= escritura.getAttribute("value");
		System.out.println(valorCampana);

		// Fecha inicio
		WebElement fechaInicio1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div[1]/input")));
		fechaInicio1.clear();
		fechaInicio1.sendKeys(fechaInicio);

		// Fecha fin
		WebElement opfechaFin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[6]/div[2]/div/div/div[1]/input")));
		opfechaFin.clear();
		opfechaFin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[6]/div[2]/div/div/div[1]/input")));
		opfechaFin.sendKeys(fechaFin);

		
		
		/**
		 * Seleccion de Tarea (Prueba General)
		 */

		// Seleccionamos el desplegable de tarea y lo rellenamos
		Acciones.BuscarporXpath("//div[4]/div[2]/div/div/div[2]/div/div/div");

		// Buscamos el campo de escritura y ponemos PRUEBA GENERAL
		WebElement escrituraTarea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[2]/div/div[2]/div/div/div/input")));
		escrituraTarea.sendKeys(OpcionTarea);

		// Buscamos el elemento filtrado y le hacemos click
		Acciones.BuscarporXpath(".//td[contains(text(), '" + OpcionTarea + "')][2]");

		 urlActual2 = driver.getCurrentUrl();
	      System.out.println(urlActual2);
	      
	      valorTarea= escrituraTarea.getAttribute("value");
			System.out.println(valorTarea);
		
		/**
		 * Seleccion Cultivo (Cultivo A)
		 */
		// Seleccionamos el desplegable de Cultivo
		Acciones.BuscarporXpath("//div[2]/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div");

		// Buscamos el campo de escritura y ponemos Cultivo A
		WebElement escrituraCultivo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dx-texteditor-input")));
		escrituraCultivo.sendKeys(OpcionCultivo);

		// Seleccionamos Cultivo A
		WebElement botonasociado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '" + OpcionCultivo+ "')]/preceding-sibling::td/div/div/span[@class='dx-checkbox-icon']")));
		botonasociado.click();
		
		//valorCultivo= escrituraCultivo.getAttribute("value");
		//System.out.println(valorCultivo);

		/**
		 * Guardamos Recomendaciones
		 */

		// Hacemos click en el boton Guardar Como
		Acciones.BuscarporXpath("//div[@id='main-view']/div[3]/div/div[2]/div/div[4]/div/div[2]/a[2]/span");


		// Guardamos la recomendacion
		WebElement Guardar = driver.findElement(By.xpath("//div[@data-tooltip='" + OpcionGuardado + "']"));
		Guardar.click();
		
		try {
	         Thread.sleep(7000); 
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }
	//Obtenemos la URL
      urlActual1 = driver.getCurrentUrl();
      System.out.println("recomendacion terminada: "+urlActual1);

	}
	public String getUrl() {
		return urlActual1;
	}	
	public String getUrl2() {
		return urlActual2;
	}	
	public String getUCampana() {
		return valorCampana;
	}
	public String getTarea() {
		return valorTarea;
	}
	public String getCultivo() {
		return valorCultivo;
	}

}
