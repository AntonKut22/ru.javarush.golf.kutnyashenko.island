package support;


import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import wildLife.Animals;

import java.io.IOException;
import java.util.*;

public final class WildLifeInitializer {

    private WildLifeInitializer() {
    }

    public static Map<String, Integer> initAllAtIsland() {

        Map<String, Integer> all = new HashMap<>();

        ImmutableSet<ClassPath.ClassInfo> set = null;
        try {
            set = ClassPath.from(Animals.class.getClassLoader()).getAllClasses();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        addWildLifeAtMap(all, set);
        return all;
    }

    private static void addWildLifeAtMap(Map<String, Integer> all, ImmutableSet<ClassPath.ClassInfo> set) {
        for (ClassPath.ClassInfo classInfo : set) {
            if (classInfo.getPackageName().equals("wildLife.herbivores")
                    || classInfo.getPackageName().equals("wildLife.predators")
                    || classInfo.getPackageName().equals("wildLife.herb")) {
                all.put(classInfo.getSimpleName(), 0);
            }
        }
    }
}
