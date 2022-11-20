package com.vicvilian.schoolagenda.Helper;

import com.vicvilian.schoolagenda.Model.MyModel;

public interface DAO_Interface {
    void saveUserTask(MyModel data);
    void writeUserTask(MyModel data);
    void getAllUserTask(MyModel data);
    void updateUserTask(MyModel data);
    void removeUserTask(MyModel data);
}
