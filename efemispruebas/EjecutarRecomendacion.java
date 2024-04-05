package efemispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EjecutarRecomendacion extends efemis{

	private String identificador;
	
	
	public EjecutarRecomendacion(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void ejecutarRecomendacion() {
		  	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div[3]/div[5]/div/div[4]/div/div/div[1]/div/div/div")));
		  
		/**
		 * Guardamos el id de recomendacion
		 */
	/*	WebElement fila = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines']//td[@aria-describedby='dx-col-246']")));
		identificador= fila.getText();
		 System.out.println(identificador.toString());
	    
	  */
		

		//Desplegamos el desplegable de acciones
		WebElement Acciones1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div/div/div[2]/div/div/div[1]/div[3]/div[5]/div/div[6]/div[2]/table/tbody/tr[1]/td[2]/div/div/div/div")));
	    Acciones1.click();
	  
	    //Boton Ejecutar recomendacion
	    WebElement Ejeplani = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Ejecutar recomendación']")));
	    Ejeplani.click();
	       

	    /**
	     * Creamos la orden de trabajo
	     */

	    try {
	        Thread.sleep(6000); 
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	      
	    
	    //Seleccionamos supervisor (2403 - grower null)
	     WebElement Desplegable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[1]")));
	     Desplegable.click();
	        
	    
	    //Buscamos el elemento filtrado y le hacemos click       
	    WebElement resultadoBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='2403 - grower']")));
	    resultadoBusqueda.click();
	  
	    //Seleccionamos Estado (Ejec.Finalizada
	    WebElement estado = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/input")));
	    estado.click();
	    	    
	    WebElement EjeFinalizada = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div[3]")));
	    EjeFinalizada.click();
	    
	    //Guardamos el procesos
	    WebElement GuardarOrden = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[1]/div[2]/div/div[4]/div/div[2]/a[2]")));
	    GuardarOrden.click();
		 
	    WebElement DespleglableQA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div[1]/div/div")));
	    String textoActual = DespleglableQA.getText();
	    if (!textoActual.equals("QA")) {
	    	DespleglableQA.click();
	        WebElement QA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dx-scrollview-content dx-wrap-item-text']//div[contains(text(), 'QA')]")));
	        QA.click();
	    }
	}
		
		
		/*public String getIdentificador() {
			return identificador;
		}*/
		
	
	}
		
