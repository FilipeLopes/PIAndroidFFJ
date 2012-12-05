package br.com.pizza.pizzatuh;

import br.com.pizza.dao.MesaDAO;
import br.com.pizza.entidade.Mesa;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MesaActivity extends Activity implements Runnable {
	private ProgressDialog pg;
	private EditText editNumMesa;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_mesa);
        
        Button btnOk = (Button) findViewById(R.id.btMesaEnviar);
        
        editNumMesa = (EditText) findViewById(R.id.editMesaNumMesa);
    
        btnOk.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				MesaDAO dao = new MesaDAO(getBaseContext());
				Mesa vo = new Mesa();
				vo.setNumMesa(Integer.parseInt(editNumMesa.getText().toString()));
				dao.insert(vo);
				Toast.makeText(getBaseContext(), "Sucesso", Toast.LENGTH_LONG).show();				
				finish();
			}
		});
        
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
