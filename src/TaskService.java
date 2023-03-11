import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static java.time.LocalDateTime.parse;

public class TaskService {

    public static void addTask(Map <Integer, DateInterface> taskMap, Scanner scanner) {
        try {
            try {
                scanner.nextLine();
                System.out.println("Введите название задачи: ");
                String title = ValidateUtil.checkString(scanner.nextLine());
                System.out.println("Введите описание задачи: ");
                String description = ValidateUtil.checkString(scanner.nextLine());
                System.out.println("Введите тип задачи: 0 - рабочая, 1 - личная");
                Type taskType = Type.values()[scanner.nextInt()];
                System.out.println("Введите дату и время выполнения задачи в формате dd.MM.yyyy-HH:mm : ");
                String date = scanner.next();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm");
                LocalDateTime dateTime = LocalDateTime.parse(date, dateTimeFormatter);
                System.out.println("Введите периодичность выполенения задачи: 0 - единоразово, 1 - ежедневно, 2 еженедельно, 3 - ежемесячно, 4 - ежегодно");
                Integer i = Integer.valueOf(scanner.next());
                switch (i) {
                    case 0: {
                        OneTimeTask task = new OneTimeTask(title, description, taskType, dateTime, Periodicity.ONETIME);
                        taskMap.put(task.getId(), task);
                    }
                    break;
                    case 1: {
                        DailyTask task = new DailyTask(title, description, taskType, dateTime, Periodicity.DAILY);
                        taskMap.put(task.getId(), task);
                    }
                    break;
                    case 2: {
                        WeeklyTask task = new WeeklyTask(title, description, taskType, dateTime, Periodicity.WEEKLY);
                        taskMap.put(task.getId(), task);
                    }
                    break;
                    case 3: {
                        MonthlyTask task = new MonthlyTask(title, description, taskType, dateTime, Periodicity.MONTHLY);
                        taskMap.put(task.getId(), task);
                    }
                    break;
                    case 4: {
                        YearlyTask task = new YearlyTask(title, description, taskType, dateTime, Periodicity.YEARLY);
                        taskMap.put(task.getId(), task);
                    }
                    break;
                    default: {
                        System.out.println("Задача добавлена!");
                    }
                }
                scanner.nextLine();
            } catch (IncorrectArgumentExeption e) {
                System.out.println("Некорректный ввод данных, повторите попытку");
            }
        }catch (DateTimeParseException e) {
                System.out.println("Некорректный ввод даты, повторите попытку");
        }
    }
    public static void getTaskByDay(Map <Integer, DateInterface> taskMap, Scanner scanner) {
        System.out.println("Введите дату для просмотра задачи в формате dd.MM.yyyy-HH.mm : ");
        try {
            String date = scanner.next();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm");
            LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);
            if (taskMap.entrySet().stream().noneMatch(task -> task.getValue().appearsIn(localDateTime))) {
                System.out.println("На эту дату нет задач");
            } else {
                taskMap.entrySet().stream()
                        .filter(task -> task.getValue().appearsIn(localDateTime))
                        .forEach(s -> System.out.println(s.getValue()));
            }
        } catch (DateTimeParseException e) {
            System.out.println("Неправильный ввод даты, повторите попытку");
        }
    }
    public static void deleteTask (Map <Integer, DateInterface> taskMap, Scanner scanner) {
        System.out.println("Текущие задачи: ");
        System.out.println(taskMap);
        System.out.println("Для удаления задачи введите его ID: ");
        int id = scanner.nextInt();
        if (taskMap.containsKey(id)) {
            taskMap.remove(id);
            System.out.println("Задача с ID=" + id + " удалена");
        }
        else {
            System.out.println("Такой задачи не существует");
        }
    }
}
