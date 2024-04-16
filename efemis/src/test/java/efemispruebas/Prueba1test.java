package efemispruebas;

import static org.testng.Assert.assertEquals;


import java.io.File;
import java.io.IOException;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.monte.screenrecorder.ScreenRecorder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Acciones;

public class Prueba1test {
	
	private String identificador;
	private String compIdentificador;
	private String url;
	private String usuario;
	private String Compusuario;
	private String contrasena;
	private String Compcontrasena;
	private String pruebaAdrian;
	private String idioma;
	private String campana;
	private String tarea;
	private String cultivo;
	private String guardar;
	private String empresaServicios;
	private String trabajadores;
	private String maquinaria;
	private String aperos;
	private String herramientas;
	private String accion;
	
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
	private ExtentReports extent;
	private ExtentTest screen;
	
	private int numeroColumna = 4;

	


	@Before
	public void setUp() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe"); 
		driver = new ChromeDriver();
		Excel = new LeerArchivo(driver);
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("efemis/target/Spark.html");
		extent.attachReporter(spark);
      
        
		String filePath = "C:\\Users\\usuario\\Documents\\DatosPrueba\\DatosRECOM.xlsx"; 
        String nombreHoja = "Hoja1";        
        try {
        	//URL
        	url = Excel.valorCelda(filePath, nombreHoja, 1, numeroColumna);
        	//Login
            usuario = Excel.valorCelda(filePath, nombreHoja, 2, numeroColumna);
            contrasena = Excel.valorCelda(filePath, nombreHoja, 3, numeroColumna);
            //Menu
            pruebaAdrian = Excel.valorCelda(filePath, nombreHoja, 4, numeroColumna);
            idioma = Excel.valorCelda(filePath, nombreHoja, 5, numeroColumna);
            
            //Recomendaciones
            campana = Excel.valorCelda(filePath, nombreHoja, 7, numeroColumna);
            tarea = Excel.valorCelda(filePath, nombreHoja, 9, numeroColumna);            
            cultivo =Excel.valorCelda(filePath, nombreHoja, 13, numeroColumna);
            guardar =Excel.valorCelda(filePath, nombreHoja, 15, numeroColumna);
            //Planificar recomendacion
            accion = Excel.valorCelda(filePath, nombreHoja, 16, numeroColumna);
            empresaServicios = Excel.valorCelda(filePath, nombreHoja, 25, numeroColumna);
            trabajadores = Excel.valorCelda(filePath, nombreHoja, 28, numeroColumna);
            maquinaria = Excel.valorCelda(filePath, nombreHoja, 31, numeroColumna);
            aperos = Excel.valorCelda(filePath, nombreHoja, 34, numeroColumna);
            herramientas = Excel.valorCelda(filePath, nombreHoja, 37, numeroColumna);
            //Ejecutar planificacion
            supervisor = Excel.valorCelda(filePath, nombreHoja, 48, numeroColumna);
            estado = Excel.valorCelda(filePath, nombreHoja, 65, numeroColumna);
            VideoRecorder.startRecord("main");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    @After
    public void tearDown() {     
    	extent.flush();
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
    
    	
	}

	private void login() throws IOException {
		Login login = new Login(driver);
	    ExtentTest screen = extent.createTest("Login");
		Acciones accionn = new Acciones(driver,screen);
		screen.info("Iniciando sesión con los siguientes datos:");
		screen.info("URL: " + url);
		screen.info("Usuario: " + usuario);
		screen.info("Contraseña: " + contrasena);
        login.iniciarSesion(url, usuario, contrasena);
        String UrlActual = login.getUrl();
  
        try {
        	Assert.assertEquals(UrlActual, "https://efemispre.hispatec.com/dashboard");
        	screen.pass("Inicio de sesion exitoso.");
        } catch (AssertionError e) {
        	screen.fail("[ Error ] ->Inicio de sesion fallido: " + e.getMessage());
            accionn.tomarCapturaDePantalla("errorInicioSesion");
            e.printStackTrace();
            throw e;
        }
        
	}
	
	private void menu() throws IOException {
		Menu menu = new Menu(driver);
		ExtentTest screen = extent.createTest("Menu");
		Acciones accionn = new Acciones(driver,screen);
		screen.info("Cargando menú desplegable con las siguientes opciones:");
		screen.info("Prueba Adrian: " + pruebaAdrian);
		screen.info("Idioma: " + idioma);
	    menu.MenuDesplegable(pruebaAdrian, idioma, "Actividades", "Recomendaciones");
		String Url1 = menu.getUrl();
	    try {
        	Assert.assertEquals(Url1, "https://efemispre.hispatec.com/recommendations");    
		    screen.pass("La ruta del menu seguida correctamente");
        } catch (AssertionError e) {
        	screen.fail("[ Error ] -> No se ha seguido la ruta debido a: " + e.getMessage());
            accionn.tomarCapturaDePantalla("MenuErroneo");
            e.printStackTrace();
            throw e;


        }
	}
	
	private void Recomendaciones() throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		LocalDate fechaInicio = LocalDate.now();
		String inicioString = fechaInicio.format(formatter).toString();
		LocalDate fechaFin = fechaInicio.plusDays(7);
		String finString = fechaFin.format(formatter).toString();
		
    	Recomendaciones recomendacion= new Recomendaciones(driver);
    	ExtentTest screen = extent.createTest("Recomendaciones");
		Acciones accionn = new Acciones(driver,screen);
		screen.info("Creando una recomendación con los siguientes datos:");
		screen.info("Campaña: " + campana);
		screen.info("Fecha de inicio: " + inicioString);
		screen.info("Fecha de fin: " + finString);
		screen.info("Tarea: " + tarea);
		screen.info("Cultivo: " + cultivo);
		screen.info("Guardar: " + guardar);
		recomendacion.crearRecomendacion(campana, inicioString, finString, tarea, cultivo, guardar);
		String URL4 = recomendacion.getUrl2();
		String URL5 = recomendacion.getUrl();
		String camp = recomendacion.getUCampana();
		String tar = recomendacion.getTarea();
		String cul = recomendacion.getCultivo();

        try {
        	

    		Assert.assertEquals(camp, campana);  
       	    screen.pass("[ OK ] -> Se ha encontrado la campaña con exito.");
    		
    		Assert.assertEquals(tar, tarea);  
       	    screen.pass("[ OK ] -> Se ha aencontrado la tarea con exito.");
    		
        	Assert.assertEquals(URL4, "https://efemispre.hispatec.com/recommendations/create");  
       	    screen.pass("[ OK ] -> Se ha accedido correctamente a crear la recomendacion.");

        	Assert.assertEquals(URL5, "https://efemispre.hispatec.com/recommendations"); 
       	    screen.pass("[ OK ] -> Se ha comprobado la finalizacion de la recomendacion.");

        	screen.pass("Recomendacion creada exitosamente");
        } catch (AssertionError e) {
        	screen.fail("[ Error ] -> La recomendacion no se ha creado debidoa a: " + e.getMessage());
        	accionn.tomarCapturaDePantalla("RecomendacionesError");
            e.printStackTrace();
            throw e;
        }
        
	}
	
