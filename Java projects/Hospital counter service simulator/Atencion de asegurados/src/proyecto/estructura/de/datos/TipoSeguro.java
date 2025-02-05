/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.estructura.de.datos;

/**
 *
 * @author Daniel
 */
public class TipoSeguro {
    private int idTipoSeguro;
    private String descripcionSeguro;
    private char estado;

    // Constructor
    public TipoSeguro(int idTipoSeguro, String descripcionSeguro, char estado) {
        this.idTipoSeguro = idTipoSeguro;
        this.descripcionSeguro = descripcionSeguro;
        this.estado = estado;
    }

    public TipoSeguro() {
    }

    // Getters and Setters
    public int getIdTipoSeguro() {
        return idTipoSeguro;
    }

    public void setIdTipoSeguro(int idTipoSeguro) {
        this.idTipoSeguro = idTipoSeguro;
    }

    public String getDescripcionSeguro() {
        return descripcionSeguro;
    }

    public void setDescripcionSeguro(String descripcionSeguro) {
        this.descripcionSeguro = descripcionSeguro;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}

