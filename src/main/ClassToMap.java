package main;

import testClasses.MyClass;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassToMap {

    public static Map<String, String> objectToMap(Object object) {


        Field[] declaredFields = object.getClass().getDeclaredFields();

        String[] keys = Arrays.stream(declaredFields).map(Field::getName).toArray(String[]::new);

        Arrays.stream(declaredFields).forEach((Field a) -> a.setAccessible(true));

        String[] values = Arrays.stream(declaredFields)
                .map((Field a) -> getParamValue(a, object))
                .toArray(String[]::new);

        Map<String, String> mapFromClass = new HashMap<>();

        for (int i = 0; i < keys.length; i++) {

            mapFromClass.put(keys[i], values[i]);
        }

        return mapFromClass;

    }

    static String getParamValue(Field field, Object object) {

        String a = "";
        try {
            return  a = a + String.valueOf(field.get(object));
        } catch (IllegalAccessException | ClassCastException e) {
            e.printStackTrace();
        }

        return a;
    }

    public static void main(String[] args) {

        MyClass myClass = new MyClass("name", 12, 12345, "nick");

        List<Map<String, String>> maps = Arrays.asList(objectToMap(myClass));

        maps.stream().forEach(System.out::println);
    }

    }