	private void PlanificarRecomendacion() throws IOException {
		    PlanificarRecomendacion planificar = new PlanificarRecomendacion(driver);
		    ExtentTest screen = extent.createTest("Planificar Recomendaciones");
			Acciones accionn = new Acciones(driver,screen);
			screen.info("Ejecutando la planificación de la recomendación con los siguientes datos:");
			screen.info("Acción: " + accion);
			screen.info("Empresa de Servicios: " + empresaServicios);
			screen.info("Trabajadores: " + trabajadores);
			screen.info("Maquinaria: " + maquinaria);
			screen.info("Aperos: " + aperos);
			screen.info("Herramientas: " + herramientas);
	        planificar.PlanificarReco(accion, empresaServicios, trabajadores, maquinaria, aperos, herramientas);
			String Url2 = planificar.getUrl();
		    try {
		        identificador = planificar.getIdentificador();//Cogemos el id
	        	Assert.assertEquals(Url2, "https://efemispre.hispatec.com/planning");
           	    screen.pass("[ OK ] -> Comprobamos que la URL coincide con la de planificar una recomendacion.");

		        screen.pass("Planificacion de la recomendacion realizada exitosamente.");
		    } catch (AssertionError e) {
		    	screen.fail("[ Error ] -> Error al intentar planificar la recomendación: " + e.getMessage());
		    	accionn.tomarCapturaDePantalla("PlanificarRecomendacionError");
	            e.printStackTrace();
	            throw e;
	            }
		    

    }
	
