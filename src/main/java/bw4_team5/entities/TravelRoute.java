package bw4_team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "travel_routes")
public class TravelRoute {
    @Id
    @GeneratedValue
    @Column(name= "travel_route_id")
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

    public TravelRoute(long id, int actualTraveTime, LocalDate travelDate, Vehicle vehicle) {
        this.id = id;
        this.actualTraveTime = actualTraveTime;
        this.travelDate = travelDate;
        this.vehicle = vehicle;
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
