package com.psm.farmacy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class TabStadisticsFragment extends BaseFragment{

	private EditText txtUserCount;
	private EditText txtMedicationCount;
	private EditText txtMedicIncCount;
	private EditText txtMedicineCount;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		vi=inflater.inflate(R.layout.fragment_tab_stadistics, container, false);
		txtMedicationCount=(EditText)vi.findViewById(R.id.txtMedicationCount);
		txtMedicIncCount=(EditText)vi.findViewById(R.id.txtMediIncCount);
		txtMedicineCount=(EditText)vi.findViewById(R.id.txtMedicineCount);
		txtUserCount=(EditText)vi.findViewById(R.id.txtUserCount);
		LoadDatabase(getActivity());
		txtUserCount.setText(pr.countUser());
		txtMedicineCount.setText(pr.countMedicine());
		txtMedicationCount.setText(pr.countMedication());
		txtMedicIncCount.setText(0);
		return vi;
	}
	

}
