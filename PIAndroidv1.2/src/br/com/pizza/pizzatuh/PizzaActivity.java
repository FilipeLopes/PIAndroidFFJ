package br.com.pizza.pizzatuh;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PizzaActivity extends Activity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido_pizza);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
    
}
