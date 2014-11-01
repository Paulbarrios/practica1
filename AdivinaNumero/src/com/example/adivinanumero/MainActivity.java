package com.example.adivinanumero;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
		cajaTexto = (EditText) findViewById(R.id.editText1);
		adivina = (TextView) findViewById(R.id.textView11);
		restoreMe(savedInstanceState);
		android.util.Log.e(TAG, numeroAdivinar+"");
	}

	public void verificarNumero(View v) {
		int numeroCaja = 0;
		String numero = cajaTexto.getText().toString();
		if (!numero.equals("")) {
			intentos++;
			intentosText.setVisibility(View.VISIBLE);
			android.content.res.Resources res = getResources();
			String intentosTexto = res.getQuantityString(R.plurals.intentos,
					intentos, intentos);
			intentosText.setText(intentosTexto);
			try {
				numeroCaja = Integer.parseInt(numero);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (numeroCaja < numeroAdivinar) {
				String format = res.getString(R.string.mayor);
				String mayor = String.format(format, numeroCaja);
				adivina.setText(mayor);
				cajaTexto.setText("");
			} else if (numeroCaja > numeroAdivinar) {
				String format = res.getString(R.string.menor);
				String menor = String.format(format, numeroCaja);
				adivina.setText(menor);
				cajaTexto.setText("");
			} else if (numeroCaja == numeroAdivinar) {
				String format = res.getString(R.string.igual);
				String igual = String.format(format, numeroCaja);
				adivina.setText(igual);
			}
		} else {
			adivina.setText(R.string.vacio);
		}

	}
	
  @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
        outState.putInt("intentos", intentos);
        outState.putInt("numeroAdivinar", numeroAdivinar);
        outState.putString("adivina", (String) adivina.getText());
        outState.putString("intentosText", (String) intentosText.getText());
        
    }
  
  private void restoreMe(Bundle state){
  
  	if (state!=null) {
  		intentos = state.getInt("intentos");
  		numeroAdivinar = state.getInt("numeroAdivinar");
  		adivina.setText(state.getString("adivina"));
  		intentosText.setText(state.getString("intentosText"));
  	}else{
  		valoresACero();
  	}
   }
  
  public void valoresACero() {
	  intentos = 0;
	  numeroAdivinar = (int) Math.round(Math.random() * 100);
  }



	private TextView adivina;
	private TextView intentosText;
	private EditText cajaTexto;
}
