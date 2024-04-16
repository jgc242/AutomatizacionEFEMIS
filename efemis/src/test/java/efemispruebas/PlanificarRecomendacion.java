package efemispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import utils.Acciones;

public class PlanificarRecomendacion extends efemis {

	private String identificador;
	private String urlActual1;


	
	public PlanificarRecomendacion(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void PlanificarReco(String OpcionAccion, String OpcionEmpresa, String OpcionTrabajadores, String OpcionMaquinaria, String OpcionAperos, String OpcionHerramietas) {
		
		//esperamos hasta que un boton con el total de reconendaciones sea visible para continuar con la planificacion  	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div[3]/div[5]/div/div[4]/div/div/div[1]/div/div/div")));
		 System.out.println("Encontrado");   	
		// Encontrar la fila que contiene el elemento deseado (Obtener id)232
		WebElement fila = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines']//td[@aria-describedby='dx-col-235']")));
		identificador= fila.getText();
		System.out.println(identificador.toString());
		 
	 
		 //Desplegable menu
		 WebElement seleccion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div/div[1]/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div[3]/div[5]/div/div[6]/div[2]/table/tbody/tr[1]/td[2]/div/div/div[1]/div/div")));
		seleccion.click();

    	 //Boton planificaion
		Acciones.BuscarporXpath("//span[text()='"+OpcionAccion+"']", " boton planificacion");
         
        /**
         * Seleccion Empresa de Servicios
         */
 
        //Desplegable empresa servicios
       Acciones.BuscarporXpath("//div[2]/div/div[3]/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div", " Desplegable Empresa Servicios");
  
       /* WebElement escrituraEmpresa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[2]/div/div[2]/div/div/div[1]/input")));   
        escrituraEmpresa.sendKeys(OpcionEmpresa);*/
        Acciones.escribirXpathString("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[2]/div/div[2]/div/div/div[1]/input", "Escribir Empresa Serrvicios", OpcionEmpresa);
        
      //Buscamos el elemento filtrado y le hacemos click       
      Acciones.BuscarporXpath("//td[contains(text(),'"+OpcionEmpresa+"')]/preceding-sibling::td/div/div/span[@class='dx-checkbox-icon']", "click empresa servicios") ;

        
        //A�adimos empresa
      Acciones.BuscarporXpath("//div[2]/div/div/div/div[2]/div/div/span", " click añadir empresa");      
        /**
         * Seleccion Trabajadores
         */
      //Desplegable Trabajadores
        Acciones.BuscarporXpath("//div[4]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[2]/div/div", " click desplegable tranajadores");
        
      //Seleccion de Permanente
        Acciones.BuscarporXpath("//div[@class='dx-item-content dx-list-item-content' and text()='"+OpcionTrabajadores+"']", " seleccion permanente (Trabajadores)");
        
      //A�adimos Trabajador
      Acciones.BuscarporXpath("//div[2]/div/div/div[2]/div/div/span", " Añadir Trabajador");

        Acciones.BuscarporXpath("//html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[1]/div/div\r\n", "Sleccion");


        /**
         * Seleccion Maquinaria
         */
      
      //Desplegable Maquinaria
      Acciones.BuscarporXpath("//div[3]/div[2]/div/div[5]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/div", " Desplegable Maquinaria");
                                                                                     
       /* WebElement escrituraMaquinaria = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[4]/div/div[2]/div/div/div[1]/input")));   
        escrituraMaquinaria.sendKeys(OpcionMaquinaria);*/
        Acciones.escribirXpathString("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[4]/div/div[2]/div/div/div[1]/input", " Escribir maquinaria", OpcionMaquinaria);
        
      //Buscamos el elemento filtrado y le hacemos click       
        Acciones.BuscarporXpath("//td[contains(text(),'"+OpcionMaquinaria +"')]/preceding-sibling::td/div/div/span[@class='dx-checkbox-icon']", " Click en la maquinaria");
  
     
        //A�adimos Maquinaria
       Acciones.BuscarporXpath("//div[2]/div/div[5]/div/div[2]/div/div[1]/div[3]/div", " Añadimos maquinaria");

        
        /**
         * Seleccion Aperos
         */
      //Desplegable Aperos
        Acciones.BuscarporXpath("//div[3]/div[2]/div/div[6]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/div", " Desplegable aperos");
       
       /* WebElement escrituraAperos = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[4]/div/div[2]/div/div/div[1]/input")));   
        escrituraAperos.sendKeys(OpcionAperos);*/
        Acciones.escribirXpathString("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[4]/div/div[2]/div/div/div[1]/input", "Escritura aperos", OpcionAperos);
        
      //Buscamos el elemento filtrado y le hacemos click  
        Acciones.BuscarporXpath("//td[contains(text(),'"+OpcionAperos +"')]/preceding-sibling::td/div/div/span[@class='dx-checkbox-icon']", " Seleccion apaeros buscados");

             
      //A�adimos Aperos
       Acciones.BuscarporXpath("//div[3]/div[2]/div/div[6]/div/div[2]/div/div[1]/div[3]/div", " Añadir aperos");
       
        
        /**
         * Seleccion Herramientas
         */
      //Desplegable Herramientas
        Acciones.BuscarporXpath("//div[3]/div[2]/div/div[7]/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div", " Desplegable herramientas");

        
       /* WebElement escrituraHerramientas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[4]/div/div[2]/div/div/div[1]/input")));   
        escrituraHerramientas.sendKeys(OpcionHerramietas);*/
        Acciones.escribirXpathString("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[4]/div/div[2]/div/div/div[1]/input", " Escritura herramientas", OpcionHerramietas);
        
      //Buscamos el elemento filtrado y le hacemos click   
        Acciones.BuscarporXpath("//td[contains(text(),'"+OpcionHerramietas +"')]/preceding-sibling::td/div/div/span[@class='dx-checkbox-icon']", " Seleccion Herramienta filtrada");

    
      //A�adimos Tijeras
       Acciones.BuscarporXpath("//div[3]/div[2]/div/div[7]/div/div[2]/div/div[1]/div[3]/div", " Añadir herramienta");

 
        /**
         * Guardamos 
         */
        Acciones.BuscarporXpath("//div[3]/div[1]/div[2]/div/div[4]/div/div[2]/a[2]", "Guardar");

        try {
	         Thread.sleep(7000); 
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }
	//Obtenemos la URL
      urlActual1 = driver.getCurrentUrl();
      System.out.println(urlActual1);
     
	}
	public String getIdentificador() {
		return identificador;
	}

	public String getUrl() {
		return urlActual1;
	}
	

}
