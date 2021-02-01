package com.lawyeraid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.lawyeraid.model.TermModel;
import com.lawyeraid.service.TermService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setCalendarView(view);
        setTermTypeSpinner(view);
        setTermSubmitButtonAction(view);
    }

    private void setCalendarView(View view) {
        CalendarView calendarView = (CalendarView) view.findViewById(R.id.calendarView);
        calendarView.setDate((new Date().getTime()));
    }

    private void setTermSubmitButtonAction(@NonNull View view) {
        view.findViewById(R.id.submitButtonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText resultDate = ((View) view.getParent()).findViewById(R.id.resultTextDate);
                resultDate.setText(new SimpleDateFormat("DD-MM-YYYY").format(new Date()));
            }
        });
    }

    private void setTermTypeSpinner(@NonNull View view) {
        Spinner spinner = (Spinner) view.findViewById(R.id.termTypeSpinner);

        ArrayList<TermModel> terms = new TermService().getTermTypes();

        ArrayAdapter<TermModel> termModelArrayAdapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, terms);

        spinner.setAdapter(termModelArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the value selected by the user
                // e.g. to store it as a field or immediately call a method
                TermModel termModel = (TermModel) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}