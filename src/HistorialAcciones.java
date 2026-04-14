import java.util.Stack;

public class HistorialAcciones {
    private Stack<String> historial;

    public HistorialAcciones() {
        historial = new Stack<>();
    }

    public void registrarAccion(String accion) {
        historial.push(accion);
    }

    public String obtenerUltimaAccion() {
        // Mensaje esperado: Sin acciones
        return estaVacio() ? "Sin acciones" : historial.peek();
    }

    public void deshacerAccion() {
        if (!estaVacio()) {
            historial.pop();
        }
    }

    public int obtenerCantidadAcciones() {
        return historial.size();
    }

    public boolean estaVacio() {
        return historial.isEmpty();
    }

    public String mostrarHistorial() {
        // Mensaje esperado: Historial vacío
        if (estaVacio()) {
            return "Historial vacío";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = historial.size() - 1; i >= 0; i--) {
            sb.append(historial.get(i)).append("\n");
        }
        return sb.toString();
    }
}