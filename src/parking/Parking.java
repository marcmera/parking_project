package parking;
import exceptions.ParkingException;
import java.util.ArrayList;

public class Parking {
    private ArrayList<String> matriculas;
    private String nombre;

    // Constructor
    public Parking(String nombre, int numPlazas) {
        this.nombre = nombre;
        // Se inicializa el ArrayList con el número de plazas indicado
        this.matriculas = new ArrayList<>(numPlazas);
        // Se rellena el ArrayList con valores nulos
        for (int i = 0; i < numPlazas; i++) {
            this.matriculas.add(null);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void entrada(String matricula, int plaza) throws ParkingException {
        if (matricula == null || matricula.length() < 4) {
            throw new ParkingException("Matrícula incorrecta", matricula);
        }
        if (plaza < 0 || plaza >= matriculas.size()) {
            throw new ParkingException("Plaza fuera de rango", matricula);
        }
        if (matriculas.get(plaza) != null) {
            throw new ParkingException("Plaza ocupada", matricula);
        }
        if (matriculas.contains(matricula)) {
            throw new ParkingException("Matrícula repetida", matricula);
        }
        matriculas.set(plaza, matricula);
    }

    public int salida(String matricula) throws ParkingException {
        if (!matriculas.contains(matricula)) {
            throw new ParkingException("Matrícula no existente", matricula);
        }
        // Se obtiene la posición de la matrícula en el ArrayList
        int plaza = matriculas.indexOf(matricula);
        // Se libera la plaza seteandola en null
        matriculas.set(plaza, null);
        return plaza;
    }

    public int getPlazasTotales() {
        return matriculas.size();
    }

    public int getPlazasOcupadas() {
        int ocupadas = 0;

        // Se recorre el ArrayList y se incrementa el contador si la plaza está ocupada
        for (String matricula : matriculas) {
            if (matricula != null) {
                ocupadas++;
            }
        }
        return ocupadas;
    }

    public int getPlazasLibres() {
        return getPlazasTotales() - getPlazasOcupadas();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(nombre).append("\n");
        for (int i = 0; i < matriculas.size(); i++) {
            builder.append("Plaza ").append(i).append(": ");
            if (matriculas.get(i) != null) {
                builder.append(matriculas.get(i));
            } else {
                builder.append("(vacía)");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
