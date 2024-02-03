package com.example.e_okul.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MudurViewModel extends ViewModel {

    private final MutableLiveData<String> headMasterName = new MutableLiveData<>();
    private final MutableLiveData<String> headMasterLastname= new MutableLiveData<>();
    private final MutableLiveData<String> headMasterUserName= new MutableLiveData<>();




    public void setHeadMasterName(String name) {headMasterName.setValue(name);}
    public LiveData<String> getHeadMasterName() {return headMasterName;}

    public MutableLiveData<String> getHeadMasterUserName() {
        return headMasterUserName;
    }
    public void setHeadMasterUserName(String username){headMasterName.setValue(username);}

    public void setHeadMasterLastname(String lastname){headMasterLastname.setValue(lastname);}
    public LiveData<String> getHeadMasterLastName(){return headMasterLastname;}



}
