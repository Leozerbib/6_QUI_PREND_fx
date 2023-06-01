package com.example.fx.Cardcontroller;

import com.example.fx.joueurs.joueurs;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import com.example.fx.joueurs.joueurs.*;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;

import static com.example.fx.joueurs.joueurs.main;

public class CardController {

    private static final int NUM_CARTES = 5; // Nombre de cartes dans la main

    public static void start(int j,int i) {

        // Création de la main du joueur
        HBox mainJoueur = new HBox(10);
        mainJoueur.setStyle("-fx-background-color: White");
        mainJoueur.setPadding(new Insets(10));
        mainJoueur.getChildren().add(joueurs.joueurs.get(j).get(i).getFx());
        // Création de la scène principale
        Parent root = mainJoueur;
        joueurs.mainFx.add(root);

    }

    // Fonction pour ajouter une carte à la main du joueur
    public static StackPane CreateCard(int j, int i) {
        Rectangle carte = new Rectangle(100,120,Color.WHITE);
        carte.setArcWidth(10);
        carte.setArcHeight(10);
        carte.setStrokeWidth(4);
        if (j< 2) {
            carte.setStroke(Color.BLACK);
        } else if (j< 4) {
            carte.setStroke(Color.YELLOW);
        } else if (j < 6) {
            carte.setStroke(Color.ORANGE);
        } else {
            carte.setStroke(Color.RED);
        }
        Label label = new Label(String.valueOf(i) + "\n\n");
        label.setStyle("-fx-font-size: 40px;");
        Label label2 = new Label("Taur : " + String.valueOf(j));

        label.setStyle("-fx-font-size: 20px;");

        VBox carteContainer = new VBox();
        carteContainer.setAlignment(Pos.CENTER);
        StackPane card = new StackPane();
        card.setAlignment(Pos.CENTER);

        carteContainer.getChildren().addAll(label,label2);
        card.getChildren().addAll(carte,carteContainer);
        card.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouse click detected! " + event.getSource() + " "+ label + " " + label2);
            };
        });
        return card;

        //mainJoueur.getChildren().add(card);
    }
    public void createcard(int i,int j){

    }


}