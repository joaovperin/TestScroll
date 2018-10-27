package scroll.jpe.feevale.br.testscroll.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDatabase extends SQLiteOpenHelper {

    public AppDatabase(Context context, String name) {
        super(context, name, null, 1);
    }

    public static final String SQL_CREATE_DB = new StringBuilder()
            .append("CREATE TABLE Persons (")
            .append(" Name TEXT NOT NULL ")
            .append(")")
            .toString();

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_DB);
        System.out.println("*** Created database " + super.getDatabaseName());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("*** Upgraded database " + super.getDatabaseName());
    }

}
