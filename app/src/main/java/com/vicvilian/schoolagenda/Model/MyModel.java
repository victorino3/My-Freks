package com.vicvilian.schoolagenda.Model;

public class MyModel {
    private String titleUserData;
    private String startAt;
    private String start_time;
    private String taskType;
    private String colleagues_email;
    private String teacherUserData;
    private String curricular_Unit;
    private String emailUser;
    private String password;

    public MyModel(String emailUser, String password) {
        this.emailUser = emailUser;
        this.password = password;
    }

    public MyModel(String titleUserData, String startAt, String start_time, String taskType, String curricular_Unit, String teacherUserData, String colleagues_email) {
        this.titleUserData = titleUserData;
        this.startAt = startAt;
        this.start_time = start_time;
        this.taskType = taskType;
        this.curricular_Unit = curricular_Unit;
        this.colleagues_email = colleagues_email;
        this.teacherUserData = teacherUserData;

    }
    public MyModel(String titleUserData, String startAt, String start_time, String taskType) {
        this.titleUserData = titleUserData;
        this.startAt = startAt;
        this.start_time = start_time;
        this.taskType = taskType;


    }

    public MyModel() {}

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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getColleagues_email() {
        return colleagues_email;
    }

    public void setColleagues_email(String colleagues_email) {
        this.colleagues_email = colleagues_email;
    }

    public String getCurricular_Unit() {
        return curricular_Unit;
    }

    public void setCurricular_Unit(String curricular_Unit) {
        this.curricular_Unit = curricular_Unit;
    }
    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
