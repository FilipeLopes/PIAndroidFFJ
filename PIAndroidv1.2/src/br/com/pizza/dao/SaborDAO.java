package br.com.pizza.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.pizza.entidade.Sabor;
import br.com.pizza.dao.DB;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SaborDAO {

	private static String table_name = "sabor";
	private Context ctx;
	private String [] columns = {"id","sabor","preco"};
	
	public SaborDAO(Context ctx){
		this.ctx = ctx;
	}
	
	public boolean insert(Sabor vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		ContentValues ctv = new ContentValues();
		ctv.put("sabor"    , vo.getSabor());
		ctv.put("preco"   , vo.getPreco());		
		
		return db.insert(table_name, null, ctv) > 0 ;	
		
	}
	
	public boolean delete(Sabor vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		return (db.delete(table_name, "id=?", new String[]
				{vo.getId().toString()}) > 0);
		
	}
	
	public boolean update(Sabor vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		ContentValues ctv = new ContentValues();
		ctv.put("sabor"    , vo.getSabor());
		ctv.put("preco"   , vo.getPreco());		
		
		return (db.update(table_name, ctv, "id=?", new String[]
				{vo.getId().toString()}) > 0 );
		
	}
	
	public Sabor getByID(Integer ID) {
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		
		Cursor rs =db.query(table_name, columns, "id=?", new String[]
				{ID.toString()}, null, null,null);
		
		Sabor vo = null;
		
		if (rs.moveToFirst()) {
			vo = new Sabor();
			vo.setId   (rs.getInt   (rs.getColumnIndex("id"   )));
			vo.setSabor(rs.getString(rs.getColumnIndex("sabor")));
			vo.setPreco(rs.getFloat (rs.getColumnIndex("preco")));
						
		}	return vo;	}
	
	public List<Sabor> getAll() {
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();		
		Cursor rs = db.rawQuery("SELECT * FROM sabor", null);		
		List<Sabor> lista = new ArrayList<Sabor>();		
		while(rs.moveToNext()){
			Sabor vo = new Sabor(rs.getInt(0),
					rs.getString(1),rs.getFloat(2));
			lista.add(vo);
		}		
		return lista;
	}
	
}
