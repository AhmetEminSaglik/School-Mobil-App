package com.example.e_okul.view.mudur;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.e_okul.R;
import com.example.e_okul.databinding.FragmentMudurGirisBinding;
import com.example.e_okul.model.HeadMaster;
import com.example.e_okul.model.LoginCredentials;
import com.example.e_okul.restapi.headmaster.concretes.ManagerAllHeadMaster;
import com.example.e_okul.restapi.headmaster.concretes.OnGetHeadmasterByUsernameListener;
import com.example.e_okul.restapi.headmaster.concretes.OnHeadmasterLoginListener;


public class MudurGirisFragment extends Fragment implements OnGetHeadmasterByUsernameListener, OnHeadmasterLoginListener {

    private FragmentMudurGirisBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMudurGirisBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LoginCredentials loginCredentials = new LoginCredentials();
        ManagerAllHeadMaster managerAllHeadMaster = ManagerAllHeadMaster.getInstance(getContext());


        binding.buttonLogin.setOnClickListener(view1 -> {
            loginCredentials.setUsername(binding.editTextUsername.getText().toString());
            loginCredentials.setPassword(binding.editTextPassword.getText().toString());

            managerAllHeadMaster.getHeadmasterByUsername(loginCredentials.getUsername(), loginCredentials, this);
            managerAllHeadMaster.login(this, loginCredentials);

        });

    }


    @Override
    public void success() {}

    @Override
    public void failed() {}

    @Override
    public void loginSuccess(HeadMaster headMaster) {
        if (binding.editTextUsername.getText().toString().equals(headMaster.getUsername()) &&
                binding.editTextPassword.getText().toString().equals(headMaster.getPassword())) {

             NavController navController = Navigation.findNavController(requireView());
             navController.navigate(R.id.action_mudurGirisFragment_to_mudurAnaSayfaFragment);

        }
    }
    @Override
    public void loginFailed() {

    }
}
