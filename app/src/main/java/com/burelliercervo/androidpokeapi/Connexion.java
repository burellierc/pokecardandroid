package com.burelliercervo.androidpokeapi;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Connexion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            boolean wifi = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
            Log.d("NetworkState", "L'interface de connexion active est du Wifi : " + wifi);
            boolean cellular = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            Log.d("NetworkState", "L'interface de connexion active est du Wifi : " + cellular);
            TextView connexionfailed = (TextView)findViewById(R.id.connexionfailed);
            connexionfailed.setVisibility(View.INVISIBLE);
        }
            else{
                TextView connexionfailed = (TextView)findViewById(R.id.connexionfailed);
                connexionfailed.setVisibility(View.VISIBLE);
            }

        //String url1 = "https://pokeapi.co/api/v2/pokedex/1/";
        //new RetrieveFeedTask().execute(url1);

      Button GoToList = (Button) findViewById(R.id.goToList);
        GoToList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Connexion.this, ListCard.class));
            }

        });
    }


    protected void onStop()
    {
        super.onStop();
        //recharger les dernières informations précédemment enregistrées dans un fichier local ou une BDD locale, lorsque l’application est mise en arrière-plan ou arrêtée.
    }
}
