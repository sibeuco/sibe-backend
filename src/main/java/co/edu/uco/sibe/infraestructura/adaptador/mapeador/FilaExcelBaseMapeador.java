package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

public abstract class FilaExcelBaseMapeador<T> implements FilaExcelMapeador<T> {
    private final DataFormatter dataFormatter = new DataFormatter();

    protected String obtenerValorCelda(Row fila, Integer indice) {
        if (indice == null) {
            return VACIO;
        }

        Cell celda = fila.getCell(indice);

        if (celda == null) {
            return VACIO;
        }

        return dataFormatter.formatCellValue(celda).trim();
    }
}