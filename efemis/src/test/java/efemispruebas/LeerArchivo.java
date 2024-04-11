package efemispruebas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;




public class LeerArchivo extends efemis{
	public LeerArchivo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

/*	private String url;
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
	//filepath --> camino al fichero*/

	 public void leer(String filePath, String nombre) throws IOException {
	        File file = new File(filePath);
	        FileInputStream inputStream = new FileInputStream(file);
	        
	        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	        XSSFSheet newSheet = newWorkbook.getSheet(nombre);
	        
	        int numFilas = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
	        
	        for(int i = 0; i < numFilas; i++) {
	            XSSFRow fila = newSheet.getRow(i);
	            for(int j = 0; j < fila.getLastCellNum(); j++) {
	               // System.out.print(fila.getCell(j).getStringCellValue() + "||");
	            }
	        }
	        
	        newWorkbook.close();
	        inputStream.close();
	    }
	    
	    
	    public String valorCelda(String filePath, String nombre, int numFila, int numColumna) throws IOException {
	        File file = new File(filePath);
	        FileInputStream inputStream = new FileInputStream(file);
	        
	        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	        XSSFSheet newSheet = newWorkbook.getSheet(nombre);
	        
	        XSSFRow fila = newSheet.getRow(numFila);
	        XSSFCell columna = fila.getCell(numColumna);
	        String valor = columna.getStringCellValue();
	        
	        newWorkbook.close();
	        inputStream.close();
	        
	        return valor;
	    }
	    
	    public String valorCeldaFecha(String filePath, String nombre, int numFila, int numColumna) {
	    	try {	
	    	File file = new File(filePath);
		        FileInputStream inputStream = new FileInputStream(file);
		        
		        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		        XSSFSheet newSheet = newWorkbook.getSheet(nombre);
		        
		        XSSFRow fila = newSheet.getRow(numFila);
		        XSSFCell columna = fila.getCell(numColumna);
	    	
		        LocalDate fecha = null;
		        if (columna != null) {
	                if (columna.getCellType() == CellType.NUMERIC) {
	                    fecha = columna.getLocalDateTimeCellValue().toLocalDate();
	                } else if (columna.getCellType() == CellType.STRING) {
	                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	                    fecha = LocalDate.parse(columna.getStringCellValue(), formatter);
	                }
	            }

	            newWorkbook.close();
	            inputStream.close();
	            return (fecha != null) ? fecha.toString() : "Celda vacía o formato inválido";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al leer el archivo";
        }
    }}
	 /*   @BeforeSuite
	    public void datos(){
	    		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe"); 
	    		driver = new ChromeDriver();
	    		//Excel = new LeerArchivo(driver);
	    		String filePath = "C:\\Users\\usuario\\Documents\\DatosPrueba\\DatosRECOM.xlsx"; 
	            String nombreHoja = "Hoja1";        
	            try {
	            	//URL
	            	url = valorCelda(filePath, nombreHoja, 1, 3);
	            	//Login
	                usuario = valorCelda(filePath, nombreHoja, 2, 3);
	                contrasena = valorCelda(filePath, nombreHoja, 3, 3);
	                //Menu
	                pruebaAdrian = valorCelda(filePath, nombreHoja, 4, 3);
	                idioma = valorCelda(filePath, nombreHoja, 5, 3);
	                
	                //Recomendaciones
	                campana = valorCelda(filePath, nombreHoja, 7, 3);
	                tarea = valorCelda(filePath, nombreHoja, 9, 3);            
	                cultivo =valorCelda(filePath, nombreHoja, 13, 3);
	                guardar =valorCelda(filePath, nombreHoja, 15, 3);
	                //Planificar recomendacion
	                accion = valorCelda(filePath, nombreHoja, 16, 3);
	                empresaServicios = valorCelda(filePath, nombreHoja, 25, 3);
	                trabajadores = valorCelda(filePath, nombreHoja, 28, 3);
	                maquinaria = valorCelda(filePath, nombreHoja, 31, 3);
	                aperos = valorCelda(filePath, nombreHoja, 34, 3);
	                herramientas = valorCelda(filePath, nombreHoja, 37, 3);
	                //Ejecutar planificacion
	                supervisor = valorCelda(filePath, nombreHoja, 48, 3);
	                estado = valorCelda(filePath, nombreHoja, 65, 3);
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
	    }*/

