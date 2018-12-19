import java.util.ArrayList;
import java.util.List;

public class Layout {     // класс который создает list из раскладок авто

    private int rotate;    // вращает картинку авто
    private int layoutX;   // начальное значение авто по X
    private int layoutY;   // начальное значение авто по Y
    private List<Layout> layoutsList = new ArrayList<>();   // list с начальными размещениями авто

    public Layout() {
        layoutsList.add(new Layout(180, -50, 410));      // westA
        layoutsList.add(new Layout(180, -50, 410));      // westA
        layoutsList.add(new Layout(180, -50, 410));      // westA
        layoutsList.add(new Layout(180, -50, 410));      // westA
        layoutsList.add(new Layout(180, -50, 410));      // westA

        layoutsList.add(new Layout(180, -50, 450));      // westB
        layoutsList.add(new Layout(180, -50, 450));      // westB
        layoutsList.add(new Layout(180, -50, 450));      // westB
        layoutsList.add(new Layout(180, -50, 450));      // westB

        layoutsList.add(new Layout(0, 800, 360));        // EastA
        layoutsList.add(new Layout(0, 800, 360));        // EastA
        layoutsList.add(new Layout(0, 800, 360));        // EastA
        layoutsList.add(new Layout(0, 800, 360));        // EastA
        layoutsList.add(new Layout(0, 800, 360));        // EastA
        layoutsList.add(new Layout(0, 800, 360));        // EastA

        layoutsList.add(new Layout(0, 800, 320));        // EastB
        layoutsList.add(new Layout(0, 800, 320));        // EastB
        layoutsList.add(new Layout(0, 800, 320));        // EastB
        layoutsList.add(new Layout(0, 800, 320));        // EastB
        layoutsList.add(new Layout(0, 800, 320));        // EastB
        layoutsList.add(new Layout(0, 800, 320));        // EastB

        layoutsList.add(new Layout(270, 350, -40));       // NorthA
        layoutsList.add(new Layout(270, 350, -40));       // NorthA
        layoutsList.add(new Layout(270, 350, -40));       // NorthA

        layoutsList.add(new Layout(270, 310, -40));       // NorthB
        layoutsList.add(new Layout(270, 310, -40));       // NorthB

        layoutsList.add(new Layout(90, 400, 810));        // SouthA
        layoutsList.add(new Layout(90, 400, 810));        // SouthA

        layoutsList.add(new Layout(90, 450, 810));        // SouthB
        layoutsList.add(new Layout(90, 450, 810));        // SouthB
        layoutsList.add(new Layout(90, 450, 810));        // SouthB
        layoutsList.add(new Layout(90, 450, 810));        // SouthB
    }    // при создании экземпляра класса Layout добавляются ссылки в list

    public Layout(int rotate, int layoutX, int layoutY) {
        this.rotate = rotate;
        this.layoutX = layoutX;
        this.layoutY = layoutY;
    }    // конструктор класса Layout

    public int getRotate() {
        return rotate;
    }     // метод возвращает переменную rotate

    public int getLayoutX() {
        return layoutX;
    }   // метод возвращает переменную layout по X

    public int getLayoutY() {
        return layoutY;
    }   // метод возвращает переменную layout по Y

    public List<Layout> getLayoutsList() {
        return layoutsList;
    }    // возвращает list с начальными размещениями авто
}
