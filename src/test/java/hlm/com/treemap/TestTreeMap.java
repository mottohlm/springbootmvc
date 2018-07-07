package hlm.com.treemap;

import java.util.List;
import java.util.TreeMap;

public class TestTreeMap {

    public static void main(String[] args){

        MyTreeMap mtm = new MyTreeMap();

        mtm.put(8,"小明8");
        mtm.put(6,"小明6");
        mtm.put(5,"小明5");
        mtm.put(7,"小明7");
        mtm.put(10,"小明10");
        mtm.put(15,"小明15");
        mtm.put(9,"小明9");
        mtm.put(12,"小明12");
        mtm.put(2,"小明2");
        mtm.put(1,"小明1");



        List<Object> i = mtm.listNode();
        for(Object o : i){
            System.out.println(o);
        }
        System.out.println(mtm.get(5));
        System.out.println(mtm.get(8));


    }
}

