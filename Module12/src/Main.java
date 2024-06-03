import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> listNumbers = CoolNumbers.generateCoolNumbers();
        for (int l = 0; l < listNumbers.size(); l++) {
            System.out.println(listNumbers.get(l));
        }

        System.out.println("Введите автомобильный номер");
        String enteringNumber = new Scanner(System.in).nextLine();

        long startFor = System.nanoTime();

        if (listNumbers.contains(enteringNumber)) {
            searchYes(startFor, "перебором");
        } else {
            searchNot(startFor, "перебором");
        }

        ArrayList<String> sortListNumber = listNumbers;
        Collections.sort(sortListNumber);
        if (Collections.binarySearch(sortListNumber, enteringNumber) >= 0) {
            searchYes(startFor, "бинарный");
        } else {
            searchNot(startFor, "бинарный");
        }

        HashSet<String> hashSet = new HashSet<>(listNumbers);
        if (hashSet.contains(enteringNumber)) {
            searchYes(startFor, "в HashSet");
        } else {
            searchNot(startFor, "в HashSet");
        }

        TreeSet<String> treeSet = new TreeSet<>(listNumbers);
        if (treeSet.contains(enteringNumber)) {
            searchYes(startFor, "в TreeSet");
        } else {
            searchNot(startFor, "в TreeSet");
        }
    }

    public static void searchYes(long startFor, String searchName) {
        System.out.println("Поиск " + searchName + ": номер найден, поиск занял " + (System.nanoTime() - startFor) + " нс");
    }

    public static void searchNot(long startFor, String searchName) {
        System.out.println("Поиск " + searchName + ": номер не найден, поиск занял " + (System.nanoTime() - startFor) + " нс");
    }
}