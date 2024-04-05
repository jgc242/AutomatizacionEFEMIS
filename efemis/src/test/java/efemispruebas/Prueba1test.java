package efemispruebas;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.monte.screenrecorder.ScreenRecorder;

public class Prueba1test {
	
	private String identificador;
	private String compIdentificador;
	private String url;
	private String usuario;
	private String contraseña;
	private String pruebaAdrian;
	private String idioma;
	private String campaña;
	private String tarea;
	private String cultivo;
	private String guardar;
	private String empresaServicios;
	private String trabajadores;
	private String maquinaria;
	private String aperos;
	private String herramientas;
	private String accion;
	
	private String CCampaña;
	private String CTarea;
	private String CCultivo;
	
	
	private String CompEmpresaServicios;
	private String CompTrabajadores;
	private String CompMaquinaria;
	private String CompAperos;
	private String CompHerramientas;

	private String supervisor;
	private String estado;
	
	private String Nplanificacion;
	private String Nplanificacion2;
	private WebDriver driver;
	private LeerArchivo Excel;


	
	@Before
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe"); 
		driver = new ChromeDriver();
		Excel = new LeerArchivo(driver);
		String filePath = "C:\\Users\\usuario\\Documents\\DatosPrueba\\DatosRECOM.xlsx"; 
        String nombreHoja = "Hoja1";        
        try {
        	//URL
        	url = Excel.valorCelda(filePath, nombreHoja, 1, 3);
        	//Login
            usuario = Excel.valorCelda(filePath, nombreHoja, 2, 3);
            contraseña = Excel.valorCelda(filePath, nombreHoja, 3, 3);
            //Menu
            pruebaAdrian = Excel.valorCelda(filePath, nombreHoja, 4, 3);
            idioma = Excel.valorCelda(filePath, nombreHoja, 5, 3);
            
            //Recomendaciones
            campaña = Excel.valorCelda(filePath, nombreHoja, 7, 3);
            tarea = Excel.valorCelda(filePath, nombreHoja, 9, 3);            
            cultivo =Excel.valorCelda(filePath, nombreHoja, 13, 3);
            guardar =Excel.valorCelda(filePath, nombreHoja, 15, 3);
            //Planificar recomendacion
            accion = Excel.valorCelda(filePath, nombreHoja, 16, 3);
            empresaServicios = Excel.valorCelda(filePath, nombreHoja, 25, 3);
            trabajadores = Excel.valorCelda(filePath, nombreHoja, 28, 3);
            maquinaria = Excel.valorCelda(filePath, nombreHoja, 31, 3);
            aperos = Excel.valorCelda(filePath, nombreHoja, 34, 3);
            herramientas = Excel.valorCelda(filePath, nombreHoja, 37, 3);
            //Ejecutar planificacion
            supervisor = Excel.valorCelda(filePath, nombreHoja, 48, 3);
            estado = Excel.valorCelda(filePath, nombreHoja, 65, 3);
            VideoRecorder.startRecord("main");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    @After
    public void tearDown() {     
    	
    	if (driver != null) {
            driver.quit();
        }
    	VideoRecorder.stopRecord();
    }
	

    @Test
	public void testAutomatizacion() throws IOException, InterruptedException {

          login();
	      menu();
		  Recomendaciones();
          PlanificarRecomendacion();
		  EjecutarPlanificacion();
		 
		
	}/*
    @Test
    public void test2() {
    	login();
		menu();
		Recomendaciones();
		//EjecutarRecomendacion();
    }*/

	private void login() {
		Login login = new Login(driver);
        login.iniciarSesion(url,usuario,contraseña);
        //String hola = login.getTitulo();
        System.out.println(login.getTitulo());
	}
	
	private void menu() {
		Menu menu = new Menu(driver);
        menu.MenuDesplegable(pruebaAdrian,idioma,"Actividades","Recomendaciones");
	}
	
	private void Recomendaciones() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate fechaInicio = LocalDate.now();
		String inicioString = fechaInicio.format(formatter).toString();
		LocalDate fechaFin = fechaInicio.plusDays(7);
		String finString = fechaFin.format(formatter).toString();
		
    	Recomendaciones recomendacion= new Recomendaciones(driver);
    	recomendacion.crearRecomendacion(campaña,inicioString,finString,tarea,cultivo,guardar);
	}
	
	private void PlanificarRecomendacion() {
    	PlanificarRecomendacion planificar = new PlanificarRecomendacion(driver);
    	planificar.PlanificarReco(accion,empresaServicios,trabajadores,maquinaria,aperos,herramientas);
    	identificador = planificar.getIdentificador();//Cogemos el id
    /*	CCampaña = planificar.getCampaña();
    	CTarea = planificar.getTarea();
    	CCultivo = planificar.getCultivo();
    	
    	//Comprobaciones
    	Assert.assertEquals(campaña,CCampaña);
    	Assert.assertEquals(tarea,CTarea);
    	Assert.assertEquals(cultivo,CCultivo);*/
    }
	
	private void EjecutarPlanificacion(){
    	EjecutarPlanificacion ejecutar = new EjecutarPlanificacion(driver);
    	ejecutar.ejecucionPlani(supervisor,estado);
    	compIdentificador = ejecutar.getIdentificador2();
    	Nplanificacion=ejecutar.getNplanificacion();
    	Nplanificacion2= ejecutar.getNplanificacion2();
    	CompEmpresaServicios = ejecutar.getEmpresaServicios();
    	CompTrabajadores = ejecutar.getTrabajador();
    	CompMaquinaria = ejecutar.getMaquinaria();
    	CompAperos = ejecutar.getAperos();
    	CompHerramientas = ejecutar.getHerramientas();
    	
    		
        // Agregar aserciones para verificar que la planificaci�n de la recomendaci�n funcion� correctamente
    	Assert.assertEquals(identificador,compIdentificador);
    	//Comprobaciones 
    	//Empresa de servicios
    	Assert.assertEquals(empresaServicios,CompEmpresaServicios);
    	//Trabajadores
    	Assert.assertEquals(trabajadores,CompTrabajadores);
    	//Maquinaria
   		Assert.assertEquals(maquinaria,CompMaquinaria);
    	//Aperos
   		Assert.assertEquals(aperos,CompAperos);
    	//Herramientas
   		Assert.assertEquals(herramientas,CompHerramientas);
   		//Numero planificaciones
    	Assert.assertEquals(Nplanificacion, Nplanificacion2);
    }
	
	public void EjecutarRecomendacion() {
		EjecutarRecomendacion ejecutar = new EjecutarRecomendacion(driver);
		ejecutar.ejecutarRecomendacion();
		//identificador = ejecutar.getIdentificador();
	}
	

	}


