package partner.softgalli.sqlitetest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import partner.softgalli.sqlitetest.model.Employee;

public class MetronDatabase extends SQLiteOpenHelper {

    private static final String KEY_ID = "_id";
    private static final String KEY_AGE = "_age";
    private static final String KEY_ADDRESS = "_address";


    private static final int VERSION = 1;
    private static final String DATABASE = "MetronEmployeeDatabase";

    private static final String EMPLOYEE_TABLE = "employee_table";

    public MetronDatabase(Context context) {
        super(context, DATABASE, null, VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        String chat_table_query = "create table " + EMPLOYEE_TABLE + " (" + KEY_ID + " text, "+ KEY_AGE + " text, " + KEY_ADDRESS
                + " text " +")";


        db.execSQL(chat_table_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + EMPLOYEE_TABLE);
        onCreate(db);
    }

    public void onUpdate(String date,String language) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();


    }

    public void insertUserData(Employee userDetailsModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, userDetailsModel.getId());
        values.put(KEY_AGE, userDetailsModel.getAge());
        values.put(KEY_ADDRESS, userDetailsModel.getAddress());

        // Inserting Row
        try{
            db.insert(EMPLOYEE_TABLE, null, values);
        }catch(Exception e){
            e.printStackTrace();
        }
        db.close(); // Closing database connection
    }

    public ArrayList<Employee> getEmployeeDetails() {
        ArrayList<Employee> msgModel = new ArrayList<Employee>();
        SQLiteDatabase db = this.getReadableDatabase();

        String s = "Select * from "+ EMPLOYEE_TABLE ;


        msgModel.clear();
        Cursor c = db.rawQuery(s, null);

        if (c.moveToFirst()) {
            do {
                Employee item = new Employee(c.getString(0), c.getString(1), c.getString(2));

                msgModel.add(item);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();

        return msgModel;
    }


}