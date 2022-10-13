package ss5_access_modifier_and_static.practices.static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car = new Car("Mazda 3", "skyactive 3");
        System.out.println(Car.numberOfCar);
        Car car1 = new Car("Mazda 6","skyactive 6");
        System.out.println(Car.numberOfCar);
        Car car2 = new Car("Mazda 9","skyactive 9");
        System.out.println(Car.numberOfCar);
    }


}
