package co.edu.uco.sibe.infraestructura.adaptador.servicio;

import co.edu.uco.sibe.infraestructura.adaptador.mapeador.FilaExcelMapeador;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ProcesadorExcelMotor {

    public <T> List<T> procesarArchivo(MultipartFile archivo, FilaExcelMapeador<T> mapeador) {
        if (archivo.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío.");
        }

        List<T> resultados = new ArrayList<>();

        try (InputStream is = archivo.getInputStream();
             Workbook workbook = new XSSFWorkbook(is)) {

            Sheet hoja = workbook.getSheetAt(0);
            Iterator<Row> filas = hoja.iterator();

            if (!filas.hasNext()) {
                throw new IllegalStateException("El archivo está vacío o no tiene encabezados.");
            }

            Row filaEncabezados = filas.next();
            Map<String, Integer> mapaColumnas = new HashMap<>();
            for (Cell celda : filaEncabezados) {
                if (celda != null && celda.getCellType() == CellType.STRING) {
                    mapaColumnas.put(celda.getStringCellValue().trim().toUpperCase(), celda.getColumnIndex());
                }
            }

            while (filas.hasNext()) {
                Row fila = filas.next();
                if (filaVacia(fila)) continue;

                T dto = mapeador.mapearFila(fila, mapaColumnas);
                resultados.add(dto);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al procesar el archivo: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado: " + e.getMessage(), e);
        }

        return resultados;
    }

    private boolean filaVacia(Row row) {
        if (row == null) return true;
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK)
                return false;
        }
        return true;
    }
}