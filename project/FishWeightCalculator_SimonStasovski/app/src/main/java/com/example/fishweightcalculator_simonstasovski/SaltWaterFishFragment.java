package com.example.fishweightcalculator_simonstasovski;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.fishweightcalculator_simonstasovski.databinding.FragmentFreshWaterFishBinding;
import com.example.fishweightcalculator_simonstasovski.databinding.FragmentSaltWaterFishBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SaltWaterFishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaltWaterFishFragment extends Fragment {
    private static final DecimalFormat POUNDS_FORMAT = new DecimalFormat("0.00");
    private FragmentSaltWaterFishBinding binding;
    double weight;
    private final int NUMBER_OF_FISH_TYPES = 9;

    ArrayList<String> fishNames = new ArrayList<>(NUMBER_OF_FISH_TYPES);


    public SaltWaterFishFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SaltWaterFishFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SaltWaterFishFragment newInstance(String param1, String param2) {
        SaltWaterFishFragment fragment = new SaltWaterFishFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSaltWaterFishBinding.inflate(inflater, container, false);

        fishNames.add("Mackerel, Redfish, Snook, Corbina, Croaker, Blue");
        fishNames.add("Shark, Drum, Bluefish");
        fishNames.add("Snapper, Grouper, Seabass");
        fishNames.add("Perch, Pompano, Sheepshead, Rockfish");
        fishNames.add("Trout, Barracuda, Bonefish, Wahoo, Sturgeon");
        fishNames.add("Tuna");
        fishNames.add("Halibut, Flounder, Sole");
        fishNames.add("Sail, White Marlin");
        fishNames.add("Blue Marlin");

        for (String fishName : fishNames) {
            RadioButton r = new RadioButton(this.getContext());
            r.setText(fishName);
            binding.fishOptionSaltWaterRadioGroup.addView(r);
        }


        binding.saltWaterCalculateButton.setOnClickListener(v -> {
            recalculate(v);
        });

        return binding.getRoot();
    }

    public void recalculate(View v) {

        String displayResult;

        int radioButtonID = binding.fishOptionSaltWaterRadioGroup.getCheckedRadioButtonId();

        RadioButton radioButton = (RadioButton) binding.fishOptionSaltWaterRadioGroup.findViewById(radioButtonID);

        String selectedText = (String) radioButton.getText();

        if (binding.saltWaterLengthPlainText.getText().toString().length() == 0)
            binding.saltWaterLengthPlainText.setText(0);
        if (binding.saltWaterGirthPlainText.getText().toString().length() == 0)
            binding.saltWaterGirthPlainText.setText(0);

        switch (selectedText) {
            case "Mackerel, Redfish, Snook, Corbina, Croaker, Blue":
                weight = (Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterGirthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterGirthPlainText.getText().toString())) / 900;
                break;
            case "Shark, Drum, Bluefish":
                weight = Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterGirthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterGirthPlainText.getText().toString()) / 800;
                break;
            case "Snapper, Grouper, Seabass":
                weight = Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterGirthPlainText.getText().toString()) / 1200;
                break;
            case "Perch, Pompano, Sheepshead, Rockfish":
                weight = Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) / 1200;
                break;
            case "Trout, Barracuda, Bonefish, Wahoo, Sturgeon":
                weight = Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) / 3500;
                break;
            case "Tuna":
                weight = Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) / 1600;
                break;
            case "Halibut, Flounder, Sole":
                weight = Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) / 2500;
                break;
            case "Sail, White Marlin":
                weight = Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) / 5500;
                break;
            case "Blue Marlin":
                weight = Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) * Double.parseDouble(binding.saltWaterLengthPlainText.getText().toString()) / 2800;
                break;
            default:
                weight = 0;
        }
        displayResult = "Calculated Weight: " + POUNDS_FORMAT.format(weight) + " pounds.";

        binding.weightSaltWaterTextView.setText(displayResult);
}

public void onDestroy() {
        super.onDestroy();
    }
}
