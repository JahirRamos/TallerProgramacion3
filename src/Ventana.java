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
        // Estado inicial en el área de texto
        textArea1.setText(miHistorial.mostrarHistorial());

        // --- BOTÓN REGISTRAR ---
        registrarboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // .trim() elimina espacios al inicio y final
                    String accion = agregueaccionTextfield.getText().trim();

                    // Restricción: No nulas, vacías o solo espacios
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

        // --- BOTÓN DESHACER ---
        deshacerboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (miHistorial.estaVacio()) {
                        // Mensaje esperado: Nada que deshacer
                        throw new Exception("Nada que deshacer");
                    }

                    miHistorial.deshacerAccion();
                    textArea1.setText(miHistorial.mostrarHistorial());

                } catch (Exception ex) {
                    textArea1.setText(miHistorial.mostrarHistorial());
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        // --- BOTÓN CONTAR ---
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
