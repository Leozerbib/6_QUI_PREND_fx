package com.example.fx;

import com.example.fx.AI.AI;
import com.example.fx.joueurs.joueurs;
import com.example.fx.mechanic.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.fx.joueurs.joueurs.joueursPli;
import static com.example.fx.joueurs.joueurs.mainFx;
import static com.example.fx.mechanic.Method.*;
import static com.example.fx.Card.Allcarte;
import static com.example.fx.Card.carte;
import static com.example.fx.mechanic.Plateaufx.e;
import static com.example.fx.mechanic.Plateaufx.plateaufxLabel;
import static com.example.fx.mechanic.turn.*;



public class HelloController implements Initializable {
    @FXML
    private TextField joueur;
    @FXML
    private Button suivant;
    @FXML
    private Label alertjoueur;
    @FXML
    private CheckBox ia;
    @FXML
    private Button start;
    @FXML
    private Button rammasser;
    private int ind;
    private int ind2;
    private StackPane Cardplay;
    private GridPane PLAT;
    @FXML
    private HBox main;
    @FXML
    private FlowPane cardpane;
    @FXML
    private GridPane plat=new GridPane();
    private Stage primaryStage;
    private Scene scene;
    private Parent root;


    public void switchScene(ActionEvent event) throws IOException{
        primaryStage =(Stage)((Node)event.getSource()).getScene().getWindow();
        switchSceneall("regle.fxml");
    }
    public void sceneback(ActionEvent event) throws IOException {
        primaryStage =(Stage)((Node)event.getSource()).getScene().getWindow();
        switchSceneall("start.fxml");
    }
    public void switchSceneStart(ActionEvent event) throws IOException{
        primaryStage =(Stage)((Node)event.getSource()).getScene().getWindow();
        switchSceneall("joueur.fxml");
    }
    public  int ram1(ActionEvent event){
        int a = 0;
        return a;
    }
    public  int ram2(ActionEvent event){
        int a = 1;
        return a;
    }
    public  int ram3(ActionEvent event){
        int a = 2;
        return a;
    }
    public  int ram4(ActionEvent event){
        int a = 3;
        return a;
    }
    public void valider(ActionEvent event) throws IOException{
        int text = 0;
        do{
            try {
                text = Integer.parseInt(joueur.getText());
                joueur.clear();
            }
            catch (NumberFormatException e){
                joueur.clear();
                alertjoueur.setText("Entrer un nombre !!");
            }
            finally {
                joueur.clear();
            }
            joueur.clear();
        }while (text<1 || text>10);
        Method.nbr_joueur = text;
        System.out.println(Method.nbr_joueur);
        suivant.setDisable(false);
        cart(event, primaryStage);

    }
    public int taureau(int i) {
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
    // Fonction pour ajouter une carte à la main du joueur
    public StackPane CreateCard(int j, int i) {
        Rectangle carte = new Rectangle(100,120, Color.WHITE);
        carte.setArcWidth(10);
        carte.setArcHeight(10);
        carte.setStrokeWidth(4);
        if (j< 2) {
            carte.setStroke(Color.RED);
        } else if (j< 4) {
            carte.setStroke(Color.YELLOW);
        } else if (j < 6) {
            carte.setStroke(Color.ORANGE);
        } else {
            carte.setStroke(Color.PURPLE);
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
                System.out.println("mouse click detected! " + event.getSource() + " "+ label.getText() + " " + card.getId() );
                System.out.println("              "+ joueurs.joueurs.get(Integer.parseInt(card.getParent().getId())).get(Integer.parseInt(card.getId())).getNum_card() + "4444  :" );
                plat.setBackground(Background.fill(Color.ORANGE));
                GameLogic(Integer.parseInt(card.getId()));

                for (int j= 0 ; j<joueurs.joueurs.get(i).size();j++) {
                    joueurs.joueurs.get(i).get(j).getFx().setId(String.valueOf(j));


                }
            };
        });

        return card;

