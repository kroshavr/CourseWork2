import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Map <Integer, DateInterface> taskMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
            lable:
            while (true) {
                printMenu();
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1: TaskService.addTask(taskMap, scanner);
                        break ;
                        case 2: TaskService.getTaskByDay(taskMap, scanner);
                        break ;
                        case 3: TaskService.deleteTask(taskMap, scanner);
                        break ;
                        case 0: break lable;
                    }
                } else {
                        scanner.next();
                        System.out.println("Выберите нужный пукнт меню");
                    }

            }
        }

    public static void printMenu (){
        System.out.println("МЕНЮ\n" +
                "Выберите нужный пункт меню:\n" +
                "1 - Добавить задачу\n" +
                "2 - Получить задачу на день\n" +
                "3 - Удалить задачу по id\n" +
                "0 - Выход из программы");
    }
}