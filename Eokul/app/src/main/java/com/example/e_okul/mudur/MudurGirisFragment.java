package com.example.e_okul.mudur;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.example.e_okul.R;
import com.example.e_okul.database.Mudur;
import com.example.e_okul.databinding.FragmentMudurGirisBinding;

public class MudurGirisFragment extends Fragment {

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

        binding.buttonLogin.setOnClickListener(view1 -> login());
    }

    private void login() {
        String userName = binding.editTextUsername.getText().toString();
        String password = binding.editTextPassword.getText().toString();
        EditText editText = binding.editTextPassword;

        // Veritabanından verileri çek
        Mudur mudur = new Mudur(editText);

        // Veri çekme işlemi tamamlandığında çağrılacak callback fonksiyonu
        mudur.setCallback(() -> {

            // Veritabanından alınan değerleri kontrol et
           // if (userName.equals(mudur.getName()) && password.equals(String.valueOf(mudur.getPassword()))) {
                navigateToSuccessFragment();
           // } else {
            //    Toast.makeText(requireContext(), "Hatalı Giriş", Toast.LENGTH_LONG).show();
            //}
        });

        // Veri çekme işlemini başlat
        mudur.getData();
    }


    private void navigateToSuccessFragment() {
        // Giriş başarılı ise SuccessFragment'a geçiş yap
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_mudurGirisFragment_to_mudurAnaSayfaFragment);
    }
}
