package co.com.k4soft.parqueaderouco.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.k4soft.parqueaderouco.R;
import co.com.k4soft.parqueaderouco.entidades.Tarifa;

public class TarifaAdapter extends BaseAdapter{

    private final LayoutInflater inflater;
    private List<Tarifa> listaTarifaOut;
    private List<Tarifa> listaTarifaIn;

    public TarifaAdapter(Context context, List<Tarifa> listaTarifa){

        listaTarifaOut = listaTarifa;
        listaTarifaIn = listaTarifa;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listaTarifaOut.size();
    }

    @Override
    public Tarifa getItem(int position) {
        return listaTarifaOut.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        }else{
            convertView = inflater.inflate(R.layout.tarifa_item_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.txtNombre.setText(listaTarifaOut.get(position).getNombre());
        holder.txtCodigo.setText(listaTarifaOut.get(position).getIdTarifa());
        holder.txtPrecio.setText((int) listaTarifaOut.get(position).getPrecio());

        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.txtNombre)
        TextView txtNombre;
        @BindView(R.id.txtCodigo)
        TextView txtCodigo;
        @BindView(R.id.txtPrecio)
        TextView txtPrecio;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
