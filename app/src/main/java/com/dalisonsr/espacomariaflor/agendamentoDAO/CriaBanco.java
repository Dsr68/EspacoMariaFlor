package com.dalisonsr.espacomariaflor.agendamentoDAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper{
    public final String TABELA = "agendamentos";
    public final String ID = "id";
    public final String NOME = "nome";
    public final String SOBRENOME = "sobrenome";
    public final String TELEFONE = "telefone";
    public final String DATA = "data";
    public final String HORA = "hora";
    public final String MAO = "mao";
    public final String PE = "pe";
    public final String MANUTENCA = "manutencao";
    public final String PLASTICA = "plastica";
    public final String FIBRA = "fibra";
    public final String GEL = "gel";

    public final int VERSION = 2;

    public CriaBanco(Context context){
        super(context, "Banco", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE " + TABELA + " (" +
                ID + " integer primary key autoincrement, " +
                NOME + " text ," +
                SOBRENOME + " text, " +
                TELEFONE + " text, " +
                DATA + " text, " +
                HORA + " text, " +
                MAO + " integer, " +
                PE + " integer, " +
                MANUTENCA + " integer, " +
                PLASTICA + " integer, " +
                FIBRA + " integer, " +
                GEL + " integer" +
                ")";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }

}
