package com.dalisonsr.espacomariaflor.agendamentoDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dalisonsr.espacomariaflor.agendamentoBEAN.AgendamentoBEAN;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoContoleDAO {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public AgendamentoContoleDAO(Context context){
        banco = new CriaBanco(context);
    }

    public String inserirDados(AgendamentoBEAN agendamento){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(banco.NOME, agendamento.getNome());
        valores.put(banco.SOBRENOME, agendamento.getSobrenome());
        valores.put(banco.TELEFONE, agendamento.getTelefone());
        valores.put(banco.DATA, agendamento.getData());
        valores.put(banco.HORA, agendamento.getHora());
        valores.put(banco.MAO, agendamento.getMao());
        valores.put(banco.PE, agendamento.getPe());
        valores.put(banco.MANUTENCA, agendamento.getManutencao());
        valores.put(banco.PLASTICA, agendamento.getPlastica());
        valores.put(banco.FIBRA, agendamento.getFibra());
        valores.put(banco.GEL, agendamento.getGelmoldado());

        resultado = db.insert(banco.TABELA, null, valores);
        db.close();

        if(resultado == -1){
            return "Erro ao inserir no bando de dados";
        }
        else{
            return "Dados salvos com sucesso";
        }
    }

    public List<AgendamentoBEAN> carregarDados(){
        List<AgendamentoBEAN> lista = new ArrayList<AgendamentoBEAN>();
        Cursor cursor;

        String campos[] = {banco.ID, banco.NOME, banco.SOBRENOME, banco.TELEFONE, banco.DATA
        , banco.HORA, banco.MAO, banco.PE, banco.MANUTENCA, banco.PLASTICA, banco.FIBRA,
        banco.GEL};

        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null
        , null, null, null);

            if(cursor != null){
                while (cursor.moveToNext()){
                    AgendamentoBEAN a = new AgendamentoBEAN();
                    a.setId(cursor.getInt(0));
                    a.setNome(cursor.getString(1));
                    a.setSobrenome(cursor.getString(2));
                    a.setTelefone(cursor.getString(3));
                    a.setData(cursor.getString(4));
                    a.setHora(cursor.getString(5));

                    lista.add(a);
                }

            }

        db.close();
        return lista;
    }

    public AgendamentoBEAN carregarRegistro(int id){
        AgendamentoBEAN agendamentoBEAN = new AgendamentoBEAN();
        Cursor cursor;
        String campos[] = {"id", "nome", "sobrenome", "telefone", "data", "hora",
        "mao", "pe", "manutencao", "plastica", "fibra", "gel"};
        String where = banco.ID + " = " + id;

        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, where, null, null,
                null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
            agendamentoBEAN.setId(cursor.getInt(0));
            agendamentoBEAN.setNome(cursor.getString(1));
            agendamentoBEAN.setSobrenome(cursor.getString(2));
            agendamentoBEAN.setTelefone(cursor.getString(3));
            agendamentoBEAN.setData(cursor.getString(4));
            agendamentoBEAN.setHora(cursor.getString(5));
            agendamentoBEAN.setMao(cursor.getInt(6));
            agendamentoBEAN.setPe(cursor.getInt(7));
            agendamentoBEAN.setManutencao(cursor.getInt(8));
            agendamentoBEAN.setPlastica(cursor.getInt(9));
            agendamentoBEAN.setFibra(cursor.getInt(10));
            agendamentoBEAN.setGelmoldado(cursor.getInt(11));
        }

        return agendamentoBEAN;
    }

    public void atualizar(int id, String nome, String sobrenome, String telefone,
                          String data, String hora, int mao, int pe, int manutencao,
                          int plastica, int fibra, int gel){

        ContentValues valores;

        db = banco.getWritableDatabase();
        String where = banco.ID + " = " + id;

        valores = new ContentValues();
        valores.put(banco.NOME, nome);
        valores.put(banco.SOBRENOME, sobrenome);
        valores.put(banco.TELEFONE, telefone);
        valores.put(banco.DATA, data);
        valores.put(banco.HORA, hora);
        valores.put(banco.MAO, mao);
        valores.put(banco.PE, pe);
        valores.put(banco.MANUTENCA, manutencao);
        valores.put(banco.PLASTICA, plastica);
        valores.put(banco.FIBRA, fibra);
        valores.put(banco.GEL, gel);


        db.update(banco.TABELA, valores, where, null);
        db.close();
    }

    public void apagarRegistro(int id){
        String where = banco.ID + " = " + id;

        db = banco.getReadableDatabase();
        db.delete(banco.TABELA, where, null);
        db.close();
    }
}
