package com.example.e_okul.viewmodel;

// SharedViewModel.java
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OgrenciViewModel extends ViewModel {
    private final MutableLiveData<String> studentName = new MutableLiveData<>();
    private final MutableLiveData<String> studentLastname= new MutableLiveData<>();
    private final MutableLiveData<String> studentNo= new MutableLiveData<>();
    private final MutableLiveData<String> studentUserName= new MutableLiveData<>();
    private final MutableLiveData<String> studentPassword= new MutableLiveData<>();

    private final MutableLiveData<Integer> studentId=new MutableLiveData<>();



    public MutableLiveData<Integer> getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer id){
        studentId.setValue(id);
    }
    public void setStudentName(String name) {studentName.setValue(name);}
    public LiveData<String> getStudentName() {return studentName;}

    public MutableLiveData<String> getStudentUserName() {
        return studentUserName;
    }
    public void setStudentUserName(String username){studentUserName.setValue(username);}

    public void setStudentLastname(String lastname){studentLastname.setValue(lastname);}
    public LiveData<String> getStudentLastname(){return studentLastname;}

    public void setStudentNo(String no){studentNo.setValue(no);}
    public LiveData<String> getStudentNo() {return studentNo;}

    public void setStudentPassword(String password){studentPassword.setValue(password);}
    public LiveData<String> getStudentPassword(){return studentPassword;}


}
