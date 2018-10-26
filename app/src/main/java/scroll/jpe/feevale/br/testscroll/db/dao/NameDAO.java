package scroll.jpe.feevale.br.testscroll.db.dao;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;
import scroll.jpe.feevale.br.testscroll.db.Connection;

public class NameDAO {

    public static final String TABLE_NAME = "Persons";
    public static final String COLUMN_NAME = "Name";

    private final Connection conn;

    public NameDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(String name){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        conn.getDb().insert(TABLE_NAME, null, values);
    }

    public List<String> select(){
        List<String> list = new ArrayList<>();
        String[] columns = {COLUMN_NAME};
        Cursor cursor = conn.getDb().query(TABLE_NAME, columns,null,null,null,null, COLUMN_NAME);
        // Iterates the query result
        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            do{
                String name = (cursor.getString(cursor.getColumnIndex("Name")));
                list.add(name);
            } while(cursor.moveToNext());
        }
        return list;
    }

}
