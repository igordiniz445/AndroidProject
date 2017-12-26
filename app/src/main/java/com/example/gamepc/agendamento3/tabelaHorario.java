package com.example.gamepc.agendamento3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import dao.ReservaDAO;

public class tabelaHorario extends AppCompatActivity {

    public final static String DATA_DE_PESQUISA = "DATA_DE_PESQUISA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela_horario);
        String dataDePesquisa = (String) getIntent().getExtras().get(DATA_DE_PESQUISA);
        TextView texto = (TextView) findViewById(R.id.tabela_dia);
        texto.setText(dataDePesquisa);
        List<Reserva> reservas = new ReservaDAO(this).getListaReservaPorDia(dataDePesquisa);
        ListView listView = (ListView) findViewById(R.id.lista_reservas);
        listView.setAdapter(new ReservaAdapter(this, reservas));
    }
}
