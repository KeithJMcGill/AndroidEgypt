package com.keithjmcgill.ancientegypt;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity
{
	String classes[] = {"Amun", "AmunRa", "Anuket", "Bes", "Horus", "Isis", "Khnum", "Khonsu", "Mut",
			"Nefertem", "Osiris", "Ptah", "Ra", "Satet", "Sekmet", "Sobek", "Taweret", "Thoth"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
		final ListView listView = getListView();
		listView.setBackgroundColor(Color.YELLOW);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String menuSpot = classes[position];
		try
		{
			Class ourClass = Class.forName("com.keithjmcgill.ancientegypt." + menuSpot);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}