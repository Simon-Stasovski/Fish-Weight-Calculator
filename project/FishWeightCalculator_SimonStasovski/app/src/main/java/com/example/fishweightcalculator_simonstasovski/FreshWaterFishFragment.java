package com.example.fishweightcalculator_simonstasovski;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.example.fishweightcalculator_simonstasovski.databinding.FragmentFreshWaterFishBinding;

public class FreshWaterFishFragment extends Fragment {
    private final double POUNDS_TO_GRAMS = 453.59237;
    private static final DecimalFormat POUNDS_FORMAT = new DecimalFormat("0.00");
    private FragmentFreshWaterFishBinding binding;
    double weight;
    private final int NUMBER_OF_FISH_TYPES = 5;

    ArrayList<String> fishNames = new ArrayList<>(NUMBER_OF_FISH_TYPES);

    public FreshWaterFishFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static FreshWaterFishFragment newInstance(String param1, String param2) {
        FreshWaterFishFragment fragment = new FreshWaterFishFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFreshWaterFishBinding.inflate(inflater, container, false);
        binding.calculateFreshWaterButton.setOnClickListener(v -> { recalculate(v);});

        fishNames.add("Trout, steelhead, snook, redfish, bonefish");
        fishNames.add("Salmon, bass");
        fishNames.add("Walleye");
        fishNames.add("Pike, gar, muskie");
        fishNames.add("Sunfish, bluegill");

        for (String fishName: fishNames) {
            RadioButton r = new RadioButton(this.getContext());
            r.setText(fishName);
            binding.fishOptionsRadioGroup.addView(r);
        }
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public void recalculate(View v){

        int radioButtonID = binding.fishOptionsRadioGroup.getCheckedRadioButtonId();

        RadioButton radioButton = (RadioButton) binding.fishOptionsRadioGroup.findViewById(radioButtonID);

        String selectedText = (String) radioButton.getText();

        if(binding.fishLengthEditText.getText().toString().trim().length() == 0)
            binding.fishLengthEditText.setText(0);
        if(binding.fishGirthEditText.getText().toString().trim().length() == 0)
            binding.fishGirthEditText.setText(0);

        switch (selectedText) {
            case "Trout, steelhead, snook, redfish, bonefish":
                weight = (Double.parseDouble(binding.fishLengthEditText.getText().toString()) * Double.parseDouble(binding.fishGirthEditText.getText().toString()) * Double.parseDouble(binding..getText().toString())) / 900;
                break;
            case "Salmon, bass":
                weight = Double.parseDouble(binding.fishLengthEditText.getText().toString()) * Double.parseDouble(binding.fishGirthEditText.getText().toString()) * Double.parseDouble(binding.fishGirthEditText.getText().toString()) / 800;
                break;
            case "Walleye":
                weight = Double.parseDouble(binding.fishLengthEditText.getText().toString()) * Double.parseDouble(binding.fishLengthEditText.getText().toString()) * Double.parseDouble(binding.fishLengthEditText.getText().toString()) / 3500;
                break;
            case "Pike, gar, muskie":
                weight = Double.parseDouble(binding.fishLengthEditText.getText().toString()) * Double.parseDouble(binding.fishLengthEditText.getText().toString()) * Double.parseDouble(binding.fishLengthEditText.getText().toString()) / 2700;
                break;
            case "Sunfish, bluegill":
                weight = Double.parseDouble(binding.fishLengthEditText.getText().toString()) * Double.parseDouble(binding.fishGirthEditText.getText().toString()) * Double.parseDouble(binding.fishGirthEditText.getText().toString()) / 1200;
                break;
            default:
                weight = 0;
        }

        String displayResult;

        if(binding.gramsPoundsSwitch.isChecked()){
            displayResult = "Calculated Weight: " + (int)((weight) * POUNDS_TO_GRAMS) + " grams.";
        }
        else {
            displayResult = "Calculated Weight: " + POUNDS_FORMAT.format(weight) + " pounds.";
        }

        binding.weightResultTextView.setText(displayResult);
    }
}

