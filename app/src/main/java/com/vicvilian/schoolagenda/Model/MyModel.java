package com.vicvilian.schoolagenda.Model;

public class MyModel {
    private String titleUserData;
    private String startAt;
    private String teacherUserData;
    private String timeLeft;

    public MyModel(String titleUserData, String startAt, String teacherUserData, String timeLeft) {
        this.titleUserData = titleUserData;
        this.startAt = startAt;
        this.teacherUserData = teacherUserData;
        this.timeLeft = timeLeft;
    }
    public static void insertData(){

    }
    public String getTitleUserData() {
        return titleUserData;
    }

    public void setTitleUserData(String titleUserData) {
        this.titleUserData = titleUserData;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getTeacherUserData() {
        return teacherUserData;
    }

    public void setTeacherUserData(String teacherUserData) {
        this.teacherUserData = teacherUserData;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }
}
