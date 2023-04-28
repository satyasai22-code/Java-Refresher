package com.javarefresher.week05.designpatterns.creationaldesignpatterns.factorypattern;

/*
 Factory Method - It is a creational design pattern that provides
 an interface for creating objects in a superclass, but allows
 subclasses to alter the type of objects that will be created
*/

/*
Why (Problem its addressing)?
Adding a new class to the program isn’t that simple if the rest of the code
is already coupled to existing classes. 
*/

/*
 * How (Solution it provides)?
 * The Factory Method pattern suggests that you replace direct
 * object construction calls (using the new operator) with calls
 * to a special factory method. Don’t worry: the objects are still
 * created via the new operator, but it’s being called from within
 * the factory method. Objects returned by a factory method are
 * often referred to as “products.
 */


 /*
  When?
  - Use the Factory Method when you don’t know beforehand the
  exact types and dependencies of the objects your code should
  work with.
  - Use the Factory Method when you want to provide users of 
  your library or framework with a way to extend its internal
  components
  */
public class FactoryPattern {
    
}
