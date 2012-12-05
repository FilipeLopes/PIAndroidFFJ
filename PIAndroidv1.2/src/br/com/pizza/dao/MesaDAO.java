package br.com.pizza.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.pizza.entidade.Mesa;
import br.com.pizza.dao.DB;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MesaDAO {

	private static String table_name = "mesa";
	private Context ctx;
	private String [] columns = {"id","numMesa"};
	
	public MesaDAO(Context ctx){
		this.ctx = ctx;
	}
	
	public boolean insert(Mesa vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		ContentValues ctv = new ContentValues();
		ctv.put("numMesa"    , vo.getNumMesa());	
		
		return db.insert(table_name, null, ctv) > 0 ;	
		
	}
	
	public boolean delete(Mesa vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		return (db.delete(table_name, "id=?", new String[]
				{vo.getId().toString()}) > 0);
		
	}
	
	public boolean update(Mesa vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		ContentValues ctv = new ContentValues();
		ctv.put("numMesa"    , vo.getNumMesa());	
		
		return (db.update(table_name, ctv, "id=?", new String[]
				{vo.getId().toString()}) > 0 );
		
	}
	
	public Mesa getByID(Integer ID) {
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		
		Cursor rs =db.query(table_name, columns, "id=?", new String[]
				{ID.toString()}, null, null,null);
		
		Mesa vo = null;
		
		if (rs.moveToFirst()) {
			vo = new Mesa();
			vo.setId     (rs.getInt(rs.getColumnIndex("id"     )));
			vo.setNumMesa(rs.getInt(rs.getColumnIndex("numMesa")));
						
		}	return vo;	}
	
	public List<String> getAll() {
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();		
		Cursor rs = db.rawQuery("SELECT * FROM mesa", null);		
		List<String> lista = new ArrayList<String>();		
		while(rs.moveToNext()){
			
		lista.add(rs.getString(1));	
			
		}		
		return lista;
	}
	
}
