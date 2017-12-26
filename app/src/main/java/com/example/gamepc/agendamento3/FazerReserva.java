package com.example.gamepc.agendamento3;

import android.app.DatePickerDialog;

import java.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import dao.ReservaDAO;


@RequiresApi(api = Build.VERSION_CODES.N)
public class FazerReserva extends AppCompatActivity {

    Calendar calendar = Calendar.getInstance();
    TextView data;
    //private Dados_Reserva helper;
    public final static String MATRICULA_PROF = "";
    public final static String Nome_PROF = "";
    public final static String QR_LAB = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_reserva);
        Button cancelar = (Button) findViewById(R.id.reserva_Cancelar);
        final String matricula = (String) getIntent().getExtras().get(MATRICULA_PROF);
        final String nome = (String) getIntent().getExtras().get(Nome_PROF);
        System.out.println(nome);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(FazerReserva.this, "Operação cancelada com sucesso !", Toast.LENGTH_SHORT).show();
            }
        });
        Spinner spinnerInicio = (Spinner) findViewById(R.id.reserva_ComboBoxInicio);
        ArrayAdapter<CharSequence> adapterInicio = ArrayAdapter.createFromResource(this, R.array.horarioInicio, android.R.layout.simple_spinner_item);
        adapterInicio.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerInicio.setAdapter(adapterInicio);
        //ComboBox inicio do horario

        Spinner spinnerFim = (Spinner) findViewById(R.id.reserva_ComboBoxFim);
        ArrayAdapter<CharSequence> adapterFim = ArrayAdapter.createFromResource(this, R.array.horarioFim, android.R.layout.simple_spinner_item);
        adapterFim.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerFim.setAdapter(adapterFim);
        //ComboBox fim do horario

        //Spinner spinnerRepeticao = (Spinner) findViewById(R.id.reserva_ComboBoxRepeticao);
        //ArrayAdapter<CharSequence> adapterRepeticao = ArrayAdapter.createFromResource(this, R.array.repeticao, android.R.layout.simple_spinner_item);
        //adapterRepeticao.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //spinnerRepeticao.setAdapter(adapterRepeticao);
        //ComboBox repetição

        Spinner spinnerLaboratorio = (Spinner) findViewById(R.id.reserva_ComboBoxLab);
        ArrayAdapter<CharSequence> adapterLab = ArrayAdapter.createFromResource(this, R.array.laboratorio, android.R.layout.simple_spinner_item);
        adapterLab.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerLaboratorio.setAdapter(adapterLab);

        String qr = (String) getIntent().getExtras().get(QR_LAB);
        if(qr.equals("")){

        }else{
            for (int i=0;i<spinnerLaboratorio.getCount();i++){
                if (spinnerLaboratorio.getItemAtPosition(i).toString().equalsIgnoreCase(qr)){
                    spinnerLaboratorio.setSelection(((ArrayAdapter<String>)spinnerLaboratorio.getAdapter()).getPosition(qr));
                    break;
                }
            }
        }
        //comboBox Laboratório

        TextView pegaData = (TextView) findViewById(R.id.reserva_Data);
        data = (TextView) findViewById(R.id.reserva_Data);
        pegaData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FazerReserva.this, "Deu certo", Toast.LENGTH_LONG).show();
                new DatePickerDialog(FazerReserva.this,listener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        //Metodo para pegar uma data no calendario

        Button reservar = (Button) findViewById(R.id.reserva_Confirmar);
        reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dados_Reserva helper = new Dados_Reserva(FazerReserva.this, matricula, nome);
                Info_Reserva informacao = helper.PegaDados();
                ReservaDAO dao = new ReservaDAO(FazerReserva.this);
                if(dao.verificaLabHorario(informacao.getData(),informacao.getComboLab(),informacao.getComboInicio(),informacao.getComboFim())){
                    Toast.makeText(FazerReserva.this, "Horários não disponiveis", Toast.LENGTH_SHORT).show();
                }else if(informacao.getComboInicio()>= informacao.getComboFim()){
                    Toast.makeText(FazerReserva.this,"Horário de início deve ser menor que o horário de fim",Toast.LENGTH_LONG).show();
                }else{
                    dao.insere(informacao);
                    dao.close();
                    Toast.makeText(FazerReserva.this, "Agendado "+informacao.getComboLab()+", dia : "+informacao.getData()+", as "+informacao.getComboInicio()+" horas.",Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
        //Metodo para finalisar o agendamento
    }
    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            data.setText(+dayOfMonth+"/"+(month+1)+"/"+year);
        }
    };
}

