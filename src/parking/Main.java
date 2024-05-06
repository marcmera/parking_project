package parking;
import exceptions.ParkingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking("Parking Centro", 10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1) Entrada de coche");
            System.out.println("2) Salida de coche");
            System.out.println("3) Mostrar parking");
            System.out.println("4) Salir del programa");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Introduce la matrícula:");
                        String matriculaEntrada = scanner.nextLine();
                        System.out.println("Introduce la plaza:");
                        int plazaEntrada = Integer.parseInt(scanner.nextLine());
                        parking.entrada(matriculaEntrada, plazaEntrada);
                        System.out.println("Plazas totales: " + parking.getPlazasTotales());
                        System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
                        System.out.println("Plazas libres: " + parking.getPlazasLibres());
                        break;
                    case 2:
                        System.out.println("Introduce la matrícula:");
                        String matriculaSalida = scanner.nextLine();
                        int plazaLiberada = parking.salida(matriculaSalida);
                        System.out.println("Plaza liberada: " + plazaLiberada);
                        System.out.println("Plazas totales: " + parking.getPlazasTotales());
                        System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
                        System.out.println("Plazas libres: " + parking.getPlazasLibres());
                        break;
                    case 3:
                        System.out.println(parking.toString());
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción no válida. Introduce un número del 1 al 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un número válido.");
            } catch (ParkingException e) {
                System.out.println("Error: " + e.getMensaje() + ". Matrícula: " + e.getMatricula());
            }
        }
    }
}
