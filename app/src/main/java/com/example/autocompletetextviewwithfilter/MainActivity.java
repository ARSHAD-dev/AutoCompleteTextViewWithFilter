package com.example.autocompletetextviewwithfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
AutoCompleteTextView act;
String [] names={"Android","React","Flutter","JavaScript","java","Azure","Focus","Arshad",};
String my_var;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        act = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, names);
        act.setThreshold(0);
        act.setAdapter(arrayAdapter);
        act.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                my_var = arrayAdapter.getItem(position);
                Toast.makeText(MainActivity.this, "Name is : " + my_var, Toast.LENGTH_SHORT).show();
            }
        });
        act.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!act.isPerformingCompletion()){
                    boolean validation=false;
                    for (String val : names){
                        if (val.toLowerCase().startsWith(charSequence.toString().toLowerCase())){
                            validation=true;
                        }
                    }
                    if (!validation) {

                        Toast.makeText(MainActivity.this, "Search is not found", Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

}