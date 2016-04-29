package com.lidroid.xutils.db.converter;

import android.database.Cursor;

import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class ByteArrayColumnConverter implements com.lidroid.xutils.db.converter.ColumnConverter<byte[]> {
    @Override
    public byte[] getFieldValue(final Cursor cursor, int index) {
        return cursor.isNull(index) ? null : cursor.getBlob(index);
    }

    @Override
    public byte[] getFieldValue(String fieldStringValue) {
        return null;
    }

    @Override
    public Object fieldValue2ColumnValue(byte[] fieldValue) {
        return fieldValue;
    }

    @Override
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.BLOB;
    }
}
