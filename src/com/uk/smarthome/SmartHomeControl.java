package com.uk.smarthome;

public class SmartHomeControl {
    public static void main(String[] args) {
        Appliance light = new Light();
        Appliance fan = new Fan();
        Appliance ac = new AirConditioner();

        light.turnOn();
        fan.turnOn();
        ac.turnOn();

        YearlyUpdateSystem updateSystem = new YearlyUpdateSystem();
        updateSystem.scheduleYearlyUpdate(light, fan, ac);
    }
}
