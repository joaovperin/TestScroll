package scroll.jpe.feevale.br.testscroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NomesAdapter extends BaseAdapter {

    final List<String> list;
    final LayoutInflater inflater;

    public NomesAdapter(LayoutInflater inflater, List<String> list){
        this.inflater = inflater;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.nome_item, parent, false);
        }

        // get current item to be displayed
        String currentItem = (String) getItem(position);
        // get the TextView for item name and item description
        TextView textViewItemName = (TextView) convertView.findViewById(R.id.txtPersonName);
        textViewItemName.setText(currentItem);

        // returns the view for the current row
        return convertView;
    }
}
