package com.example.e_okul.viewmodel;

// SharedViewModel.java
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OgretmenViewModel extends ViewModel {
    private final MutableLiveData<String> teacherName = new MutableLiveData<>();
    private final MutableLiveData<String> teacherLastName= new MutableLiveData<>();
    private final MutableLiveData<String> teacherBranch= new MutableLiveData<>();
    private final MutableLiveData<Integer> teacherId=new MutableLiveData<>();


    public MutableLiveData<Integer> getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Integer id){
        teacherId.setValue(id);
    }

    public void setTeacherName(String name) {teacherName.setValue(name);}
    public LiveData<String> getTeacherName() {return teacherName;}

    public void setTeacherLastName(String lastname){teacherLastName.setValue(lastname);}
    public LiveData<String> getTeacherLastName(){return teacherLastName;}


    public void setTeacherBranch(String branch){teacherBranch.setValue(branch);}
    public LiveData<String> getTeacherBranch() {return teacherBranch;}


}
