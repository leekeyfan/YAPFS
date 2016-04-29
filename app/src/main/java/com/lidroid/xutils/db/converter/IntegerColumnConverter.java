package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import android.text.TextUtils;

import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class IntegerColumnConverter implements com.lidroid.xutils.db.converter.ColumnConverter<Integer> {
    @Override
    public Integer getFieldValue(final Cursor cursor, int index) {
        return cursor.isNull(index) ? null : cursor.getInt(index);
    }

    @Override
    public Integer getFieldValue(String fieldStringValue) {
        if (TextUtils.isEmpty(fieldStringValue)) return null;
        return Integer.valueOf(fieldStringValue);
    }

    @Override
    public Object fieldValue2ColumnValue(Integer fieldValue) {
        return fieldValue;
    }

    @Override
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }
}
