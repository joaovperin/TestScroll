package scroll.jpe.feevale.br.testscroll;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    EditText txtPersonName;
    ListView listView;
    final List<String> names = new ArrayList<>();
    NomesAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPersonName = (EditText) findViewById(R.id.txtPersonName);
        listView = (ListView) findViewById(R.id.listPerson);

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        listAdapter = new NomesAdapter(layoutInflater, names);
        listView.setAdapter(listAdapter);

        names.add("joao");
        names.add("perin");
        names.add("haha");
    }

    public void addPersonOnList(View v){
        String personName = txtPersonName.getText().toString();
        if(!names.contains(personName)){
            names.add(personName);
            txtPersonName.setText("");
        }
        listAdapter.notifyDataSetChanged();
    }

}
