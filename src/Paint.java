import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// класс который отрисовует авто, фон, кнопки

public class Paint {

    Singelton singelton = Singelton.getInstans();

    private List<ImageView> listViewCar = new ArrayList<>();  // создаем список отрисованных авто
    private Text textCounterCar = new Text("0 car");         // для вывода счетчика автомобилей
    private Text textCounterStep = new Text("0 step");       // для вывода счетчика шагов
    private Text texCounterRedL = new Text("0");               // для вывода счетчика красного светофора левого
    private Text texCounterGreenL = new Text("0");             // для вывода счетчика зеленого светофора левого
    private Text texCounterRedR = new Text("0");               // для вывода счетчика красного светофора правого
    private Text texCounterGreenR = new Text("0");             // для вывода счетчика зеленого светофора правого
    private   Timer timer;   //  переменная класса таймер

    MoveCar2 moveCarWestA2 = new MoveCar2("WestA", -50, 410, 180);       // создаем класса moveCar2 для каждого авто
    MoveCar2 moveCarWestAA2 = new MoveCar2("WestA", -50, 410, 180);
    MoveCar2 moveCarWestAA3 = new MoveCar2("WestA", -50, 410, 180);
    MoveCar2 moveCarWestAA4 = new MoveCar2("WestA", -50, 410, 180);
    MoveCar2 moveCarWestAA5 = new MoveCar2("WestA", -50, 410, 180);

    MoveCar2 moveCarWestB2 = new MoveCar2("WestB", -50, 450, 180);
    MoveCar2 moveCarWestBB2 = new MoveCar2("WestB", -50, 450, 180);
    MoveCar2 moveCarWestBB3 = new MoveCar2("WestB", -50, 450, 180);
    MoveCar2 moveCarWestBB4 = new MoveCar2("WestB", -50, 450, 180);

    MoveCar2 moveCarEastA2 = new MoveCar2("EastA", 800, 360, 0);
    MoveCar2 moveCarEastAA2 = new MoveCar2("EastA", 800, 360, 0);
    MoveCar2 moveCarEastAA3 = new MoveCar2("EastA", 800, 360, 0);
    MoveCar2 moveCarEastAA4 = new MoveCar2("EastA", 800, 360, 0);
    MoveCar2 moveCarEastAA5 = new MoveCar2("EastA", 800, 360, 0);
    MoveCar2 moveCarEastAA6 = new MoveCar2("EastA", 800, 360, 0);

    MoveCar2 moveCarEastB2 = new MoveCar2("EastB", 800, 320, 0);
    MoveCar2 moveCarEastBB2 = new MoveCar2("EastB", 800, 320, 0);
    MoveCar2 moveCarEastBB3 = new MoveCar2("EastB", 800, 320, 0);
    MoveCar2 moveCarEastBB4 = new MoveCar2("EastB", 800, 320, 0);
    MoveCar2 moveCarEastBB5 = new MoveCar2("EastB", 800, 320, 0);
    MoveCar2 moveCarEastBB6 = new MoveCar2("EastB", 800, 320, 0);

    MoveCar2 moveCarNorthA2 = new MoveCar2("NorthA", 350, -40, 270);
    MoveCar2 moveCarNorthAA2 = new MoveCar2("NorthA", 350, -40, 270);
    MoveCar2 moveCarNorthAA3 = new MoveCar2("NorthA", 350, -40, 270);

    MoveCar2 moveCarNorthB2 = new MoveCar2("NorthB", 310, -40, 270);
    MoveCar2 moveCarNorthBB2 = new MoveCar2("NorthB", 310, -40, 270);

    MoveCar2 moveCarSouthA2 = new MoveCar2("SouthA", 400, 810, 90);
    MoveCar2 moveCarSouthAA2 = new MoveCar2("SouthA", 400, 810, 90);

    MoveCar2 moveCarSouthB2 = new MoveCar2("SouthB", 450, 810, 90);
    MoveCar2 moveCarSouthBB2 = new MoveCar2("SouthB", 450, 810, 90);
    MoveCar2 moveCarSouthBB3 = new MoveCar2("SouthB", 450, 810, 90);
    MoveCar2 moveCarSouthBB4 = new MoveCar2("SouthB", 450, 810, 90);

