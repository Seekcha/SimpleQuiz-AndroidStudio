package com.example.seekcsaz.mygeoquiz_v10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Retrieve an instance of the ListView control */
        ListView menuList = (ListView) findViewById(R.id.ListView_Menu);

        //define the String values you will use to populate the TextView items within the ListView control.
        String[] items ={
                getResources().getString(R.string.menu_item_play),
                getResources().getString(R.string.menu_item_score),
                getResources().getString(R.string.menu_item_settings),
                getResources().getString(R.string.menu_item_help)
        };
        /* you need to use a data adapter to map the data to the layout
        template you created (menu_item.xml). The choice of adapter
        depends on the type of data being used. In this case, you use
        ArrayAdapter: */

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.activity_menu_item, items);
        /* Tell the ListView control to use the adapter: */
        menuList.setAdapter(adapt);

        /* To listen for item clicks, you use the setOnItemClickListener() method of the ListView.
        Specifically, you implement the onItemClick() method of the AdapterView.OnItemClickListener class,
        like below: */
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View itemClicked, int position, long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_play))){
                    startActivity(new Intent(MainActivity.this,QuizActivity.class));
                }else if(strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_score))){
                    startActivity(new Intent(MainActivity.this,ScoreActivity.class));
                }else if(strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_settings))){
                    startActivity(new Intent(MainActivity.this,SettingsActivity.class));
                }else if(strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_help))){
                    startActivity(new Intent(MainActivity.this,HelpActivity.class));
                }
            }
        });
    }
}
