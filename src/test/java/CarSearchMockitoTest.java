import mock.CarException;
import mock.CarSearch;
import mock.FindCar;
import org.junit.Test;
import org.mockito.Mockito;

public class CarSearchMockitoTest {

    @Test
    public void shouldFindTheBestCar() throws CarException {
        String manufacture = "manufacture";
        int price = 100000;
        int yearOfProduction = 2020;

        FindCar findCarMock1 = Mockito.mock(FindCar.class);
        FindCar findCarMock2 = Mockito.mock(FindCar.class);
        FindCar findCarMock3 = Mockito.mock(FindCar.class);

        CarSearch carSearch = new CarSearch(findCarMock1, findCarMock2, findCarMock3);
        carSearch.findTheBestCar(manufacture, price, yearOfProduction);

        Mockito.verify(findCarMock1).findCar(manufacture, price, yearOfProduction);
        Mockito.verify(findCarMock2).findCar(manufacture, price, yearOfProduction);
        Mockito.verify(findCarMock3).findCar(manufacture, price, yearOfProduction);
    }
}
