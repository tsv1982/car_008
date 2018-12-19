import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileNotFoundException;

public class MainCar extends Application {    // основной класс

    @Override
    public void start(Stage primaryStage)  {

        Paint paint = new Paint();   // создаем экземпляр класса Paint
        Pane pane = new Pane();       // создаем экземпляр класса Pane (контейнер расположений)

        pane.getChildren().addAll(paint.paintPole(), paint.paintVbox(), paint.getTextCounterCar(), paint.getTextCounterStep(), paint.getTexCounterRedL(),
                paint.getTexCounterGreenL(), paint.getTexCounterGreenR(), paint.getTexCounterRedR(), paint.painButtonStartStop());
                                                                                             // (добавляем в контейнер кнопки, текст, ит д )
        for (int i = 0; i < 12; i++) {
            pane.getChildren().add(paint.singelton.getListTrafficLight().get(i));    //  добавляем в контейнер светофоры
        }

        for (int i = 0; i < 32; i++) {
            pane.getChildren().add((ImageView) paint.getlistViewCar().get(i));       // добавляем в контейнер автомобили
        }

        Line lineX1 = new Line(0, 315, 800, 315);         // отрисовываем линии
        Line lineX2 = new Line(0, 345, 800, 345);
        Line lineX3 = new Line(0, 450, 800, 450);
        Line lineX4 = new Line(0, 480, 800, 480);

        Line lineY1 = new Line(450, 0, 450, 800);
        Line lineY2 = new Line(485, 0, 485, 800);
        Line lineY3 = new Line(315, 0, 315, 800);
        Line lineY4 = new Line(345, 0, 345, 800);

        pane.getChildren().addAll(lineX1, lineX2, lineX3, lineX4, lineY1, lineY2, lineY3, lineY4);    // добавляем линии в контейнер

        int a = 0;          //  переменные для отрисовки линий
        int b = 0;
        int c = 0;
        int d = 0;

        for (int i = 0; i < 16; i++) {
            a += 50;                     //  рисуем линии с шагом 50
            b += 50;
            c += 50;
            d += 50;
            pane.getChildren().addAll(new Line(a, 315, a, 410), new Line(b, 410, b, 480),     // добавляем линии в контейнер
                    new Line(315, c, 410, c), new Line(410, d, 485, d));
        }

        primaryStage.setScene(new Scene(pane, 800, 800));     //  добавляем сцену и задаем размеры начального экрана
        primaryStage.setTitle("Car");                                       //  добавляем надпись в title
        primaryStage.setResizable(false);                                   //  запрещаем развертывание окна
        primaryStage.show();                                                //  показывает приложение
    }
}



