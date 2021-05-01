package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import transport.Transport;
import transport.air.Plane;

public class PlaneViewModel implements ViewModel {
    public static PlaneViewModel create() {
        return Main.create("plane.fxml");
    }

    @FXML
    private GridPane root;
    @FXML
    private TextField width, height, depth, maxSpeed, teamCount, passagesCount,
            minWeight, maxWeight, maxFlightAltitude, wingArea;

    private Main m;
    private Plane v;

    private void setDisable() {
        getRoot().setDisable(v == null || m == null);
    }

    public GridPane getRoot() {
        return root;
    }

    public Main getMain() {
        return m;
    }
    public void setMain(Main m) {
        this.m = m;
        setDisable();
    }

    public Transport getTransport() {
        return v;
    }
    public void setTransport(Transport t) {
        v = ((Plane) t);
        setDisable();
        if (v == null)
            return;
        width.setText(String.valueOf(v.getWidth()));
        height.setText(String.valueOf(v.getHeight()));
        depth.setText(String.valueOf(v.getDepth()));
        maxSpeed.setText(String.valueOf(v.getMaxSpeed()));
        teamCount.setText(String.valueOf(v.getTeamCount()));
        passagesCount.setText(String.valueOf(v.getPassagesCount()));
        minWeight.setText(String.valueOf(v.getMinWeight()));
        maxWeight.setText(String.valueOf(v.getMaxWeight()));
        maxFlightAltitude.setText(String.valueOf(v.getMaxFlightAltitude()));
        wingArea.setText(String.valueOf(v.getWingArea()));
    }

    @FXML
    private void initialize() {
        setOnEnterIntSetter(width, width1 -> v.setWidth(width1));
        setOnEnterIntSetter(height, height1 -> v.setHeight(height1));
        setOnEnterIntSetter(depth, depth1 -> v.setDepth(depth1));
        setOnEnterIntSetter(maxSpeed, maxSpeed1 -> v.setMaxSpeed(maxSpeed1));
        setOnEnterIntSetter(teamCount, teamCount1 -> v.setTeamCount(teamCount1));
        setOnEnterIntSetter(passagesCount, passagesCount1 -> v.setPassagesCount(passagesCount1));
        setOnEnterIntSetter(minWeight, minWeight1 -> v.setMinWeight(minWeight1));
        setOnEnterIntSetter(maxWeight, maxWeight1 -> v.setMaxWeight(maxWeight1));
        setOnEnterIntSetter(maxFlightAltitude, maxFlightAltitude1 -> v.setMaxFlightAltitude(maxFlightAltitude1));
        setOnEnterIntSetter(wingArea, wingArea1 -> v.setWingArea(wingArea1));
    }
}