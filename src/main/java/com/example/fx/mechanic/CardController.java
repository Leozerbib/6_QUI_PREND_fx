package com.example.fx.mechanic;

import com.example.fx.joueurs.joueurs;
import com.example.fx.method;
import com.example.fx.Card;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;

import static com.example.fx.joueurs.joueurs.joueursPli;

public class CardController {

    private final int NUM_CARTES = 5; // Nombre de cartes dans la main
    public static Comparator<Card> cardComparator =new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            return (int) (o1.getNum_card() - o2.getNum_card());
        }
    };
    public static void start(int i) {

        // Création de la main du joueur    
        HBox mainJoueur = new HBox(10);
        mainJoueur.setStyle("-fx-background-color: black");
        mainJoueur.setPadding(new Insets(10));
        mainJoueur.setId(String.valueOf(i));
        for (int j= 0 ; j<joueurs.joueurs.get(i).size();j++) {
            Collections.sort(joueurs.joueurs.get(i), cardComparator);
            joueurs.joueurs.get(i).get(j).getFx().setId(String.valueOf(j));
            mainJoueur.getChildren().addAll(joueurs.joueurs.get(i).get(j).getFx());
        }

        // Création de la scène principale

        joueurs.mainFx.add(mainJoueur);

    }






    public void createcard(int i,int j){

    }


}