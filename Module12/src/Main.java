import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String regex = "[АВЕКМНОРСТУХ] ([0-9]\1\1) [АВЕКМНОРСТУХ] {2} [0-9] {2,3}";
//        String nnn = "A555OM199";
//        if (nnn.matches(regex)) {
//            System.out.println(CoolNumbers.generateCoolNumbers(nnn));
//        }


//        for (int l = 0; l < CoolNumbers.generateCoolNumbers().size(); l++) {
//            System.out.println(CoolNumbers.generateCoolNumbers().get(l));
//
//
////        System.out.println(CoolNumbers.generateCoolNumbers());
//
//
//        }


        for (int l = 0; l < CoolNumbers.generateCoolNumbers().size(); l++) {
            System.out.println(CoolNumbers.generateCoolNumbers().get(l));
        }
        Collections.sort(CoolNumbers.generateCoolNumbers());
        HashSet<String> hashSet = new HashSet<>(CoolNumbers.generateCoolNumbers());
        TreeSet<String> treeSet = new TreeSet<>(CoolNumbers.generateCoolNumbers());


        System.out.println("Введите автомобильный номер");

        while (true) {

            String enteringNumber = new Scanner(System.in).nextLine();

            long startFor = System.nanoTime();
            if (CoolNumbers.generateCoolNumbers().contains(enteringNumber)) {
            System.out.println("Поиск перебором: номер найден, поиск занял " + (System.nanoTime() - startFor) + " нс");
                } else {
                    System.out.println("Поиск перебором: номер не найден, поиск занял " + (System.nanoTime() - startFor) + " нс");
                }


                long startBinary = System.nanoTime();
                if (Collections.binarySearch(CoolNumbers.generateCoolNumbers(), enteringNumber) == 0) {
                    System.out.println("Бинарный поиск: номер найден, поиск занял " + (System.nanoTime() - startBinary) + " нс");
                } else {
                    System.out.println("Бинарный поиск: номер не найден, поиск занял " + (System.nanoTime() - startBinary) + " нс");
                }




            long startHash = System.nanoTime();
            if (hashSet.contains(enteringNumber)) {
                System.out.println("Поиск в HashSet: номер найден, поиск занял " + (System.nanoTime() - startHash) + " нс");
            } else {
                System.out.println("Поиск в HashSet: номер не найден, поиск занял " + (System.nanoTime() - startHash) + " нс");
            }


            long startTree = System.nanoTime();
            if (treeSet.contains(enteringNumber)) {
                System.out.println("Поиск в TreeSet: номер найден, поиск занял " + (System.nanoTime() - startTree) + " нс");
            } else {
                System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + (System.nanoTime() - startTree) + " нс");
            }

        }
    }
}