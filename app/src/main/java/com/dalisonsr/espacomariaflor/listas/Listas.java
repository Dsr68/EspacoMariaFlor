package com.dalisonsr.espacomariaflor.listas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dalisonsr.espacomariaflor.EditeCliente;
import com.dalisonsr.espacomariaflor.R;
import com.dalisonsr.espacomariaflor.agendamentoBEAN.AgendamentoBEAN;
import com.dalisonsr.espacomariaflor.agendamentoDAO.AgendamentoContoleDAO;

import java.util.List;

public class Listas extends RecyclerView.Adapter<Listas.ViewHolder> {
    private List<AgendamentoBEAN> lista;
    private Context context;
    private Activity activity;
    private final int CONSTANTE = 1;

    public Listas(Context context, Activity activity, List<AgendamentoBEAN> lista) {
        this.lista = lista;
        this.activity = activity;
        this.context = context;
    }

    @NonNull
    @Override
    public Listas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itens = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo,
                parent, false);

        return new ViewHolder(itens);
    }

    @Override
    public void onBindViewHolder(@NonNull Listas.ViewHolder holder, final int position) {
        final AgendamentoBEAN agendamento = lista.get(position);

        holder.verificacao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println(agendamento.getId());
                AgendamentoContoleDAO controle = new AgendamentoContoleDAO(context);
                controle.apagarRegistro(agendamento.getId());

                removerItem(position);
            }
        });


       holder.data.setText(agendamento.getData());
       holder.nome.setText(agendamento.getNome());
       holder.hora.setText(agendamento.getHora());

       holder.ver.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Bundle parametros = new Bundle();
               parametros.putInt("id", agendamento.getId());

               Intent intent = new Intent(activity,  EditeCliente.class);
               intent.putExtras(parametros);

               activity.startActivityForResult(intent, CONSTANTE);
           }
       });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void removerItem(int posicao){
        lista.remove(posicao);
        notifyItemRemoved(posicao);
        notifyItemRangeChanged(posicao, lista.size());
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox verificacao;
        TextView nome;
        TextView data;
        TextView hora;
        ImageButton ver;
        ImageButton apagar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            verificacao = itemView.findViewById(R.id.checkBox);
            data = itemView.findViewById(R.id.txtMostrarData);
            nome = itemView.findViewById(R.id.txtMostrarNome);
            hora = itemView.findViewById(R.id.txtMostrarHora);
            ver = itemView.findViewById(R.id.btnVer);

        }

    }
}
