package fragments;

import com.sparks.feliz.R;

import adapters.PharmaListAdapter;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class CheckInFragment extends ListFragment {

	String[] patient_list, doctor_list;
	ArrayAdapter<String> adapter,  doctorAdapter;
	AutoCompleteTextView textView, doctorTextView;
	Button goButton;
	CharSequence patient, doctor;
	private ArrayAdapter pharmaListArrayAdapter;
	String[] StringArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	public CheckInFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_pharma_list, container,
				false);

		patient_list = getResources().getStringArray(R.array.patient_list);
	
		

		pharmaListArrayAdapter = new PharmaListAdapter(getActivity(), StringArray);
		setListAdapter(pharmaListArrayAdapter);
		
		
		return rootView;
	}
}
