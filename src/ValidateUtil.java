public class ValidateUtil {
    public static String checkString (String string) throws IncorrectArgumentExeption {
        if (string == null || string.isEmpty() || string.isBlank()) {
            throw new IncorrectArgumentExeption("Некорректный ввод данных!");
        } else return string;
    }
//    public static Integer checkIn (Integer in) throws IncorrectArgumentExeption {
//        if (in < 0 || in > 2) {
//            throw new IncorrectArgumentExeption("Некорректный ввод данных!");
//        } else return in;
//    }
}
