package support;


import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import wildLife.Animals;

import java.io.IOException;
import java.util.*;

public final class InitAll {

//    private Map<String, Integer> initAll;



    public static Map<String, Integer> initAllAtIsland() {

        Map<String, Integer> all = new HashMap<>();
//        all.put("Herb", 0);

        ImmutableSet<ClassPath.ClassInfo> set = null;
        try {
            set = ClassPath.from(Animals.class.getClassLoader()).getAllClasses();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (ClassPath.ClassInfo classInfo : set) {
            if (classInfo.getPackageName().equals("wildLife.herbivores")
                    || classInfo.getPackageName().equals("wildLife.predators")
                    || classInfo.getPackageName().equals("wildLife.herb")) {
                all.put(classInfo.getSimpleName(), 0);
            }
        }
        return all;
    }
}
