import java.util.ArrayList;
import java.util.List;

public class CarColor {     // клас для создания list с сылками на рисунки авто

    private ArrayList<String> list = new ArrayList<>();   // лист со ссылками на рисунки

    public CarColor() {
        list.add("img/car_001.png");      // при создании экземпляра класса CarColor добавляются ссылки в list
        list.add("img/car_002.png");
        list.add("img/car_003.png");
        list.add("img/car_005.png");
        list.add("img/car_006.png");
        list.add("img/car_007.png");
        list.add("img/car_008.png");
        list.add("img/car_009.png");
    }    // конструктор класса CarColor

    public List getColor() {
        return list;
    }      //  метод, который возвращает list
}
