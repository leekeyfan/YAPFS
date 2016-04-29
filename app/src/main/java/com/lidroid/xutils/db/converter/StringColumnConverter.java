package com.lidroid.xutils.db.converter;

import android.database.Cursor;

import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class StringColumnConverter implements com.lidroid.xutils.db.converter.ColumnConverter<String> {
    @Override
    public String getFieldValue(final Cursor cursor, int index) {
        return cursor.isNull(index) ? null : cursor.getString(index);
    }

    @Override
    public String getFieldValue(String fieldStringValue) {
        return fieldStringValue;
    }

    @Override
    public Object fieldValue2ColumnValue(String fieldValue) {
        return fieldValue;
    }

    @Override
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.TEXT;
    }
}
