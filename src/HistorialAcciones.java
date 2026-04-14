import java.util.Stack;

public class HistorialAcciones {
    private Stack<String> historial;

    public HistorialAcciones(){
        historial=new Stack<>();
    }

    public void registrarAccion(String accion) throws Exception {
        if (accion==null || accion.trim().isEmpty()){
            throw new Exception("Accion no valida");

        }
        historial.push(accion);

    }
    public String deshacerAccion() throws Exception {
        if(historial.isEmpty()){
            throw new Exception("Nada que deshacer");
        }
        return historial.pop();
    }

    public String obtenerUltimaAccion() throws Exception {
        if (historial.isEmpty()){
            throw new Exception("Sin accion");

        }
        return historial.peek();
    }

    public String mostrarHistorial(){
        String resultado = "";
        for (int i = historial.size()-1; i >=0; i--){
            resultado += historial.get(i).toString() + "\n";
        }
     return resultado.length() !=0 ? resultado : "Historial vacio";
    }

    public int obtenerCantidadAcciones(){
        return historial.size();
    }
    public boolean estaVacio(){
        return historial.isEmpty();
    }
}