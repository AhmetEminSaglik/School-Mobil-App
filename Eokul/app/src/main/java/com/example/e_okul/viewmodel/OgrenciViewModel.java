package com.example.e_okul.viewmodel;

// SharedViewModel.java
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OgrenciViewModel extends ViewModel {
    private final MutableLiveData<String> studentName = new MutableLiveData<>();
    private final MutableLiveData<String> studentSurname= new MutableLiveData<>();
    private final MutableLiveData<Long> stuntTc_kn = new MutableLiveData<>();
    private final MutableLiveData<Integer> studentNo= new MutableLiveData<>();
    private final MutableLiveData<String> studentParentName = new MutableLiveData<>();



    public void setStudentName(String name) {studentName.setValue(name);}
    public LiveData<String> getStudentName() {return studentName;}

    public void setStudentSurname(String surname){studentSurname.setValue(surname);}
    public LiveData<String> getStudentSurname(){return studentSurname;}
    public  void setStudentTc_kn(long tc_kn){stuntTc_kn.setValue(tc_kn);}

    public LiveData<Long> getStudenTc_kn() {return stuntTc_kn;
    }

    public void setStudentNo(int no){studentNo.setValue(no);}
    public LiveData<Integer> getStudentNo() {return studentNo;}

    public void setParentName(String parentName){studentParentName.setValue(parentName);}

    public LiveData<String> getStudentParentName() {return studentParentName;}
}
