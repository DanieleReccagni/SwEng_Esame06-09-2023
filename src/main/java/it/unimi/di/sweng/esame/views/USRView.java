package it.unimi.di.sweng.esame.views;


import it.unimi.di.sweng.esame.presenter.Presenter;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.jetbrains.annotations.NotNull;

public class USRView extends Region implements InputView {
  @NotNull
  private final TextField textField;
  @NotNull
  private final Label error;
  @NotNull
  private final Button button;

  public USRView(String buttonName) {

    button = new Button(buttonName);

    textField = new TextField();
    error = new Label("");
    textField.setFont(Font.font("sans", 20));

    setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5.0), Insets.EMPTY)));
    setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));

    grid.add(textField, 0, 2, 3, 1);

    grid.add(button, 0, 1);
    button.setFont(Font.font("sans", 20));

    grid.add(error, 0, 3, 3, 1);

    this.getChildren().add(grid);
  }

  @Override
  public void addHandlers(@NotNull Presenter presenter) {
    button.setOnAction(eh -> presenter.action(button.getText(), textField.getText()));
  }

  @Override
  public void showError(@NotNull String s) {
    error.setText(s);
    setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5.0), Insets.EMPTY)));
  }

  @Override
  public void showSuccess() {
    error.setText("");
    textField.clear();
    setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5.0), Insets.EMPTY)));
  }
}
