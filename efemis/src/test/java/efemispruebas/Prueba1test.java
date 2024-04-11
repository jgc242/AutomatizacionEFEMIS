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
        	url = Excel.valorCelda(filePath, nombreHoja, 1, 3);
        	//Login
            usuario = Excel.valorCelda(filePath, nombreHoja, 2, 3);
            contrasena = Excel.valorCelda(filePath, nombreHoja, 3, 3);
            //Menu
            pruebaAdrian = Excel.valorCelda(filePath, nombreHoja, 4, 3);
            idioma = Excel.valorCelda(filePath, nombreHoja, 5, 3);
            
            //Recomendaciones
            campana = Excel.valorCelda(filePath, nombreHoja, 7, 3);
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
       // Recomendaciones();
        //PlanificarRecomendacion();
        //EjecutarPlanificacion();	
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
        Compusuario = login.getUsuario();
        Compcontrasena =login.getContrasena();
  
        try {
        	//assertEquals(Compusuario, usuario);
           // assertEquals(Compcontrasena,contrasena);
        	screen.pass("Inicio de sesión exitoso.");
        } catch (AssertionError e) {
        	screen.fail("Inicio de sesión fallido: " + e.getMessage());
            accionn.tomarCapturaDePantalla("errorInicioSesion");
            e.printStackTrace();
        }
        
	}
	
	private void menu() throws IOException {
		Menu menu = new Menu(driver);
		ExtentTest screen = extent.createTest("Menu");
		Acciones accionn = new Acciones(driver,screen);
		screen.info("Cargando menú desplegable con las siguientes opciones:");
		screen.info("Prueba Adrian: " + pruebaAdrian);
		screen.info("Idioma: " + idioma);
	    try {
		    menu.MenuDesplegable(pruebaAdrian, idioma, "Actividades", "Recomendaciones");
		    screen.pass("La ruta del menu seguida correctamente");
        } catch (Exception e) {
        	screen.fail("No se ha seguido la ruta debido a: " + e.getMessage());
        	//menuTest.fail(MediaEntityBuilder.createScreenCaptureFromPath("ErrorMenu.jpg").build());
            accionn.tomarCapturaDePantalla("MenuErroneo");
            e.printStackTrace();


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

        try {
        	screen.pass("Recomendacion creada exitosamente");
        } catch (Exception e) {
        	screen.fail("La recomendacion no se ha creado debidoa a: " + e.getMessage());
        	//screen.fail(MediaEntityBuilder.createScreenCaptureFromPath("ErrorPlanificacion.png").build());
        	accionn.tomarCapturaDePantalla("RecomendacionesError");
            e.printStackTrace();

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
		    try {
		        planificar.PlanificarReco(accion, empresaServicios, trabajadores, maquinaria, aperos, herramientas);
		        identificador = planificar.getIdentificador();//Cogemos el id
		        screen.pass("Planificación de la recomendación realizada exitosamente.");
		    } catch (Exception e) {
		    	screen.fail("Error al intentar planificar la recomendación: " + e.getMessage());
		    	accionn.tomarCapturaDePantalla("PlanificarRecomendacionError");
	            e.printStackTrace();		
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
        	// Agregar aserciones para verificar que la planificaci�n de la recomendaci�n funcion� correctamente
        /*	Assert.assertEquals(identificador,compIdentificador);
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
        	Assert.assertEquals(Nplanificacion, Nplanificacion2);*/
        	 try {
        		 Assert.assertEquals(identificador,compIdentificador);
             	 Assert.assertEquals(empresaServicios,CompEmpresaServicios);
             	 Assert.assertEquals(trabajadores,CompTrabajadores);
            	 Assert.assertEquals(maquinaria,CompMaquinaria);
            	 Assert.assertEquals(aperos,CompAperos);
            	 Assert.assertEquals(herramientas,CompHerramientas);
             	 Assert.assertEquals(Nplanificacion, Nplanificacion2);
         		screen.pass("Ejecucion de la planificacion llevada a cabo correctamente.");

             	 
 		    } catch (Exception e) {
 		    	screen.fail("Error al intentar ejecutar la planificacion: " + e.getMessage());
 		    	accionn.tomarCapturaDePantalla("EjecutarPlanificacion");
 	            e.printStackTrace();		
 	            }
       
   
    }
	
	public void EjecutarRecomendacion() {
		EjecutarRecomendacion ejecutar = new EjecutarRecomendacion(driver);
		ejecutar.ejecutarRecomendacion();
		//identificador = ejecutar.getIdentificador();
	}
	

	}


