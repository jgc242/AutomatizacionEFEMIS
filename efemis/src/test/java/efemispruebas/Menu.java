package efemispruebas;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import utils.Acciones;


public class Menu extends efemis{

	private Acciones acciones;
	private String urlActual1;

	public Menu(WebDriver driver) {
		super(driver);
		this.acciones = new Acciones(driver, null);
		// TODO Auto-generated constructor stub
	}

	public void MenuDesplegable(String OpcionPrueba, String OpcionIdioma, String opcion1, String opcion2) throws IOException {
	    
	    try {
	        Thread.sleep(4000); 
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    //Boton del menu desplegable
	  //*[@id="main-view"]/div[3]/div[1]/div[2]/div/div[3]/a[1]
	   // Acciones.BuscarporXpath("//div[@id='main-view']/div[2]/div/div[2]/div/div[3]/a/span[2]");
		 Acciones.BuscarporXpath("//*[@id=\"main-view\"]/div[3]/div[1]/div[2]/div/div[3]/a[1]", "fbdfb");

	    
	    //Extraemos el texto y comprobamos/ si no pone Pruebas Adrian lo seleccionamos
	    Acciones.BuscarporXpath("//div[7]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div", "dfvdf");

	    //DespleglableAdrian.click();
	    WebElement pruebadri = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dx-item-content dx-list-item-content'and contains(text(), '"+OpcionPrueba+"')]")));
	    pruebadri.click();
	    
	    //Boton del menu desplegable
	   /* WebElement DespleglableAdrian2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='main-view']/div[2]/div/div[2]/div/div[3]/a/span[2]")));
	    DespleglableAdrian2.click();
	  
	  //Seleccionamos Español
	  //*[@id="framework7-root"]/div[7]/div[2]/div[2]/div[2]
        WebElement DespleglableIdioma = driver.findElement(By.cssSelector(".dx-dropdowneditor-input-wrapper input"));
	   // WebElement DespleglableIdioma = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"framework7-root\"]/div[7]/div[2]/div[2]/div[2]")));
	    DespleglableIdioma.click();
	    WebElement español = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dx-item-content dx-list-item-content'and contains(text(), '"+OpcionIdioma+"')]")));
	    español.click();*/
	    	   
	    
	    //Desplegamos el menu izquierdo
	   Acciones.BuscarporXpath("//*[@id=\"main-view\"]/div[3]/div[1]/div[2]/div/div[1]/a", "menu izquierdo");

	   //Pulsamos sobre Actividades
	   Acciones.BuscarporXpath("//li[@title='"+ opcion1 +"']", "click actividades");

	    //Accedemos a la opcion2 (Recomendaciones)
	  Acciones.BuscarporXpath("//a[text()='"+opcion2+"']", "click recomendaciones");
	  
	  try {
	         Thread.sleep(7000); 
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }
	//Obtenemos la URL
       urlActual1 = driver.getCurrentUrl();
       System.out.println(urlActual1);
	}
	
	public String getUrl() {
		return urlActual1;
	}	

}
