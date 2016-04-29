/*
 * Copyright (c) 2013. wyouflf (wyouflf@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lidroid.xutils.http.client.multipart;

import java.util.*;

/**
 * The header of an entity (see RFC 2045).
 */
class MinimalFieldHeader implements Iterable<com.lidroid.xutils.http.client.multipart.MinimalField> {

    private final List<com.lidroid.xutils.http.client.multipart.MinimalField> fields;
    private final Map<String, List<com.lidroid.xutils.http.client.multipart.MinimalField>> fieldMap;

    public MinimalFieldHeader() {
        super();
        this.fields = new LinkedList<com.lidroid.xutils.http.client.multipart.MinimalField>();
        this.fieldMap = new HashMap<String, List<com.lidroid.xutils.http.client.multipart.MinimalField>>();
    }

    public void addField(final com.lidroid.xutils.http.client.multipart.MinimalField field) {
        if (field == null) {
            return;
        }
        String key = field.getName().toLowerCase(Locale.US);
        List<com.lidroid.xutils.http.client.multipart.MinimalField> values = this.fieldMap.get(key);
        if (values == null) {
            values = new LinkedList<com.lidroid.xutils.http.client.multipart.MinimalField>();
            this.fieldMap.put(key, values);
        }
        values.add(field);
        this.fields.add(field);
    }

    public List<com.lidroid.xutils.http.client.multipart.MinimalField> getFields() {
        return new ArrayList<com.lidroid.xutils.http.client.multipart.MinimalField>(this.fields);
    }

    public com.lidroid.xutils.http.client.multipart.MinimalField getField(final String name) {
        if (name == null) {
            return null;
        }
        String key = name.toLowerCase(Locale.US);
        List<com.lidroid.xutils.http.client.multipart.MinimalField> list = this.fieldMap.get(key);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    public List<com.lidroid.xutils.http.client.multipart.MinimalField> getFields(final String name) {
        if (name == null) {
            return null;
        }
        String key = name.toLowerCase(Locale.US);
        List<com.lidroid.xutils.http.client.multipart.MinimalField> list = this.fieldMap.get(key);
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        } else {
            return new ArrayList<com.lidroid.xutils.http.client.multipart.MinimalField>(list);
        }
    }

    public int removeFields(final String name) {
        if (name == null) {
            return 0;
        }
        String key = name.toLowerCase(Locale.US);
        List<com.lidroid.xutils.http.client.multipart.MinimalField> removed = fieldMap.remove(key);
        if (removed == null || removed.isEmpty()) {
            return 0;
        }
        this.fields.removeAll(removed);
        return removed.size();
    }

    public void setField(final com.lidroid.xutils.http.client.multipart.MinimalField field) {
        if (field == null) {
            return;
        }
        String key = field.getName().toLowerCase(Locale.US);
        List<com.lidroid.xutils.http.client.multipart.MinimalField> list = fieldMap.get(key);
        if (list == null || list.isEmpty()) {
            addField(field);
            return;
        }
        list.clear();
        list.add(field);
        int firstOccurrence = -1;
        int index = 0;
        for (Iterator<com.lidroid.xutils.http.client.multipart.MinimalField> it = this.fields.iterator(); it.hasNext(); index++) {
            com.lidroid.xutils.http.client.multipart.MinimalField f = it.next();
            if (f.getName().equalsIgnoreCase(field.getName())) {
                it.remove();
                if (firstOccurrence == -1) {
                    firstOccurrence = index;
                }
            }
        }
        this.fields.add(firstOccurrence, field);
    }

    public Iterator<com.lidroid.xutils.http.client.multipart.MinimalField> iterator() {
        return Collections.unmodifiableList(fields).iterator();
    }

    @Override
    public String toString() {
        return this.fields.toString();
    }

}

