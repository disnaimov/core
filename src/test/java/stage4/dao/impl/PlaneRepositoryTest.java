package stage4.dao.impl;

import org.example.stage4.dao.impl.PlaneRepositoryImpl;
import org.example.stage4.enums.PlaneStatus;
import org.example.stage4.enums.PlaneType;
import org.example.stage4.model.Plane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlaneRepositoryTest {
    private PlaneRepositoryImpl planeRepository;

    @BeforeEach
    void setUp() {
        planeRepository = new PlaneRepositoryImpl();
    }

    @Test
    void testGetAllPlanes() {
        List<Plane> planes = planeRepository.getAllPlanes();
        assertEquals(11, planes.size());
    }

    @Test
    void testGetQuantityPlanesByPlaneType() {
        int passengerCount = planeRepository.getQuantityPlanesByPlaneType(PlaneType.PASSENGER);
        int cargoCount = planeRepository.getQuantityPlanesByPlaneType(PlaneType.CARGO);

        assertEquals(6, passengerCount, "Should return 6 passenger planes");
        assertEquals(5, cargoCount, "Should return 5 cargo planes");
    }

    @Test
    void testGetPlanesByPlaneType() {
        List<Plane> passengerPlanes = planeRepository.getPlanesByPlaneType(PlaneType.PASSENGER);
        assertEquals(6, passengerPlanes.size(), "Should return 6 passenger planes");

        List<Plane> cargoPlanes = planeRepository.getPlanesByPlaneType(PlaneType.CARGO);
        assertEquals(5, cargoPlanes.size(), "Should return 5 cargo planes");
    }

    @Test
    void testGetPlaneByPlaneTypeAndCapacity() {
        Plane plane = planeRepository.getPlaneByPlaneTypeAndCapacity(PlaneType.PASSENGER, 150);
        assertNotNull(plane, "Should find a plane with type PASSENGER and capacity 150");
        assertEquals(1L, plane.getId(), "The plane ID should be 1");

        Plane nonExistentPlane = planeRepository.getPlaneByPlaneTypeAndCapacity(PlaneType.CARGO, 500);
        assertNull(nonExistentPlane, "Should return null for non-existent plane");
    }

    @Test
    void testUpdatePlaneStatus() {
        Long planeId = 1L;
        PlaneStatus newStatus = PlaneStatus.WAITING_SERVICE;
        PlaneType planeType = PlaneType.PASSENGER;

        // обновляем статус
        planeRepository.updatePlaneStatus(planeId, newStatus, planeType);

        // убедимся что статус обновлен
        Plane updatedPlane = planeRepository.getPlaneByPlaneTypeAndCapacity(planeType, 150);
        assertNotNull(updatedPlane, "The plane should exist");
        assertEquals(newStatus, updatedPlane.getStatus(), "The plane status should be updated to WAITING_SERVICE");
    }

}
