package efemispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import utils.Acciones;

public class EjecutarPlanificacion extends efemis{
	
	private String compIdentificador;
	private String Nplanificacion;
	private String Nplanificacion2;
	private String emprServicios;
	private String Trabajador;
	private String maquinaria;
	private String aperos;
	private String herramineta;
	
	public EjecutarPlanificacion(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ejecucionPlani(String OpcionSupervisor, String OpcionEstado) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/div[2]/div/div/div[2]/div/div/div[1]/div[3]/div[5]/div/div[4]/div/div/div[1]/div/div/div")));

	/**
	 * Guardamos el numero de planificacion
	 */
	WebElement fila = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines']//td[@aria-colindex='12']")));
	//WebElement fila = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines']//td[@aria-describedby='dx-col-202']")));
	compIdentificador= fila.getText();
    System.out.println(compIdentificador);
    
  //Numero planificacion
	 WebElement Nplani = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines']//td[@aria-colindex='9']")));
	 Nplanificacion= Nplani.getText();
	

	//Desplegamos el desplegable de acciones
	Acciones.BuscarporXpath("//div[3]/div[2]/div/div/div[2]/div/div/div[1]/div[3]/div[5]/div/div[6]/div[2]/table/tbody/tr[1]/td[2]/div/div/div/div");
  
    //Boton Ejecutar planificaion
    Acciones.BuscarporXpath("//body/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div[4]/div");
       

    /**
     * Creamos la orden de trabajo
     */

    try {
        Thread.sleep(8000); 
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
      
    
    //Seleccionamos supervisor (2403 - grower null)
  //*[@id="main-view"]/div[3]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/div                                                                   
                                                                        //*[@id="main-view"]/div[3]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/div/div
     WebElement Desplegable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[2]")));
     Desplegable.click();
     try {
         Thread.sleep(5000); 
     } catch (InterruptedException e) {
         e.printStackTrace();
     }    
     //Escritura supervisor
   //*[@id="treeList"]/div/div[5]/div/table/tbody/tr[2]/td[1]/div/div[2]/div/div/div[1]/input
       WebElement escrituraSupervisor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div/div/div/div[5]/div/table/tbody/tr[2]/td[1]/div/div[2]/div/div/div[1]/input")));   
      escrituraSupervisor.sendKeys(OpcionSupervisor);
     try {
         Thread.sleep(3000); 
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
   //Buscamos el elemento filtrado y le hacemos click 
     Acciones.BuscarporXpath("//td[text()='"+OpcionSupervisor+"']");
  
    //Seleccionamos Estado (Ejec.Finalizada
     Acciones.BuscarporXpath("//div[3]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/input");
    	   
    
  //Seleccion de ejecucion finalizada
     Acciones.BuscarporXpath("//div[@class='dx-item-content dx-list-item-content' and text()='"+OpcionEstado+"']");   
    
    /**
     * Comprobaciones
     */

    //Empresa de servicios
    WebElement ComprobacionES = driver.findElement(By.xpath("//*[@id=\"data-Table-Layout\"]/tbody/tr/td[3]/div"));
    emprServicios = ComprobacionES.getText();
    System.out.println(emprServicios);

    //Trabajadores
    WebElement traba = driver.findElement(By.xpath("//html/body/div/div[1]/div[3]/div[2]/div/div[4]/div[2]/div[1]/div[5]/div[2]/ul/li/div/div/div[1]"));
    Trabajador = traba.getText();
    System.out.println(Trabajador);
    
  //Maquinaria
    WebElement Maqui = driver.findElement(By.xpath("//html/body/div/div[1]/div[3]/div[2]/div/div[5]/div[2]/div[2]/div[1]/div[2]/table/tbody/tr/td[2]/div"));
    maquinaria = Maqui.getText();
    System.out.println(maquinaria);

    //Aperos
    WebElement ape = driver.findElement(By.xpath("//html/body/div/div[1]/div[3]/div[2]/div/div[7]/div/div[2]/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]/div"));
    aperos = ape.getText();
    System.out.println(aperos);
    
  //Herramientas
                                                     
    WebElement herra = driver.findElement(By.xpath("//html/body/div/div[1]/div[3]/div[2]/div/div[8]/div/div[2]/div/div[2]/div/div/div[2]/table/tbody/tr/td[2]/div"));
    herramineta = herra.getText();
    System.out.println(herramineta);
    
    
    //Guardamos el procesos
    Acciones.BuscarporXpath("//div[3]/div[1]/div[2]/div/div[4]/div/div[2]/a[2]");
	 
    WebElement DespleglableQA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-view\"]/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div[1]/div/div")));
    String textoActual = DespleglableQA.getText();
    if (!textoActual.equals("QA")) {
    	DespleglableQA.click();
        WebElement QA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dx-scrollview-content dx-wrap-item-text']//div[contains(text(), 'QA')]")));
        QA.click();
    }

	//Numero planificacion
	WebElement Nplani2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines']//td[@aria-colindex='6']")));
	Nplanificacion2= Nplani2.getText();
	System.out.println(Nplanificacion2.toString());
		 
    }
	
	public String getIdentificador2() {
		return compIdentificador;
	}
	
	public String getNplanificacion() {
		return Nplanificacion;
	}
	public String getNplanificacion2() {
		return Nplanificacion2;
	}
	public String getEmpresaServicios() {
		return emprServicios;
	}	
	public String getTrabajador() {
		return Trabajador;
	}
	public String getMaquinaria() {
		return maquinaria;
	}
	public String getAperos() {
		return aperos;
	}
	public String getHerramientas() {
		return herramineta;
	}
	
	
}
	

