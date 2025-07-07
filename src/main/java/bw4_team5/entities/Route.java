package bw4_team5.entities;

public class Route {
    private long id;
    private String terminal;
    private String startRoute;
    private int expectedTime;
    private int effectiveTime;

    public Route(){}

    public Route(long id,String terminal,String startRoute,int expectedTime,int effectiveTime){
        this.id = id;
        this.terminal = terminal;
        this.startRoute = startRoute;
        this.expectedTime = expectedTime;
        this.effectiveTime =effectiveTime;
    }

    public int getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(int effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public int getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(int expectedTime) {
        this.expectedTime = expectedTime;
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

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id + '\'' +
                ", startRoute='" + startRoute +
                ", terminal='" + terminal +
                ", expectedTime=" + expectedTime +
                ", effectiveTime=" + effectiveTime + '\'' +
                '}';
    }
}
