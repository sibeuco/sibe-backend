package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import org.apache.poi.ss.usermodel.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

public abstract class FilaExcelBaseMapeador<T> implements FilaExcelMapeador<T> {
    private final DataFormatter dataFormatter = new DataFormatter();

    protected String obtenerValorCelda(Row fila, int indiceColumna) {
        Cell celda = fila.getCell(indiceColumna);

        if (celda == null) {
            return VACIO;
        }

        if (celda.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(celda)) {
            Date fechaCelda = celda.getDateCellValue();

            var sdf = new SimpleDateFormat("MM/dd/yyyy");
            return sdf.format(fechaCelda);

        } else {
            return celda.toString();
        }
    }
}