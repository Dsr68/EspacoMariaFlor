package com.dalisonsr.espacomariaflor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.dalisonsr.espacomariaflor.agendamentoBEAN.AgendamentoBEAN;
import com.dalisonsr.espacomariaflor.agendamentoDAO.AgendamentoContoleDAO;
import com.dalisonsr.espacomariaflor.listas.Listas;

import java.util.ArrayList;
import java.util.List;

public class ViewClientes extends AppCompatActivity {
    List<AgendamentoBEAN> lista = new ArrayList<AgendamentoBEAN>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_clientes);

        AgendamentoContoleDAO agendamentoContoleDAO = new AgendamentoContoleDAO(getApplicationContext());
        lista = agendamentoContoleDAO.carregarDados();
        recyclerView = findViewById(R.id.reciclador);

        recyclerView.setAdapter(new Listas(getApplicationContext(), ViewClientes.this,
                lista));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

    }
}
