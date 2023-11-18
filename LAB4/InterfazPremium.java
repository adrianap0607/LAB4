

//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023
/**
 * Interfaz para definir métodos que deben ser implementados por la clase Premium.
 */
public interface InterfazPremium {
    /**
     * Establece el número de asiento para el usuario VIP.
     *
     * @param numeroAsiento Número de asiento seleccionado.
     */
    void setNumAsiento(int numeroAsiento);

    /**
     * Establece la cantidad de maletas para el usuario VIP.
     *
     * @param cantidadMaletas Cantidad de maletas seleccionada.
     */
    void setCantMaletas(int cantidadMaletas);
}

