import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("가");
        arrayList.add("나");
        arrayList.add("다");
        printItem(arrayList);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("가");
        linkedList.add("나");
        linkedList.add("다");
        printItem(linkedList);

        List<String> vector = new Vector<>();
        vector.add("가");
        vector.add("나");
        vector.add("다");
        printItem(vector);

        Set<String> hashSet = new HashSet<>();
        hashSet.add("가");
        hashSet.add("나");
        hashSet.add("다");
        printItem(hashSet);

    }

    public static <T> void printItem(Collection<T> collection) {
        if (collection.isEmpty()) {
            System.out.println("No Elements");
        } else {
            System.out.println("idx\titem");
            AtomicInteger index = new AtomicInteger();
            collection.forEach(item -> {
                System.out.printf("%d\t%s%n", index.get(), item.toString());
                index.getAndIncrement();
            });
        }
    }
}