package reference1.StreamAPI.Object;

public class Student {

    private String name;

    public boolean local;

    public Student(){

    }

    public Student(String name, boolean local) {
        this.name = name;
        this.local = local;
    }

    public String getName() {
        return name;
    }

    public boolean isLocal() {
        return local;
    }


}
