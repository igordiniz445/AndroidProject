package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gamepc.agendamento3.Responsavel;

public class ProfessorDAO extends SQLiteOpenHelper{

    public ProfessorDAO(Context context) {
        super(context, "Cadastro de professor",null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Professores (id INTEGER PRIMARY KEY, nome TEXT, matricula TEXT UNIQUE, email TEXT UNIQUE, usuario TEXT UNIQUE, senha TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Professores");
        onCreate(db);
    }

    public String retornaNomeProfessor(String matricula){
        SQLiteDatabase db =  getReadableDatabase();
        String sql = "SELECT nome FROM Professores WHERE usuario ='"+matricula+"'";
        Cursor cursor = db.rawQuery(sql, null);
        String nome = "";
        //inicializando a string
        if(cursor.moveToFirst()){
            nome = cursor.getString(0);
            //retorna a string do ID da matricula do profssor
        }
        return nome;
    }

    public void insere(Responsavel professor) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();

        dados.put("nome", professor.getNome());
        dados.put("matricula", professor.getMatricula());
        dados.put("usuario", professor.getUser());
        dados.put("email", professor.getEmail());
        dados.put("senha", professor.getSenha());
        db.insert("Professores",null,dados);
    }

    public boolean isExisteProfessor(String usuario, String senha) {
        SQLiteDatabase db =  getReadableDatabase();
        String sql = "SELECT senha FROM Professores WHERE usuario ='"+usuario+"' and senha = '"+senha+"'";
        Cursor c = db.rawQuery(sql, null);
        return c.getCount() > 0;
    }

    public String retornaCpfProfessor(String usuario){
        SQLiteDatabase db =  getReadableDatabase();
        String sql = "SELECT matricula FROM Professores WHERE usuario ='"+usuario+"'";
        Cursor cursor = db.rawQuery(sql, null);
        String matricula = "";
        //inicializando a string
        if(cursor.moveToFirst()){
            matricula = cursor.getString(0);
            //retorna a string do ID da matricula do profssor
        }
        return matricula;
    }
    public boolean confereUsuario(String user) {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT usuario FROM Professores WHERE usuario ='"+user+"';";
        Cursor c = db.rawQuery(sql, null);
        return c.getCount() > 0;
    }

    public boolean confereMatricula(String matricula) {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT matricula FROM Professores WHERE matricula ='"+matricula+"';";
        Cursor c = db.rawQuery(sql, null);
        return c.getCount() > 0;
    }

    public boolean confereEmail(String email) {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT email FROM Professores WHERE email ='"+email+"';";
        Cursor c = db.rawQuery(sql, null);
        return c.getCount() > 0;
    }
}
