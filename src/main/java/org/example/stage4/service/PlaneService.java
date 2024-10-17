package org.example.stage4.service;

import lombok.RequiredArgsConstructor;
import org.example.stage4.dao.PlaneRepository;
import org.example.stage4.enums.PlaneStatus;
import org.example.stage4.enums.PlaneType;
import org.example.stage4.model.Plane;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;
    @Value("${app.total-size}")
    private int totalSize;

    public void method(PlaneType type, int totalSize) {
        List<Plane> planes = planeRepository.getPlanesByPlaneType(type); // получаем все самолеты по переданному типу

        planes.stream()
                .filter(plane -> plane.getStatus() == PlaneStatus.SERVICE)
                .forEach(plane -> {
                    plane.setStatus(PlaneStatus.WAITING_SERVICE);
                    plane.setTechnicalDate(LocalDateTime.now());
                });

        long flight = planes.stream() // число всех кто в полете
                .filter(plane -> plane.getStatus() == PlaneStatus.FLIGHT)
                .count();

        long threshold = planes.size() / 2; // допустимый порог

        if (flight < threshold) {
            planes.stream()
                    .filter(plane -> plane.getStatus() == PlaneStatus.WAITING_SERVICE)
                    .limit(totalSize) // лимит из конфгиа
                    .forEach(plane -> plane.setStatus(PlaneStatus.SERVICE));
        }
    }

    public void sendProduct(int capacity, PlaneType planeType) {
        Plane plane = planeRepository.getPlaneByPlaneTypeAndCapacity(planeType, capacity); // ищем подходящий самолет
        if (plane != null) {
            plane.setStatus(PlaneStatus.FLIGHT); // меняем статус
        } else {
            throw new IllegalArgumentException("Invalid plane type or capacity: " + planeType + ", " + capacity); // исключение
        }
    }

    public void registerPlane(Long id) {
        List<Plane> planes = planeRepository.getAllPlanes();
        planes.stream()
                .filter(plane -> plane.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(plane -> {
                    if (plane.getStatus() == PlaneStatus.FLIGHT) { // проверить статус
                        plane.setCapacity(0); // Обнуляем груз
                        plane.setStatus(PlaneStatus.WAITING_SERVICE); // изменяем статус на "ожидает"
                    } else {
                        throw new IllegalStateException("Plane must be in flight to be registered!"); // исключение
                    }
                }, () -> {
                    throw new NoSuchElementException("Plane with id " + id + " does not exist."); // исключение, если самолет не найден
                });
    }
}