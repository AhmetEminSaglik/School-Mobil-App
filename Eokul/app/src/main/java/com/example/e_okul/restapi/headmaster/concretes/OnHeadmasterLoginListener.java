package com.example.e_okul.restapi.headmaster.concretes;

import com.example.e_okul.model.HeadMaster;

public interface OnHeadmasterLoginListener {
    void loginSuccess(HeadMaster headMaster);
    void loginFailed();
}
