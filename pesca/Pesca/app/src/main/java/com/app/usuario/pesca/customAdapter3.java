package com.app.usuario.pesca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customAdapter3 extends BaseAdapter {

    private Context context;
    private ArrayList<PezModel> pezModelArrayList;

    public customAdapter3(Context context, ArrayList<PezModel> pezModelArrayList) {
        this.context = context;
        this.pezModelArrayList = pezModelArrayList;
    }

    @Override
    public int getCount() {
        return pezModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return pezModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        customAdapter3.ViewHolder holder;
        if (convertView == null) {
            holder = new customAdapter3.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lista_peces_l, null, true);
            holder.tvnombre = (TextView) convertView.findViewById(R.id.nombre);
            holder.tvcarnada = (TextView) convertView.findViewById(R.id.carnada);
            holder.tvepoca = (TextView) convertView.findViewById(R.id.epoca);
            holder.tvpeso = (TextView) convertView.findViewById(R.id.peso);

            convertView.setTag(holder);
        }else {
            holder = (customAdapter3.ViewHolder)convertView.getTag();
        }

        holder.tvnombre.setText("Nombre: "+pezModelArrayList.get(position).getNombre());
        holder.tvcarnada.setText("Carnada: "+pezModelArrayList.get(position).getCarnada());
        holder.tvepoca.setText("Epoca: "+pezModelArrayList.get(position).getEpoca());
        holder.tvpeso.setText("Peso: "+pezModelArrayList.get(position).getPeso());
        return convertView;
    }

    private class ViewHolder {
        protected TextView tvnombre, tvcarnada, tvepoca, tvpeso;
    }

}
