package org.example.stage4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.stage4.enums.PlaneStatus;
import org.example.stage4.enums.PlaneType;

import java.time.LocalDateTime;

//@Getter
////@AllArgsConstructor
//@Builder
//public class Plane {
//    //@Setter
//    private Long id;
//    //@Setter
//    private int capacity;
//    private PlaneType type;
//    //@Setter
//    private LocalDateTime technicalDate;
//    //@Setter
//    private PlaneStatus status;
//}

/*@Getter
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

    public static PlaneBuilder builder() {
        return new PlaneBuilder();
    }

    public static class PlaneBuilder {
        private Long id;
        private int capacity;
        private PlaneType type;
        private LocalDateTime technicalDate;
        private PlaneStatus status;

        public PlaneBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PlaneBuilder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public PlaneBuilder withType(PlaneType type) {
            this.type = type;
            return this;
        }

        public PlaneBuilder withTechnicalDate(LocalDateTime technicalDate) {
            this.technicalDate = technicalDate;
            return this;
        }

        public PlaneBuilder withStatus(PlaneStatus status) {
            this.status = status;
            return this;
        }

        public Plane build() {
            return new Plane(id, capacity, type, technicalDate, status);
        }
    }
}*/

@Getter
@Builder
public class Plane {
    @Setter
    private Long id; // Сеттер есть
    @Setter
    private int capacity; // Сеттер есть
    @Setter
    private PlaneType type; // Добавляем сеттер для метода withType
    @Setter
    private LocalDateTime technicalDate; // Сеттер есть
    @Setter
    private PlaneStatus status; // Сеттер есть
}
