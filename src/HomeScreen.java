import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class HomeScreen extends Application {
    private static final String ORANGE = "#E65100";
    private static final String DARK = "#1C232B";

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        try {
            Image image = new Image(new FileInputStream("assets/background.png"));
            BackgroundImage bgImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true)
            );
            root.setBackground(new Background(bgImage));
        } catch (Exception e) {
            root.setStyle("-fx-background-color: #F6F1E8;");
        }

        root.setTop(createHeader());
        root.setCenter(createCenter());
        root.setBottom(createFooter());

        Scene scene = new Scene(root, 1000, 650);
        stage.setTitle("QuickBite");
        stage.setScene(scene);
        stage.show();
    }

    private HBox createHeader() {
        Label brand = new Label("QuickBite");
        brand.setTextFill(Color.WHITE);
        brand.setFont(Font.font("Arial", FontWeight.BOLD, 34));

        Label slogan = new Label("Fresh meals, Fast pickup");
        slogan.setTextFill(Color.WHITE);
        slogan.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox header = new HBox(20, brand, spacer, slogan);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(18, 30, 18, 30));
        header.setStyle("-fx-background-color: rgba(230,81,0,0.94);");
        return header;
    }

    private StackPane createCenter() {
        VBox card = new VBox(16);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(40, 60, 40, 60));
        card.setMaxWidth(650);
        card.setStyle("-fx-background-color: rgba(255,255,255,0.90); -fx-background-radius: 18;");

        Label title = new Label("QuickBite");
        title.setTextFill(Color.web(DARK));
        title.setFont(Font.font("Arial", FontWeight.BOLD, 54));

        Label subtitle = new Label("Come order from local restaurants to pick up your meals!");
        subtitle.setTextFill(Color.web(DARK));
        subtitle.setFont(Font.font("Arial", 21));

        Button viewRestaurants = new Button("View Restaurants");
        viewRestaurants.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        viewRestaurants.setTextFill(Color.WHITE);
        viewRestaurants.setStyle("-fx-background-color: " + ORANGE + "; -fx-background-radius: 10; -fx-padding: 14 30;");

        viewRestaurants.setOnAction(e -> {
            // Show restaurant displays
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("QuickBite");
            alert.setHeaderText(null);
            alert.setContentText("Restaurant display will open here once the feature branches are integrated.");
            alert.showAndWait();
        });

        card.getChildren().addAll(title, subtitle, viewRestaurants);

        StackPane center = new StackPane(card);
        center.setPadding(new Insets(50));
        return center;
    }

    private HBox createFooter() {
        Label left = new Label("QuickBite Food Ordering App");
        left.setTextFill(Color.WHITE);

        Label right = new Label("Troy Williams, Marissa Jones, Tioluwani Adesina, Tina Joudi (COMP 354)");
        right.setTextFill(Color.WHITE);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox footer = new HBox(left, spacer, right);
        footer.setPadding(new Insets(14, 25, 14, 25));
        footer.setStyle("-fx-background-color: rgba(28,35,43,0.94);");
        return footer;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
