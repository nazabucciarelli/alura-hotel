package test;

import javax.swing.*;
import java.util.Optional;

public class Test {
   /*  private boolean tieneFilaElegida() {
        return tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0;
    }

    private void modificar() {
        if (tieneFilaElegida()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    int id = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
                    String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), 1);
                    String descripcion = (String) modelo.getValueAt(tabla.getSelectedRow(), 2);
                    int cantidad = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
                    this.productoController.modificar(new Product(nombre,descripcion,cantidad), id);

                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
    }

    private void eliminar() {
        if (tieneFilaElegida()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
                    int rowsDeleted;
                    rowsDeleted = this.productoController.eliminar(id);
                    modelo.removeRow(tabla.getSelectedRow());

                    JOptionPane.showMessageDialog(this, "Se han eliminado " + rowsDeleted +" filas.");
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
    } */
}
