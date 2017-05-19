package com.example.angelus.productosapirest;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterProductos extends ArrayAdapter<Producto> {

    private List<Producto> productos;
    private Context ctx;
    public AdapterProductos(Context context, List<Producto> lista) {
        super(context, R.layout.item_producto,lista);
        this.ctx=context;
        productos=lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view=inflater.inflate(R.layout.item_producto,parent,true);

        TextView txtv1=(TextView) view.findViewById(R.id.txtProducto);
        TextView txtv2=(TextView) view.findViewById(R.id.txtId);

        txtv1.setText(productos.get(position).getNombre());
        txtv2.setText(productos.get(position).getId());

        return view;
    }
}
