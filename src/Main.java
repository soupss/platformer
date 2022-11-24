import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;



public class Main extends Application {
    private Game game;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void init() {
        this.game = new Game();
    }


    @Override
    public void start(Stage stage) {
        this.game.setStage(stage);

        new AnimationTimer() {
            public void handle(long now) {
                game.update();
                game.render();
            }
        }.start();
    }
}
