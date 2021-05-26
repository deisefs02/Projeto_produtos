package PROJETO_01.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBGateway {

    private static DBGateway dbGateway;
    private SQLiteDatabase db;

    public static DBGateway getInstance(Context contexto){
        if(dbGateway == null){
            dbGateway = new DBGateway(contexto);
        }
        return dbGateway;
    }

    private DBGateway(Context context){
        DatabaseDBHelper dbHelper = new DatabaseDBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public SQLiteDatabase getDatabase(){
        return db;
    }
}
