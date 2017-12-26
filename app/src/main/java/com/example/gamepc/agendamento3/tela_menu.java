package com.example.gamepc.agendamento3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tela_menu extends AppCompatActivity {

    public final static String MATRICULA_PROFESSOR = "";
    public final static String NOME_PROFESSOR = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu);

        Button voltar = (Button) findViewById(R.id.menu_voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent voltarLoguin = new Intent(tela_menu.this, MainScreen.class);
                //startActivity(voltarLoguin);
                finish();
            }
        });

        Button qr = (Button) findViewById(R.id.menu_qr);
        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chamaQR = new Intent(tela_menu.this, QR_Code.class);
                startActivity(chamaQR);
            }
        });

        Button fazerReserva = (Button) findViewById(R.id.menu_fazerReserva);
        fazerReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matricula = (String) getIntent().getExtras().get(MATRICULA_PROFESSOR);
                String nome = (String) getIntent().getExtras().get(NOME_PROFESSOR);
                Intent chamaTelaDeReserva = new Intent(tela_menu.this, FazerReserva.class);
                chamaTelaDeReserva.putExtra(FazerReserva.MATRICULA_PROF, matricula);
                chamaTelaDeReserva.putExtra(FazerReserva.Nome_PROF, nome);
                startActivity(chamaTelaDeReserva);
            }
        });

        Button consultaCalendario = (Button) findViewById(R.id.menu_consultar);
        consultaCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chamaTelaDoCalendario = new Intent(tela_menu.this, CalendarioPrincipal.class);
                startActivity(chamaTelaDoCalendario);
            }
        });
    }
}
