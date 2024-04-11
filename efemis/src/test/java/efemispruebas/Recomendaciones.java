package efemispruebas;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import utils.Acciones;

public class Recomendaciones extends efemis{

	public Recomendaciones(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void crearRecomendacion(String OpcionCampana, String fechaInicio, String fechaFin, String OpcionTarea, String OpcionCultivo,String OpcionGuardado) {
		//String OpcionFechaInicio, String OpFechaFin,
		//Pulsamos el boton de mas, para crear una recomendacion
		Acciones.BuscarporXpath("//div[3]/div/div/div/div/i");

        //Seleccionamos el desplegable de campa�a y lo rellenamos
		Acciones.BuscarporXpath("//div[2]/div/div/div/div[2]/div/div[3]/div[2]/div/div/div[2]/div/div/div");

          
         
         /**
          * Seleccion CAMPA�A A
          */

         //Buscamos el campo de escritura y ponemos campa�a A
           WebElement escritura = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[aria-describedby='dx-col-7']")));
           escritura.sendKeys(OpcionCampana);
          
           //Buscamos el elemento filtrado y le hacemos click       
          Acciones.BuscarporXpath("//td[text()='" + OpcionCampana + "']");
           //WebElement resultadoBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='" + OpcionCampana + "']")));
          // resultadoBusqueda.click();
         
           
           //Fecha inicio
           WebElement fechaInicio1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div[1]/input")));
           fechaInicio1.clear();
           fechaInicio1.sendKeys(fechaInicio);
           
           //Fecha fin
           WebElement opfechaFin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[6]/div[2]/div/div/div[1]/input")));
           opfechaFin.clear();
           opfechaFin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[6]/div[2]/div/div/div[1]/input")));
           opfechaFin.sendKeys(fechaFin);
           
   
         /**
          * Seleccion de Tarea (Prueba General)
          */
           
         //Seleccionamos el desplegable de tarea y lo rellenamos
          Acciones.BuscarporXpath("//div[4]/div[2]/div/div/div[2]/div/div/div");

            
         //Buscamos el campo de escritura y ponemos PRUEBA GENERAL
           WebElement escrituraTarea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[2]/div/div[2]/div/div/div/input")));   
           escrituraTarea.sendKeys(OpcionTarea);

           
         //Buscamos el elemento filtrado y le hacemos click       
         Acciones.BuscarporXpath(".//td[contains(text(), '"+OpcionTarea+"')][2]");
          // WebElement resultadoTarea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//td[contains(text(), '"+OpcionTarea+"')][2]")));
         //  WebElement resultadoTarea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//tr[contains(td[2],'" + OpcionTarea + "')]")));
   
          // resultadoTarea.click();
       
           
           
        /**
         * Seleccion Cultivo (Cultivo A)
         */
         //Seleccionamos el desplegable de Cultivo 
         Acciones.BuscarporXpath("//div[2]/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div"); 
        // WebElement cultivo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div")));
          // cultivo.click();
         
           //Buscamos el campo de escritura y ponemos Cultivo A
           WebElement escrituraCultivo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dx-texteditor-input")));
          // class="dx-texteditor-input-container"
           escrituraCultivo.sendKeys(OpcionCultivo);

           
           //Seleccionamos Cultivo A
           WebElement botonasociado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '"+OpcionCultivo+"')]/preceding-sibling::td/div/div/span[@class='dx-checkbox-icon']")));
           botonasociado.click();  

           
           /**
            * Guardamos Recomendaciones
            */
           
           //Hacemos click en el boton Guardar Como
           Acciones.BuscarporXpath("//div[@id='main-view']/div[3]/div/div[2]/div/div[4]/div/div[2]/a[2]/span");
         // WebElement GuardarComo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='main-view']/div[3]/div/div[2]/div/div[4]/div/div[2]/a[2]/span")));
          // GuardarComo.click();
                    
           //Guardamos la recomendacion
           WebElement Guardar = driver.findElement(By.xpath("//div[@data-tooltip='"+OpcionGuardado+"']"));
           Guardar.click();
                
        
	}



}
