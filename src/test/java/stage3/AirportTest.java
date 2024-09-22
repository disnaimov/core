package stage3;

import org.example.stage3.enums.Cargo;
import org.example.stage3.model.CargoAirport;
import org.example.stage3.model.Plane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AirportTest {
    private CargoAirport airport;

    @BeforeEach
    public void setUp() {
        airport = new CargoAirport();
    }

    @Test
    public void testUnloadTechniquePlane() throws InterruptedException {
        Plane plane = new Plane(Cargo.TECHNIQUE, 50, 30); // начальная загрузка 30
        airport.landPlane(plane);
        airport.getTerminalByCargo(plane.getCargo());


        assertEquals(0, plane.getLoaded()); // Проверяем, что разгрузка завершена и нагрузка равна 0
    }

    @Test
    public void testUnloadMedicinePlane() throws InterruptedException {
        Plane plane = new Plane(Cargo.MEDICINE, 50, 25); // начальная загрузка 25
        airport.landPlane(plane);
        airport.getTerminalByCargo(plane.getCargo());


        assertEquals(0, plane.getLoaded()); // Проверяем, что разгрузка завершена и нагрузка равна 0
    }

    @Test
    public void testUnloadFoodPlane() throws InterruptedException {
        Plane plane = new Plane(Cargo.FOOD, 50, 50); // начальная загрузка 50
        airport.landPlane(plane);
        airport.getTerminalByCargo(plane.getCargo());


        assertEquals(0, plane.getLoaded()); // Проверяем, что разгрузка завершена и нагрузка равна 0
    }

    @Test
    public void testUnloadWithZeroLoad() throws InterruptedException {
        Plane plane = new Plane(Cargo.TECHNIQUE, 50, 0); // начальная загрузка 0
        airport.landPlane(plane);
        airport.getTerminalByCargo(plane.getCargo());


        assertEquals(0, plane.getLoaded()); // Проверяем, что разгрузка завершена и нагрузка равна 0
    }

    @Test
    public void testUnloadTwoFoodPlane() throws InterruptedException {
        Plane plane = new Plane(Cargo.FOOD, 50, 50); // начальная загрузка 50
        Plane secondPlane = new Plane(Cargo.FOOD, 100, 25); // начальная загрузка 25
        airport.landPlane(plane);
        airport.landPlane(secondPlane);
        airport.getTerminalByCargo(plane.getCargo());
        airport.getTerminalByCargo(secondPlane.getCargo());


        assertEquals(0, plane.getLoaded()); // Проверяем, что разгрузка завершена и нагрузка равна 0
        assertEquals(0, secondPlane.getLoaded()); // Проверяем, что разгрузка второго самолета завершена и нагрузка равна 0
    }
}