    public Paint()  {
        ArrayList<Layout> layoutsList = (ArrayList<Layout>) new Layout().getLayoutsList(); //  получаем list с начальными размещениями авто с класса Layout
        for (int i = 0; i < 32; i++) {
            addlistViewCar(layoutsList.get(i).getRotate(), layoutsList.get(i).getLayoutX(), layoutsList.get(i).getLayoutY());
        }
    }  // конструктор, добавляем отрисованные авто их расположение

    private void addlistViewCar(int rotate, int layoutX, int layoutY)  {
        BuildCars buildCars = new BuildCars();
        Image imageCar = null;  // считываем картинку авто из файла
        try {
            imageCar = new Image(new FileInputStream(buildCars.getCar().getImage()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageViewCar = new ImageView(imageCar);   // передаем imageCar классу ImageView
        imageViewCar.setRotate(rotate);    // указываем rotate авто
        imageViewCar.setLayoutX(layoutX);  // указываем начальное положение авто по x
        imageViewCar.setLayoutY(layoutY);   // указываем начальное положение авто по Y
        listViewCar.add(imageViewCar);
    }   // метод добавляет в лист отрисованные авто

    public void startCar() {
        if (singelton.getTrafficLightCounter() < (singelton.getRed() + singelton.getYellow() + singelton.getGreen())) {   // проверяем общий счетчик не больше за красный, желтый и зеленый
            singelton.STrafficLightCounter();                             // добавляем единицу к общему счетчику светофора
            if (singelton.getCounterGreen() < singelton.getGreen()) {     // проверяем не закончился ли зеленый
                singelton.SsetCounterGreen();                             // добавляем единицу к счетчику зеленого
            } else {
                if (singelton.getCounterYellow() < singelton.getYellow()) {   // проверяем не закончился ли желтый
                    singelton.SsetCounterYellow();                            // добавляем единицу к счетчику желтого
                } else {
                    if (singelton.getCounterRed() < singelton.getRed()) {    // проверяем не закончился ли красный
                        singelton.SsetCounterRed();                           // добавляем единицу к счетчику красный
                    }
                }
            }
        } else {
            singelton.setTrafficLightCounter(0);   // сбрасывает счетчики
            singelton.setCounterGreen(0);
            singelton.setCounterYellow(0);
            singelton.setCounterRed(0);
        }

        singelton.setCounterStep();     //  считаем шаги

        textCounterCar.setText(singelton.getCounterCar() + " car");           // добавляем в текст для вывода счетчики авто, шаги, красный, зеленый
        textCounterStep.setText(singelton.getCounterStep() + " step");
        texCounterRedL.setText(String.valueOf(singelton.getRed() - singelton.getCounterRed()));
        texCounterGreenL.setText(String.valueOf(singelton.getGreen() - singelton.getCounterGreen()));
        texCounterRedR.setText(String.valueOf(singelton.getRed() - singelton.getCounterRed()));
        texCounterGreenR.setText(String.valueOf(singelton.getGreen() - singelton.getCounterGreen()));

        moveCarWestA2.move(listViewCar.get(0), 90, "SouthA", "EastA", "EastB");  // west A   вызываем методы для движения авто
        moveCarWestAA2.move(listViewCar.get(1), 90, "SouthA", "EastA", "EastB");  // west A
        moveCarWestAA3.move(listViewCar.get(2), 90, "SouthA", "EastA", "EastB");  // west A
        moveCarWestAA4.move(listViewCar.get(3), 90, "SouthA", "EastA", "EastB");  // west A
        moveCarWestAA5.move(listViewCar.get(4), 90, "SouthA", "EastA", "EastB");  // west A

        moveCarWestB2.move(listViewCar.get(5), 270, "NorthB", "EastA", "EastB");   // west B
        moveCarWestBB2.move(listViewCar.get(6), 270, "NorthB", "EastA", "EastB");   // west B
        moveCarWestBB3.move(listViewCar.get(7), 270, "NorthB", "EastA", "EastB");   // west B
        moveCarWestBB4.move(listViewCar.get(8), 270, "NorthB", "EastA", "EastB");   // west B

        moveCarEastA2.move(listViewCar.get(9), 270, "NorthA", "WestA", "WestB");   // East A
        moveCarEastAA2.move(listViewCar.get(10), 270, "NorthA", "WestA", "WestB");   // East A
        moveCarEastAA3.move(listViewCar.get(11), 270, "NorthA", "WestA", "WestB");   // East A
        moveCarEastAA4.move(listViewCar.get(12), 270, "NorthA", "WestA", "WestB");   // East A
        moveCarEastAA5.move(listViewCar.get(13), 270, "NorthA", "WestA", "WestB");   // East A
        moveCarEastAA6.move(listViewCar.get(14), 270, "NorthA", "WestA", "WestB");   // East A

        moveCarEastB2.move(listViewCar.get(15), 90, "SouthB", "WestA", "WestB");    // East B
        moveCarEastBB2.move(listViewCar.get(16), 90, "SouthB", "WestA", "WestB");    // East B
        moveCarEastBB3.move(listViewCar.get(17), 90, "SouthB", "WestA", "WestB");    // East B
        moveCarEastBB4.move(listViewCar.get(18), 90, "SouthB", "WestA", "WestB");    // East B
        moveCarEastBB5.move(listViewCar.get(19), 90, "SouthB", "WestA", "WestB");    // East B
        moveCarEastBB6.move(listViewCar.get(20), 90, "SouthB", "WestA", "WestB");    // East B

        moveCarNorthA2.move(listViewCar.get(21), 180, "WestA", "SouthA", "SouthB");    // NorthA
        moveCarNorthAA2.move(listViewCar.get(22), 180, "WestA", "SouthA", "SouthB");    // NorthA
        moveCarNorthAA3.move(listViewCar.get(23), 180, "WestA", "SouthA", "SouthB");    // NorthA

        moveCarNorthB2.move(listViewCar.get(24), 0, "EastB", "SouthA", "SouthB");    // NorthA
        moveCarNorthBB2.move(listViewCar.get(25), 0, "EastB", "SouthA", "SouthB");    // NorthA

        moveCarSouthA2.move(listViewCar.get(26), 0, "EastA", "NorthA", "NorthB");    // NorthA
        moveCarSouthAA2.move(listViewCar.get(27), 0, "EastA", "NorthA", "NorthB");    // NorthA

        moveCarSouthB2.move(listViewCar.get(28), 180, "WestB", "NorthA", "NorthB");    // NorthA
        moveCarSouthBB2.move(listViewCar.get(29), 180, "WestB", "NorthA", "NorthB");    // NorthA
        moveCarSouthBB3.move(listViewCar.get(30), 180, "WestB", "NorthA", "NorthB");    // NorthA
        moveCarSouthBB4.move(listViewCar.get(31), 180, "WestB", "NorthA", "NorthB");    // NorthA
    }    // метод который передвигает авто

    public ImageView paintPole()  {

        Image imagePole = null;  // читаем картинку из файла
        try {
            imagePole = new Image(new FileInputStream("img/pole.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(imagePole);                          //  передаем считанный файл классу ImageView

        imageView.setOnMouseClicked(event -> {

                startCar();


        });
        return imageView;  // возвращаем imageView
    }  // метод отрисовки поля и управление полем по клику

    public VBox paintVbox() {
        VBox vBox = new VBox();   // создаем менеджер кнопок

        HBox hBox = new HBox();  // создаем менеджер кнопок
        hBox.setSpacing(10);     // растояние между кнопками
        HBox hBox1 = new HBox();  // создаем менеджер кнопок
        hBox1.setSpacing(10);     // растояние между кнопками
        HBox hBox2 = new HBox();  // создаем менеджер кнопок
        hBox2.setSpacing(10);     // растояние между кнопками

        TextField textField = new TextField("red");   // создаем поле для ввода красного
        textField.setMaxWidth(70);      //  размер поля для ввода
        textField.setOnMouseClicked(event -> {
            textField.setText("");
        });

        TextField textField1 = new TextField("yellow");   // создаем поле для ввода
        textField1.setMaxWidth(70);      //  размер поля для ввода
        textField1.setOnMouseClicked(event -> {
            textField1.setText("");
        });

        TextField textField2 = new TextField("green");   // создаем поле для ввода
        textField2.setMaxWidth(70);      //  размер поля для ввода
        textField2.setOnMouseClicked(event -> {
            textField2.setText("");
        });

        Button buttonOk = new Button("ok");     //  создаем кнопку
        buttonOk.setOnMouseClicked(event -> {
            singelton.setRed(Integer.parseInt(textField.getText()));         // считываем значения красного, желтого, зеленого и присваиваем переменным
            singelton.setYellow(Integer.parseInt(textField1.getText()));
            singelton.setGreen(Integer.parseInt(textField2.getText()));
        });

        hBox.getChildren().add(textField);    //  добавляем поле для ввода и кнопку в менеджер
        hBox1.getChildren().add(textField1);  //  добавляем поле для ввода и кнопку в менеджер
        hBox2.getChildren().add(textField2);  //  добавляем поле для ввода и кнопку в менеджер
        hBox2.getChildren().addAll(buttonOk);  //  добавляем поле для ввода и кнопку в менеджер

        vBox.getChildren().addAll(hBox, hBox1, hBox2);
        vBox.setSpacing(10);     // расстояние между менеджерам
        return vBox;    // возвращаем менеджер
    }   // метод для отрисовки кнопок

    public VBox painButtonStartStop() {
        VBox vBox = new VBox();
        Button button = new Button("start");
        button.setLayoutX(550);
        button.setLayoutY(20);
        button.setPrefHeight(40);
        button.setPrefWidth(100);

        button.setOnMouseClicked(event -> {           // добавил клас таймер для автомтической прогонки
            timer= new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    startCar();
                }
            }, 0, 500);    // для изменения скорости меняй 500
        });

        Button button1 = new Button("pause");
        button1.setLayoutX(550);
        button1.setLayoutY(20);
        button1.setPrefHeight(40);
        button1.setPrefWidth(100);

        button1.setOnMouseClicked(event -> {     //  обнуляем таймер
            timer.cancel();
            timer = null;
        });

        vBox.getChildren().addAll(button, button1);

        vBox.setLayoutX(550);
        vBox.setLayoutY(20);
        vBox.setSpacing(10);
        return vBox;
    } // метод для создания кнопок старт стоп

    public List getlistViewCar() {
        return listViewCar;
    }   //  возвращаем список отрисованных авто

    public Text getTextCounterCar() {
        textCounterCar.setX(20);
        textCounterCar.setY(700);
        textCounterCar.setFont(Font.font(40));
        return textCounterCar;
    }  // метод для размещения счетчика количества автомобилей

    public Text getTextCounterStep() {
        textCounterStep.setX(20);
        textCounterStep.setY(650);
        textCounterStep.setFont(Font.font(40));
        return textCounterStep;
    } // метод для размещения счетчика количества шагов

    public Text getTexCounterRedL() {
        texCounterRedL.setX(280);
        texCounterRedL.setY(550);
        texCounterRedL.setFont(Font.font(20));
        texCounterRedL.setRotate(90);
        return texCounterRedL;
    }  // метод для размещения счетчика красного левого

    public Text getTexCounterGreenL() {
        texCounterGreenL.setX(130);
        texCounterGreenL.setY(550);
        texCounterGreenL.setFont(Font.font(20));
        texCounterGreenL.setRotate(90);
        return texCounterGreenL;
    }   // метод для размещения счетчика зеленого левого

    public Text getTexCounterGreenR() {
        texCounterGreenR.setX(535);
        texCounterGreenR.setY(510);
        texCounterGreenR.setFont(Font.font(20));
        return texCounterGreenR;
    }   // метод для размещения счетчика зеленого правого

    public Text getTexCounterRedR() {
        texCounterRedR.setX(535);
        texCounterRedR.setY(650);
        texCounterRedR.setFont(Font.font(20));
        return texCounterRedR;
    }    // метод для размещения счетчика красного аправого
}




