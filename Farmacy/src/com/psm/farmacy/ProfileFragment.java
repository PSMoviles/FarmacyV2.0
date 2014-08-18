package com.psm.farmacy;

import java.util.List;

import com.psm.Database.Procedures;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProfileFragment extends Fragment{

	private Activity actParent;
	private View vi;
	private List<String> usuarios;
	private ListView lstUsers;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setHasOptionsMenu(true);
		super.onCreate(savedInstanceState);
		try
		{
			Procedures pr= new Procedures(getActivity());
			usuarios=pr.LstUsuarios();
		}
		catch(Exception ex)
		{}
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		vi= inflater.inflate(R.layout.fragment_profile, container, false);
		lstUsers=(ListView) vi.findViewById(R.id.profilelstUsers);
		//ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, usuarios);
		lstUsers.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,usuarios));
		return vi;
		//return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub		
		/*actParent=getActivity();
		MenuInflater inflater2 = actParent.getMenuInflater();
	    inflater2.inflate(R.menu.profile, menu);*/
		//super.onCreateOptionsMenu(menu, inflater);
		menu.clear();		
		inflater.inflate(R.menu.profile, menu);		
		//showGlobalContextActionBar();
		
	}
	
	private ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }
	
	private void showGlobalContextActionBar() {
        ActionBar actionBar = getActionBar();       
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setTitle(R.string.app_name);
    }

}
