class Data {
    private String name;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name= name;
    }
}
public class AccessModifiers {
    public static void main(String[] main){
        Data d = new Data();
        d.setName("Satya");
        System.out.println(d.getName());
    }
}