package com.psm.farmacy;

import com.psm.Database.Procedures;
import com.psm.Model.Lang;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

public class BaseFragment extends Fragment{
	public Procedures pr;
	
	public void LoadDatabase(Context context)
	{
		try
		{
			pr= new Procedures(context);			
		}
		catch(Exception ex)
		{
			Toast.makeText(context, ex.getMessage(), Toast.LENGTH_LONG).show();			
		}		
	}
	
	public void ReplaceFragment(Fragment frag)
	{
		FragmentTransaction tran= getActivity().getSupportFragmentManager().beginTransaction();
		tran.replace(R.id.container,frag);
		tran.commit();		
	}
	
	public void addFragmentStrack(Fragment frag)
	{
		FragmentTransaction tran= getActivity().getSupportFragmentManager().beginTransaction();
		tran.replace(R.id.container,frag);
		tran.addToBackStack(null);
		tran.commit();		
	}

	public Lang getCurrentLang()
	{
		SharedPreferences sharedPref;
		sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		int lang=sharedPref.getInt("lang", 0);
		Lang lan=Lang.Spanish;
		switch(lang)
        {
        case 0:
        	lan=Lang.Spanish;
        	break;
        case 1:
        	lan=Lang.French;
        	break;
        case 2:
        	lan=Lang.English;
        	break;
        }
		return lan;
	}
}
