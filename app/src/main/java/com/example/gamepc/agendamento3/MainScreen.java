package com.example.gamepc.agendamento3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dao.ProfessorDAO;

public class MainScreen extends AppCompatActivity {


    public String matriculaProfessor;
    public String nomeProfessor;
    //RESOLVER QUESTAO DA IDENTIFICAÇÃO DO USUARIO LOGADO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button botaoLogar = (Button) findViewById(R.id.bt1);
        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfessorDAO dao = new ProfessorDAO(MainScreen.this);
                String usuario = ((EditText) findViewById(R.id.loguinNome)).getText().toString();
                String senha = ((EditText) findViewById(R.id.loguinSenha)).getText().toString();

                if(dao.isExisteProfessor(usuario, senha)){
                    matriculaProfessor = dao.retornaCpfProfessor(usuario);
                    nomeProfessor = dao.retornaNomeProfessor(usuario);
                    System.out.println("Nome doProfessor: "+nomeProfessor);
                    Toast.makeText(MainScreen.this,"Logado com Sucesso, Bem-Vindo",Toast.LENGTH_SHORT).show();
                    Intent chamaMenu = new Intent(MainScreen.this, tela_menu.class);
                    chamaMenu.putExtra(tela_menu.MATRICULA_PROFESSOR, matriculaProfessor);
                    chamaMenu.putExtra(tela_menu.NOME_PROFESSOR, nomeProfessor);
                    startActivity(chamaMenu);
                }else{
                    Toast.makeText(MainScreen.this,"Não foi possivel logar",Toast.LENGTH_SHORT).show();
                }
                dao.close();
            }
        });

        Button botaoCadrastar = (Button) findViewById(R.id.bt2);
        botaoCadrastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chamaCadrasto = new Intent(MainScreen.this,Cadrasto.class);
                startActivity(chamaCadrasto);
            }
        });
    }

}
