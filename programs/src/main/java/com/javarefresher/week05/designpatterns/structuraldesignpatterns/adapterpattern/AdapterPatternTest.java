package com.javarefresher.week05.designpatterns.structuraldesignpatterns.adapterpattern;

// Use the Adapter class when you want to use some existing class, 
// but its interface isn’t compatible with the rest of your code.

class RoundHole{
    private double radius;

    public RoundHole() {
    }
    public RoundHole(double radius) {
        this.radius = radius;
    }
        
    public double getRadius() {
        return radius;
    }
    public void fits(RoundPeg roundPeg){
        if(this.getRadius() - roundPeg.getRadius() >= 0){
            System.out.println("Given peg fits inside the hole");
            return;
        }
        System.out.println("Given peg does not fit inside the hole");
    }
}
class RoundPeg{
    private double radius;

    public RoundPeg() {}

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class SquarePeg{
    private double width;
    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}

class SquarePegAdapter extends RoundPeg{
    private SquarePeg squarePeg;
    public SquarePegAdapter(SquarePeg peg) {
        this.squarePeg = peg;
    }

    @Override
    public double getRadius() {
        double radius;
        radius = (Math.sqrt(Math.pow((squarePeg.getWidth() / 2), 2) * 2));
        return radius;
    }
}

public class AdapterPatternTest {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(10);
        RoundPeg roundPeg = new RoundPeg(5);

        roundHole.fits(roundPeg);

        SquarePeg squarePeg = new SquarePeg(2);


        // roundHole.fits(squarePeg); // Required operation, but fails as squarePeg is not RoundPeg

        SquarePegAdapter spAdapter = new SquarePegAdapter(squarePeg);
        
        roundHole.fits(spAdapter);
    }
}
