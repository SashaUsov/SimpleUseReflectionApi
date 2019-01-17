package test;

import main.MapToClass;
import org.junit.Test;
import testClasses.MyClass;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MapToClassTest {

    @Test
    public void mapToClass() throws Exception {

        MyClass expected = new MyClass("bob", 1, 12345, "user");

        Map<String, String> map = new HashMap<>();

        map.put("nick", "user");

        map.put("number", "12345");

        map.put("name", "bob");

        map.put("id", "1");

        MyClass actual = new MyClass();

        MapToClass.mapToClass(map, actual);

        assertEquals(expected, actual);

    }

}
