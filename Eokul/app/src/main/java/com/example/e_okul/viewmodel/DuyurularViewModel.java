package com.example.e_okul.viewmodel;

// SharedViewModel.java
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DuyurularViewModel extends ViewModel {
    private final MutableLiveData<String> duyuruBaslik = new MutableLiveData<>();
    private final MutableLiveData<String> duyuruIcerik= new MutableLiveData<>();



    public MutableLiveData<String> getDuyuruBaslik() {return duyuruBaslik;}
    public void setDuyuruBaslik(String baslik){duyuruBaslik.setValue(baslik);}

    public MutableLiveData<String> getDuyuruIcerik() {
        return duyuruIcerik;
    }
    public void setDuyuruIcerik(String icerik){duyuruIcerik.setValue(icerik);}

}
