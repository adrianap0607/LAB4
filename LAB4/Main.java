
//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023





import java.util.Scanner;

/**
 * Clase principal que contiene el método main para la interacción con el usuario.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Premium usuarioPremium = null;

        int opcion;
        do {
            System.out.println("------- Menú -------");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Reservar vuelo");
            System.out.println("3. Confirmar vuelo");
            System.out.println("4. Cambiar plan a VIP");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    if (usuarioPremium != null) {
                        System.out.println("Ya hay un usuario registrado. Cierre sesión para registrar uno nuevo.");
                        break;
                    }
                    System.out.println("Registro - Ingrese usuario y tipo de plan (Gratis o VIP): ");
                    String usuarioRegistro = scanner.nextLine();
                    String tipoPlan = scanner.nextLine();
                    usuarioPremium = new Premium();
                    usuarioPremium.registrarUsuario(usuarioRegistro, tipoPlan);
                    break;

                case 2:
                    if (usuarioPremium == null) {
                        System.out.println("Inicie sesión para reservar un vuelo.");
                        break;
                    }
                    System.out.println("Reserva - Ingrese fecha, tipo de vuelo, número de boletos y aerolínea: ");
                    String fecha = scanner.nextLine();
                    String tipoVuelo = scanner.nextLine();
                    int numBoletos = scanner.nextInt();
                    scanner.nextLine();
                    String aerolinea = scanner.nextLine();
                    usuarioPremium.reservarVuelo(fecha, tipoVuelo, numBoletos, aerolinea);
                    break;

                case 3:
                    if (usuarioPremium == null) {
                        System.out.println("Inicie sesión para confirmar un vuelo.");
                        break;
                    }
                    System.out.println("Confirmación - Ingrese detalles del vuelo: ");
                    // Lógica de confirmación...
                    break;

                case 4:
                    if (usuarioPremium != null && !usuarioPremium.esVIP()) {
                        usuarioPremium.cambiarPlanAVIP();
                        System.out.println("¡Ahora eres un usuario VIP!");
                    } else {
                        System.out.println("Ya eres un usuario VIP o no has iniciado sesión.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}
