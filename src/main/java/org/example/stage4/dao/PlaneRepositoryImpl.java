package org.example.stage4.dao;

import org.example.stage4.enums.PlaneStatus;
import org.example.stage4.enums.PlaneType;
import org.example.stage4.model.Plane;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PlaneRepositoryImpl implements PlaneRepository {
    private final List<Plane> planes;

    public PlaneRepositoryImpl() {
        planes = new ArrayList<>();
        initPlanes();
    }

    private void initPlanes() {
        planes.add(new Plane(1L, 150, PlaneType.PASSENGER, LocalDateTime.now().minusMonths(6), PlaneStatus.FLIGHT));
        planes.add(new Plane(2L, 120, PlaneType.PASSENGER, LocalDateTime.now().minusMonths(12), PlaneStatus.WAITING_SERVICE));
        planes.add(new Plane(3L, 200, PlaneType.CARGO, LocalDateTime.now().minusMonths(3), PlaneStatus.FLIGHT));
        planes.add(new Plane(4L, 220, PlaneType.PASSENGER, LocalDateTime.now().minusMonths(2), PlaneStatus.WAITING_SERVICE));
        planes.add(new Plane(5L, 300, PlaneType.PASSENGER, LocalDateTime.now().minusMonths(1), PlaneStatus.FLIGHT));
        planes.add(new Plane(6L, 100, PlaneType.CARGO, LocalDateTime.now().minusMonths(8), PlaneStatus.WAITING_SERVICE));
        planes.add(new Plane(7L, 120, PlaneType.PASSENGER, LocalDateTime.now().minusMonths(5), PlaneStatus.FLIGHT));
        planes.add(new Plane(8L, 160, PlaneType.CARGO, LocalDateTime.now().minusMonths(10), PlaneStatus.WAITING_SERVICE));
        planes.add(new Plane(9L, 180, PlaneType.PASSENGER, LocalDateTime.now().minusMonths(7), PlaneStatus.FLIGHT));
        planes.add(new Plane(10L, 250, PlaneType.CARGO, LocalDateTime.now().minusMonths(9), PlaneStatus.WAITING_SERVICE));
    }

    @Override
    public List<Plane> getAllPlanes() {
        return planes;
    }

    @Override
    public int getQuantityPlanesByPlaneType(PlaneType planeType) {
        return (int) planes.stream()
                .filter(plane -> plane.getType() == planeType)
                .count();
    }

    @Override
    public List<Plane> getPlanesByPlaneType(PlaneType planeType) {
        return planes.stream()
                .filter(plane -> plane.getType() == planeType)
                .toList();
    }

    @Override
    public Plane getPlaneByPlaneTypeAndCapacity(PlaneType planeType, int capacity) {
        return planes.stream()
                .filter(plane -> plane.getType() == planeType && plane.getCapacity() == capacity)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updatePlaneStatus(Long id, PlaneStatus status, PlaneType type) {
        planes.stream()
                .filter(plane -> Objects.equals(plane.getId(), id) && plane.getType() == type)
                .findFirst()
                .ifPresent(plane ->
                        plane.setStatus(status)
                );
    }
}
