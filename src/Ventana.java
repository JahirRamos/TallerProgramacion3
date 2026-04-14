import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel PanelPrincipal;
    private JLabel HistorialAcciones;
    private JTextField agregueaccionTextfield;
    private JButton registrarboton;
    private JButton deshacerboton;
    private JTextArea textArea1;
    private JButton contarAccionboton;
    private HistorialAcciones miHistorial;

    public Ventana() {
        miHistorial = new HistorialAcciones();

        textArea1.setText(miHistorial.mostrarHistorial());


        registrarboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String accion = agregueaccionTextfield.getText().trim();

                    if (accion.isEmpty()) {
                        throw new Exception("Sin acciones");
                    }

                    miHistorial.registrarAccion(accion);
                    agregueaccionTextfield.setText("");
                    textArea1.setText(miHistorial.mostrarHistorial());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        deshacerboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (miHistorial.estaVacio()) {
                        throw new Exception("Nada que deshacer");
                    }


                    String ultima = miHistorial.obtenerUltimaAccion();

                    miHistorial.deshacerAccion();
                    textArea1.setText(miHistorial.mostrarHistorial());


                    JOptionPane.showMessageDialog(null, "Se deshizo la acción: " + ultima);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        contarAccionboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cantidad = miHistorial.obtenerCantidadAcciones();
                if (cantidad == 0) {
                    JOptionPane.showMessageDialog(null, "Historial vacío");
                } else {
                    JOptionPane.showMessageDialog(null, "Total de acciones: " + cantidad);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Historial acciones");
        frame.setContentPane(new Ventana().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
