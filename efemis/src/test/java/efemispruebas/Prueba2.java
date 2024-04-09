package efemispruebas;

import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;


public class Prueba2 {

	private String identificador;
	private String compIdentificador;

	
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

    @AfterMethod
    public void tearDown() {     
    	
    	if (driver != null) {
            driver.quit();
       }
    	VideoRecorder.stopRecord();
    }
  
    LeerArchivo leerarchivo = new LeerArchivo(driver);
    
	private void login() {
		leerarchivo.datos();

		Login login = new Login(driver);
        login.iniciarSesion(leerarchivo.getUrl(),leerarchivo.getUsuario(),leerarchivo.getContrasena());
        System.out.println(login.getTitulo());
	}
	
	private void menu() {
		Menu menu = new Menu(driver);
        menu.MenuDesplegable(leerarchivo.getPruebaAdrian(),leerarchivo.getIdioma(),"Actividades","Recomendaciones");
	}
	
	private void Recomendaciones() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate fechaInicio = LocalDate.now();
		String inicioString = fechaInicio.format(formatter).toString();
		LocalDate fechaFin = fechaInicio.plusDays(7);
		String finString = fechaFin.format(formatter).toString();
		
    	Recomendaciones recomendacion= new Recomendaciones(driver);
    	recomendacion.crearRecomendacion(leerarchivo.getCampana(),inicioString,finString,leerarchivo.getTarea(),leerarchivo.getCultivo(),leerarchivo.getGuardar());
	}
	
	private void PlanificarRecomendacion() {
    	PlanificarRecomendacion planificar = new PlanificarRecomendacion(driver);
    	planificar.PlanificarReco(leerarchivo.getAccion(),leerarchivo.getEmpresaServicios(),leerarchivo.getTrabajadores(),leerarchivo.getMaquinaria(),leerarchivo.getAperos(),leerarchivo.getHerramientas());
    	identificador = planificar.getIdentificador();//Cogemos el id

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
    	Assert.assertEquals(leerarchivo.getEmpresaServicios(),CompEmpresaServicios);
    	//Trabajadores
    	Assert.assertEquals(leerarchivo.getTrabajadores(),CompTrabajadores);
    	//Maquinaria
   		Assert.assertEquals(leerarchivo.getMaquinaria(),CompMaquinaria);
    	//Aperos
   		Assert.assertEquals(leerarchivo.getAperos(),CompAperos);
    	//Herramientas
   		Assert.assertEquals(leerarchivo.getHerramientas(),CompHerramientas);
   		//Numero planificaciones
    	Assert.assertEquals(Nplanificacion, Nplanificacion2);
    }
	
	public void EjecutarRecomendacion() {
		EjecutarRecomendacion ejecutar = new EjecutarRecomendacion(driver);
		ejecutar.ejecutarRecomendacion();
		//identificador = ejecutar.getIdentificador();
		
	}
	

	
}
