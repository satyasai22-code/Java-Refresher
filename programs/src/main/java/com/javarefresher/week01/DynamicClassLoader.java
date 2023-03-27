package com.javarefresher.week01;
import java.lang.reflect.Constructor;
class Animal{

    public Animal(){
    }
    public void run(){
        System.out.println("Inside run method of Animal Class " );
    }
}
public class DynamicClassLoader extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            String className = "com.javarefresher.week01.Animal";
            ClassLoader classLoader = DynamicClassLoader.class.getClassLoader();
            Class loadedClass = classLoader.loadClass(className);
            Constructor constructor = loadedClass.getConstructor();
            Object obj = constructor.newInstance();
            ((Animal)obj).run();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
