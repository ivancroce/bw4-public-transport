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
    private Integer actualTravelTime;
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
            throw new IllegalArgumentException("The vehicle with ID '" + vehicle.getId() + "' is not in service.");
        }
        this.vehicle = vehicle;
        this.route = route;
        this.travelDate = LocalDate.now();
        this.actualTravelTime = null;
    }

    public long getId() {
        return id;
    }


    public int getActualTravelTime() {
        return actualTravelTime;
    }

    public void setActualTravelTime(Integer actualTravelTime) {
        if (actualTravelTime != null && actualTravelTime < 0) {
            throw new IllegalArgumentException("The actual travel time can't be a negative value.");
        }
        this.actualTravelTime = actualTravelTime;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
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

    @Override
    public String toString() {
        return "TravelRoute{" +
                "id=" + id +
                ", actualTraveTime=" + actualTravelTime +
                ", travelDate=" + travelDate +
                ", vehicle=" + vehicle +
                ", route=" + route +
                '}';
    }
}
