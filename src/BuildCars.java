import java.util.Random;

public class BuildCars {  // класс который создает автомобили

    private Random random = new Random();       // Создаем экземпляр класса Random
    private CarColor carColor = new CarColor();  // Создаем экземпляр класса CarColor

    public Car getCar() {
        Car car = new Car();   // Создаем экземпляр класса Car
        car.setImage((String) carColor.getColor().get(random.nextInt(8))); // присваиваем авто цвет в рандомном порядке
        return car;    // возвращаем экземпляр класса Car
    }  // метод, который возвращает экземпляр класса Car
}
