package com.uk.smarthome;

public class Fan implements Appliance {
    private int speed;

    @Override
    public void turnOn() {
        turnOn(1); // Default to speed 1 if no parameter is provided
    }

    public void turnOn(int speed) {
        if (speed < 1 || speed > 2) {
            throw new IllegalArgumentException("Speed must be 1 or 2.");
        }
        this.speed = speed;
        System.out.println("Fan is turned on at speed " + speed + ".");
    }

    @Override
    public void turnOff() {
        speed = 0;
        System.out.println("Fan is turned off by setting speed to 0.");
    }
}
