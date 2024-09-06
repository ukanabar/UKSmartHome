package com.uk.smarthome;

public class AirConditioner implements Appliance {
    private String mode;

    @Override
    public void turnOn() {
        mode = "cool"; // default mode
        System.out.println("Air Conditioner is turned on in cool mode.");
    }

    @Override
    public void turnOff() {
        mode = "off";
        System.out.println("Air Conditioner is turned off by setting mode to off.");
    }
}
