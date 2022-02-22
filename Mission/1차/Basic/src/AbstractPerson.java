public abstract class AbstractPerson implements Person {
    private String name;
    private int age;

    public AbstractPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public void speak() {
        System.out.printf("Hi, My name is %s.%n", this.name);
    }
}
