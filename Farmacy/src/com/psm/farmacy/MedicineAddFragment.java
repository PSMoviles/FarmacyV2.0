package com.psm.farmacy;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import com.psm.Model.Container;
import com.psm.Model.Lang;
import com.psm.UI.spnContainerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.Spinner;

public class MedicineAddFragment extends BaseFragment{
	
	private View vi;
	private EditText txtMedicineName;
	private Spinner spnType;
	private ListView lstActives;
	private Button btnSave;
	private Button btnAddActive;
	private List<Container> list;
	private String textMedicine;
	private String selSpnType;
	private Bundle savedParams;

	public static MedicineAddFragment NewInstance(String name,int index,List<String> actives)
	{
		MedicineAddFragment frag= new MedicineAddFragment();		
		Bundle args = new Bundle();	
		args.putString("textMedicine", name);		
		args.putInt("selSpnType", index);
		args.putStringArrayList("actives", (ArrayList<String>) actives);
		frag.setArguments(args);
		return frag;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		try
		{
		setHasOptionsMenu(true);		
		if(savedInstanceState!=null)
			savedParams=savedInstanceState;			
		LoadDatabase(getActivity());
		Lang lan=getCurrentLang();		
		list=pr.lstExcipientes(lan);		
		}
		catch(Exception ex)
		{
			String es= ex.getMessage();			
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
		btnAddActive=(Button)vi.findViewById(R.id.btnAddActive);
		createListeners();
		savedParams=getArguments();
		if(savedParams!=null)
		{
			txtMedicineName.setText(savedParams.getString("textMedicine"));
			spnType.setSelection(savedParams.getInt("index"));
			List<String> list=savedParams.getStringArrayList("actives");
			try
			{
			lstActives.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,list));
			}
			catch(Exception ex)
			{
				String es= ex.getMessage();				
			}
		}
		return vi;
	}	
	
	public void createListeners()
	{
		btnSave.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
							//GuardarMedicina
			}
		});
		
		btnAddActive.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				ReplaceFragment(ActivesFragment.NewInstance(txtMedicineName.getText().toString(), 
						spnType.getSelectedItemPosition(),getCurrentActives()));
			}
		});
	}
	
	public List<String> getCurrentActives()
	{
		List<String> actives= new ArrayList<String>();
		try
		{		
		int n= lstActives.getAdapter().getCount();
		for(int i=0;i<n;i++)
		{
			actives.add(lstActives.getItemAtPosition(i).toString());
		}
		return actives;
		}
		catch(Exception ex)
		{
			String n=ex.getMessage();
			return actives;
		}
		
	}
}
