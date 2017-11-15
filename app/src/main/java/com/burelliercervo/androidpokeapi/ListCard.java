package com.burelliercervo.androidpokeapi;

        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.ArrayAdapter;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.Toast;


        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

public class ListCard extends AppCompatActivity implements RetrieveFeedTask.Listener {

    private ListView mListView;

    public static final String URL = "https://pokeapi.co/api/v2/pokedex/1/";

    private List<HashMap<String, String>> mPokemonMapList = new ArrayList<>();

    //private static final int KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_XP = "xp";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_WIDHT = "width";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView= (ListView) findViewById(R.id.listview);
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

        //mListView.setOnItemClickListener(this);
        //new L(this).execute(URL);
        new RetrieveFeedTask(this).execute(URL);



    }

    @Override
    public void onLoaded(List<Pokemon> pokemonList) {

        for (Pokemon pokemon : pokemonList) {

            HashMap<String, String> map = new HashMap<>();

            //map.put(KEY_ID, pokemon.getId());
            map.put(KEY_NAME, pokemon.getName());
            map.put(KEY_WIDHT, pokemon.getWidth());
            map.put(KEY_HEIGHT, pokemon.getHeight());
            map.put(KEY_XP, pokemon.getXp());


            mPokemonMapList.add(map);
        }

        loadListView();
    }

    @Override
    public void onError() {

        Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();

    }

    //@Override
    //public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

     //   Toast.makeText(this, mPokemonMapList.get(i).get(KEY_NAME),Toast.LENGTH_LONG).show();
    //}

    private void loadListView() {

        ListAdapter adapter = new SimpleAdapter(ListCard.this, mPokemonMapList, R.layout.layout,
                new String[] {  KEY_NAME },
                new int[] { R.id.name});


        mListView.setAdapter(adapter);


    }



}