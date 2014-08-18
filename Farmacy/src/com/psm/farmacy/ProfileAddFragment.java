package com.psm.farmacy;

import java.util.List;
import com.psm.Database.Procedures;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ProfileAddFragment extends Fragment{

	private View vi;
	private EditText  txtName;
	private EditText  txtAge;
	private Button btnSave;
	private Activity actParent;
	private FragmentActivity myContext;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {		
		//super.onCreateOptionsMenu(menu, inflater);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		vi= inflater.inflate(R.layout.fragment_profile_add, container, false);	
		txtName=(EditText)vi.findViewById(R.id.profiletxtName);
		txtAge=(EditText)vi.findViewById(R.id.profiletxtAge);
		btnSave=(Button)vi.findViewById(R.id.profilebtnSave);
		CreateListener();
		return vi;
		//return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity activity) {
		myContext=(FragmentActivity) activity;
		super.onAttach(activity);
	}

	public void CreateListener()
	{
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				FragmentManager fragManager = myContext.getSupportFragmentManager();
				fragManager.beginTransaction().replace(R.id.container, new ProfileFragment()).commit();				
			}
		});
	}


}
