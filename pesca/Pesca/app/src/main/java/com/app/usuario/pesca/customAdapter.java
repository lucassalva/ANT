package com.app.usuario.pesca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MapaModel> mapaModelArrayList;

    public customAdapter(Context context, ArrayList<MapaModel> mapaModelArrayList) {
        this.context = context;
        this.mapaModelArrayList = mapaModelArrayList;
    }


    @Override
    public int getCount() {
        return mapaModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mapaModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.name);
            holder.tvlat = (TextView) convertView.findViewById(R.id.carnada);
            holder.tvlon = (TextView) convertView.findViewById(R.id.epoca);
            holder.tvid = (TextView) convertView.findViewById(R.id.id);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvname.setText("Nombre: "+mapaModelArrayList.get(position).getNombre());
        holder.tvlat.setText("Latitud: "+mapaModelArrayList.get(position).getLatitud());
        holder.tvlon.setText("Longitud: "+mapaModelArrayList.get(position).getLongitud());
        holder.tvid.setText("Id: "+mapaModelArrayList.get(position).getId());
        return convertView;
    }

    private class ViewHolder {
        protected TextView tvname, tvlat, tvlon,tvid;
    }

}