import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;



public class Game {
    private Stage stage;
    private Group root;
    private Scene scene;
    private Canvas canvas;
    private GraphicsContext gc;
    private ArrayList<String> input;

    public Game() {
        this.root = new Group();
        this.scene = new Scene(this.root);
        this.canvas = new Canvas(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        this.gc = this.canvas.getGraphicsContext2D();
        this.input = new ArrayList<String>();
        this.root.getChildren().add(this.canvas);

        this.scene.setOnKeyPressed(
            new EventHandler<KeyEvent>() {
                public void handle(KeyEvent e) {
                    String code = e.getCode().toString();
                    if (!input.contains(code)) {
                        input.add(code);
                    }
                }
        });
        this.scene.setOnKeyReleased(
            new EventHandler<KeyEvent>() {
                public void handle(KeyEvent e) {
                    String code = e.getCode().toString();
                    input.remove(code);
                }
        });
    }


    public void setStage(Stage stage) {
        this.stage = stage;
        this.stage.setTitle("Platformer");
        this.stage.setScene(this.scene);
    }


    public void update() {
    }


    public void render() {
        this.gc.clearRect(0, 0, Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        this.stage.show();
    }
}
