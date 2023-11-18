//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023

import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que representa a un usuario Premium con funcionalidades extendidas.
 */
public class Premium implements InterfazPremium {
    private String tipoPlan;
    private String usuario;
    private boolean esVIP;

    /**
     * Registra un nuevo usuario con un tipo de plan.
     *
     * @param usuario   Nombre de usuario.
     * @param tipoPlan  Tipo de plan (Gratis o VIP).
     */
    public void registrarUsuario(String usuario, String tipoPlan) {
        this.usuario = usuario;
        this.tipoPlan = tipoPlan;
        this.esVIP = tipoPlan.equalsIgnoreCase("VIP");
    }

    /**
     * Verifica si el usuario es VIP.
     *
     * @return true si el usuario es VIP, false en caso contrario.
     */
    public boolean esVIP() {
        return esVIP;
    }

    /**
     * Cambia el plan del usuario a VIP.
     */
    public void cambiarPlanAVIP() {
        this.tipoPlan = "VIP";
        this.esVIP = true;
    }

    /**
     * Realiza la reserva de un vuelo para el usuario VIP y guarda la información en un archivo CSV.
     *
     * @param fecha       Fecha del vuelo.
     * @param tipoVuelo   Tipo de vuelo (Ida y vuelta o Solo ida).
     * @param numBoletos  Cantidad de boletos.
     * @param aerolinea   Aerolínea seleccionada.
     */
    public void reservarVuelo(String fecha, String tipoVuelo, int numBoletos, String aerolinea) {
        if (usuario != null && esVIP) {
            try {
                FileWriter csvWriter = new FileWriter("reservas.csv", true);
                csvWriter.append(fecha + "," + tipoVuelo + "," + numBoletos + "," + aerolinea + "," + usuario + "\n");
                csvWriter.flush();
                csvWriter.close();
                System.out.println("Reserva exitosa.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Para realizar reservas, inicie sesión como usuario VIP.");
        }
    }

    /**
     * Procesa la confirmación de un vuelo para el usuario VIP y guarda la información en un archivo CSV.
     *
     * @param numTarjeta   Número de tarjeta de crédito.
     * @param cuotas       Cantidad de cuotas.
     * @param claseVuelo   Clase de vuelo (Coach o Primera Clase).
     * @param itinerario   Itinerario del vuelo.
     */
    public void confirmarVuelo(String numTarjeta, int cuotas, String claseVuelo, String itinerario) {
        if (usuario != null && esVIP) {
            try {
                FileWriter csvWriter = new FileWriter("confirmaciones.csv", true);
                csvWriter.append(numTarjeta + "," + cuotas + "," + claseVuelo + "," + itinerario + "," + usuario + "\n");
                csvWriter.flush();
                csvWriter.close();
                System.out.println("Confirmación exitosa.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Para confirmar vuelos, inicie sesión como usuario VIP.");
        }
    }

    /**
     * Establece el número de asiento para el usuario VIP.
     *
     * @param numeroAsiento Número de asiento seleccionado.
     */
    @Override
    public void setNumAsiento(int numeroAsiento) {
        if (esVIP) {
            // Lógica para seleccionar número de asiento
            System.out.println("Asiento seleccionado: " + numeroAsiento);
        } else {
            System.out.println("Esta opción solo está disponible para usuarios VIP.");
        }
    }

    /**
     * Establece la cantidad de maletas para el usuario VIP.
     *
     * @param cantidadMaletas Cantidad de maletas seleccionada.
     */
    @Override
    public void setCantMaletas(int cantidadMaletas) {
        if (esVIP) {
            // Lógica para seleccionar cantidad de maletas
            System.out.println("Cantidad de maletas seleccionada: " + cantidadMaletas);
        } else {
            System.out.println("Esta opción solo está disponible para usuarios VIP.");
        }
    }
}
