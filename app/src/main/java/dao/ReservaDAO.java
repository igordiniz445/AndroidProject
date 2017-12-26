package dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;

import com.example.gamepc.agendamento3.Info_Reserva;
import com.example.gamepc.agendamento3.Reserva;

import java.util.LinkedList;
import java.util.List;

public class ReservaDAO extends SQLiteOpenHelper {

    public static final String DIA = "dia";
    public static final String LABORATORIO = "laboratorio";
    public static final String INICIO  = "inicio";
    public static final String FIM = "fim";
    public static final String NOME = "nome";


    public ReservaDAO(Context context) {super(context,"Dados_Reserva", null, 7);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Reserva(id INTEGER PRIMARY KEY autoincrement, dia TEXT NOT NULL, laboratorio TEXT NOT NULL, inicio INT NOT NULL, fim INT NOT NULL, repeticao TEXT NOT NULL, motivo TEXT NOT NULL, descricao TEXT, matricula TEXT NOT NULL, nome TEXT NOT NULL);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Reserva;");
        onCreate(db);
    }
    public void insere(Info_Reserva informacoes) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();

        dados.put("dia",informacoes.getData());
        dados.put("laboratorio",informacoes.getComboLab());
        dados.put("inicio",informacoes.getComboInicio());
        dados.put("fim",informacoes.getComboFim());
        dados.put("repeticao",informacoes.getComboRepeticao());
        dados.put("motivo",informacoes.getMotivo());
        dados.put("descricao",informacoes.getDescricao());
        dados.put("id",informacoes.getID());
        dados.put("matricula",informacoes.getMatriculaProfessor());
        dados.put("nome",informacoes.getNomeProfessor());
        db.insert("Reserva",null,dados);
        System.out.println(informacoes.getData());
    }

    public List<Reserva> getListaReservaPorDia(String dia){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM Reserva WHERE dia = '"+dia+"'";
        Cursor c = db.rawQuery(sql, null);
        List<Reserva> reservas = new LinkedList<>();
        while(c.moveToNext()){
            String diaRerservado = c.getString(c.getColumnIndex(DIA));
            int inicio = c.getInt(c.getColumnIndex(INICIO));
            int fim = c.getInt(c.getColumnIndex(FIM));
            String lab = c.getString(c.getColumnIndex(LABORATORIO));
            String nome = c.getString(c.getColumnIndex(NOME));
            reservas.add(new Reserva(diaRerservado, inicio, fim, lab, nome));
        }
        return reservas;
    }

    public boolean verificaLabHorario(String dia, String lab, int inicio, int fim){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM Reserva WHERE laboratorio = '"+lab+"' and dia = '"+dia+"' and ((inicio <= '"+inicio+"' and fim >= '"+fim+"')"+
                "or(inicio <= '"+inicio+"' and fim <= '"+fim+"' and fim > '"+inicio+"')"+
                "or(inicio >= '"+inicio+"' and fim >= '"+fim+"' and inicio < '"+fim+"')" +
                "or(inicio >= '"+inicio+"' and fim <= '"+fim+"'));";
        Cursor c = db.rawQuery(sql, null);
        return c.getCount() > 0;
    }
}