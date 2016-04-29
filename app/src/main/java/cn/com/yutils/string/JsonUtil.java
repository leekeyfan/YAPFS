package cn.com.yutils.string;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lee on 16/4/29.
 */
public class JsonUtil {
    private static Gson gson = null;

    static {
        if(gson == null) {
            gson = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
        }

    }

    private JsonUtil() {
    }

    public static String objectToJson(Object ts) {
        String jsonStr = null;
        if(gson != null) {
            jsonStr = gson.toJson(ts);
        }

        return jsonStr;
    }

    public static String objectToJsonDateSerializer(Object ts, final String dateformat) {
        String jsonStr = null;
        gson = (new GsonBuilder()).registerTypeHierarchyAdapter(Date.class, new JsonSerializer() {
            @Override
            public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
                return null;
            }

            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                SimpleDateFormat format = new SimpleDateFormat(dateformat);
                return new JsonPrimitive(format.format(src));
            }
        }).setDateFormat(dateformat).create();
        if(gson != null) {
            jsonStr = gson.toJson(ts);
        }

        return jsonStr;
    }

    public static List<?> jsonToList(String jsonStr) {
        jsonStr = stringFormat(jsonStr);
        List objList = null;
        if(gson != null) {
            Type type = (new TypeToken() {
            }).getType();
            objList = (List)gson.fromJson(jsonStr, type);
        }

        return objList;
    }

    public static List<?> jsonToList(String jsonStr, Type type) {
        jsonStr = stringFormat(jsonStr);
        List objList = null;
        if(gson != null) {
            objList = (List)gson.fromJson(jsonStr, type);
        }

        return objList;
    }

    public static Map<?, ?> jsonToMap(String jsonStr) {
        jsonStr = stringFormat(jsonStr);
        Map objMap = null;
        if(gson != null) {
            Type type = (new TypeToken() {
            }).getType();
            objMap = (Map)gson.fromJson(jsonStr, type);
        }

        return objMap;
    }

    public static Object jsonToBean(String jsonStr, Class<?> cl) {
        jsonStr = stringFormat(jsonStr);
        Object obj = null;
        if(gson != null) {
            obj = gson.fromJson(jsonStr, cl);
        }

        return obj;
    }

//    public static <T> T jsonToBeanDateSerializer(String jsonStr, Class<T> cl, final String pattern) {
//        jsonStr = stringFormat(jsonStr);
//        Object obj = null;
//        gson = (new GsonBuilder()).registerTypeAdapter(Date.class, new JsonDeserializer() {
//            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                SimpleDateFormat format = new SimpleDateFormat(pattern);
//                String dateStr = json.getAsString();
//
//                try {
//                    return format.parse(dateStr);
//                } catch (ParseException var7) {
//                    var7.printStackTrace();
//                    return null;
//                }
//            }
//        }).setDateFormat(pattern).create();
//        if(gson != null) {
//            obj = gson.fromJson(jsonStr, cl);
//        }
//
//        return obj;
//    }

    public static Object getJsonValue(String jsonStr, String key) {
        jsonStr = stringFormat(jsonStr);
        Object rulsObj = null;
        Map rulsMap = jsonToMap(jsonStr);
        if(rulsMap != null && rulsMap.size() > 0) {
            rulsObj = rulsMap.get(key);
        }

        return rulsObj;
    }

    private static String stringFormat(String jsonStr) {
        jsonStr = jsonStr.replaceAll("\\\\n", "\n");
        jsonStr = jsonStr.replace("\\", "");
        if(jsonStr.startsWith("\"")) {
            jsonStr = jsonStr.substring(1, jsonStr.length());
        }

        if(jsonStr.endsWith("\"")) {
            jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
        }

        return jsonStr;
    }
}
