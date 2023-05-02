package com.javarefresher.week05.solidprinciples;

// class Computer{
//     private final WiredKeyboard keyboard;
//     private final WiredMouse mouse;
// }
// class WiredKeyboard {}
// class WiredMouse {}
// But above computer class wont work with modern equipments like wireless keyboard, wireless mouse 
// as they are tightly coupled

//Solution:
class Computer1{
    private final Keyboard keyboard;
    private final Mouse mouse;
    public Computer1(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}

interface Keyboard{}
class WiredKeyboard implements Keyboard{}
class WiredLessKeyboard implements Keyboard {}

interface Mouse{}
class WiredMouse implements Mouse{}
class WireLessMouse implements Mouse{}


public class D {
    
}
