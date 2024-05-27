import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String regex = "[АВЕКМНОРСТУХ] ([0-9]\1\1) [АВЕКМНОРСТУХ] {2} [0-9] {2,3}";


        ArrayList<String> listNumbers = CoolNumbers.generateCoolNumbers();
        for (int l = 0; l < listNumbers.size(); l++) {
            System.out.println(listNumbers.get(l));
        }

        System.out.println("Введите автомобильный номер");
        String enteringNumber = new Scanner(System.in).nextLine();

        long startFor = System.nanoTime();
        if (listNumbers.contains(enteringNumber)) {
            System.out.println("Поиск перебором: номер найден, поиск занял " + (System.nanoTime() - startFor) + " нс");
        } else {
            System.out.println("Поиск перебором: номер не найден, поиск занял " + (System.nanoTime() - startFor) + " нс");
        }

        ArrayList<String> sortListNumber = new ArrayList<>(listNumbers);
        Collections.sort(sortListNumber);
        long startBinary = System.nanoTime();
        if (Collections.binarySearch(sortListNumber, enteringNumber) == 0) {
            System.out.println("Бинарный поиск: номер найден, поиск занял " + (System.nanoTime() - startBinary) + " нс");
        } else {
            System.out.println("Бинарный поиск: номер не найден, поиск занял " + (System.nanoTime() - startBinary) + " нс");
        }

        HashSet<String> hashSet = new HashSet<>(listNumbers);
        long startHash = System.nanoTime();
        if (hashSet.contains(enteringNumber)) {
            System.out.println("Поиск в HashSet: номер найден, поиск занял " + (System.nanoTime() - startHash) + " нс");
        } else {
            System.out.println("Поиск в HashSet: номер не найден, поиск занял " + (System.nanoTime() - startHash) + " нс");
        }

        TreeSet<String> treeSet = new TreeSet<>(listNumbers);
        long startTree = System.nanoTime();
        if (treeSet.contains(enteringNumber)) {
            System.out.println("Поиск в TreeSet: номер найден, поиск занял " + (System.nanoTime() - startTree) + " нс");
        } else {
            System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + (System.nanoTime() - startTree) + " нс");
        }

    }
}