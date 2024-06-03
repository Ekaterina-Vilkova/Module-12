import java.util.*;

public class CoolNumbers {
    public static ArrayList<String> generateCoolNumbers() {
        String text = "";

        String firstLetter = "";

        String numbers = "";

        String lastLetter = "";

        String region1 = "";
        String region2 = "";
        String region3 = "";

        int countNumber = 0;


        ArrayList<String> coolNumbers = new ArrayList<>();
        int count = 2000005;
        ArrayList<String> letter = new ArrayList<>(Arrays.asList("А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"));
        ArrayList<String> number = new ArrayList<>(Arrays.asList("111", "222", "333", "444", "555", "666", "777", "888", "999"));


        ArrayList<String> oneNumberRegion = new ArrayList<>(Arrays.asList("0", "1"));
        ArrayList<String> numberRegion = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));


        for (int i = 0; i < count; i++) {
            Collections.shuffle(letter);
            for (String firstLetters : letter) {
                firstLetter = firstLetters;
                Collections.shuffle(number);
                for (String numb : number) {
                    numbers = numb;
                    Collections.shuffle(letter);
                    while (countNumber <= 2) {
                        for (String l : letter) {
                            lastLetter = lastLetter + l;
                            countNumber++;
                            if (countNumber == 2) {
                                for (int a = 0; a < count; a++) {
                                    Collections.shuffle(oneNumberRegion);
                                    for (String oneRegin : oneNumberRegion) {
                                        region1 = oneRegin;
                                        if (region1.equals("0")) {
                                            region1 = "";
                                        }
                                        Collections.shuffle(numberRegion);
                                        for (String twoRegion : numberRegion) {
                                            region2 = twoRegion;
                                            Collections.shuffle(numberRegion);
                                            for (String threeRegion : numberRegion) {
                                                region3 = threeRegion;
                                            }
                                        }
                                    }
                                    text = firstLetter + numbers + lastLetter + region1 + region2 + region3;
                                    coolNumbers.add(text);
                                }
                            }
                        }
                    }
                }
            }
        }

        return coolNumbers;
    }
}