package mock;

import java.util.List;

public interface FindCar {
    List<Car> findCar(String manufacturer, int price, int yearOfProduction) throws CarException;
}
