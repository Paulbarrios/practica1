package com.example.adivinanumero;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private int intentos = 0;
	private int numeroAdivinar = 50;
	private static final String TAG = "Pulsame";


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		intentosText = (TextView) findViewById(R.id.textView1);
		cajaTexto = (EditText) findViewById(R.id.editText1);
		adivina = (TextView) findViewById(R.id.textView11);

	


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
		 int numeroCaja = Integer.parseInt(cajaTexto.getText().toString());
		 if(numeroCaja > numeroAdivinar){
			adivina.setText("Funciona Pringao!!"); 
		 }else if(numeroCaja > numeroAdivinar){
			 
		 }else if(numeroCaja == numeroAdivinar){
			 
		 }
		 
		 
	}
	
	private TextView adivina;
	private TextView intentosText;
	private EditText cajaTexto;
}
