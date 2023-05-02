package com.javarefresher.week05.designpatterns.structuraldesignpatterns.bridgepattern;



// Strategy: you have more ways for doing an operation; with strategy, you can choose the algorithm at run-time and you can modify a single Strategy without a lot of side-effects at compile-time;
// Bridge: you can split the hierarchy of interface and class, join it with an abstract reference


// abstract class LivingThing{
//     abstract public void breathe();
// }

// class Dog extends LivingThing{
//     @Override
//     public void breathe() {
//        System.out.println("Land Breathing Technique");
//     }
// }
// class Man extends LivingThing{

//     @Override
//     public void breathe() {
//         System.out.println("Land Breathing Technique");
//     }
// }
// class Tree extends LivingThing{
//     @Override
//     public void breathe() {
//         System.out.println("Tree Breathing Technique");
//     }
// }
// class Fish extends LivingThing{
//     @Override
//     public void breathe() {
//         System.out.println("Water Breathing Technique");
//     }
// }
//Problem : Dog, Man has similar breathing technique where as Fish and Tree has different technique
// Difficul to separate the abstraction and implemention in this way.

//Solution:

interface BreatheImpl{
    public void breathe();
}

class LandBreatheImpl implements BreatheImpl{

    @Override
    public void breathe() {
        System.out.println("Land Breathing Technique");
    }
}
class WaterBreatheImpl implements BreatheImpl{

    @Override
    public void breathe() {
        System.out.println("Water Breathing Technique");
    }
}
class TreeBreatheImpl implements BreatheImpl{
    @Override
    public void breathe() {
        System.out.println("Tree Breathing Technique");
    }
}
abstract class LivingThing{
    protected BreatheImpl breatheImpl;
    public LivingThing(BreatheImpl breathImpl){
        this.breatheImpl = breathImpl;
    }   
    abstract public void breathe();
}

class Dog extends LivingThing{
    
    public Dog(BreatheImpl breathImpl) {
        super(breathImpl);
    }

    @Override
    public void breathe() {
       breatheImpl.breathe();
    }
}

class Man extends LivingThing{
    public Man(BreatheImpl breathImpl) {
        super(breathImpl);
    }
    @Override
    public void breathe() {
        breatheImpl.breathe();
    }
}
class Tree extends LivingThing{
    public Tree(BreatheImpl breathImpl) {
        super(breathImpl);
    }
    @Override
    public void breathe() {
        breatheImpl.breathe();
    }
}
class Fish extends LivingThing{
    public Fish(BreatheImpl breathImpl) {
        super(breathImpl);
    }
    @Override
    public void breathe() {
        breatheImpl.breathe();
    }
}

public class BridgePatternTest {
    public static void main(String[] args) {
        Dog dog = new Dog(new LandBreatheImpl());
        Man man = new Man(new LandBreatheImpl());
        Fish fish = new Fish(new WaterBreatheImpl());
        Tree tree =  new Tree(new TreeBreatheImpl());
        dog.breathe();
        man.breathe();
        fish.breathe();
        tree.breathe();
    }
}
