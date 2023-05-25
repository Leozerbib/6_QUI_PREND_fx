package com.example.fx.object;

import com.example.fx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Card {
    private int Num_card;
    private int NbrTaureau;
    private String Img;
    private static Parent root;
    public static List<Card> cartes = new ArrayList<>();
    public static List<Card> AllcarteV = new ArrayList<>();
    public static List<Card> Allcarte = new ArrayList<>();

    public Card(int n, int num,String img) {
        Num_card = n;
        NbrTaureau = num;

    }

    public static int taureau(int Num_card, int i) {
        if (Num_card % 10==5){
            cartes.get(i-1).NbrTaureau+=2;
        }
        if (Num_card % 10==0){
            cartes.get(i-1).NbrTaureau+=3;
        }
        if (Num_card % 11==0){
            cartes.get(i-1).NbrTaureau+=5;
        } if (Num_card % 10!=5&&Num_card % 10!=0&&Num_card % 11!=0){
            cartes.get(i-1).NbrTaureau+=1;
        }
        return cartes.get(i-1).NbrTaureau;
    }

    public static List<Card> cart(ActionEvent event, Stage primaryStage) throws IOException {
        // Initialiser les cartes avec les valeurs de 1 à 104
        for (int i = 1; i <= 104; i++) {
            Card card = new Card(i,0,i + ".png");
            cartes.add(card);
            Allcarte.add(card);
            taureau(cartes.get(i-1).Num_card,i);
            taureau(Allcarte.get(i-1).Num_card,i);

            cartes.get(i - 1).setNbrTaureau(cartes.get(i - 1).getNbrTaureau() / 2);

            System.out.println("numcard"+ cartes.get(i-1).getNum_card() + "   nbrtaureau"  + cartes.get(i-1).getNbrTaureau());
        }

        return cartes;
    }
}