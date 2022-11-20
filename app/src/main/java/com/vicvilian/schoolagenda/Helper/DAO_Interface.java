package com.vicvilian.schoolagenda.Helper;

import com.vicvilian.schoolagenda.Model.MyModel;

public interface DAO_Interface {
    Boolean saveUserTask(MyModel data);
    Boolean writeUserTask(MyModel data);
    Boolean getAllUserTask(MyModel data);
    Boolean updateUserTask(MyModel data);
    Boolean removeUserTask(MyModel data);
}
