package org.example.stage4.dao.impl;

import org.example.stage4.dao.PlaneRepository;
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
        planes.add(Plane.builder()
                .id(1L)
                .capacity(150)
                .type(PlaneType.PASSENGER)
                .technicalDate(LocalDateTime.now().minusMonths(6))
                .status(PlaneStatus.FLIGHT)
                .build());

        planes.add(Plane.builder()
                .id(2L)
                .capacity(200)
                .type(PlaneType.CARGO)
                .technicalDate(LocalDateTime.now().minusMonths(12))
                .status(PlaneStatus.WAITING_SERVICE)
                .build());

        planes.add(Plane.builder()
                .id(3L)
                .capacity(100)
                .type(PlaneType.PASSENGER)
                .technicalDate(LocalDateTime.now().minusMonths(3))
                .status(PlaneStatus.FLIGHT)
                .build());

        planes.add(Plane.builder()
                .id(4L)
                .capacity(180)
                .type(PlaneType.PASSENGER)
                .technicalDate(LocalDateTime.now().minusMonths(1))
                .status(PlaneStatus.WAITING_SERVICE)
                .build());

        planes.add(Plane.builder()
                .id(5L)
                .capacity(220)
                .type(PlaneType.CARGO)
                .technicalDate(LocalDateTime.now().minusYears(1))
                .status(PlaneStatus.FLIGHT)
                .build());

        planes.add(Plane.builder()
                .id(6L)
                .capacity(120)
                .type(PlaneType.CARGO)
                .technicalDate(LocalDateTime.now().minusMonths(9))
                .status(PlaneStatus.WAITING_SERVICE)
                .build());

        planes.add(Plane.builder()
                .id(7L)
                .capacity(160)
                .type(PlaneType.PASSENGER)
                .technicalDate(LocalDateTime.now().minusMonths(6))
                .status(PlaneStatus.FLIGHT)
                .build());

        planes.add(Plane.builder()
                .id(8L)
                .capacity(250)
                .type(PlaneType.CARGO)
                .technicalDate(LocalDateTime.now().minusYears(2))
                .status(PlaneStatus.FLIGHT)
                .build());

        planes.add(Plane.builder()
                .id(9L)
                .capacity(110)
                .type(PlaneType.PASSENGER)
                .technicalDate(LocalDateTime.now().minusMonths(3))
                .status(PlaneStatus.WAITING_SERVICE)
                .build());

        planes.add(Plane.builder()
                .id(10L)
                .capacity(200)
                .type(PlaneType.PASSENGER)
                .technicalDate(LocalDateTime.now().minusMonths(10))
                .status(PlaneStatus.FLIGHT)
                .build());

        planes.add(Plane.builder()
                .id(11L)
                .capacity(215)
                .type(PlaneType.CARGO)
                .technicalDate(LocalDateTime.now().minusMonths(8))
                .status(PlaneStatus.WAITING_SERVICE)
                .build());
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