	private void EjecutarPlanificacion() throws IOException{
    	EjecutarPlanificacion ejecutar = new EjecutarPlanificacion(driver);
	    ExtentTest screen = extent.createTest("Ejecutar Planificacion");
		Acciones accionn = new Acciones(driver,screen);
    	screen.info("Ejecutando la planificación con los siguientes datos:");
    	screen.info("Supervisor: " + supervisor);
    	screen.info("Estado: " + estado);
    	ejecutar.ejecucionPlani(supervisor, estado);


            compIdentificador = ejecutar.getIdentificador2();
        	Nplanificacion=ejecutar.getNplanificacion();
        	Nplanificacion2= ejecutar.getNplanificacion2();
        	CompEmpresaServicios = ejecutar.getEmpresaServicios();
        	CompTrabajadores = ejecutar.getTrabajador();
        	CompMaquinaria = ejecutar.getMaquinaria();
        	CompAperos = ejecutar.getAperos();
        	CompHerramientas = ejecutar.getHerramientas();
        	String Url3 = ejecutar.getUrl();

        	 try {
             	 Assert.assertEquals(empresaServicios,CompEmpresaServicios);
            	 screen.pass("[ OK ] -> Empresa de servcios comprobadas.");

             	 Assert.assertEquals(trabajadores,CompTrabajadores);
            	 screen.pass("[ OK ] -> Trabajadoras comprobados.");

            	 Assert.assertEquals(maquinaria,CompMaquinaria);
            	 screen.pass("[ OK ] -> Maquinaria comprobada.");

            	 Assert.assertEquals(aperos,CompAperos);
            	 screen.pass("[ OK ] -> Aperos comprobados.");

            	 Assert.assertEquals(herramientas,CompHerramientas);
            	 screen.pass("[ OK ] -> Herramientas Comprobadas.");

            	 Assert.assertEquals(identificador,compIdentificador);
           		 screen.pass("[ OK ] -> Comprobamos que los ID corresponden a la misma recomendacion.");
           		 
             	 Assert.assertEquals(Nplanificacion, Nplanificacion2);     	 
            	 screen.pass("[ OK ] -> Comprobamos que los ID de la planificacion corresponden.");

            	 Assert.assertEquals(Url3,"https://efemispre.hispatec.com/task");
         		 screen.pass("Ejecucion de la planificacion llevada a cabo correctamente.");

             	 
 		    } catch (AssertionError e) {
 		    	screen.fail("[ Error ] -> Error al intentar ejecutar la planificacion: " + e.getMessage());
 		    	accionn.tomarCapturaDePantalla("EjecutarPlanificacion");
 	            e.printStackTrace();
 	           throw e;
 	            }
       
   
    }
	
	public void EjecutarRecomendacion() {
		EjecutarRecomendacion ejecutar = new EjecutarRecomendacion(driver);
		ejecutar.ejecutarRecomendacion();
		//identificador = ejecutar.getIdentificador();
	}
	

	}


