package gt.umg.ventasonline.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import gt.umg.ventasonline.R;
import gt.umg.ventasonline.entities.Categoria;

/**
 * Created by BYRON TOLEDO on 2/22/2017.
 */

public class CategoriaAdapter extends BaseAdapter{

    private Categoria[] categorias;
    private Context context;

    public CategoriaAdapter(Categoria[] categorias, Context context) {
        this.categorias = categorias;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categorias.length;
    }

    @Override
    public Object getItem(int position) {
        return categorias[position];
    }

    @Override
    public long getItemId(int position) {
        return categorias[position].getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_item_spinner,null);
        }

        Categoria categoria = categorias[position];

        TextView textView = (TextView) convertView.findViewById(R.id.ItemSpinnerText);

        textView.setText(categoria.getDescripcion());

        return convertView;
    }
}
