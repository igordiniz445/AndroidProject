package com.example.gamepc.agendamento3;

import android.widget.EditText;

import static com.example.gamepc.agendamento3.R.string.nome;

public class Cadrastamento {
    private final EditText campoNome;
    private final EditText campoMatricula;
    private final EditText campoEmail;
    private final EditText campoUsuario;
    private final EditText campoSenha;
    private final EditText campoSenha2;

    public Cadrastamento(Cadrasto activity) {
        campoNome = (EditText) activity.findViewById(R.id.cadrasto_nome);
        campoMatricula = (EditText) activity.findViewById(R.id.cadrasto_matricula);
        campoEmail = (EditText) activity.findViewById(R.id.cadrasto_email);
        campoUsuario = (EditText) activity.findViewById(R.id.cadrasto_user);
        campoSenha = (EditText) activity.findViewById(R.id.cadrasto_senha);
        campoSenha2 = (EditText) activity.findViewById(R.id.cadrasto_confirmasenha);
    }

    public Responsavel pegaProfessor(){
        Responsavel professor = new Responsavel();
        professor.setNome(campoNome.getText().toString());
        professor.setEmail(campoEmail.getText().toString());
        professor.setMatricula(campoMatricula.getText().toString());
        professor.setUser(campoUsuario.getText().toString());
        professor.setSenha(campoSenha.getText().toString());
        professor.setConfirmaSenha(campoSenha2.getText().toString());
        return professor;
    }
}
