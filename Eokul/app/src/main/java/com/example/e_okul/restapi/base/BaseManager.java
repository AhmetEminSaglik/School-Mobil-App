package com.example.e_okul.restapi.base;

import com.example.e_okul.restapi.headmaster.abstracts.RestApiHeadMasterService;
import com.example.e_okul.restapi.student.abstracts.RestApiStudentService;
import com.example.e_okul.restapi.teacher.abstracts.RestApiTeacherService;
import com.example.e_okul.restapi.user.abstracts.RestApiUserService;


public class BaseManager {
    protected RestApiUserService getUserRestApiClient() {
        return RestApiClient.getUserRestApi(BaseUrl.USER_URL);
    }
    protected RestApiHeadMasterService getHeadMasterRestApiClient() {
        return RestApiClient.getHeadMasterRestApi(BaseUrl.HEADMASTER_URL);
    }

    protected RestApiStudentService getStudentRestApiClient() {
        return RestApiClient.getStudentRestApi(BaseUrl.STUDENT_URL);
    }

    protected RestApiTeacherService getTeacherRestApiClient() {
        return RestApiClient.getTeacherRestApi(BaseUrl.TEACHERS_URL);
    }
}
