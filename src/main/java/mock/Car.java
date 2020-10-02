package mock;

public class Car {

    private final String manufacturer;
    private final Integer price;
    private final Integer yearOfProduction;

    public Car(String manufacturer, Integer price, Integer yearOfProduction) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.yearOfProduction = yearOfProduction;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }
}
