package test;

import main.ClassToMap;
import org.junit.Test;
import testClasses.MyClass;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ClassToMapTest {

    @Test
    public void objectToMap() throws Exception {

        Map<String, String> expected = new HashMap<>();

        expected.put("nick", "user");

        expected.put("number", "12345");

        expected.put("name", "bob");

        expected.put("id", "1");

        Map<String, String> actual = ClassToMap.objectToMap(new MyClass("bob", 1, 12345, "user"));

        assertEquals(actual, expected);

    }

}
