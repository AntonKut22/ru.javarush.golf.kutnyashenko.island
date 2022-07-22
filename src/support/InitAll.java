package support;


import com.google.common.reflect.ClassPath;
import org.reflections.Reflections;
import wildLife.Animals;

import java.util.*;

public class InitAll {

    private Map<String, Integer> initAll;


    public static Map<String, Integer> initAllAtIsland() {




        Reflections reflections = new Reflections("java.util");
        Set<Class<? extends List>> classes = reflections.getSubTypesOf(java.util.List.class);
        for (Class<? extends List> aClass : classes) {
            System.out.println(aClass.getName());
            if(aClass == ArrayList.class) {
                List list = null;
                try {
                    list = aClass.newInstance();
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                list.add("test");
                System.out.println(list.getClass().getName() + ": " + list.size());
            }
        }



//        Class clazz = Animals.class;
//        Reflections reflections = new Reflections("Animals", new SubTypesScanner());
//        Set<Animals> animals = reflections.getSubTypesOf(clazz);
        Map<String, Integer> all = new HashMap<>();
//        for (String s : all.keySet()) {
//            all.put(s.getClass().getSimpleName(), 1);
//        }
        return all;
    }
}
