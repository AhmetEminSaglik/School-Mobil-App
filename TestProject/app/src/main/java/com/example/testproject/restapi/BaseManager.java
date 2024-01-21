package com.example.testproject.restapi;

public class BaseManager {
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
