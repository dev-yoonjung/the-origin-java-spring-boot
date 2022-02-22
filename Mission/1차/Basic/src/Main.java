import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person studentKim = new Student("Kim", 26);
        Person studentLee = new Student("Lee", 28);
        Person studentPark = new Student("Park", 24);

        Person lecturer = new Lecturer("Park Jeeho", 35);

        List<Person> everyone = new ArrayList<>();
        everyone.add(studentKim);
        everyone.add(studentLee);
        everyone.add(studentPark);
        everyone.add(lecturer);

        for (Person person : everyone) {
            person.speak();
        }

    }

}
