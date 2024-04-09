package efemispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Menu extends efemis{

	public Menu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Test(dependsOnMethods = "Prueba2.menu")
	public void MenuDesplegable(String OpcionPrueba, String OpcionIdioma, String opcion1, String opcion2) {
	    
	    try {
	        Thread.sleep(4000); 
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    //Boton del menu desplegable
	    WebElement DespleglableAdrian1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='main-view']/div[2]/div/div[2]/div/div[3]/a/span[2]")));
	    DespleglableAdrian1.click();
	        
	    //Extraemos el texto y comprobamos/ si no pone Pruebas Adrian lo seleccionamos
	    WebElement DespleglableAdrian = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div")));
	    DespleglableAdrian.click();
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
	    WebElement menuIzquierdo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='main-view']/div[2]/div/div[2]/div/div/a")));
	    menuIzquierdo.click();
	    
	    //Pulsamos sobre Actividades
	    //Sirve para cualquier elemento del menu
	    WebElement Actividades = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='"+ opcion1 +"']")));
	    Actividades.click(); 

	    //Accedemos a la opcion2 (Recomendaciones)
	    WebElement Recomendaciones = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='"+opcion2+"']")));
	    Recomendaciones.click();
	}
	

}
