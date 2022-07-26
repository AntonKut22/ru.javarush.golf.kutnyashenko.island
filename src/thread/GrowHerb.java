package thread;

import island.Location;

import java.util.List;

public class GrowHerb implements Runnable{
//TODO Возможно этот класс нужно удалить
    private List<Location> locationList;

    public GrowHerb(List<Location> locationList) {
        this.locationList = locationList;
    }

    @Override
    public void run() {

        for (Location location : locationList) {
        }

    }
}
