import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.util.Random;

public class MoveCar2 {
    private int x = 0; //  расположение авто по X
    private int y = 0; // расположение авто по y
    private int rotate;
    private int xSave = 0;   // сохранение начального положения
    private int ySave = 0;   // сохранение начального положения
    private String side = null;   // на какой полосе и с какой стороны движется авто
    private int counter;   // счетчик
    private Singelton singelton = Singelton.getInstans();     // создаем экземпляр класса singelton
    private Random random = new Random(); // класс для определения рандомного числа
    private int turn = 0;    // 0 - прямо   1 - лево  2 - право
    private boolean bol = true;
    Check check = new Check();     // создаем екземпляр класса check
    TrafficLight trafficLight = new TrafficLight();     // создаем екземпляр класса trafficLight

    public MoveCar2(String side, int x, int y, int rotate) {
        this.x = x;
        this.y = y;
        this.side = side;
        xSave = x;
        ySave = y;
        this.rotate = rotate;
    }      // конструктор класса

    void motionData(String s) {      // метод который перемещает авто движение по выбраном пути
        switch (s) {
            case "WestA": {
                if (check.checkStraight(side, counter)) {                 // делаем проверку есть ли впереди стоящее авто
                    if (counter == 7 && singelton.mas(side)[9] == true) {   // проверяем нет ли в впереди авто, которое поворачивает налево
                    } else {
                        x += 51;                                            // передвигаем авто по x
                        counter++;                                         // добавляем единицу к счетчику
                    }
                }
                break;
            }
            case "WestB": {
                if (check.checkStraight(side, counter)) {
                    x += 51;
                    counter++;
                }
                break;
            }
            case "EastA": {
                if (check.checkStraight(side, counter)) {
                    if (counter == 7 && singelton.mas(side)[9] == true) {
                    } else {
                        x -= 51;
                        counter++;
                    }
                }
                break;
            }
            case "EastB": {
                if (check.checkStraight(side, counter)) {
                    x -= 50;
                    counter++;
                }
                break;
            }
            case "NorthA": {
                if (check.checkStraight(side, counter)) {
                    if (counter == 7 && singelton.mas(side)[9] == true) {
                    } else {
                        y += 51;
                        counter++;
                    }
                }
                break;
            }
            case "NorthB": {
                if (check.checkStraight(side, counter)) {
                    y += 51;
                    counter++;
                }
                break;
            }
            case "SouthA": {
                if (check.checkStraight(side, counter)) {
                    if (counter == 7 && singelton.mas(side)[9] == true) {
                    } else {
                        y -= 51;
                        counter++;
                    }
                }
                break;
            }
            case "SouthB": {
                if (check.checkStraight(side, counter)) {
                    y -= 51;
                    counter++;
                }
                break;
            }
        }
    }     // метод, который перемещает авто по выбранном пути

    private void endArray(ImageView imageView, String side2) {
        if (counter == 17) {                                  // когда счетчик 17
            singelton.mas(side2)[16] = false;                 // делаем последнюю ячейку массива пустой
            counter = 0;                                      // обнуляем счетчик
            x = xSave;                                       // присваиваем начальное значение
            y = ySave;                                        // присваиваем начальное значение
            turn = random.nextInt(3);                  // выбираем рандомное направление


            if (turn == 1 && singelton.getTernLeft() > 5) {
                turn = 1;
                singelton.setTernLeft(0);
            } else {   // делаем проверку было ли у предыдущего авто поворот на лево
                if (singelton.getTernLeft()==9){
                    singelton.setTernLeft(0);
                }
                turn =2;
                singelton.SsetTernLeft();
            }

            imageView.setRotate(rotate);                         // выравниваем авто на начальное значение
            bol = true;
            singelton.setCounterCar();             // вызываем метод, который отмечает проехавшее авто
        }
    }    // проверка конца дороги и обнуление значений

