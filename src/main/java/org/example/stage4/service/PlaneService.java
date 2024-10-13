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
                    if (plane.getStatus() == PlaneStatus.FLIGHT) { // Проверить статус
                        plane.setCapacity(0); // Обнуляем груз
                        plane.setStatus(PlaneStatus.WAITING_SERVICE); // Изменяем статус на "ожидает"
                    } else {
                        throw new IllegalStateException("Plane must be in flight to be registered!"); // Исключение
                    }
                }, () -> {
                    throw new NoSuchElementException("Plane with id " + id + " does not exist."); // Исключение, если самолет не найден
                });
    }

    public void technicalService() {
        List<Plane> cargoPlanes = planeRepository.getPlanesByPlaneType(PlaneType.CARGO); // получаем все грузовые самолеты
        List<Plane> passengerPlanes = planeRepository.getPlanesByPlaneType(PlaneType.PASSENGER); // получаем все пассажирские самолеты

        cargoPlanes.stream()
                .filter(plane -> plane.getStatus() == PlaneStatus.SERVICE)
                .forEach(plane -> {
                    plane.setStatus(PlaneStatus.WAITING_SERVICE); // Изменяем статус на "ожидает"
                    plane.setTechnicalDate(LocalDateTime.now()); // Обновляем technicalDate
                });

        long flightCount = cargoPlanes.stream() // кол-о грузовых самолетов со статусом в полете
                .filter(plane -> plane.getStatus() == PlaneStatus.FLIGHT)
                .count();

        long totalCount = cargoPlanes.size(); // количество грузовых самолетов
        long threshold = totalCount / 2; // допустимый порог

        if (flightCount < threshold) {
            cargoPlanes.stream()
                    .filter(plane -> plane.getStatus() == PlaneStatus.WAITING_SERVICE)
                    .limit(totalSize)
                    .forEach(plane ->
                            plane.setStatus(PlaneStatus.SERVICE)
                            );
        }

        // Повторяем для пассажирских
        passengerPlanes.stream()
                .filter(plane -> plane.getStatus() == PlaneStatus.SERVICE)
                .forEach(plane -> {
                    plane.setStatus(PlaneStatus.WAITING_SERVICE); // Изменяем статус на "ожидает"
                    plane.setTechnicalDate(LocalDateTime.now()); // Обновляем technicalDate
                });

        flightCount = passengerPlanes.stream() // кол-о пассажирских самолетов со статусом в полете
                .filter(plane -> plane.getStatus() == PlaneStatus.FLIGHT)
                .count();

        totalCount = passengerPlanes.size(); // количество пассажиских самолетов
        threshold = totalCount / 2; // допустимый порог

        if (flightCount < threshold) {
            passengerPlanes.stream()
                    .filter(plane -> plane.getStatus() == PlaneStatus.WAITING_SERVICE)
                    .limit(totalSize)
                    .forEach(plane ->
                            plane.setStatus(PlaneStatus.SERVICE)
                    );
        }
    }
}