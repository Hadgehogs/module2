package lesson1;

import java.util.HashMap;
import java.util.Map;

public class lesson1 {

    public static <T> T getValue(Map<String, Object> map, String key)
    {
        return (T) map.get(key);

    }

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","Dima");
        map.put("age",37);

        String res=getValue(map,"age");

        System.out.print(res);
    }
}
