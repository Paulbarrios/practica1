package com.example.adivinanumero;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private int intentos = 0;
	private int numeroAdivinar = 0;
	private static final String TAG = "Pulsame";


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Obtenemos el objeto Button a partir de su id.
		Boton = (Button) findViewById(R.id.button);
		intentosText = (TextView) findViewById(R.id.textView1);
		
		// Nos hacemos observadores de sus pulsaciones.
		Boton.setOnClickListener(
			new View.OnClickListener() {
				public void onClick(View v) {
				verificarNumero();
			}
			}
		);

	}
	
	public void verificarNumero() {
		 android.util.Log.e(TAG, "Pulsado");
		 
		 
	}
	
	private Button Boton = null;
	private TextView intentosText = null;
}
