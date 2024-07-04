import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;


public class MainSceneController {
    private Graph graph;
    @FXML
    private Pane graphPane;
    @FXML
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    @FXML
    private Label outputLabel;
    @FXML
    public void initialize() {
        graph = new Graph();
        initializeGraph();

        drawGraph();
        
        btn1.setOnAction(e -> outputLabel.setText("Salida #1: " + (graph.getDistance("A", "B", "C") != -1 ? graph.getDistance("A", "B", "C") : "NO SUCH ROUTE")));
        btn2.setOnAction(e -> outputLabel.setText("Salida #2: " + (graph.getDistance("A", "D") != -1 ? graph.getDistance("A", "D") : "NO SUCH ROUTE")));
        btn3.setOnAction(e -> outputLabel.setText("Salida #3: " + (graph.getDistance("A", "D", "C") != -1 ? graph.getDistance("A", "D", "C") : "NO SUCH ROUTE")));
        btn4.setOnAction(e -> outputLabel.setText("Salida #4: " + (graph.getDistance("A", "E", "B", "C", "D") != -1 ? graph.getDistance("A", "E", "B", "C", "D") : "NO SUCH ROUTE")));
        btn5.setOnAction(e -> outputLabel.setText("Salida #5: " + (graph.getDistance("A", "E", "D") != -1 ? graph.getDistance("A", "E", "D") : "NO SUCH ROUTE")));
        btn6.setOnAction(e -> outputLabel.setText("Salida #6: " + graph.countRoutesWithMaxStops("C", "C", 3)));
        btn7.setOnAction(e -> outputLabel.setText("Salida #7: " + graph.countRoutesWithExactStops("A", "C", 4)));
        btn8.setOnAction(e -> outputLabel.setText("Salida #8: " + graph.shortestDistance("A", "C")));
        btn9.setOnAction(e -> outputLabel.setText("Salida #9: " + graph.shortestDistance("B", "B")));
        btn10.setOnAction(e -> outputLabel.setText("Salida #10: " + graph.countRoutesWithMaxDistance("C", "C", 30)));
    }

    private void initializeGraph() {
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 4);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "C", 8);
        graph.addEdge("D", "E", 6);
        graph.addEdge("A", "D", 5);
        graph.addEdge("C", "E", 2);
        graph.addEdge("E", "B", 3);
        graph.addEdge("A", "E", 7);
    }

    private void drawGraph() {
        double[][] positions = {
            {50, 50}, 
            {150, 50}, 
            {250, 50}, 
            {75, 150}, 
            {225, 150}
        };
        String[] cities = {"A", "B", "C", "D", "E"};

        for (int i = 0; i < cities.length; i++) {
            double x = positions[i][0];
            double y = positions[i][1];
            Circle circle = new Circle(x, y, 20);
            circle.setFill(Color.LIGHTGRAY);
            circle.setStroke(Color.BLACK);
            
            Text text = new Text(cities[i]);
            text.setX(x - text.getBoundsInLocal().getWidth() / 2);
            text.setY(y + text.getBoundsInLocal().getHeight() / 4);
            text.setBoundsType(TextBoundsType.VISUAL);

            graphPane.getChildren().addAll(circle, text);
        }

        
        drawEdge("A", "B", positions, 5);
        drawEdge("B", "C", positions, 4);
        drawEdge("C", "D", positions, 8);
        drawEdge("D", "C", positions, 8);
        drawEdge("D", "E", positions, 6);
        drawEdge("A", "D", positions, 5);
        drawEdge("C", "E", positions, 2);
        drawEdge("E", "B", positions, 3);
        drawEdge("A", "E", positions, 7);
    }

    private void drawEdge(String from, String to, double[][] positions, int weight) {
        int fromIndex = from.charAt(0) - 'A';
        int toIndex = to.charAt(0) - 'A';
        double startX = positions[fromIndex][0];
        double startY = positions[fromIndex][1];
        double endX = positions[toIndex][0];
        double endY = positions[toIndex][1];

        Line line = new Line(startX, startY, endX, endY);
        Text text = new Text((startX + endX) / 2, (startY + endY) / 2, String.valueOf(weight));

        graphPane.getChildren().addAll(line, text);
    }


}