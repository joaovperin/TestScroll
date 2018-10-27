package scroll.jpe.feevale.br.testscroll.db;

import android.database.sqlite.SQLiteDatabase;

public interface Connection {

    public void commit();
    public void close();
    public void execute(String sql);
    public void execute(String sql, Object[] bindings);

    public SQLiteDatabase getDb();

}
