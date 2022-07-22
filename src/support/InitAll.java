package support;


import com.google.common.reflect.ClassPath;
import org.reflections.Reflections;
import wildLife.Animals;
import wildLife.predators.Predator;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class InitAll {

    private Map<String, Integer> initAll;


    public static Map<String, Integer> initAllAtIsland() {

        Map<String, Integer> all = new HashMap<>();

        try {
            List<Animals> list = ClassPath.from(Animals.class.getClassLoader()).getAllClasses().stream()
                    .filter()
        } catch (IOException e) {
            throw new RuntimeException(e);


            return all;
        }
    }
}
