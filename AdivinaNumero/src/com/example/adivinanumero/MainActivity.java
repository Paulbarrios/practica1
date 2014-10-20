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
		
		
		intentosText = (TextView) findViewById(R.id.textView1);

	


	}
	
	public void verificarNumero(View v) {
		intentos++;
		 android.util.Log.e(TAG, "Pulsado");
		 intentosText.setVisibility(View.VISIBLE);
		 android.content.res.Resources res = getResources();
		 String intentosTexto = res.getQuantityString(
					R.plurals.intentos,
					intentos,
					intentos);
		 intentosText.setText(intentosTexto);
		 
	}
	
	private TextView intentosText;
}
