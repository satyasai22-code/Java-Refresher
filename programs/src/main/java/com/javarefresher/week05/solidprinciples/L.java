package com.javarefresher.week05.solidprinciples;

//Liskov Substitution says that every subclass or derived class should be substitutable for their base or parent class.
interface Car {

    void turnOnEngine();
    void accelerate();
}

class MotorCar implements Car {
    class Engine{
        public void on() {
            System.out.println("Engine is on");
        }

        public void powerOn(int i) {
            System.out.println("Power increased by " + i);
        }
    }
    private Engine engine;
    public MotorCar(Engine engine) {
        this.engine = engine;
    }
    public void turnOnEngine() {
        engine.on();
    }
    public void accelerate() {
        engine.powerOn(1000);
    }
}

class ElectricCar implements Car {

    public void turnOnEngine() {
        throw new AssertionError("I don't have an engine!");
    }

    public void accelerate() {
        
    }
}


public class L {
    public static void main(String[] args) {
        
    }    
}
