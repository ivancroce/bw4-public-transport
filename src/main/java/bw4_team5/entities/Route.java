package bw4_team5.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue
    @Column(name = "route_id")
    private long id;
    @Column(name = "start_route")
    private String startRoute;
    private String terminal;
    @Column(name = "estimated_travel_time")
    private int estimatedTravelTime;

    @OneToMany(mappedBy = "route")
    private List<TravelRoute> travelRoutes = new ArrayList<>();

    public Route() {
    }

    public Route(String startRoute, String terminal, int estimatedTravelTime) {
        if (estimatedTravelTime <= 0) {
            throw new IllegalArgumentException("Estimated travel time must be a positive number.");
        }
        this.startRoute = startRoute;
        this.terminal = terminal;
        this.estimatedTravelTime = estimatedTravelTime;
    }

    public long getId() {
        return id;
    }

    public String getStartRoute() {
        return startRoute;
    }

    public void setStartRoute(String startRoute) {
        this.startRoute = startRoute;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getEstimatedTravelTime() {
        return estimatedTravelTime;
    }

    public void setEstimatedTravelTime(int estimatedTravelTime) {
        this.estimatedTravelTime = estimatedTravelTime;
    }

    public List<TravelRoute> getTravelRoutes() {
        return travelRoutes;
    }

    public void setTravelRoutes(List<TravelRoute> travelRoutes) {
        this.travelRoutes = travelRoutes;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", startRoute='" + startRoute + '\'' +
                ", terminal='" + terminal + '\'' +
                ", estimatedTravelTime=" + estimatedTravelTime +
                '}';
    }
}
