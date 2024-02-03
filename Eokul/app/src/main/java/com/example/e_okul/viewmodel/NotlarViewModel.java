package com.example.e_okul.viewmodel;

// SharedViewModel.java
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotlarViewModel extends ViewModel {
    private final MutableLiveData<String> vize = new MutableLiveData<>();
    private final MutableLiveData<String> _final= new MutableLiveData<>();
    private final MutableLiveData<String> dersAdi= new MutableLiveData<>();


    public MutableLiveData<String> getVize() {
        return vize;
    }
    public void setVize(String _vize){vize.setValue(_vize);}

    public MutableLiveData<String> get_final() {
        return _final;
    }
    public void set_final(String __final){_final.setValue(__final);
    }

    public MutableLiveData<String> getDersAdi() {
        return dersAdi;
    }
    public void setDersAdi(String _dersAdi){dersAdi.setValue(_dersAdi);}
}
