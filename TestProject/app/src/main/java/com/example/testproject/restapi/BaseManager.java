package com.example.testproject.restapi;

public class BaseManager {
/*
    protected RestApiUserService getUserRestApiClient() {
        return RestApiClient.getUserRestApi(BaseUrl.USER_URL);
    }

    protected RestApiBookService getBookRestApiClient() {
        return RestApiClient.getBookRestApi(BaseUrl.BOOK_URL);
    }
*/

    protected RestApiTeacherService getTeacherRestApiClient() {
        return RestApiClient.getTeacherRestApi(BaseUrl.TEACHERS_URL);
    }
}
