package island;

import support.RandomNumber;

public class WhatToDo implements Runnable{

    private Location[][] location;

    public WhatToDo(Location[][] location) {
        this.location = location;
    }

    @Override
    public void run() {
        for (int i = 0; i < location.length; i++) {
            for (int j = 0; j < location[i].length; j++) {
                location[i][j].run();
            }
        }
//        location.addHerb();
//        int activy = RandomNumber.get(3);

    }
}
