import javax.management.ObjectName;

class Animal{
    public void run(){
        System.out.println("Inside run method of Animal Class " );
    }
}
public class DynamicClassLoader extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            String className = "Animal";
            ClassLoader classLoader = DynamicClassLoader.class.getClassLoader();
            Class loadedClass = classLoader.loadClass(className);
            Object obj = loadedClass.getConstructor().newInstance();
            ((Animal)obj).run();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
