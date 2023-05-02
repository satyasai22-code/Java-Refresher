package com.javarefresher.week05.solidprinciples;

import javax.swing.Icon;

// interface RestaurantEmployee {
//     abstract void cookFood();
//     abstract String getBill(int id);
//     abstract String processBill(int id);
//     abstract void markAttendance(int id);
// }
// class WaiterClass implements RestaurantEmployee{

//     //I dont do
//     @Override
//     public void cookFood() {
//     }

//     @Override
//     public String getBill(int id) {
//         return "Bill is given";
//     }

//     //I dont do
//     @Override
//     public String processBill(int id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'takeBill'");
//     }


//     @Override
//     public void markAttendance(int id) {
//         System.out.println("Attendance marked");
//     }
// }

//Above code is wrong as waiter class does not implement all the methods

//Solution:
interface RestaurantEmployee{
    abstract void markAttendance(int id);
}
interface IWaiter extends RestaurantEmployee{
    abstract String getBill(int id);
}
class WaiterImpl implements IWaiter{

    @Override
    public void markAttendance(int id) {
        System.out.println("Attendance marked");
    }

    @Override
    public String getBill(int id) {
        return "Bill is given";
    }
}
interface IChef extends RestaurantEmployee{
    abstract void cookFood();
}
class ChefImpl implements IChef{

    @Override
    public void markAttendance(int id) {
        System.out.println("Attendance marked");
    }
    @Override
    public void cookFood() {
        System.out.println("Food is cooked");
    }
    
}
// A client should never be forced to implement an interface that it doesn’t use, 
// or clients shouldn’t be forced to depend on methods they do not use.
public class I {
    
}
