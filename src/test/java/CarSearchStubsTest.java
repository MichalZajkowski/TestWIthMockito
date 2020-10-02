import mock.Car;
import mock.CarSearch;
import mock.FindCar;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CarSearchStubsTest {

    private final FindCar subCar1 = (manufacture, price, yearOfProduction) -> Collections.singletonList(
            new Car("Abc",1000, 2012)
    );

    private final FindCar subCar2 = (manufacture, price, yearOfProduction) -> Collections.singletonList(
            new Car("Abcd",9999, 2020)
    );

    @Test
    public void shouldFindTheBestCar(){
        CarSearch carSearch = new CarSearch(subCar1, subCar2);
        assertThat(carSearch.findTheBestCar("manufacture", 999, 2010).getManufacturer(), is("Abc"));
    }
}
