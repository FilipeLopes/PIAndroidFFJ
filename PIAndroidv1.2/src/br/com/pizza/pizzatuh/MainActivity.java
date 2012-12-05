package br.com.pizza.pizzatuh;

import java.util.List;

import br.com.pizza.dao.MesaDAO;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Spinner spinner;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        loadSpinnerData();//######## Chama o metodo que carrega todo o Spinner ########
        
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
        
        //######################### Maneira de pegar a posição do Spinner#########################
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int posicao, long id) {
				// TODO Auto-generated method stub
				String texto = parent.getItemAtPosition(posicao).toString();
				
				Toast.makeText(getBaseContext(), "A posição é " + texto, Toast.LENGTH_LONG).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        //################## Fim do metodo de pegar posição ###########################	                   
    }

    @Override
    protected void onResume(){//################# Da Refresh nos dados e re inicia o carregamento do spinner #######
    	super.onResume();
    	loadSpinnerData();
    }
    
    //############### metodo que povoa o Spinner com os dados do banco ##################
    private void loadSpinnerData() {
    	 
        spinner = (Spinner) findViewById(R.id.spMainMesa);
        MesaDAO mesa = new MesaDAO(getBaseContext());
    	
        List<String> lables = mesa.getAll();// messa.getAll() é um metodo que tá dentro do do MesaDAO
    	
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    
    }
  //############### FIM do metodo que povoa o Spinner com os dados do banco ##################
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
