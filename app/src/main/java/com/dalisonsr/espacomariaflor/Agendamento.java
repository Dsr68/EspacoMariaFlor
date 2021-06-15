package com.dalisonsr.espacomariaflor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.dalisonsr.espacomariaflor.agendamentoBEAN.AgendamentoBEAN;
import com.dalisonsr.espacomariaflor.agendamentoDAO.AgendamentoContoleDAO;

public class Agendamento extends AppCompatActivity {
    EditText nome, sobrenome, telefone, data, hora;
    Spinner servico;
    Button salvar;
    CheckBox mao, pe, manutencao, plastica, fibra, gel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        nome = findViewById(R.id.txtNome);
        sobrenome = findViewById(R.id.txtSobrenome);
        telefone = findViewById(R.id.txtTelefone);
        data = findViewById(R.id.txtData);
        hora = findViewById(R.id.txtHora);
        salvar = findViewById(R.id.btnAgendar);
        mao = findViewById(R.id.checkMao);
        pe = findViewById(R.id.checkPe);
        manutencao = findViewById(R.id.checkManutencao);
        plastica = findViewById(R.id.checkPlastica);
        fibra = findViewById(R.id.checkFibra);
        gel = findViewById(R.id.checkGel);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgendamentoBEAN agendamento = new AgendamentoBEAN();
                agendamento.setNome(nome.getText().toString());
                agendamento.setSobrenome(sobrenome.getText().toString());
                agendamento.setTelefone(telefone.getText().toString());
                agendamento.setData(data.getText().toString());
                agendamento.setHora(hora.getText().toString());

                if(mao.isChecked()){
                    agendamento.setMao(1);
                }
                else {
                    agendamento.setMao(0);
                }

                if(pe.isChecked()){
                    agendamento.setPe(1);
                }
                else{
                    agendamento.setPe(0);
                }

                if(manutencao.isChecked()){
                    agendamento.setManutencao(1);
                }
                else {
                    agendamento.setManutencao(0);
                }
                if(plastica.isChecked()){
                    agendamento.setPlastica(1);
                }
                else {
                    agendamento.setPlastica(0);
                }
                if(fibra.isChecked()){
                    agendamento.setFibra(1);
                }
                else {
                    agendamento.setFibra(0);
                }
                if(gel.isChecked()){
                    agendamento.setGelmoldado(1);
                }
                else {
                    agendamento.setGelmoldado(0);
                }

                AgendamentoContoleDAO cotrole = new AgendamentoContoleDAO(getApplicationContext());
                String mensage = cotrole.inserirDados(agendamento);

                Toast toast = Toast.makeText(getApplicationContext(), mensage, Toast.LENGTH_LONG);
                toast.show();

                nome.setText("");
                sobrenome.setText("");
                telefone.setText("");
                data.setText("");
                hora.setText("");
                mao.setChecked(false);
                pe.setChecked(false);
                manutencao.setChecked(false);
                plastica.setChecked(false);
                fibra.setChecked(false);
                gel.setChecked(false);
            }
        });
    }
}
