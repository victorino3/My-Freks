package com.vicvilian.schoolagenda.Helper;

import com.vicvilian.schoolagenda.Model.MyModel;

import java.util.List;

public interface DAO_Interface {
    Boolean saveUserTask(MyModel data);
    Boolean writeUserTask(MyModel data);
    List<MyModel> getAllUserTask();
    List<MyModel> loginUser();
    List<MyModel> register();
    Boolean updateUserTask(MyModel data);
    Boolean removeUserTask(MyModel data);
}
