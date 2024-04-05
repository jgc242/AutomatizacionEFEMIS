package efemispruebas;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testng {

	private String identificador;
	private String compIdentificador;
	private String Nplanificacion;
	private String Nplanificacion2;
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }
	
    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Test(groups = "login")
    public void testLogin() {
        login();
        // Agregar aserciones para verificar que el inicio de sesi�n fue exitoso
    }

    @Test(groups = "menu", dependsOnGroups = "login")
    public void testMenu() {
        menu();
        // Agregar aserciones para verificar que el men� se despleg� correctamente
    }

    @Test(groups = "recomendaciones", dependsOnGroups = "menu")
    public void testRecomendaciones() {
        Recomendaciones();
        // Agregar aserciones para verificar que se cre� una recomendaci�n correctamente
    }

    @Test(groups = "planificacion", dependsOnGroups = "recomendaciones")
    public void testPlanificarRecomendacion() {
        PlanificarRecomendacion();
        // Agregar aserciones para verificar que la planificaci�n de la recomendaci�n funcion� correctamente
    }

    @Test(groups = "ejecucion", dependsOnGroups = "planificacion")
    public void testEjecutarPlanificacion() {
        EjecutarPlanificacion();
        // Agregar aserciones para verificar que la ejecuci�n de la planificaci�n funcion� correctamente
        Assert.assertEquals(identificador, compIdentificador);
        Assert.assertEquals(Nplanificacion, Nplanificacion2);
    }
    
    private void login() {
		Login login = new Login(driver);
        login.iniciarSesion("Adrian.vazquez@hispatec.com","1234567.");
	}
	
	private void menu() {
		Menu menu = new Menu(driver);
        menu.MenuDesplegable("Actividades","Recomendaciones");
	}
	
	private void Recomendaciones() {
    	Recomendaciones recomendacion= new Recomendaciones(driver);
    	recomendacion.crearRecomendacion();
	}
	
	private void PlanificarRecomendacion() {
    	PlanificarRecomendacion planificar = new PlanificarRecomendacion(driver);
    	planificar.PlanificarReco();
    	identificador = planificar.getIdentificador();//Cogemos el id
    }
	
	private void EjecutarPlanificacion() {
    	EjecutarPlanificacion ejecutar = new EjecutarPlanificacion(driver);
    	ejecutar.ejecucionPlani();
    	compIdentificador = ejecutar.getIdentificador2();
    	Nplanificacion=ejecutar.getNplanificacion();
    	Nplanificacion2= ejecutar.getNplanificacion2();
    	
        // Agregar aserciones para verificar que la planificaci�n de la recomendaci�n funcion� correctamente
    	Assert.assertEquals(identificador,compIdentificador);
    	Assert.assertEquals(Nplanificacion, Nplanificacion2);
    }
}
