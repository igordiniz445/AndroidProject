package com.example.gamepc.agendamento3;

import dao.ProfessorDAO;

/**
 * Created by GamePC on 17/03/2017.
 */

public class Reserva {

    private String data;
    private int inicio;
    private int fim;
    private String lab;
    private String nome;

    public Reserva(String data, int inicio, int fim, String lab, String nome ){
        this.data = data;
        this.inicio = inicio;
        this.fim = fim;
        this.lab = lab;
        this.nome = nome;
    }

    @Override
    public String toString(){
        return this.getData() +" "+ this.getInicio() +" "+ this.getFim() +" "+ this.getLab() +" "+ this.getNome();
    }

    public String getData() {
        return data;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }

    public String getLab() {
        return lab;
    }

    public String getNome() {
        return nome;
    }
}
