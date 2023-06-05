package com.example.fx.mechanic;
import com.example.fx.AI.AI;
import com.example.fx.HelloController;
import com.example.fx.joueurs.joueurs;
import lombok.*;



import com.example.fx.method;
import com.example.fx.Card;

import java.util.ArrayList;
import java.util.List;

import static com.example.fx.joueurs.joueurs.joueurs;
import static com.example.fx.joueurs.joueurs.joueursPli;
import static com.example.fx.mechanic.Method.*;
import static com.example.fx.Card.Allcarte;
@Getter@Setter
public class turn {
    public static int choix=0;
    public static int choix2=0;
    public static int lastcol(int i){
        int lastcol=5;
        while( rangees[lastcol][i].getNum_card()==0){
            lastcol-=1;
        }
        return lastcol;
    }

    public static boolean verif(int i, int choix){
        for (int k = 0; k < 4; k++) {
            int indexLastcol=lastcol(k);
            if (joueurs.get(i).get(choix).getNum_card() > rangees[indexLastcol][k].getNum_card()) {
                return true;
            }
        }
        return false;
    }

    public static void rammasser(int i, int j, Card cardPlay){
        int indexLastcol=lastcol(j);
        for (int k=0;k<=indexLastcol;k++) {
            joueursPli.get(i).add(rangees[k][j]);
            rangees[k][j]=Card0;
        }
        rangees[0][j]=cardPlay;

    }

}
