
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import java.io.IOException;
import java.net.URISyntaxException;

import static javafx.application.Application.launch;

/**
 * Created by J on 21-Dec-2014.
 */
public class StockOutputUI extends Application {
    private JPanel panel1;
    private JButton button1;
    private JTextArea textArea1;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws URISyntaxException, SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        StockAnalyser test = new StockAnalyser();

        test.loadMarketFromFile("ftse",new FilePersistenceHandler());

        test.initialiseData();
        test.buildMarketData();


        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
             //   textArea1.append(test.filterMarket().toString());
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
