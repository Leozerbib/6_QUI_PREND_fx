package com.example.fx.object;

import com.example.fx.Cardcontroller.CardController;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class Card {
    private int Num_card;
    private int NbrTaureau;
    private StackPane fx;
    private static Parent root;
    public static List<Card> carte = new ArrayList<>();
    public static List<Card> cartesFX = new ArrayList<>();
    public static List<Card> AllcarteV = new ArrayList<>();
    public static List<Card> Allcarte = new ArrayList<>();
    static HashMap<Card, StackPane> cartes = new HashMap<Card, StackPane>();


    public Card(int n, int num,StackPane fx) {
        Num_card = n;
        NbrTaureau = num;
        fx = fx;
    }

    public static int taureau( int i) {
        int taureau = 0 ;
        if (i% 10==5){
            taureau+=2;
        }
        if (i % 10==0){
            taureau+=3;
        }
        if (i % 11==0){
            taureau+=5;
        } if (i % 10!=5&&i % 10!=0&&i % 11!=0){
            taureau+=1;
        }
        return taureau;
    }

    public static List<Card> cart(ActionEvent event, Stage primaryStage) throws IOException {
        // Initialiser les cartes avec les valeurs de 1 à 104
        for (int i = 1; i <= 104; i++) {

            int taurau = taureau(i);
            taurau=taurau/ 2;
            Card card = new Card(i,taurau,CardController.CreateCard(taurau,i) );
            carte.add(card);
            System.out.println("numcard"+ carte.get(i-1).getNum_card() + "   nbrtaureau"  + carte.get(i-1).getNbrTaureau());
            Allcarte.add(card);
        }

        return carte;
    }
}