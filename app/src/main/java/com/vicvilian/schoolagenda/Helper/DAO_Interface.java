package com.vicvilian.schoolagenda.Helper;

import com.vicvilian.schoolagenda.Model.MyModel;

import java.util.List;

public interface DAO_Interface {
    Boolean saveUserTask(MyModel data);
    Boolean writeUserTask(MyModel data);
    List<MyModel> getAllUserTask();
    Boolean updateUserTask(MyModel data);
    Boolean removeUserTask(MyModel data);
}