    private void moveStraight(ImageView imageView, String side) {

        if (side.equals("WestA") || side.equals("WestB") || side.equals("EastA") || side.equals("EastB")) {   // проверка по каком пути движется авто
            if (singelton.getCounterGreen() < singelton.getGreen()) {     //  проверка светофора зеленного
                trafficLight.GreenLightWE();                               // включаем зеленный
                if (counter==6 && ((singelton.mas("NorthB")[7] == true || singelton.mas("NorthB")[8] == true || singelton.mas("NorthB")[9] == true ||   // проверка есть ли авто на светооре после красного
                        singelton.mas("NorthA")[7] == true || singelton.mas("NorthA")[8] == true || singelton.mas("NorthA")[9] == true)) ||
                        ((singelton.mas("SouthA")[7] == true || singelton.mas("SouthA")[8] == true || singelton.mas("SouthA")[9] == true ||
                                singelton.mas("SouthB")[7] == true || singelton.mas("SouthB")[8] == true || singelton.mas("SouthB")[9] == true))){

                }else {
                    motionData(side);                                // вызываем метод для перемещения авто
                    endArray(imageView, side);                     // проверяем конец дороги
                    singelton.mas(side)[counter] = true;          // делаем отметки в какой ячейке авто
                    if (counter > 0) {
                        singelton.mas(side)[counter - 1] = false;
                    }
                }
            } else {
                if (singelton.getCounterYellow() < singelton.getYellow()) {        // проверка желтого светофора
                    trafficLight.YellowLight();                                    // включаем желтый
                    if (counter != 6) {                                            // если авто не дальше 6 ячейке то продолжаем движение
                        motionData(side);
                        endArray(imageView, side);
                        singelton.mas(side)[counter] = true;
                        if (counter > 0) {
                            singelton.mas(side)[counter - 1] = false;
                        }
                    }
                } else {
                    if (singelton.getCounterRed() < singelton.getRed()) {        // проверка красного
                        trafficLight.RedLightWE();                               // включаем красный
                        if (counter != 6) {                                    // если авто не дальше 6 ячейке то продолжаем движение
                            motionData(side);
                            endArray(imageView, side);
                            singelton.mas(side)[counter] = true;
                            if (counter > 0) {
                                singelton.mas(side)[counter - 1] = false;
                            }
                        }
                    }
                }
            }
        }
        if (side.equals("NorthA") || side.equals("NorthB") || side.equals("SouthA") || side.equals("SouthB")) {
            if (singelton.getCounterGreen() < singelton.getGreen()) {
                if (counter != 6) {
                    motionData(side);
                    endArray(imageView, side);
                    singelton.mas(side)[counter] = true;
                    if (counter > 0) {
                        singelton.mas(side)[counter - 1] = false;
                    }
                }
            } else {
                if (singelton.getCounterYellow() < singelton.getYellow()) {
                    if (counter != 6) {
                        motionData(side);
                        endArray(imageView, side);
                        singelton.mas(side)[counter] = true;
                        if (counter > 0) {
                            singelton.mas(side)[counter - 1] = false;
                        }
                    }
                } else {
                    if (singelton.getCounterRed() < singelton.getRed()) {
                        motionData(side);
                        endArray(imageView, side);
                        singelton.mas(side)[counter] = true;
                        if (counter > 0) {
                            singelton.mas(side)[counter - 1] = false;
                        }
                    }
                }
            }
        }
    }   // метод движения прямо

    private void moveLeft(ImageView imageView, int degree, String side2, String sideOnRightA, String sideOnRightB) {

        endArray(imageView, side2);                                  // вызываем метод для проверки конца дороги
        if (counter < 9 && bol) {
            moveStraight(imageView, side);                        // вызываем метод для движения прямо
        }
        if (counter == 9 && bol) {
            imageView.setRotate(degree);                          // разворачиваем авто
            bol = false;
        }
        if (counter >= 9 && (bol == false)) {
            if (counter == 9 && singelton.mas(sideOnRightA)[7] == true || singelton.mas(sideOnRightA)[8] == true) {
            } else {
                if (counter == 10 && singelton.mas(sideOnRightB)[7] == true || singelton.mas(sideOnRightB)[8] == true) {
                } else {
                    singelton.mas(side)[9] = false;
                    singelton.mas(side2)[counter] = true;                    // делаем отметку
                    singelton.mas(side2)[counter - 1] = false;                // удаляем отметку
                    motionData(side2);
                    endArray(imageView, side2);                                    // вызиваем метод для проверки конца дороги
                }
            }
        }        // делаем проверку есть ли справа авто при повороте на лево
    }  // метод для движения налево

    private void moveRight(ImageView imageView, int degree, String side2) {
        endArray(imageView, side2);                  // вызываем метод для определения конца дороги передаем в него значения s - путь при изменении
        if (counter < 7) {
            moveStraight(imageView, side);      // вызываем метод для движения прямо до перекрестка
        }
        if (counter == 7) {
            imageView.setRotate(degree);     // разворачиваем авто
            singelton.mas(side)[7] = false;     // удаляем отметку
            counter += 4;
        }
        if (counter >= 7) {
            singelton.mas(side2)[counter] = true;          // делаем отметку в массиве
            singelton.mas(side2)[counter - 1] = false;     // удаляем отметку
            motionData(side2);                           // вызываем метод для передвижения авто
        }
    }     // метод движения направо

    public ImageView move(ImageView imageView, int rotate, String side2, String sideOnRightA, String sideOnRightB) {
        // side2 - путь после поворота
        // rotate- на сколько градусов повернуть авто

        switch (turn) {        // переключатель движения авто (0- прямо, 1- налево, 2- направо)
            case 0: {                               // прямо
                moveStraight(imageView, side);
                break;
            }
            case 1: {                               // налево
                if (side.equals("WestB") || side.equals("EastB") || side.equals("NorthB") || side.equals("SouthB")) {  // делаем проверку
                    moveStraight(imageView, side);                                                                      // если авто движется по B
                } else {                                                                                         // то перенаправляем его прямо
                    moveLeft(imageView, rotate, side2, sideOnRightA, sideOnRightB);                                                        // если нет то поворачиваем налево
                }
                break;
            }
            case 2: {                               // направо

                if (side.equals("WestA") || side.equals("EastA") || side.equals("NorthA") || side.equals("SouthA")) {   // делаем проверку
                    moveStraight(imageView, side);                                                                    // если авто движется по А
                } else {                                                                                                // то перенаправляем его прямо
                    moveRight(imageView, rotate, side2);                                                               // если нет то поворачиваем направо
                }
                break;
            }
        }
        imageView.relocate(x, y);    // задаем первоначальную значение авто
        return imageView;
    }   // основной метод движения авто который рандомно определяет движение
}
