package org.example.stage4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.stage4.enums.PlaneStatus;
import org.example.stage4.enums.PlaneType;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Plane {
    private Long id;
    @Setter
    private int capacity;
    private PlaneType type;
    @Setter
    private LocalDateTime technicalDate;
    @Setter
    private PlaneStatus status;

}
