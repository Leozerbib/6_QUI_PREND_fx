package com.example.fx.mechanic;

import com.example.fx.Card;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter@Setter

public class Plateaufx {
    public StackPane cardplay;
    public int indexcol;
    public int indexlin;
    public static int e = 0;
    public static List<Plateaufx> plateaufxLabel=new ArrayList<>();
    public Plateaufx(int ic,int il, StackPane cp){
        indexcol=ic;
        indexlin=il;
        cardplay=cp;
    }
}
