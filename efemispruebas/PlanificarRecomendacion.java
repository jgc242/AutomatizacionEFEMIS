package efemispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlanificarRecomendacion extends efemis {

	private String identificador;
	private String compCampaña;
	private String compTarea;
	private String compCultivo;

	
	public PlanificarRecomendacion(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void PlanificarReco(String OpcionAccion, String OpcionEmpresa, String OpcionTrabajadores, String OpcionMaquinaria, String OpcionAperos, String OpcionHerramietas) {
		
		//esperamos hasta que un boton con el total de reconendaciones sea visible para continuar con la planificacion  	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div[3]/div[5]/div/div[4]/div/div/div[1]/div/div/div")));
		    	
		// Encontrar la fila que contiene el elemento deseado (Obtener id)223
		WebElement fila = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines']//td[@aria-describedby='dx-col-243']")));
		identificador= fila.getText();
		System.out.println(identificador.toString());
		 
	 
		 //Desplegable menu
		 WebElement seleccion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div/div[1]/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div[3]/div[5]/div/div[6]/div[2]/table/tbody/tr[1]/td[2]/div/div/div[1]/div/div")));
		seleccion.click();

    	 //Boton planificaion
		WebElement plani = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+OpcionAccion+"']")));
		//WebElement plani = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[2]/div/span")));
        plani.click();
       
    
        
        
        
        
        /**
         * Seleccion Empresa de Servicios
         */
 
        //Desplegable empresa servicios
        WebElement DesplegableEmpServicios = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[3]/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div")));
        DesplegableEmpServicios.click();
       
        
        WebElement escrituraEmpresa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[2]/div/div[2]/div/div/div[1]/input")));   
        escrituraEmpresa.sendKeys(OpcionEmpresa);
        
      //Buscamos el elemento filtrado y le hacemos click       
       WebElement resultadoEmpresa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'"+OpcionEmpresa+"')]/preceding-sibling::td/div/div/span[@class='dx-checkbox-icon']")));
       resultadoEmpresa.click();
        
        //A�adimos empresa
        WebElement AnadirEmpresa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div/div/div[2]/div/div/span")));
        AnadirEmpresa.click();
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DesplegableEmpServicios);//scroll
        
        /**
         * 	Comprobaciones
         */
     /*   
      //Campaña
        WebElement ComprobacionCampaña = driver.findElement(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div/div[1]/input"));
        compCampaña = ComprobacionCampaña.getText();
        System.out.println(compCampaña);
        
      //Tarea
        WebElement ComprobacionTarea = driver.findElement(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div/div[1]/input"));
        compTarea = ComprobacionTarea.getText();
        System.out.println(compTarea);
        
      //Cultivo
        WebElement ComprobacionCultivo = driver.findElement(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/input"));
        compCampaña = ComprobacionCultivo.getText();
        System.out.println(compCampaña);*/
        
        /**
         * Seleccion Trabajadores
         */
      //Desplegable Trabajadores
        WebElement DesplegableTrabajadores = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[4]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[2]/div/div")));
        DesplegableTrabajadores.click();
        
      //Seleccion de Permanente
        WebElement Permanente = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dx-item-content dx-list-item-content' and text()='"+OpcionTrabajadores+"']")));
        Permanente.click();
        
      //A�adimos Trabajador
        WebElement AnadirTrabajador = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div/div[2]/div/div/span")));
        AnadirTrabajador.click();
        
        WebElement marcar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[1]/div/div\r\n")));
        marcar.click();

        /**
         * Seleccion Maquinaria
         */
      
      //Desplegable Maquinaria
        WebElement DesplegableMaquinaria = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div/div[5]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/div")));
        DesplegableMaquinaria.click();
        
                                                                                                  
        WebElement escrituraMaquinaria = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[4]/div/div[2]/div/div/div[1]/input")));   
        escrituraMaquinaria.sendKeys(OpcionMaquinaria);
        
      //Buscamos el elemento filtrado y le hacemos click       
       WebElement resultadoMaquinaria = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'"+OpcionMaquinaria +"')]/preceding-sibling::td/div/div/span[@class='dx-checkbox-icon']")));
       resultadoMaquinaria.click();
     
        //A�adimos Maquinaria
        WebElement AnadirMaquinaria = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[5]/div/div[2]/div/div[1]/div[3]/div")));
        AnadirMaquinaria.click();
        
        /**
         * Seleccion Aperos
         */
      //Desplegable Aperos
        WebElement DesplegableAperos = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div/div[6]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/div")));
        DesplegableAperos.click();
       
        WebElement escrituraAperos = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[4]/div/div[2]/div/div/div[1]/input")));   
        escrituraAperos.sendKeys(OpcionAperos);
        
      //Buscamos el elemento filtrado y le hacemos click       
       WebElement resultadoAperos = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'"+OpcionAperos +"')]/preceding-sibling::td/div/div/span[@class='dx-checkbox-icon']")));
       resultadoAperos.click();
             
      //A�adimos Aperos
        WebElement AnadirAperos = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div/div[6]/div/div[2]/div/div[1]/div[3]/div")));
        AnadirAperos.click();
       
        
        /**
         * Seleccion Herramientas
         */
      //Desplegable Herramientas
        WebElement DesplegableHerramientas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div/div[7]/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div")));
        DesplegableHerramientas.click();
        
        WebElement escrituraHerramientas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[4]/div/div[2]/div/div/div[1]/input")));   
        escrituraHerramientas.sendKeys(OpcionHerramietas);
        
      //Buscamos el elemento filtrado y le hacemos click       
       WebElement resultadoHerramientas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'"+OpcionHerramietas +"')]/preceding-sibling::td/div/div/span[@class='dx-checkbox-icon']")));
       resultadoHerramientas.click();

    
      //A�adimos Tijeras
       WebElement AnadirHerramientas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div/div[7]/div/div[2]/div/div[1]/div[3]/div")));
        AnadirHerramientas.click();
 
        /**
         * Guardamos 
         */

        WebElement Guardar1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[1]/div[2]/div/div[4]/div/div[2]/a[2]")));
        Guardar1.click();
     
	}
	public String getIdentificador() {
		return identificador;
	}
	/*public String getCampaña() {
		return compCampaña;
	}
	public String getTarea() {
		return compTarea;
	}
	public String getCultivo() {
		return compCultivo;
	}*/
	

}
