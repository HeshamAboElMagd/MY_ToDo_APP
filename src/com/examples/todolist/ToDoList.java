package com.examples.todolist;

import java.util.ArrayList;

import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoList extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView myListView = (ListView) findViewById(R.id.listView);
        final EditText myEditText = (EditText) findViewById(R.id.addNewToDo);
        
        final ArrayList<String> todoItems = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter ;
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,todoItems);
        myListView.setAdapter(arrayAdapter);
        
        myEditText.setOnKeyListener(new OnKeyListener(){

			@Override
			public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
				// TODO Auto-generated method stub
				if(arg2.getAction()==KeyEvent.ACTION_DOWN)
					if(arg1== KeyEvent.KEYCODE_DPAD_CENTER){
						todoItems.add(0,myEditText.getText().toString());
						arrayAdapter.notifyDataSetChanged();
						myEditText.setText("");
						return true;
					}
					return false;				
			}
        	
        });
        
        
    }
}