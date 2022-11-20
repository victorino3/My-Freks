package com.vicvilian.schoolagenda.Model;

public class MyModel {
    private String titleUserData;
    private String startAt;
    private String start_time;
    private String taskType;
    private String colleagues_email;
    private String teacherUserData;
    private String curricular_Unit;

    public MyModel(String titleUserData, String startAt, String start_time, String taskType,String curricular_Unit, String colleagues_email, String teacherUserData) {
        this.titleUserData = titleUserData;
        this.startAt = startAt;
        this.start_time = start_time;
        this.taskType = taskType;
        this.curricular_Unit = curricular_Unit;
        this.colleagues_email = colleagues_email;
        this.teacherUserData = teacherUserData;

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
}
