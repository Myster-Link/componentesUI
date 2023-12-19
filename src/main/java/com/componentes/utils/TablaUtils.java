package com.componentes.utils;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class TablaUtils {

    public static <T> void rellenarTabla(JTable table, List<T> dataList, String[] columnNames) {
        try {
            // Crear un modelo de tabla
            DefaultTableModel model = new DefaultTableModel();

            // Definir las columnas
            model.setColumnIdentifiers(columnNames);

            // Agregar los datos al modelo de la tabla
            for (T item : dataList) {
                Object[] rowData = obtenerDatos(item);
                model.addRow(rowData);
            }

            // Asignar el modelo a la tabla
            table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static <T> Object[] obtenerDatos(T item) throws IllegalAccessException {
        // Utilizar reflexión para obtener los valores de los campos
        Field[] fields = item.getClass().getDeclaredFields();
        Object[] rowData = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            rowData[i] = fields[i].get(item);
        }

        return rowData;
    }
}
