package com.example.angelus.productosapirest;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btndescarga;
    private TextView txtdatos;
    private ListView listav;
    private AdapterProductos adapterProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        btndescarga=(Button) findViewById(R.id.btndownload);
        txtdatos=(TextView) findViewById(R.id.txtdatos);
        //listav=(ListView) findViewById(R.id.listaProductos);


        btndescarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetProducto gp=new GetProducto();
                gp.execute("http://www.legionx.com.mx/alumnos/data/apiproductos/getproductos.php");
            }
        });
    }

    public class GetProducto extends AsyncTask<String,Integer,List<Producto>>{

        @Override
        protected List<Producto> doInBackground(String... params) {
            try {
                URL url=new URL(params[0]);
                HttpURLConnection con=
                        (HttpURLConnection)
                                url.openConnection();
                InputStreamReader isr=new InputStreamReader(con.getInputStream(),"UTF-8");

                //BufferedReader is=new BufferedReader(isr);
                //String cadena="",textofinal="";
                //while((cadena=is.readLine())!=null){
                 //   textofinal+=cadena;
                //}
                //JSONObject object=JSONObject.
                JsonReader reader=new JsonReader(isr);
                reader.beginObject();
                List<Producto> list=new ArrayList<>();
                while(reader.hasNext()){
                    String name=reader.nextName();
                    int valor=0;
                    if(name.equals("estado"))
                        valor=reader.nextInt();
                    if(name.equals("productos") ){   //-----
                                reader.beginArray();
                            while(reader.hasNext())
                            {
                                reader.beginObject();
                                Producto p=new Producto();
                                while(reader.hasNext())
                                {
                                    //{"id":"1","nombre":"Zeth","descripcion":"...","precio":"8.00","fecha":"2017-03-29 17:18:36","urlfoto":null
                                    String nombre=reader.nextName();
                                    switch (nombre){
                                        case "id":
                                            p.setId(reader.nextInt());
                                            break;
                                        case "nombre":
                                            p.setNombre(reader.nextString());
                                            break;
                                        case "descripcion":
                                            p.setDescripcion(reader.nextString());
                                            break;
                                        case "precio":
                                            p.setPrecio(reader.nextDouble());
                                            break;
                                        case "fecha":
                                            p.setFecha(reader.nextString());
                                            break;
                                        default:
                                            reader.skipValue();
                                            break;
                                    }
                                }
                                reader.endObject();
                                list.add(p);
                            }
                            reader.endArray();


                    }

                }
                reader.endObject();

//                is.close();
                isr.close();
                con.disconnect();
                //return  textofinal;
                return list;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Producto> s) {
            super.onPostExecute(s);
            for(int i=0;i<s.size();i++) {
                txtdatos.append(s.get(i).toString());
            }
            ///adaptador
            //adapterProductos=new AdapterProductos(getBaseContext(),s);

            //listav.setAdapter(adapterProductos);
        }
    }




}
