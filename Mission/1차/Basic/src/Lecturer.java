public class Lecturer extends AbstractPerson{
    public Lecturer(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.printf("My name is %s and and I am a lecturer of this class.\n", getName());
    }
}
