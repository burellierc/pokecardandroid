package com.burelliercervo.androidpokeapi;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.Toast;


        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

public class ListCard extends AppCompatActivity {

    private ListView mListView;

    public static final String URL = "http://192.168.240.43/jsonExport.json";

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
        mListView = (ListView) findViewById(R.id.listview);
    }
}