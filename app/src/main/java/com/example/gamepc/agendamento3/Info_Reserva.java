package com.example.gamepc.agendamento3;

/**
 * Created by GamePC on 14/02/2017.
 */

public class Info_Reserva {
    private Integer ID;

    private String matriculaProfessor;
    private String nomeProfessor;
    private String data;
    private String motivo;
    private String descricao;
    private String comboLab;
    private int comboInicio;
    private int comboFim;
    private String comboRepeticao;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getComboRepeticao() {
        return comboRepeticao;
    }

    public void setComboRepeticao(String comboRepeticao) {
        this.comboRepeticao = comboRepeticao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getComboLab() {
        return comboLab;
    }

    public void setComboLab(String comboLab) {
        this.comboLab = comboLab;
    }

    public int getComboInicio() {
        return comboInicio;
    }

    public void setComboInicio(int comboInicio) {
        this.comboInicio = comboInicio;
    }

    public int getComboFim() {
        return comboFim;
    }

    public void setComboFim(int comboFim) {
        this.comboFim = comboFim;
    }

    public String getMatriculaProfessor() {
        return matriculaProfessor;
    }

    public void setMatriculaProfessor(String matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
}
