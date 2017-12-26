package com.example.gamepc.agendamento3;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Dados_Reserva {
    private final String data;
    private final EditText motivo;
    private final EditText descricao;
    private final Spinner comboInicio;
    private int inicio;
    private final Spinner comboFim;
    private int fim;
    private final Spinner comboLab;
    private String lab;
    private String repeticao;
    private String matriculaX;
    private String nomeProfesor;

    public Dados_Reserva(FazerReserva activity, String matricula, String nome){
        data =  ((TextView) (activity.findViewById(R.id.reserva_Data))).getText().toString();
        motivo = (EditText) activity.findViewById(R.id.reserva_Motivo);
        descricao = (EditText) activity.findViewById(R.id.reserva_Descricao);
        comboInicio = (Spinner) activity.findViewById(R.id.reserva_ComboBoxInicio);
        inicio =Integer.parseInt(comboInicio.getSelectedItem().toString()) ;
        comboFim = (Spinner) activity.findViewById(R.id.reserva_ComboBoxFim);
        fim = Integer.parseInt(comboFim.getSelectedItem().toString());
        comboLab = (Spinner) activity.findViewById(R.id.reserva_ComboBoxLab);
        lab = comboLab.getSelectedItem().toString();
        repeticao = "Nenhum";
        matriculaX = matricula;
        nomeProfesor = nome;

    }

    public Info_Reserva PegaDados(){
        Info_Reserva reservar = new Info_Reserva();
        reservar.setData(data.toString());
        reservar.setMotivo(motivo.getText().toString());
        reservar.setDescricao(descricao.getText().toString());
        reservar.setComboLab(lab);
        reservar.setComboInicio(inicio);
        reservar.setComboFim(fim);
        reservar.setComboRepeticao(repeticao);
        reservar.setMatriculaProfessor(matriculaX);
        reservar.setNomeProfessor(nomeProfesor);
        return reservar;
    }
}
