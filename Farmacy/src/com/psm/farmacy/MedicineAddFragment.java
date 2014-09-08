package com.psm.farmacy;

import java.util.List;

import com.psm.Database.Procedures;
import com.psm.Model.Container;
import com.psm.Model.Lang;
import com.psm.UI.spnContainerAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MedicineAddFragment extends Fragment{
	
	private View vi;
	private EditText txtMedicineName;
	private Spinner spnType;
	private ListView lstActives;
	private Button btnSave;
	private List<Container> list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		try
		{
			Procedures pr= new Procedures(getActivity());
			SharedPreferences sharedPref;
			sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
			String lan =sharedPref.getString("lang", "es");
			Lang idioma=Lang.Spanish;				
			if(lan.equals("en"))
			{idioma=Lang.English;}
			if(lan.equals("fr"))
			{idioma=Lang.French;}
			list=pr.lstExcipientes(idioma);
		}
		catch(Exception ex)
		{
			Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_LONG).show();			
		}
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		vi=inflater.inflate(R.layout.fragment_medicine_add, container, false);
		txtMedicineName=(EditText)vi.findViewById(R.id.txtMedicineName);
		spnType=(Spinner)vi.findViewById(R.id.spnType);
		lstActives=(ListView)vi.findViewById(R.id.lstActives);
		btnSave=(Button)	vi.findViewById(R.id.btnSave);
		spnType.setAdapter(new spnContainerAdapter(getActivity(), list));
		return vi;
	}
	
	
}
