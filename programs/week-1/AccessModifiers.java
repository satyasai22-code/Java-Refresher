class Data {
    private String name;

    protected String getClassName(){
        return "Data";
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name= name;
    }
}

class SubData extends Data{
    @Override
    public String getClassName(){
        return super.getClassName();
    }
}
public class AccessModifiers {
    public static void main(String[] main){
        Data d = new Data();
        d.getClassName();
        d.setName("Satya");
        System.out.println(d.getName());
        System.out.println(d.getClassName());
        SubData subData = new SubData();
        System.out.println(subData.getClassName());
    }
}