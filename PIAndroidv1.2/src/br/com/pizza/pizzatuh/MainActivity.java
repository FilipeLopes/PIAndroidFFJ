package br.com.pizza.pizzatuh;

import java.util.List;

import br.com.pizza.dao.MesaDAO;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	Spinner spinner;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadSpinnerData();
        findViewById(R.id.btMainFazerPedido).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getBaseContext(), PedidoActivity.class));
			
			}
		});   
        
        findViewById(R.id.btMainMesa).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getBaseContext(), MesaActivity.class));
			
			}
		});   
        
    }

    @Override
    protected void onResume(){
    	super.onResume();
    	loadSpinnerData();
    }
    
    private void loadSpinnerData() {
    	 
        spinner = (Spinner) findViewById(R.id.spMainMesa);
        MesaDAO mesa = new MesaDAO(getBaseContext());
    	
        List<String> lables = mesa.getAll();
    	
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
