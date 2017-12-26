package com.example.gamepc.agendamento3;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by GamePC on 17/03/2017.
 */

public class ReservaAdapter extends BaseAdapter {

    private Context context;
    private List<Reserva> reservas;
    private static final int HORARIOS[] = {7,8,9,10,11,13,14,15,16,17,18,19,20,21,22};

    public ReservaAdapter(Context context, List<Reserva> reservas) {
        this.context = context;
        this.reservas = reservas;
    }


    @Override
    public int getCount() {
        return HORARIOS.length;
    }

    @Override
    public Object getItem(int position) {
        return HORARIOS[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int horario = HORARIOS[position];
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.linha_tabela_horario, null);
        TextView tvHorario = (TextView) view.findViewById(R.id.tablea_horario);
        TextView tvLab1 = (TextView) view.findViewById(R.id.tabela_texto1);
        TextView tvLab2 = (TextView) view.findViewById(R.id.tabela_texto2);
        TextView tvLab3 = (TextView) view.findViewById(R.id.tabela_texto3);
        tvHorario.setText(horario+":00");
        tvLab1.setText("Disponível");
        tvLab1.setTextColor(Color.GREEN);
        tvLab2.setText("Disponível");
        tvLab2.setTextColor(Color.GREEN);
        tvLab3.setText("Disponível");
        tvLab3.setTextColor(Color.GREEN);
        for(Reserva reserva : reservas){
            if(reserva.getInicio() <= horario && reserva.getFim() >= horario){
                if(reserva.getLab().equals("Lab 1")){
                    tvLab1.setText("Reservado por : "+reserva.getNome());
                    tvLab1.setTextColor(Color.RED);
                }else if(reserva.getLab().equals("Lab 2")){
                    tvLab2.setText("Reservado por : "+reserva.getNome());
                    tvLab2.setTextColor(Color.RED);
                }else if(reserva.getLab().equals("Lab 3")){
                    tvLab3.setText("Reservado por : "+reserva.getNome());
                    tvLab3.setTextColor(Color.RED);
                }
            }
        }
        return view;
    }
}
