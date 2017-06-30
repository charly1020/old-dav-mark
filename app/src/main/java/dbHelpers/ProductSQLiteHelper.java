package dbHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sabrina on 17/05/2017.
 */

public class ProductSQLiteHelper extends SQLiteOpenHelper {

  String sqlCreate = "CREATE TABLE Product(id INTEGER PRIMARY KEY NOT NULL, name TEXT, description TEXT, product_cat INTEGER, FOREIGN KEY(product_cat) REFERENCES Category(id))";


  public ProductSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    super(context, name, factory, version);

  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(sqlCreate);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  public void clearTable(SQLiteDatabase db){
    db.execSQL("DROP TABLE IF EXISTS Product");
    db.execSQL(sqlCreate);
  }

}
