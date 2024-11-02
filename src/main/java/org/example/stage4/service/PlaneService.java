package org.example.stage4.service;

import org.example.stage4.enums.PlaneType;

public interface PlaneService {
    void technicalService(PlaneType type);
    void sendProduct(int capacity, PlaneType planeType);
    void registerPlane(Long id);
}
