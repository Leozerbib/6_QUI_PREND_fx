package com.example.fx;

import com.example.fx.joueurs.joueurs;
import com.example.fx.mechanic.CardController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.fx.mechanic.CardController.*;

@Getter
@Setter
public class Card {
    private int Num_card;
    private int NbrTaureau;
    private StackPane fx;
    private  Parent root;
    public  static List<Card> carte = new ArrayList<>();
    public static List<Card> cartesFX = new ArrayList<>();
    public static List<Card> AllcarteV = new ArrayList<>();
    public static List<Card> Allcarte = new ArrayList<>();


    public Card(int n, int num,StackPane car) {
        Num_card = n;
        NbrTaureau = num;
        fx = car;
    }



}