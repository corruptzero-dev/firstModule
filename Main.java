package task;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Выберите задачу:
                1. 'Двадцать одно' (15 баллов)
                2. Шаг между элементами в массиве (10 баллов)
                """);
        int taskChoice = scanner.nextInt();
        if (taskChoice==1){
            twentyOne();
        } else if (taskChoice == 2){
            System.out.print("""
                    Выберите:
                    0. Пример, который возвращает false (1,2,8,4,5,6)
                    1. Пример, который возвращает true (1,3,5,7,9,11)
                    """);
            int returnChoice = scanner.nextInt();
            int[] exampleArray;
            if (returnChoice == 0){
                exampleArray = new int[] {1,2,8,4,5,6};
            } else {
                exampleArray = new int[]{1,3,5,7,9,11};
            }
            System.out.println(stepTask(exampleArray.length, exampleArray));
        }
    }
    public static void twentyOne(){
        //Колода 36 карт
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String userChoice;
        String[] cardNames = {"Валет", "Король", "Дама", "Туз", "6", "7", "8", "9", "10"};
        int userValue = 0;
        System.out.print("Игра начинается. \nЧтобы тянуть карту, напишите '+': ");
        userChoice = scanner.next();
        while (!userChoice.equals("-")){
            int nextCardIdx = random.nextInt(cardNames.length);
            String nextCard = cardNames[nextCardIdx];
            if (nextCard.equalsIgnoreCase("Валет")){
                userValue += 2;
            } else if (nextCard.equalsIgnoreCase("Дама")){
                userValue += 3;
            } else if (nextCard.equalsIgnoreCase("Король")) {
                userValue += 4;
            } else if (nextCard.equalsIgnoreCase("Туз")) {
                if (userValue<=10){
                    System.out.println("Туз! Можете решить, сколько очков хотите добавить.");
                    System.out.print("1 или 11 (1/2): ");
                    int choice = scanner.nextInt();
                    userValue+=choice==1?1:11;
                } else {
                    userValue += 1;
                }
            } else {
                userValue += Integer.parseInt(nextCard);
            }
            System.out.printf("Выпала карта: %s. У вас %d очка(-ов)\n", nextCard, userValue);
            if (userValue>21){
                System.out.println("Вы проиграли.");
                break;
            } else if (userValue==21){
                System.out.println("21! Поздравляю, вы выиграли.");
                break;
            }
            System.out.println("Напишите '+' чтобы тянуть карту или '-' чтобы подвести итог.");
            userChoice = scanner.next();
        }
        if (userChoice.equals("-")){
            System.out.printf("У вас %d очков.", userValue);
        }
    }
    public static boolean stepTask(int size, int[] arr){
        int step = arr[1] - arr[0];
        for (int i = size-1; i > 0; i--) {
            if(arr[i]-arr[i-1] != step){
                return false;
            }
        }
        return step % 2 == 0;
    }
}
