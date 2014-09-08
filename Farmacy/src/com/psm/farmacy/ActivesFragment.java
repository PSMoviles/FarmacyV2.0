package com.psm.farmacy;

import java.util.ArrayList;
import java.util.List;
import com.psm.Database.Procedures;
import com.psm.Model.Lang;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ActivesFragment extends Fragment{
	private View vi;
	private Procedures pr;
	private Button btnBuscar;
	private EditText txtActivo;
	private ListView lstActivos;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		vi=inflater.inflate(R.layout.fragment_actives, container, false);
		txtActivo=(EditText) vi.findViewById(R.id.txtActiveName);
		btnBuscar=(Button) vi.findViewById(R.id.btnSearchActive);
		lstActivos=(ListView) vi.findViewById(R.id.lstActives);
		listeners();
		return vi;
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		try
		{
			pr= new Procedures(getActivity());			
		}
		catch(Exception ex)
		{
			Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_LONG).show();			
		}
		super.onCreate(savedInstanceState);
	}
	
	private void listeners()
	{
		btnBuscar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				List<String> lista= new ArrayList<String>();
				SharedPreferences sharedPref;
				sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
				String lan =sharedPref.getString("lang", "es");
				Lang idioma=Lang.Spanish;				
				if(lan.equals("en"))
				{idioma=Lang.English;}
				if(lan.equals("fr"))
				{idioma=Lang.French;}
				lista=pr.srcActivos(idioma,txtActivo.getText().toString());
				lstActivos.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,lista));
			}
		});			
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();		
		inflater.inflate(R.menu.actives, menu);		
	}
}
