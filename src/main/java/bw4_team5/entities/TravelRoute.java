package bw4_team5.entities;

import bw4_team5.enums.ServiceVehicleStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "travel_routes")
public class TravelRoute {
    @Id
    @GeneratedValue
    @Column(name = "travel_route_id")
    private long id;
    @Column(name = "actual_travel_time")
    private int actualTraveTime;
    @Column(name = "travel_date")
    private LocalDate travelDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public TravelRoute() {
    }

    // to continue
    public TravelRoute(Vehicle vehicle, Route route) {
        if (vehicle.getStatus() != ServiceVehicleStatus.IN_SERVICE) {
            throw new IllegalArgumentException("The vehicle is not in service.");
        }
        this.vehicle = vehicle;
        this.route = route;
        this.travelDate = LocalDate.now();
        this.actualTraveTime = 0;
    }

    @Override
    public String toString() {
        return "TravelRoutes{" +
                "id=" + id +
                ", actualTraveTime=" + actualTraveTime +
                ", travelDate=" + travelDate +
                ", vehicle=" + vehicle +
                '}';
    }

    public long getId() {
        return id;
    }


    public int getActualTraveTime() {
        return actualTraveTime;
    }

    public void setActualTraveTime(int actualTraveTime) {
        this.actualTraveTime = actualTraveTime;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
