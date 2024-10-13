package org.example.stage4.dao;

import org.example.stage4.enums.PlaneStatus;
import org.example.stage4.enums.PlaneType;
import org.example.stage4.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneRepository {
    List<Plane> getAllPlanes();
    int getQuantityPlanesByPlaneType(PlaneType type);
    List<Plane> getPlanesByPlaneType(PlaneType type);
    Plane getPlaneByPlaneTypeAndCapacity(PlaneType type, int capacity);
    void updatePlaneStatus(Long id, PlaneStatus status, PlaneType type);
}
