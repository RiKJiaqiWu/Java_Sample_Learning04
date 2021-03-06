package project.code07.UseMap;
import java.util.HashMap;
import java.util.Map;

public class UseMap {
    public static void main(String[] args) {

        Map<String, String> map = createMap(99);
        System.out.println(map.get("key20"));
        // 如果没有key，或者key可能对应的值就是null，那么就返回null
        System.out.println(map.get(new Object()));
        System.out.println(map.get("key999"));

        //注意：不是每种Map的实现都允许key或者value为null，使用时需要注意
        map.put(null, "value of null key");
        map.put("testnull", null);

        System.out.println("null key value:" + map.get(null));
        System.out.println("null value support:" + map.get("testnull"));

        //删除key
        System.out.println("--------------删除key--------------");

        String keyToRemove = "key9";
        System.out.println(keyToRemove + "对应的值是：" + map.get(keyToRemove));
        map.remove(keyToRemove);
        System.out.println("执行删除操作后，" + keyToRemove + "对应的值是：" + map.get(keyToRemove));

        System.out.println("--------------遍历key和value--------------");
        //通过Entry类遍历Map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key为：" + entry.getKey() + "，value为：" + entry.getValue());
        }

        System.out.println("--------------遍历value--------------");
        //通过Entry类遍历Map
        for (String value : map.values()) {
            System.out.println(value);
        }

        System.out.println("--------------遍历key--------------");
        //通过Entry类遍历Map
        for (String key : map.keySet()) {
            System.out.println(key);
        }

    }

    //创建 HashMap 实例，并按照泛型的定义，向里面放入key和value
    private static Map<String, String> createMap(int size) {
        Map<String, String> ret = new HashMap<>();
        for (int i = 0; i < size; i++) {
            //put的第一个为key，第二个为value
            ret.put("key" + i, String.valueOf(Math.random()));
        }
        return ret;
    }

}