        //mainJoueur.getChildren().add(card);
    }

    public List<Card> cart(ActionEvent event, Stage primaryStage) throws IOException {
        // Initialiser les cartes avec les valeurs de 1 à 104
        for (int i = 1; i <= 104; i++) {

            int taurau = taureau(i);
            Card card = new Card(i,taurau,CreateCard(taurau,i) );
            carte.add(card);
            System.out.println("numcard"+ carte.get(i-1).getNum_card() + "   nbrtaureau"  + carte.get(i-1).getNbrTaureau());
            Allcarte.add(card);
        }

        return carte;
    }
    public void switchScenejeu(ActionEvent event) throws IOException{
        primaryStage =(Stage)((Node)event.getSource()).getScene().getWindow();
        switchSceneall("jeu.fxml");
        addCard();



    }
    public void switchSceneall(String fxml) throws IOException{
        FXMLLoader sce = new FXMLLoader(getClass().getResource(fxml));
        sce.setLocation(HelloApplication.class.getResource(fxml));
        root = sce.load();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void checkIA(ActionEvent event) {
        if (ia.isSelected()) {
            Start.ia = 1;
            System.out.println(Start.ia);
        }
        else {
            Start.ia=0;
            System.out.println(Start.ia);
        }
    }
    private void addCard() throws IOException {
        Start.start();
        for (int i= 0 ; i<Method.nbr_joueur;i++){
            CardController.start(i);
        System.out.println(joueurs.mainFx.size());
    }}
    public void Toplateau(int i,int j,StackPane Card){

        plat.add(Card,j,i,1,1);
        Plateaufx platfx = new Plateaufx(i,j,Card);
        if (!plateaufxLabel.contains(platfx)){
            plateaufxLabel.add(platfx);
    }

    }
    public void car(int ply){
        cardpane.getChildren().clear();
        cardpane.getChildren().addAll(joueurs.mainFx.get(ply));
        FlowPane cardpane;
    }
    public void Startt(ActionEvent event) throws IOException{
        if(launch !=1){
            System.out.println("je suis ici" + launch);
            init();
            cardpane.getChildren().clear();
            cardpane.getChildren().addAll(joueurs.mainFx.get(0));

        }
        else {
            cardpane.getChildren().clear();
            cardpane.getChildren().addAll(joueurs.mainFx.get(e));
            for (int r=0;r<plateaufxLabel.size();r++){
            Toplateau(plateaufxLabel.get(r).getIndexcol(),plateaufxLabel.get(r).indexlin,plateaufxLabel.get(r).getCardplay());
            }
            Toplateau(ind,ind2,Cardplay);
        }
        start.setDisable(true);
        start.setVisible(false);
        Method.launch=1;
    }
    public void car1(ActionEvent event) throws IOException{
        cardpane.getChildren().clear();
        cardpane.getChildren().addAll(joueurs.mainFx.get(1));
    }
    public void car2(ActionEvent event) throws IOException{
        cardpane.getChildren().clear();
        cardpane.getChildren().addAll(joueurs.mainFx.get(2));
    }
    public void car3(ActionEvent event) throws IOException{
        cardpane.getChildren().clear();
        cardpane.getChildren().addAll(joueurs.mainFx.get(3));
    }
    public void init(){
        Method.Initplateau();
        for (int i =0;i<4;i++){
            rangees[0][i]=carte.get(0);
            Toplateau(i,0,carte.get(0).getFx());
            Allcarte.remove(carte.get(0));
            carte.remove(carte.get(0));
        }
        plateau();
    }
    public void GameLogic(int choix) {

        System.out.println(e);

        game(choix,e);
        if(joueurs.joueurs.get(joueurs.joueurs.size()-1).size()==0) {
            List<Integer> scores = new ArrayList<>();
            for (int i = 0; i < com.example.fx.joueurs.joueurs.joueurs.size(); i++) {
                int point = 0;
                for (int j = 0; j < joueursPli.get(i).size(); j++) {
                    point += joueursPli.get(i).get(j).getNbrTaureau();
                }
                scores.add(point);
                System.out.println("Nombre de taureaux pour le joueur " + i + " : " + point);
            }
        }
    }

    public void game(int choi, int i){
        Method.plateau();
        System.out.println(choi);
        if(joueurs.joueurs.get(i)!= AI.ordimain){
            System.out.println(joueurs.joueurs.get(i).get(choi).getNum_card());
            if (verif(i, choi) == true){
                Allcarte.remove(joueurs.joueurs.get(i).get(choi));
                turn(i,choi);
            }
            else{
                try {
                    switchSceneall("jeu.fxml");
                    System.out.println("yoooooo");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                rammasser(i,choix2, joueurs.joueurs.get(i).get(choi));
                Allcarte.remove(joueurs.joueurs.get(i).get(choi));
                joueurs.joueurs.get(i).remove(joueurs.joueurs.get(i).get(choi));


            }
        }

        else {
            AI.arbre(50);
            int random =AI.Savemouv.get(0);
            int randomcol=AI.Savemouv.get(1);
            AI.Savemouv.clear();
            if (verif(i, random) == true) {
                turn(i, random);
            } else {
                rammasser(i, randomcol, joueurs.joueurs.get(i).get(random));
                joueurs.joueurs.get(i).remove(joueurs.joueurs.get(i).get(random));
            }


        }

    }
    public void turn(int i, int choix) {
        int answer=0;
        int indexRangee = 0;
        int lastcol;
        int indexLastcol=lastcol(0);

        for (int k = 1; k < 4; k++) {
            lastcol = turn.lastcol(k);
            if ((joueurs.joueurs.get(i).get(choix).getNum_card() > rangees[indexLastcol][indexRangee].getNum_card())) {
                if ((rangees[lastcol][k].getNum_card() > rangees[indexLastcol][indexRangee].getNum_card()) && (rangees[lastcol][k].getNum_card() < joueurs.joueurs.get(i).get(choix).getNum_card())) {
                    indexRangee = k;
                    indexLastcol = lastcol;
                }
            }

            else{
                indexRangee = k;
                indexLastcol=lastcol;
            }
        }
        if (indexLastcol==4){
            rammasser(i,indexRangee, joueurs.joueurs.get(i).get(choix));
            answer=0;
        }
        else {
            rangees[indexLastcol+1][indexRangee] = joueurs.joueurs.get(i).get(choix);
            plateau();
            answer = 1;
            Cardplay=joueurs.joueurs.get(i).get(choix).getFx();
            ind=indexLastcol+1;
            ind2=indexRangee;
        }

        System.out.println(joueurs.mainFx.get(e) + "oui + " +joueurs.mainFx.get(e).getChildrenUnmodifiable().get(choix) );
        joueurs.mainFx.get(e).getChildren().remove(joueurs.mainFx.get(e).getChildren().get(choix));
        joueurs.joueurs.get(e).remove(joueurs.joueurs.get(e).get(choix));
        System.out.println(e);
        if (e==joueurs.joueurs.size()-1){
            e=0;
        }else{
            e+=1;
        }
        System.out.println(e);
        try {
            switchSceneall("jeu.fxml");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Plateaufx plateaufx = new Plateaufx(ind2,ind,Cardplay);
        if (!plateaufxLabel.contains(plateaufx))
        plateaufxLabel.add(plateaufx);
    }
    public void Toplat(ActionEvent event){
            Toplateau(ind,ind2,Cardplay);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}