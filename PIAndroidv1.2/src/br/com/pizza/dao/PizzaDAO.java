package br.com.pizza.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.pizza.entidade.Pizza;
import br.com.pizza.dao.DB;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PizzaDAO {

	private static String table_name = "pizzas";
	private Context ctx;
	private String [] columns = {"id","idBorda","idTamanho","idSabor"};
	
	public PizzaDAO(Context ctx){
		this.ctx = ctx;
	}
	
	public boolean insert(Pizza vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		ContentValues ctv = new ContentValues();
		ctv.put("idBorda"    , vo.getIdBorda());
		ctv.put("idTamanho"   , vo.getIdTamanho());
		ctv.put("idSabor", vo.getIdSabor());		
		
		return db.insert(table_name, null, ctv) > 0 ;	
		
	}
	
	public boolean delete(Pizza vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		return (db.delete(table_name, "id=?", new String[]
				{vo.getId().toString()}) > 0);
		
	}
	
	public boolean update(Pizza vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		ContentValues ctv = new ContentValues();
		ctv.put("idBorda"    , vo.getIdBorda());
		ctv.put("idTamanho"   , vo.getIdTamanho());
		ctv.put("idSabor", vo.getIdSabor());		
		
		return (db.update(table_name, ctv, "id=?", new String[]
				{vo.getId().toString()}) > 0 );
		
	}
	
	public Pizza getByID(Integer ID) {
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		
		Cursor rs =db.query(table_name, columns, "id=?", new String[]
				{ID.toString()}, null, null, null);
		
		Pizza vo = null;
		
		if (rs.moveToFirst()) {
			vo = new Pizza();
			vo.setId        (rs.getInt   (rs.getColumnIndex("id"        )));
			vo.setIdBorda   (rs.getInt   (rs.getColumnIndex("idBorda"   )));
			vo.setIdTamanho (rs.getInt   (rs.getColumnIndex("idTamanho" )));
			vo.setIdSabor   (rs.getInt   (rs.getColumnIndex("idSabor"   )));
			
		}	return vo;	}
	
	public List<Pizza> getAll() {
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();		
		Cursor rs = db.rawQuery("SELECT * FROM pizza", null);		
		List<Pizza> lista = new ArrayList<Pizza>();		
		while(rs.moveToNext()){
			Pizza vo = new Pizza(rs.getInt(0),
					rs.getInt(1),rs.getInt(2),
					rs.getInt(3));
			lista.add(vo);
		}		
		return lista;
	}
	
}
