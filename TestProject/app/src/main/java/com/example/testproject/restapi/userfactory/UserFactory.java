package com.example.testproject.restapi.userfactory;

import android.util.Log;

import com.example.testproject.model.EnumUserRoleId;
import com.example.testproject.model.Student;
import com.example.testproject.model.User;

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
