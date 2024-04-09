package efemispruebas;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Excel extends efemis {
	public Excel(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	private String url;
	private String usuario;
	private String contrasena;
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
	private String supervisor;
	private String estado;

	private WebDriver driver;
	private LeerArchivo Excel;
	
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
	
	public String getUrl() {
        return url;
    }
    public String getUsuario() {

        return usuario;
    }
    public String getContrasena() {

        return contrasena;
    }
    public String getPruebaAdrian() {
        return pruebaAdrian;
    }
    public String getIdioma() {
        return idioma;
    }
    public String getCampana() {
        return campana;
    }
    public String getTarea() {
        return tarea;
    }
    public String getCultivo() {
        return cultivo;
    }
    public String getGuardar() {
        return guardar;
    }
    public String getAccion() {
        return accion;
    }
    public String getEmpresaServicios() {
        return empresaServicios;
    }
    public String getTrabajadores() {
        return trabajadores;
    }
    public String getMaquinaria() {
        return maquinaria;
    }
    public String getAperos() {
        return aperos;
    }
    public String getHerramientas() {
        return herramientas;
    }
    public String getSupervisor() {
        return supervisor;
    }
    public String getEstado() {
        return estado;
    }
    
}
