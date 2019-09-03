package com.emovakemenkes.framework.mvvm.data.model.db.puskesmas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "puskesmas")
public class Puskesmas {
    @PrimaryKey
    public Long id;
    public String name;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;

    @ColumnInfo(name = "created_at")
    public String createdAt;
}
