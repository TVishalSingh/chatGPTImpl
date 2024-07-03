package com.guixt.liquidui.android.handsfree.ai.luihandsfreewithopenai;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ChoiceDao {
    @Insert
    void insert(ChoiceEntity choiceEntity);
    @Insert
    void insertAll(List<ChoiceEntity> choices);

    @Query("SELECT * FROM ChoiceEntity")
    List<ChoiceEntity> getAllChoices();
}
