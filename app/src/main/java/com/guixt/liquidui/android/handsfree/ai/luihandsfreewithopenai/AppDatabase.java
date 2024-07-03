package com.guixt.liquidui.android.handsfree.ai.luihandsfreewithopenai;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {ChoiceEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ChoiceDao choiceDao();
}


