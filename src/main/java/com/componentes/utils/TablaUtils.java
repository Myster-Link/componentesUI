package com.componentes.utils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import java.lang.reflect.Method;

public class TablaUtils {

    public static <T> void rellenarTabla(JTable table, String[] columns, List<T> list, String[] attributeAccessExpressions) {
        try {
            DefaultTableModel model = new DefaultTableModel();

            // Definir las columnas
            String[] columnNames = columns;
            model.setColumnIdentifiers(columnNames);

            // Agregar los datos al modelo de la tabla
            for (T obj : list) {
                // Obtener los valores de los atributos especificados en attributeAccessExpressions
                Object[] rowData = new Object[attributeAccessExpressions.length];
                for (int i = 0; i < attributeAccessExpressions.length; i++) {
                    rowData[i] = obtenerValorAtributo(obj, attributeAccessExpressions[i]);
                }

                // Agregar la fila al modelo de la tabla
                model.addRow(rowData);
            }

            // Asignar el modelo a la tabla 
            table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static <T> Object obtenerValorAtributo(T obj, String attributeAccessExpression) throws Exception {
        String[] attributeNames = attributeAccessExpression.split("\\."); // Separar por puntos si hay accesos anidados
        Object valor = obj;

        for (String attributeName : attributeNames) {
            // Verificar si el atributo es una invocación de método (contiene paréntesis)
            if (attributeName.contains("(") && attributeName.endsWith(")")) {
                // Extraer el nombre del método y sus argumentos
                String methodName = attributeName.substring(0, attributeName.indexOf("("));
                String[] arguments = attributeName.substring(attributeName.indexOf("(") + 1, attributeName.length() - 1).split(",");

                // Obtener el método con el nombre proporcionado
                Method method = valor.getClass().getMethod(methodName);

                // Convertir los argumentos a objetos
                Object[] argumentObjects = new Object[arguments.length];
                for (int i = 0; i < arguments.length; i++) {
                    argumentObjects[i] = obtenerValorAtributo(valor, arguments[i].trim());
                }

                // Invocar el método con los argumentos y actualizar el valor
                valor = method.invoke(valor, argumentObjects);
            } else {
                // Es un atributo normal, obtener el valor del atributo
                Method getter = valor.getClass().getMethod(obtenerNombreGetter(attributeName));
                valor = getter.invoke(valor);
            }
        }

        return valor;
    }

    private static String obtenerNombreGetter(String attributeName) {
        return "get" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
    }
}
