package com.example.adivinanumero;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
		adivina = (TextView) findViewById(R.id.textoPrincipal);
		intentaloText = (TextView) findViewById(R.id.textView2);
		textoVictoria  = (TextView) findViewById(R.id.textoVictoria);
		volverAJugar = (Button) findViewById(R.id.jugarDeNuevo);
		probar = (Button) findViewById(R.id.button);
		
		
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
				terminarJuego(res,numeroCaja);
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
        
        outState.putInt("intentosText", intentosText.getVisibility());
        outState.putInt("cajaTexto", cajaTexto.getVisibility());
        outState.putInt("adivinaV", adivina.getVisibility());
        outState.putInt("intentaloText", intentaloText.getVisibility());
        outState.putInt("textoVictoria", textoVictoria.getVisibility());
        outState.putInt("volverAJugar", volverAJugar.getVisibility());
        outState.putInt("probar", probar.getVisibility());
               
    }
  
	  private void restoreMe(Bundle state){
	  
	  	if (state!=null) {
	  		intentos = state.getInt("intentos");
	  		numeroAdivinar = state.getInt("numeroAdivinar");
	  		adivina.setText(state.getString("adivina"));
	  		intentosText.setText(state.getString("intentosText"));
	  		
	  		
	  		android.content.res.Resources res = getResources();
	  		String format = res.getString(R.string.igual);
			String igual = String.format(format, state.getInt("numeroAdivinar"));
			textoVictoria.setText(igual) ;		
	  		
	  		intentosText.setVisibility(state.getInt("intentosText"));
			cajaTexto.setVisibility(state.getInt("cajaTexto"));
			adivina.setVisibility(state.getInt("adivinaV"));
			intentaloText.setVisibility(state.getInt("intentaloText"));
			probar.setVisibility(state.getInt("probar"));
			textoVictoria.setVisibility(state.getInt("textoVictoria"));
			volverAJugar.setVisibility(state.getInt("volverAJugar"));
	  	}else{
	  		valoresACero();
	  	}
	   }
  
	  public void valoresACero() {
		  intentos = 0;
		  numeroAdivinar = (int) Math.round(Math.random() * 100);
	  }
	  
	  public void terminarJuego(Resources res, int numeroCaja) {
		  String format = res.getString(R.string.igual);
		  String igual = String.format(format, numeroCaja);
		  intentosText.setVisibility(View.INVISIBLE);
		  cajaTexto.setVisibility(View.INVISIBLE);
		  adivina.setVisibility(View.INVISIBLE);
		  intentaloText.setVisibility(View.INVISIBLE);
		  probar.setVisibility(View.INVISIBLE);
		  textoVictoria.setText(igual);
		  textoVictoria.setVisibility(View.VISIBLE);
		  volverAJugar.setVisibility(View.VISIBLE);
		  
	  }
	  
	  public void reiniciarJuego(View v) {
		 valoresACero();
		 cajaTexto.setText("");
		 adivina.setText(R.string.adivina);
		  cajaTexto.setVisibility(View.VISIBLE);
		  adivina.setVisibility(View.VISIBLE);
		  intentaloText.setVisibility(View.VISIBLE);
		  probar.setVisibility(View.VISIBLE);
		  textoVictoria.setVisibility(View.INVISIBLE);
		  volverAJugar.setVisibility(View.INVISIBLE);
	}



	private TextView adivina;
	private TextView intentosText;
	private EditText cajaTexto;
	private TextView intentaloText;
	private TextView textoVictoria;
	private Button volverAJugar;
	private Button probar;
}
