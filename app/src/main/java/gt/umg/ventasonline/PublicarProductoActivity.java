package gt.umg.ventasonline;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.Voice;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import gt.umg.ventasonline.adapters.CategoriaAdapter;
import gt.umg.ventasonline.entities.Categoria;
import gt.umg.ventasonline.ws.VentasOnlineWs;

public class PublicarProductoActivity extends AppCompatActivity {

    private Spinner spinnerCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_producto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        spinnerCategorias = (Spinner) findViewById(R.id.PublicarProductoCategorias);

        new CategoriaTask(this).execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_publicar_producto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class CategoriaTask extends AsyncTask<Void, String, Boolean>{

        private Context context;
        private Categoria[] categorias = null;
        private ProgressDialog progressDialog = null;

        public CategoriaTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog =  new ProgressDialog(context);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Obteniendo Categorias");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Boolean b) {
            super.onPostExecute(b);
            progressDialog .hide();
            if(categorias!=null){
                CategoriaAdapter categoriaAdapter = new CategoriaAdapter(categorias,context);
                spinnerCategorias.setAdapter(categoriaAdapter);
            }

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            try{
                VentasOnlineWs ventasOnlineWs = new VentasOnlineWs();

                categorias = ventasOnlineWs.getCategorias();

                return true;
            }catch (Exception exception){
                return false;
            }


        }
    }


}
