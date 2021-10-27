package com.example.aadharshala2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.aadharshala2.databinding.ActivityLoginBinding;
import com.example.aadharshala2.databinding.FragmentAskPermitBinding;
import com.example.aadharshala2.ui.login.LoginViewModel;
import com.example.aadharshala2.ui.login.LoginViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link askForPermit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class askForPermit extends Fragment {

    private FragmentAskPermitBinding binding2;

    public askForPermit() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment askForPermit.
     */
    // TODO: Rename and change types and number of parameters
    public static askForPermit newInstance() {
        askForPermit fragment = new askForPermit();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ask_permit, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding2 = FragmentAskPermitBinding.inflate(getLayoutInflater());




        final EditText usernameEditText = binding2.username;
        final Button loginButton = binding2.sendRequest;


        }



}