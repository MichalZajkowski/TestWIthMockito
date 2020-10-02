import mock.Car;
import mock.CarException;
import mock.FindCar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarSearchMocksTest {

    @Mock
    FindCar findCarMock;

    @Test
    public void shouldCreateMockInstance(){
        assertThat(findCarMock, is(notNullValue()));
    }

    @Test
    public void verifyMock() throws CarException {
        findCarMock.findCar("test", 100, 2020);
        verify(findCarMock).findCar("test", 100, 2020);
    }

    @Test
    public void verifyMockWithAtMost() throws CarException {
        findCarMock.findCar("test", 100, 2020);
        verify(findCarMock, atMost(10)).findCar(anyString(), anyInt(), anyInt());
    }

    @Test
    public void verifyMockWithAtLeastOnce() throws CarException {
        findCarMock.findCar("test", 100, 2020);
        verify(findCarMock, atLeastOnce()).findCar(contains("te"), 100, 2020);
    }

    @Test
    public void whenMock() throws CarException {
        Car car = new Car("Test", 100, 2030);
        when(findCarMock.findCar("Test", 0, 0))
                .thenReturn(Collections.singletonList(car));
        List<Car> cars = findCarMock.findCar("Test", 0, 0);
        assertThat(cars.size(), is(1));
        assertThat(cars.get(0), is(car));
    }
}
