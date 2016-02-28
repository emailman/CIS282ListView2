package edu.dtcc.emailman.cis282listview2;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(edu.dtcc.emailman.cis282listview2.R.layout.activity_main);

        // Build the array for the list
        final String[] fruits = {"Apple", "Mango", "Orange", "Grapes", "Bananas"};

        // Get a reference to the text view
        final TextView selectedOpt =
                (TextView) findViewById(edu.dtcc.emailman.cis282listview2.R.id.selectedOption);

        // Get a reference to the list view
        ListView fruitsList = (ListView) findViewById(android.R.id.list);

        // Setup an adapter for the list (radio buttons)
        final ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, fruits);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        // Setup an adapter for the list (check boxes)
        /*
        final ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, fruits);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        */

        fruitsList.setAdapter(arrayAdapter);

        // Setup a listener on the list
        fruitsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedOpt.setText("You selected " + fruits[position]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(edu.dtcc.emailman.cis282listview2.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == edu.dtcc.emailman.cis282listview2.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
