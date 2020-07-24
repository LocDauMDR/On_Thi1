package vn.edu.ntu.quangloc.on_thi1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

import vn.edu.ntu.quangloc.controller.INgoaiTeController;
import vn.edu.ntu.quangloc.model.NgoaiTe;

public class FirstFragment extends Fragment {
    NavController navController;
    ImageView imvDate;
    EditText edtDate, edtMua, edtBan;
    RadioGroup rdgType;
    Button btnThem, btnXDS;
    INgoaiTeController controller;
    String[] arrayPT;
    ArrayAdapter<String> adapterPT;
    Spinner spinner;
    String service;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        addViews(v);
        addEvents();
        return v;
    }

    private void addViews(View v) {
        navController = NavHostFragment.findNavController(FirstFragment.this);
        ((MainActivity) getActivity()).navController = navController;
        controller = (INgoaiTeController) getActivity().getApplication();
        imvDate = v.findViewById(R.id.imvDate);
        edtDate = v.findViewById(R.id.edtDate);
        edtMua = v.findViewById(R.id.edtMua);
        edtBan = v.findViewById(R.id.edtBan);
        rdgType = v.findViewById(R.id.rdgType);
        btnThem = v.findViewById(R.id.btnThem);

        spinner = v.findViewById(R.id.spinner);
        arrayPT = getResources().getStringArray(R.array.loai_tien);
        adapterPT = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayPT);
        spinner.setAdapter(adapterPT);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        imvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("/")
                                .append(++month)
                                .append("/")
                                .append(year);
                        edtDate.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        listener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
    }

    private void addEvents() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                service = adapterPT.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                service = "None";
            }
        });
    }

    private void addItem() {
        RadioButton rdBtn = getActivity().findViewById(rdgType.getCheckedRadioButtonId());
        if (edtDate.getText().length() <= 0 ||
                edtMua.getText().length() <= 0 ||
                edtBan.getText().length() <= 0) {
            Toast.makeText(getActivity(), "Giá trị không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }
        controller.addItem(
                new NgoaiTe(edtDate.getText().toString(),
                        rdBtn.getText().toString(),
                        service,
                        Integer.parseInt(edtMua.getText().toString()),
                        Integer.parseInt(edtBan.getText().toString())
                ));
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btnXDS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}