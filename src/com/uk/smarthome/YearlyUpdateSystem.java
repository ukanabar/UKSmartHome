package com.uk.smarthome;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class YearlyUpdateSystem {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void scheduleYearlyUpdate(Appliance... appliances) {
        Calendar now = Calendar.getInstance();
        Calendar firstUpdate = Calendar.getInstance();
        firstUpdate.set(Calendar.MONTH, Calendar.JANUARY);
        firstUpdate.set(Calendar.DAY_OF_MONTH, 1);
        firstUpdate.set(Calendar.HOUR_OF_DAY, 1);
        firstUpdate.set(Calendar.MINUTE, 0);
        firstUpdate.set(Calendar.SECOND, 0);

        if (now.after(firstUpdate)) {
            firstUpdate.add(Calendar.YEAR, 1);
        }

        long initialDelay = firstUpdate.getTimeInMillis() - now.getTimeInMillis();
        long oneYearInMillis = 365L * 24 * 60 * 60 * 1000;

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Yearly update started.");
            for (Appliance appliance : appliances) {
                appliance.turnOff();
            }
            System.out.println("All appliances turned off for yearly update.");
        }, initialDelay, oneYearInMillis, TimeUnit.MILLISECONDS);
    }
}
