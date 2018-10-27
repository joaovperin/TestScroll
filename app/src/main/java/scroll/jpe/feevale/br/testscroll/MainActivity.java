package scroll.jpe.feevale.br.testscroll;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import scroll.jpe.feevale.br.testscroll.db.Connection;
import scroll.jpe.feevale.br.testscroll.db.ConnectionFactory;
import scroll.jpe.feevale.br.testscroll.db.dao.NameDAO;

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

        Connection conn = ConnectionFactory.getReadConnection(this);
        NameDAO dao = new NameDAO(conn);
        for (String n : dao.select()){
            names.add(n);
        }
    }

    public void addPersonOnList(View v){
        String personName = txtPersonName.getText().toString();
        if(!personName.trim().isEmpty() && !names.contains(personName)){
            names.add(personName);

            Connection conn = ConnectionFactory.getTransactionConnection(this);
            NameDAO dao = new NameDAO(conn);
            dao.insert(personName);
            conn.commit();
            conn.close();

            txtPersonName.setText("");
            listAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Nome invalido ou ja existente!",Toast.LENGTH_SHORT).show();
        }
    }

}
