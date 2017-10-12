package layouts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BorderPanePractice extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Practicing with BorderPane");
        stage.setScene(getScene());
        stage.show();
    }

    private Scene getScene()
    {
        BorderPane parentPanel = new BorderPane();

        //buttons to the top
        HBox topPanel = new HBox(); //nested panel
        topPanel.setAlignment(Pos.CENTER);
        parentPanel.setTop(topPanel);

        topPanel.getChildren().addAll(new Button("Click"),
                new Button("Me"), new Button("Now!"));

        //text on the left
        VBox leftPanel = new VBox();
        parentPanel.setLeft(leftPanel);

        String[] sayings = {"If I don't push the limits!!!",
                "Lasagna, lasagna, lasagna...", "Don't let your dreams be dreams!",
                "Some people dream of greatness, others work hard for it!"};

        for (int i = 0; i < sayings.length; i++)
        {
            leftPanel.getChildren().add(getTextControl(sayings[i]));
        }

        //list on the right
        ListView list = new ListView();
        list.getItems().addAll(FXCollections.observableArrayList(
                "I'll follow you down", "The Room", "Running Man",
                        "Wonder Woman", "Lego Batman", "Despicable Me 3"));
        parentPanel.setRight(list);

        //image in the middle
        Image image = new Image("images/owl.jpg");
        ImageView imageControl = new ImageView(image);
        imageControl.setFitWidth(200);
        imageControl.setFitHeight(200);

        parentPanel.setCenter(imageControl);

        //paragraph on the bottom
        Text bottomParagraph = new Text("Lorem ipsum dolor sit amet, " +
                "consectetur adipiscing elit. Nunc vel lectus ex. Integer" +
                "at mattis orci, at posuere risus. Ut in massa quis lectus" +
                "sagittis fringilla. Suspendisse velit elit, pretium eget " +
                "felis eget, finibus accumsan nulla. Ut ornare commodo ante," +
                "ut rhoncus elit rhoncus quis. Duis commodo, ante sit amet" +
                "convallis tincidunt, risus ipsum accumsan ipsum, at sagittis");
        bottomParagraph.setWrappingWidth(500);
        parentPanel.setBottom(bottomParagraph);

        return new Scene(parentPanel, 400, 400);
    }

    private Text getTextControl(String message)
    {
        Text control = new Text(message);
        control.setWrappingWidth(120);
        return control;
    }
}
