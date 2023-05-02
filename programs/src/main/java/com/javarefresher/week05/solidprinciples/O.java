package com.javarefresher.week05.solidprinciples;


class Ball {
    private int radius;
    private String materialType;
        //Constructors, getters & setters
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public String getMaterialType() {
        return materialType;
    }
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
}

//Shoud create separate class instead of modifying original class
class AllFormatBall extends Ball{
    private String ballColor;
}


// Objects or entities should be open for extension but closed for modification
public class O {
    
}
