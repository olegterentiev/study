import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RoutCalculatorTest extends TestCase {

    List<Station> routOnTheLine;
    List<Station> routWithOneConnection;
    List<Station> routWithTwoConnection;

    StationIndex stationIndex;
    RouteCalculator routeCalculator;
    Line a,b,c;
    Station s1,s2,s3,s4,s5,s6,s7,s8,s9;

    @Override
    protected void setUp() throws Exception {
        routOnTheLine = new ArrayList<>();
        routWithOneConnection = new ArrayList<>();
        routWithTwoConnection = new ArrayList<>();
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        a = new Line(1,"Первая");
        b = new Line(2,"Вторая");
        c = new Line(3,"Третья");

        stationIndex.addLine(a);
        stationIndex.addLine(b);
        stationIndex.addLine(c);

        s1 = new Station("Станция №1 Линии 1", a);
        s2 = new Station("Станция №2 Линии 1", a);
        s3 = new Station("Станция №3 Линии 1", a);
        s4 = new Station("Станция №4 Линии 2", b);
        s5 = new Station("Станция №5 Линии 2", b);
        s6 = new Station("Станция №6 Линии 2", b);
        s7 = new Station("Станция №7 Линии 3", c);
        s8 = new Station("Станция №8 Линии 3", c);
        s9 = new Station("Станция №9 Линии 3", c);

        stationIndex.addStation(s1);
        stationIndex.addStation(s2);
        stationIndex.addStation(s3);
        stationIndex.addStation(s4);
        stationIndex.addStation(s5);
        stationIndex.addStation(s6);
        stationIndex.addStation(s7);
        stationIndex.addStation(s8);
        stationIndex.addStation(s9);

        a.addStation(s1);
        a.addStation(s2);
        a.addStation(s3);
        b.addStation(s4);
        b.addStation(s5);
        b.addStation(s6);
        c.addStation(s7);
        c.addStation(s8);
        c.addStation(s9);

        List<Station> connectionA_B = new ArrayList<>();
        List<Station> connectionB_C = new ArrayList<>();

        connectionA_B.add(stationIndex.getStation("Станция №2 Линии 1"));
        connectionA_B.add(stationIndex.getStation("Станция №5 Линии 2"));
        connectionB_C.add(stationIndex.getStation("Станция №6 Линии 2"));
        connectionB_C.add(stationIndex.getStation("Станция №8 Линии 3"));

        stationIndex.addConnection(connectionA_B);
        stationIndex.addConnection(connectionB_C);

        routOnTheLine.add(s1);
        routOnTheLine.add(s2);
        routOnTheLine.add(s3);

        routWithOneConnection.add(s1);
        routWithOneConnection.add(s2);
        routWithOneConnection.add(s5);
        routWithOneConnection.add(s4);

        routWithTwoConnection.add(s1);
        routWithTwoConnection.add(s2);
        routWithTwoConnection.add(s5);
        routWithTwoConnection.add(s6);
        routWithTwoConnection.add(s8);
        routWithTwoConnection.add(s9);

    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(routWithTwoConnection);
        double expected = 14.5;
        assertEquals(actual, expected);
    }

    public void testGetRouteOnTheLine(){
        List<Station> actual = routeCalculator.getShortestRoute(s1,s3);
        List<Station> expected = routOnTheLine;
        assertEquals(actual, expected);
    }

    public void testGetRouteWithOneConnection(){
        List<Station> actual = routeCalculator.getShortestRoute(s1,s4);
        List<Station> expected = routWithOneConnection;
        assertEquals(actual,expected);
    }

    public  void testGetRouteWithTwoConnection(){
        List<Station> actual = routeCalculator.getShortestRoute(s1,s9);
        List<Station> expected = routWithTwoConnection;
        assertEquals(actual,expected);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
