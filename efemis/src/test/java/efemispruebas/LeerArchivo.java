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



	 public void leer(String filePath, String nombre) throws IOException {
	        File file = new File(filePath);
	        FileInputStream inputStream = new FileInputStream(file);
	        
	        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	        XSSFSheet newSheet = newWorkbook.getSheet(nombre);
	        
	        int numFilas = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
	        
	        for(int i = 0; i < numFilas; i++) {
	            XSSFRow fila = newSheet.getRow(i);
	            for(int j = 0; j < fila.getLastCellNum(); j++) {
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
	 

