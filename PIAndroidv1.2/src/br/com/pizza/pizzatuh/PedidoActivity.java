package br.com.pizza.pizzatuh;

import android.os.Bundle;
import android.widget.TabHost;
import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.content.res.Resources;

public class PedidoActivity extends ActivityGroup {
	static TabHost tabHost;
	static int tab = -1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_pedido);
        
        Resources res = getResources();
        	tabHost = (TabHost)findViewById(R.id.tabhost);
        	tabHost.setup(this.getLocalActivityManager());
        	 TabHost.TabSpec spec;
        	 Intent intent;
        	 
        	// Adiciona Tab #1
        	 intent = new Intent().setClass(this, PizzaActivity.class);
        	 spec = tabHost.newTabSpec("0").setIndicator("Pizza").setContent(intent);
        	 tabHost.addTab(spec);
        	 
        	// Adiciona Tab #2
        	 intent = new Intent(this, BebidaActivity.class);
        	 spec = tabHost.newTabSpec("1").setIndicator("Bebida").setContent(intent);
        	 tabHost.addTab(spec);
        	 
        	 tabHost.setCurrentTab(0);
        	 
    }
    
}
