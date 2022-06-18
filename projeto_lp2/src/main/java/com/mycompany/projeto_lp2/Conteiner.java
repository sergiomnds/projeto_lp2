/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_lp2;

/**
 *
 * @author gulos
 */
public class Conteiner {

    private String nomeProprietario;
    private String tipoCarga;
    private float pesoCarga;

    public Conteiner(){
    }
    
    public Conteiner(String nomeProprietario, String tipoCarga, float pesoCarga) {
        this.nomeProprietario = nomeProprietario;
        this.tipoCarga = tipoCarga;
        this.pesoCarga = pesoCarga;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    /**
     * @param nomeProprietario the nomeProprietario to set
     */
    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    /**
     * @return the tipoCarga
     */
    public String getTipoCarga() {
        return tipoCarga;
    }

    /**
     * @param tipoCarga the tipoCarga to set
     */
    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    /**
     * @return the pesoCarga
     */
    public float getPesoCarga() {
        return pesoCarga;
    }

    /**
     * @param pesoCarga the pesoCarga to set
     */
    public void setPesoCarga(float pesoCarga) {
        this.pesoCarga = pesoCarga;
    }

    @Override
    public String toString() {
        return "Nome Proprietario [ " + nomeProprietario + " ]" + " Tipo de Carga [ " + tipoCarga + " ]" + " Peso da Carga [ " + pesoCarga + " ]";
    }

}
