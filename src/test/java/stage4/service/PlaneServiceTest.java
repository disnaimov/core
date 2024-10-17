package stage4.service;

import org.example.stage4.dao.PlaneRepository;
import org.example.stage4.enums.PlaneStatus;
import org.example.stage4.enums.PlaneType;
import org.example.stage4.model.Plane;
import org.example.stage4.service.PlaneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlaneServiceTest {
    private List<Plane> planes;
    @InjectMocks
    PlaneService planeService;
    @Mock
    private PlaneRepository planeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        planeService = new PlaneService(planeRepository);
        planes = new ArrayList<>();

        planes.add(new Plane(1L, 200, PlaneType.PASSENGER, LocalDateTime.now().minusMonths(6), PlaneStatus.FLIGHT));
        planes.add(new Plane(2L, 300, PlaneType.PASSENGER, LocalDateTime.now().minusMonths(12), PlaneStatus.WAITING_SERVICE));
        planes.add(new Plane(3L, 400, PlaneType.PASSENGER, LocalDateTime.now().minusMonths(6), PlaneStatus.SERVICE));
        planes.add(new Plane(4L, 500, PlaneType.PASSENGER, LocalDateTime.now().minusMonths(12), PlaneStatus.WAITING_SERVICE));
        ;
    }

    @Test
    public void testMethod_UpdatesServicePlanes() {
        when(planeRepository.getPlanesByPlaneType(PlaneType.PASSENGER)).thenReturn(planes);
        planeService.method(PlaneType.PASSENGER, 5);
        assertEquals(PlaneStatus.SERVICE, planes.get(2).getStatus());
    }

    @Test
    void testSendProduct_ValidPlane() {
        when(planeRepository.getPlaneByPlaneTypeAndCapacity(PlaneType.PASSENGER, 150)).thenReturn(planes.get(0));

        planeService.sendProduct(150, PlaneType.PASSENGER);

        assertEquals(PlaneStatus.FLIGHT, planes.get(0).getStatus());
    }

    @Test
    void testSendProduct_InvalidPlane() {
        when(planeRepository.getPlaneByPlaneTypeAndCapacity(PlaneType.PASSENGER, 200)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            planeService.sendProduct(200, PlaneType.PASSENGER);
        });

        assertEquals("Invalid plane type or capacity: PASSENGER, 200", exception.getMessage());
    }

    @Test
    void testRegisterPlane_ValidPlaneInFlight() {
        when(planeRepository.getAllPlanes()).thenReturn(planes);

        planeService.registerPlane(1L);

        assertEquals(PlaneStatus.WAITING_SERVICE, planes.get(0).getStatus());
        assertEquals(0, planes.get(0).getCapacity());
    }

    @Test
    void testRegisterPlane_InvalidPlaneNotInFlight() {
        when(planeRepository.getAllPlanes()).thenReturn(planes);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            planeService.registerPlane(2L);
        });

        assertEquals("Plane must be in flight to be registered!", exception.getMessage());
    }

    @Test
    void testRegisterPlane_PlaneNotFound() {
        when(planeRepository.getAllPlanes()).thenReturn(planes);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            planeService.registerPlane(99L);
        });

        assertEquals("Plane with id 99 does not exist.", exception.getMessage());
    }

}
