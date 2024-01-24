package com.example.e_okul.restapi.userfactory;

import android.util.Log;

import com.example.e_okul.model.EnumUserRoleId;
import com.example.e_okul.model.Student;
import com.example.e_okul.model.User;

public class UserFactory {

    public static User getUserByRoleId(User user) {
        if (user.getRoleId() == EnumUserRoleId.STUDENT.getId()) {
            Log.e("FACTORY : ",user.toString());
            Log.e("FACTORY : ",((Student)user).toString());

            return (Student) user;
        }
        return null;
    }
}
