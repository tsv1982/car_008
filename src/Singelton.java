import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Singelton {                // класс одиночка (все переменные создаются в единственном экземпляре)

    private static volatile Singelton instans;

    private Boolean WestBooleanA[] = new Boolean[18];    // масивы, где гранятся отметки о расположении авто
    private Boolean WestBooleanB[] = new Boolean[18];
    private Boolean EastBooleanA[] = new Boolean[18];
    private Boolean EastBooleanB[] = new Boolean[18];
    private Boolean NorthBooleanA[] = new Boolean[18];
    private Boolean NorthBooleanB[] = new Boolean[18];
    private Boolean SouthBooleanA[] = new Boolean[18];
    private Boolean SouthBooleanB[] = new Boolean[18];

    private List<ImageView> listTrafficLight = new ArrayList<>();    //  массив куда добавляем светофоры

    private int trafficLightCounter = 0;         // общий счетчик светофора
    private int counterCar = 0;                  // счетчик автомобилей, которые проехали поле
    private int counterStep = 0;                  // счетчик шагов
    private int ternLeft = 0;                     // в переменной делаем отметку был ли поворот на лево
    private int red = 10;                         // количество шагов красного
    private int yellow = 4;                       // количество шагов желтого
    private int green = 15;                       // количество шагов зеленного
    private int counterRed = 0;                   // счетчик красного
    private int counterYellow = 0;                // счетчик желтого
    private int counterGreen = 0;                 // счетчик зеленного

    private Singelton() {
        for (int i = 0; i < 18; i++) {
            WestBooleanA[i] = false;
            WestBooleanB[i] = false;
            EastBooleanA[i] = false;
            EastBooleanB[i] = false;
            NorthBooleanA[i] = false;
            NorthBooleanB[i] = false;
            SouthBooleanA[i] = false;
            SouthBooleanB[i] = false;
        }          // заполняем массивы
        trafficLight();                            //вызываем метод и заполняем массивы светофорами
    }    // конструктор класса

    public int getCounterRed() {
        return counterRed;
    }    // метод, который возвращает счетчик красного

    public void SsetCounterRed() {
        counterRed++;
    }       // метод увеличивает счетчик красного на единицу при каждом вызове

    public void setCounterRed(int counterRed) {
        this.counterRed = counterRed;
    }  // при вызове изменяет значение классного

    public int getCounterYellow() {
        return counterYellow;
    }   // метод, который возвращает счетчик желтого

    public void SsetCounterYellow() {
        counterYellow++;
    }    // метод увеличивает счетчик желтого на единицу при каждом вызове

    public void setCounterYellow(int counterYellow) {
        this.counterYellow = counterYellow;
    }    // при вызове изменяет значение желтого

    public int getCounterGreen() {
        return counterGreen;
    }   // метод, который возвращает счетчик зеленого

    public void SsetCounterGreen() {
        counterGreen++;
    }    // метод увеличивает счетчик зеленого на единицу при каждом вызове

    public void setCounterGreen(int counterGreen) {
        this.counterGreen = counterGreen;
    }      // при вызове изменяет значение зеленого

    public int getTernLeft() {
        return ternLeft;
    }     //   возвращает значение когда был ли поворот на лево

    public void setTernLeft(int ternLeft) {
        this.ternLeft = ternLeft;
    }     // метод изменяет значение поворота на лево

    public void SsetTernLeft() {
        ternLeft++;
    }     // метод изменяет значение поворота на лево

    public int getRed() {
        return red;
    }       // возвращает значение красного

    public void setRed(int red) {
        this.red = red;
    }     // изменяет значение красного

    public int getYellow() {
        return yellow;
    }      // возвращает значение желтого

    public void setYellow(int yellow) {
        this.yellow = yellow;
    }    // изменяет значение желтого

    public int getGreen() {
        return green;
    }        // возвращает значение зеленого

    public void setGreen(int green) {
        this.green = green;
    }     // изменяет значение зеленого

    public int getCounterStep() {
        return counterStep;
    }     // возвращает значение шагов

    public void setCounterStep() {
        counterStep++;
    }      // при вызове изменяет значение на единицу

    public int getCounterCar() {
        return counterCar;
    }      // возвращает значение количества автомобилей

    public void setCounterCar() {
        counterCar++;
    }        // при вызове изменяет значение на единицу

    private void trafficLight()  {
        Image imageLightRed = null;     // считываем картинки светофоров
        try {
            imageLightRed = new Image(new FileInputStream("img/LRed.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imageLightYellow = null;
        try {
            imageLightYellow = new Image(new FileInputStream("img/LYellow.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imageLightGreen = null;
        try {
            imageLightGreen = new Image(new FileInputStream("img/LGreen.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImageView imageView = new ImageView(imageLightRed);           // в imegeView добавляем картинку светофора
        imageView.setRotate(90);                                // выставляем положение светофора
        imageView.setLayoutX(170);                            // координаты по X
        imageView.setLayoutY(480);                            // координаты по Y
        listTrafficLight.add(imageView);                          // добавляем imageView в массив
        ImageView imageView1 = new ImageView(imageLightYellow);
        imageView1.setRotate(90);
        imageView1.setLayoutX(170);
        imageView1.setLayoutY(480);
        listTrafficLight.add(imageView1);
        ImageView imageView2 = new ImageView(imageLightGreen);
        imageView2.setRotate(90);
        imageView2.setLayoutX(170);
        imageView2.setLayoutY(480);
        listTrafficLight.add(imageView2);

        ImageView imageView3 = new ImageView(imageLightRed);
        imageView3.setRotate(270);
        imageView3.setLayoutX(535);
        imageView3.setLayoutY(190);
        listTrafficLight.add(imageView3);
        ImageView imageView4 = new ImageView(imageLightYellow);
        imageView4.setRotate(270);
        imageView4.setLayoutX(535);
        imageView4.setLayoutY(190);
        listTrafficLight.add(imageView4);
        ImageView imageView5 = new ImageView(imageLightGreen);
        imageView5.setRotate(270);
        imageView5.setLayoutX(535);
        imageView5.setLayoutY(190);
        listTrafficLight.add(imageView5);

        ImageView imageView6 = new ImageView(imageLightRed);
        imageView6.setRotate(180);
        imageView6.setLayoutX(205);
        imageView6.setLayoutY(160);
        listTrafficLight.add(imageView6);
        ImageView imageView7 = new ImageView(imageLightYellow);
        imageView7.setRotate(180);
        imageView7.setLayoutX(205);
        imageView7.setLayoutY(160);
        listTrafficLight.add(imageView7);
        ImageView imageView8 = new ImageView(imageLightGreen);
        imageView8.setRotate(180);
        imageView8.setLayoutX(205);
        imageView8.setLayoutY(160);
        listTrafficLight.add(imageView8);

        ImageView imageView9 = new ImageView(imageLightRed);
        imageView9.setRotate(0);
        imageView9.setLayoutX(500);
        imageView9.setLayoutY(510);
        listTrafficLight.add(imageView9);
        ImageView imageView10 = new ImageView(imageLightYellow);
        imageView10.setRotate(0);
        imageView10.setLayoutX(500);
        imageView10.setLayoutY(510);
        listTrafficLight.add(imageView10);
        ImageView imageView11 = new ImageView(imageLightGreen);
        imageView11.setRotate(0);
        imageView11.setLayoutX(500);
        imageView11.setLayoutY(510);
        listTrafficLight.add(imageView11);
    }    // метод который создает светофоры

    public static Singelton getInstans()  {
        Singelton localInstance = instans;
        if (localInstance == null) {
            synchronized (Singelton.class) {
                localInstance = instans;
                if (localInstance == null) {
                    instans = localInstance = new Singelton();
                }
            }
        }
        return localInstance;
    }   // метод возвращает инстанс класса Singelton

    public Boolean[] mas(String s) {

        switch (s) {
            case "WestA": {
                return WestBooleanA;
            }
            case "WestB": {
                return WestBooleanB;
            }
            case "EastA": {
                return EastBooleanA;
            }
            case "EastB": {
                return EastBooleanB;
            }
            case "NorthA": {
                return NorthBooleanA;
            }
            case "NorthB": {
                return NorthBooleanB;
            }
            case "SouthA": {
                return SouthBooleanA;
            }
            case "SouthB": {
                return SouthBooleanB;
            }
        }
        return null;
    }    // метод возвращает нужный массив для отметок расположения авто

    public void STrafficLightCounter() {     //
        trafficLightCounter++;
    }   // при вызове метода общий счетчик светофора увеличивается на единицу

    public int getTrafficLightCounter() {
        return trafficLightCounter;
    }   // возвращает значение общего счетчика светофоров

    public void setTrafficLightCounter(int counter) {
        trafficLightCounter = counter;
    }        // изменяет значение общего счетчика

    public List<ImageView> getListTrafficLight() {
        return listTrafficLight;
    }   // метод возвращает лист(массив) со светофорами
}

