package main;

import testClasses.MyClass;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapToClass {

    public static void mapToClass (Map<String, String> map, Object object) throws NoSuchFieldException, IllegalAccessException {

        for (String key : map.keySet()) {

            Field field = object.getClass().getDeclaredField(key);

            field.setAccessible(true);

            Class<?> type = field.getType();

            if (type == int.class || type == Integer.class) {

                field.set(object, Integer.valueOf(map.get(key)));

            } else if (type == String.class) {

                field.set(object, type.cast(map.get(key)));

            } else if (type == long.class || type == Long.class) {

                field.set(object, Long.valueOf(map.get(key)));

            } else if (type == boolean.class || type == Boolean.class) {

                field.set(object, Boolean.valueOf(map.get(key)));

            } else if (type == double.class || type == Double.class) {

                field.set(object, Double.valueOf(map.get(key)));

            }

        }

    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Map<String, String> map = new HashMap<>();

        map.put("nick", "user");

        map.put("number", "12345");

        map.put("name", "bob");

        map.put("id", "1");

        MyClass expected = new MyClass("bob", 1, 12345, "user");

        MyClass myClass = new MyClass();

        mapToClass(map, myClass);

        System.out.println(expected.equals(myClass));

    }
}
