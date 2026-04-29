import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

class BouncingBallEngine {
    private double ballX;
    private double ballY;
    private double dx;
    private final double RADIUS = 20;

    BouncingBallEngine(double startX, double startY, double speed) {
        this.ballX = startX;
        this.ballY = startY;
        this.dx = speed;
    }

    void update(double canvasWidth, double canvasHeight, double speed) {
        dx = (dx > 0) ? speed : -speed;
        ballX += dx;
        ballY = canvasHeight / 2;

        if (ballX + RADIUS >= canvasWidth) {
            ballX = canvasWidth - RADIUS;
            dx = -speed;
        } else if (ballX - RADIUS <= 0) {
            ballX = RADIUS;
            dx = speed;
        }
    }

    double getBallX() { return ballX; }
    double getBallY() { return ballY; }
    double getRadius() { return RADIUS; }
}

public class p20 extends Application {
    private boolean running = false;
    private AnimationTimer timer;

    @Override
    public void start(Stage stage) {
        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: #0f0f1a;");
        canvas.setPrefSize(700, 380);

        BouncingBallEngine engine = new BouncingBallEngine(100, 190, 3);
        Circle ball = new Circle(engine.getRadius(), Color.CYAN);
        ball.setStroke(Color.WHITE);
        ball.setStrokeWidth(2);
        canvas.getChildren().add(ball);

        // Controls
        Button startBtn = new Button("▶ Start");
        Button stopBtn  = new Button("⏹ Stop");
        startBtn.setStyle("-fx-background-color: #00b894; -fx-text-fill: white; -fx-font-weight: bold;");
        stopBtn.setStyle("-fx-background-color: #d63031; -fx-text-fill: white; -fx-font-weight: bold;");

        Label speedLabel = new Label("Speed:");
        speedLabel.setStyle("-fx-text-fill: white;");
        Slider speedSlider = new Slider(1, 15, 3);
        speedSlider.setShowTickLabels(true);
        speedSlider.setShowTickMarks(true);
        speedSlider.setPrefWidth(220);

        HBox controls = new HBox(12, startBtn, stopBtn, speedLabel, speedSlider);
        controls.setAlignment(Pos.CENTER_LEFT);
        controls.setPadding(new Insets(10, 15, 10, 15));
        controls.setStyle("-fx-background-color: #1a1a2e;");

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(controls);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                engine.update(canvas.getWidth(), canvas.getHeight(), speedSlider.getValue());
                ball.setCenterX(engine.getBallX());
                ball.setCenterY(engine.getBallY());
            }
        };

        startBtn.setOnAction(e -> {
            if (!running) {
                running = true;
                timer.start();
            }
        });

        stopBtn.setOnAction(e -> {
            if (running) {
                running = false;
                timer.stop();
            }
        });

        Scene scene = new Scene(root, 700, 450);
        stage.setTitle("Practical 20 - Bouncing Ball (JavaFX)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
