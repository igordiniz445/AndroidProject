package com.example.gamepc.agendamento3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;

public class CalendarioPrincipal extends AppCompatActivity {
    CalendarView calendario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_principal);

        CalendarView view = new CalendarView(this);
        setContentView(view);

        view.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView arg0, int year, int month, int date) {
                month = month+1;
                Toast.makeText(getApplicationContext(),date+ "/"+month+"/"+year,Toast.LENGTH_SHORT).show();
                String diaTabela = date+"/"+month+"/"+year;
                Intent chamaTela = new Intent(CalendarioPrincipal.this, tabelaHorario.class);
                chamaTela.putExtra(tabelaHorario.DATA_DE_PESQUISA, diaTabela);
                startActivity(chamaTela);

            }
        });


//        Button botao = (Button) findViewById(R.id.calendarioVoltar);
//        botao.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

    }
}
