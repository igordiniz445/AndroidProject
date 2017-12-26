package com.example.gamepc.agendamento3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dao.ProfessorDAO;

public class Cadrasto extends AppCompatActivity {
    private Cadrastamento helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadrasto);
        helper = new Cadrastamento(this);
        Button botaoCadrastar = (Button) findViewById(R.id.btCadrastar);
        botaoCadrastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Responsavel professor = helper.pegaProfessor();
                ProfessorDAO dao = new ProfessorDAO(Cadrasto.this);
                if(dao.confereUsuario(professor.getUser())){
                    Toast.makeText(Cadrasto.this,"Usuário já existente",Toast.LENGTH_SHORT).show();
                }else if(dao.confereMatricula(professor.getMatricula())== true){
                    Toast.makeText(Cadrasto.this,"Matricula já cadastrada",Toast.LENGTH_SHORT).show();
                }else if(dao.confereEmail(professor.getEmail())== true){
                    Toast.makeText(Cadrasto.this,"Email já cadastrado",Toast.LENGTH_SHORT).show();
                }else if( professor.getSenha().length() <6) {
                    Toast.makeText(Cadrasto.this, "Senha muito curta",Toast.LENGTH_SHORT).show();
                }else if((professor.getConfirmaSenha().equals(professor.getSenha())) == false){
                    Toast.makeText(Cadrasto.this,"Senhas não conferem",Toast.LENGTH_SHORT).show();
                }else{
                    dao.insere(professor);
                    dao.close();
                    Toast.makeText(Cadrasto.this,"Professor "+professor.getNome()+", salvo com sucesso !",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button voltar = (Button) findViewById(R.id.btVoltar);
        //Operação de Voltar para pagina inicial
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chamaMainScreen = new Intent(Cadrasto.this, MainScreen.class);
                startActivity(chamaMainScreen);
            }
        });
    }
}
