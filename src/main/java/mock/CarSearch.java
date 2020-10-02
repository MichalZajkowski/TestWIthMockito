package mock;

import java.util.*;

public class CarSearch {

    private final FindCar[] findCars;

    public CarSearch(FindCar... findCars) {
        this.findCars = findCars;
    }

    public Car findTheBestCar(String manufacturer, int price, int yearOfProduction) {
        Optional<Car> theBestCar = Arrays.stream(findCars)
                .map(c -> {
                    try {
                        return c.findCar(manufacturer, price, yearOfProduction);
                    } catch (CarException e) {
                        return Collections.<Car>emptyList();
                    }
                })
                .flatMap(List::stream)
                .min(Comparator.comparing(Car::getPrice));
        return theBestCar.orElse(null);
    }
}
