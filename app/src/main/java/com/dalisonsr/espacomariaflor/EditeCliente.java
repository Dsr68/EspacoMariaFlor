package com.dalisonsr.espacomariaflor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.dalisonsr.espacomariaflor.agendamentoBEAN.AgendamentoBEAN;
import com.dalisonsr.espacomariaflor.agendamentoDAO.AgendamentoContoleDAO;

public class EditeCliente extends AppCompatActivity {
    EditText nome, telefone, data, hora;
    Button atualizar;
    CheckBox mao, pe, manutencao, plastica, fibra, gel;
    int id, valorMao, valorPe, valorManutencao, valorPlastica, valorFibra, valorGel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_cliente);

        nome = findViewById(R.id.txtEditeNome);
        telefone = findViewById(R.id.txtEditeTelefone);
        data = findViewById(R.id.txtEditeData);
        hora = findViewById(R.id.txtEditeHora);

        atualizar = findViewById(R.id.btnAtualizar);
        atualizar.setBackgroundResource(R.color.rosaescuro);

        mao = findViewById(R.id.checkEditeMao);
        pe = findViewById(R.id.checkEditPe);
        manutencao = findViewById(R.id.checkEditeManutencao);
        plastica = findViewById(R.id.checkEditePlastica);
        fibra = findViewById(R.id.checkEditeFibra);
        gel = findViewById(R.id.checkEditGel);

        Intent intent = getIntent();
        if(intent != null){
            Bundle parametros = intent.getExtras();
            if(parametros != null){
                AgendamentoContoleDAO dao = new AgendamentoContoleDAO(getApplicationContext());
                AgendamentoBEAN bean;

                id = parametros.getInt("id");
                bean = dao.carregarRegistro(id);

                nome.setText(bean.getNome() + " " + bean.getSobrenome());
                telefone.setText(bean.getTelefone());
                data.setText(bean.getData());
                hora.setText(bean.getHora());

                if(bean.getMao() == 1){
                    mao.setChecked(true);
                }
                else {
                    mao.setChecked(false);
                }
                if(bean.getPe() == 1){
                    pe.setChecked(true);
                }
                else {
                    pe.setChecked(false);
                }
                if(bean.getManutencao() == 1){
                    manutencao.setChecked(true);
                }
                else {
                    manutencao.setChecked(false);
                }
                if(bean.getPlastica() == 1){
                    plastica.setChecked(true);
                }
                else {
                    plastica.setChecked(false);
                }
                if(bean.getFibra() == 1){
                    fibra.setChecked(true);
                }
                else{
                    fibra.setChecked(false);
                }
                if(bean.getGelmoldado() == 1){
                    gel.setChecked(true);
                }
                else {
                    gel.setChecked(false);
                }
            }
        }

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String parte1 = "";
                String parte2 = "";
                String nomeCompleto = nome.getText().toString();
                AgendamentoContoleDAO dao = new AgendamentoContoleDAO(getApplicationContext());
                StringBuilder builder = new StringBuilder();

                String palavras[] = nomeCompleto.split(" ");
                parte1 = palavras[0];

                for(int i = 1; i < palavras.length; i++){
                    builder = builder.append(palavras[i] + " ");
                }

                parte2 = builder.toString().substring(0, builder.length() - 1);

                if(mao.isChecked()){
                    valorMao = 1;
                }
                else{
                    valorMao = 0;
                }
                if(pe.isChecked()){
                    valorPe = 1;
                }
                else {
                    valorPe = 0;
                }
                if(manutencao.isChecked()){
                    valorManutencao = 1;
                }
                else {
                    valorManutencao = 0;
                }
                if(plastica.isChecked()){
                    valorPlastica = 1;
                }
                else {
                    valorPlastica = 0;
                }
                if(fibra.isChecked()){
                    valorFibra = 1;
                }
                else {
                    valorFibra = 0;
                }
                if(gel.isChecked()){
                    valorGel = 1;
                }
                else{
                    valorGel = 0;
                }

                dao.atualizar(id, parte1, parte2, telefone.getText().toString(),
                        data.getText().toString(), hora.getText().toString(),
                        valorMao, valorPe, valorManutencao, valorPlastica, valorFibra,
                        valorGel);


                Toast toast = Toast.makeText(getApplicationContext(),
                        "Datos alterados com sucesso", Toast.LENGTH_LONG);
                toast.show();

                Intent retornarMenu = new Intent(EditeCliente.this,
                        MainActivity.class);
                startActivity(retornarMenu);
            }
        });
    }
}
