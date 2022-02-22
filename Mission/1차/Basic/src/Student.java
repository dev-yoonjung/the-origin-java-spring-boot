public class Student extends AbstractPerson{

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.printf("My name is %s and and I am a student.\n", getName());
    }
}
