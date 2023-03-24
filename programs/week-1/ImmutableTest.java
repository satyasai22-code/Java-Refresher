//Must be final to be immutable
final class ImmutableClass {
    //Must be private and final
    private final String name;
    private final int age;

    //Paramaterized construcotr should intialize all values
    public ImmutableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Only gettters should be there
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
}

public class ImmutableTest {
    public static void main(String[] args) {
        ImmutableClass immutableClass = new ImmutableClass("Satya", 10);
        System.out.println(immutableClass.getAge());
    }
}
