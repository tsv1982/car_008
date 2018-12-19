
public class TrafficLight {   //  класс в котором настраиваем светофор

    private Singelton singelton = Singelton.getInstans();  //  получаем инстанс

    public TrafficLight()  {
    }

    public void RedLightWE() {
        singelton.getListTrafficLight().get(6).setVisible(false);
        singelton.getListTrafficLight().get(7).setVisible(false);
        singelton.getListTrafficLight().get(8).setVisible(true);
        singelton.getListTrafficLight().get(9).setVisible(false);
        singelton.getListTrafficLight().get(10).setVisible(false);
        singelton.getListTrafficLight().get(11).setVisible(true);
        singelton.getListTrafficLight().get(0).setVisible(true);
        singelton.getListTrafficLight().get(1).setVisible(false);
        singelton.getListTrafficLight().get(2).setVisible(false);
        singelton.getListTrafficLight().get(3).setVisible(true);
        singelton.getListTrafficLight().get(4).setVisible(false);
        singelton.getListTrafficLight().get(5).setVisible(false);
    }   //  метод для настройки красного светофора

    public void YellowLight() {
        singelton.getListTrafficLight().get(0).setVisible(false);
        singelton.getListTrafficLight().get(1).setVisible(true);
        singelton.getListTrafficLight().get(2).setVisible(false);
        singelton.getListTrafficLight().get(3).setVisible(false);
        singelton.getListTrafficLight().get(4).setVisible(true);
        singelton.getListTrafficLight().get(5).setVisible(false);
        singelton.getListTrafficLight().get(6).setVisible(false);
        singelton.getListTrafficLight().get(7).setVisible(true);
        singelton.getListTrafficLight().get(8).setVisible(false);
        singelton.getListTrafficLight().get(9).setVisible(false);
        singelton.getListTrafficLight().get(10).setVisible(true);
        singelton.getListTrafficLight().get(11).setVisible(false);
    }   //  метод для настройки желтого светофора

    public void GreenLightWE() {
        singelton.getListTrafficLight().get(6).setVisible(true);
        singelton.getListTrafficLight().get(7).setVisible(false);
        singelton.getListTrafficLight().get(8).setVisible(false);
        singelton.getListTrafficLight().get(9).setVisible(true);
        singelton.getListTrafficLight().get(10).setVisible(false);
        singelton.getListTrafficLight().get(11).setVisible(false);
        singelton.getListTrafficLight().get(0).setVisible(false);
        singelton.getListTrafficLight().get(1).setVisible(false);
        singelton.getListTrafficLight().get(2).setVisible(true);
        singelton.getListTrafficLight().get(3).setVisible(false);
        singelton.getListTrafficLight().get(4).setVisible(false);
        singelton.getListTrafficLight().get(5).setVisible(true);
    }   //  метод для настройки зеленого светофора
}
