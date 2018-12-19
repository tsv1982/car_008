
public class Check {    // Класс для проверок

    private Singelton singelton = Singelton.getInstans();      // вызываем инстанс

    public Check()  {
    }

    Boolean checkStraight(String s, int counter) {
        if (singelton.mas(s)[counter + 1] == false) {
            return true;
        }
        return false;
    }     // метод для проверки впереди стоящей машины
}
