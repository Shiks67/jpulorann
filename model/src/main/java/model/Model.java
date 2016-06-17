package model;

import contract.IModel;
import element.mobile.Hero;
import element.mobile.Shoot;
import element.mobile.*;
import element.motionless.*;


import java.sql.SQLException;
import java.util.Observable;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

    private String[] DBplayerName = new String[6];
    private int[] DBplayerScore = new int[6];
    public String lastMove = "RIGHT";
    public String fireDirection = "RIGHT";
    public int canShoot = 1;
    private int mapnumber = 1;

    public int getOnGate() {
        return OnGate;
    }

    public int OnGate = 0;

    public Shoot shoot;
    private Hero hero;
    private GateC gateC;
    private GateO gateO;
    private Monster1 monster1;
    private Monster2 monster2;
    private Monster3 monster3;
    private Monster4 monster4;

    private int Score;  /** ingame score **/

    /** The array of objects **/
    private int height = 12;
    private int width = 21;
    private char[][] pngArray = new char[this.getHeight()][this.getWidth()];

    /** The map */
    private String map;

    public int getMapnumber() {
        return this.mapnumber;
    }

    public void setMapnumber(int mapnumber) {
        this.mapnumber = mapnumber;
    }

    /** getters **/



    public int getCanShoot() { return this.canShoot;}

    public void setCanShoot(int canShoot) {this.canShoot = canShoot;}
    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getScore() {
        return Score;
    }

    public String getDBplayerName(int i) {
        return this.DBplayerName[i];
    }

    public int getDBplayerScore(int i) {
        return this.DBplayerScore[i];
    }

    /** setters **/
    public void setDBplayerName(String DBplayerName[]) {
        this.DBplayerName = DBplayerName;
    }

    public void setDBplayerScore(int DBplayerScore[]) {
        this.DBplayerScore = DBplayerScore;
    }
    /**
     * Instantiates a new model.
     */
    public Model() {
        this.map = "";
        hero = new Hero(1,1);
        gateC = new GateC(0,0);
        gateO = new GateO(0,0);
        shoot = new Shoot(0,0);
        monster1 = new Monster1(0,0);
        monster2 = new Monster2(0,0);
        monster3 = new Monster3(0,0);
        monster4 = new Monster4(0,0);
    }

    public String getLastMove(){
        return this.lastMove;
    }


    public void setLastMove(String lastMove){
        this.lastMove = lastMove;
    }

    public String getFireDirection(){
        return this.fireDirection;
    }

    public void setFireDirection(String fireDirection){
        this.fireDirection = fireDirection;
    }


    /*
     * (non-Javadoc)
     *
     * @see contract.IModel#getObservable()
     */
    public Observable getObservable() {
        return this;
    }

    /** i added the map functions in general here **/

    public void putPngName(int i, int j, char pngName) {    /** puts the right character at the right position in the 2d char array, used in getTabInMap() **/
        pngArray[i][j]= pngName;
    }

    public void getMapInTab() {    /** put String got from the DB into a 2d char array **/
        String[] tabmap = this.map.split("\n");     /** splitting string into string array **/
        for (int i =0; i < tabmap.length; i++)      /** beginning of the parser to put string array into 2d char array at the same x, y (here j,i) position **/
        {
            for (int j = 0; j < tabmap[i].length(); j++)
            {
                switch (tabmap[i].charAt(j)){
                    case 'B' :
                        putPngName(i,j,'B');
                        break;
                    case 'H' :
                        putPngName(i,j,'H');
                        break;
                    case 'V' :
                        putPngName(i,j,'V');
                        break;
                    case 'P' :
                        putPngName(i,j,'P');
                        break;
                    case 'L' :
                        putPngName(i,j,'L');
                        hero.setX(j);
                        hero.setY(i);
                        break;
                    case 'C' :
                        putPngName(i,j,'C');
                        gateC.setX(j);
                        gateC.setY(i);
                        break;
                    case 'O':
                        putPngName(i,j,'O');
                        gateO.setX(j);
                        gateO.setY(i);
                        break;
                    case 'K' :
                        putPngName(i,j,'K');
                        break;
                    case 'M' :
                        putPngName(i,j,'M');
                        shoot.setX(j);
                        shoot.setY(i);
                        break;
                    case '1' :
                        putPngName(i,j,'1');
                        monster1.setX(j);
                        monster1.setY(i);
                        break;
                    case '2' :
                        putPngName(i,j,'2');
                        monster2.setX(j);
                        monster2.setY(i);
                        break;
                    case '3' :
                        putPngName(i,j,'3');
                        monster3.setX(j);
                        monster3.setY(i);
                        break;
                    case '4' :
                        putPngName(i,j,'4');
                        monster4.setX(j);
                        monster4.setY(i);
                        break;
                    default :
                        putPngName(i,j,' ');
                        break;
                }
            }
        }
    }

    public Hero  getHero()  { return this.hero;}


    public GateC getGateC() { return this.gateC;}

    public GateO getGateO() { return this.gateO;}


    public Shoot getShoot() { return this.shoot;}

    public Monster1 getMonster1() {
        return monster1;
    }

    public Monster2 getMonster2() {
        return monster2;
    }

    public Monster3 getMonster3() {
        return monster3;
    }

    public Monster4 getMonster4() {
        return monster4;
    }

    public char[][] getMap() {  /** return chat 2d array used to display images in view by copy **/
        return pngArray;
    }

    private void setMap(final String map) {;
        this.map = map;
        this.setChanged();
        this.notifyObservers();
    }

    public void loadMap(String key) {
        try {
            final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
            this.setMap(daoLoadMap.find(key).getMap());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    private void setDBplayer(final String[] name, final int[] score) {
        this.setDBplayerName(name);
        this.setDBplayerScore(score);
    }

    public void loadHighscores() {
        try {
            final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
            this.setDBplayer(daoLoadMap.putHighscores().getName(),daoLoadMap.putHighscores().getScore());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean mMovePossible(final int x, final int y){
        return (pngArray[x][y] == ' ' || pngArray[x][y] == 'L');
    }

    private boolean openGate(final int x, final int y){
        return (pngArray[x][y] == 'K');
    }

    private boolean isPurse(final int x, final int y){
        return (pngArray[x][y] == 'P');
    }

    private boolean onGate(final int x, final int y){
        return (pngArray[x][y] == 'O');
    }

    private boolean isMovePossible(final int x, final int y){
        return (pngArray[x][y] != 'V' && pngArray[x][y] != 'H'
             && pngArray[x][y] != 'B' && pngArray[x][y] != 'C'
             && pngArray[x][y] != '1' && pngArray[x][y] != '2'
             && pngArray[x][y] != '3' && pngArray[x][y] != '4');
    }

    public boolean isDead(){
        if (getMonster1().getX() == getHero().getX() && getMonster1().getY() == getHero().getY()){
            pngArray[getHero().getY()][getHero().getX()] = ' ';
            return true;
        }
        return false;
    }
    public boolean checkFireball(){
        if (getShoot().getX() == getHero().getX() && getShoot().getY() == getHero().getY()){
            pngArray[getHero().getY()][getHero().getX()] = 'L';
            return true;
        }
        return false;
    }

    public void lastHP(){
        pngArray[getHero().getY()][getHero().getX()] = ' ';
    }

    public void newHP(){
        pngArray[getHero().getY()][getHero().getX()] = 'L';
    }

    public void lastMP(){
        pngArray[getMonster1().getY()][getMonster1().getX()] = ' ';
    }

    public void newMP(){
        pngArray[getMonster1().getY()][getMonster1().getX()] = '1';
    }

    public void moveRIGHT() {
        if(isPurse(getHero().getY(), getHero().getX()+1)){
            Score += 100;
        }
        if(openGate(getHero().getY(), getHero().getX() +1)){
            pngArray[getGateC().getY()][gateC.getX()] = 'O';
        }
        if(onGate(getHero().getY(), getHero().getX() +1)){
            verifyMapDoor();
        }
        if(isMovePossible(getHero().getY(), getHero().getX()+1)){
            lastHP();
            getHero().moveRIGHT();
            newHP();        }
    }

    public void moveUP() {
        if(isPurse(getHero().getY() -1, getHero().getX())){
            Score += 100;
        }
        if(openGate(getHero().getY() -1, getHero().getX())){
            pngArray[getGateC().getY()][gateC.getX()] = 'O';
        }
        if(onGate(getHero().getY() -1, getHero().getX())){
            verifyMapDoor();
        }
        if(isMovePossible(getHero().getY() -1, getHero().getX())) {
            lastHP();
            getHero().moveUp();
            newHP();
        }

    }

    public void moveDOWN() {
        if(isPurse(getHero().getY() +1, getHero().getX())){
            Score += 100;
        }
        if(openGate(getHero().getY()+1, getHero().getX())){
            pngArray[getGateC().getY()][gateC.getX()] = 'O';
        }
        if(onGate(getHero().getY()+1, getHero().getX())){
            verifyMapDoor();
        }
        if (isMovePossible(getHero().getY() +1, getHero().getX())) {
            lastHP();
            getHero().moveDOWN();
            newHP();
        }
    }

   public void fireAnimation() {
       if (checkFireball()) {
           if (canShoot == 0) {
               if (getFireDirection() == "RIGHT") {

                   if (this.isMovePossible(this.getShoot().getY(), this.getShoot().getX() + 1)) {
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                       this.getShoot().moveRIGHT();
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';

                   } else {
                       System.out.println("test3");
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                       this.getShoot().moveLEFT();
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                       fireDirection = "LEFT";

                   }
               } else if (getFireDirection() == "LEFT") {
                   if (this.isMovePossible(this.getShoot().getY(), this.getShoot().getX() - 1)) {
                       System.out.println("test2");
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                       this.getShoot().moveLEFT();
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                   } else {
                       System.out.println("test3");
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                       this.getShoot().moveRIGHT();
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                       fireDirection = "RIGHT";

                   }
               } else if (getFireDirection() == "UP") {
                   if (this.isMovePossible(this.getShoot().getY() - 1, this.getShoot().getX())) {
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                       this.getShoot().moveUP();
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                   } else {
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                       this.getShoot().moveDOWN();
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                       fireDirection = "DOWN";
                   }
               } else if (getFireDirection() == "DOWN") {
                   if (this.isMovePossible(this.getShoot().getY() + 1, this.getShoot().getX())) {
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                       this.getShoot().moveDOWN();
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                   } else {
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                       this.getShoot().moveUP();
                       this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                       fireDirection = "UP";

                   }

               }
           }
       }
   }

    public void fireBall() {

        if(getLastMove() == "RIGHT"){
            this.getShoot().setY(this.getHero().getY());
            this.getShoot().setX(this.getHero().getX()+1);
            canShoot = 0;
            this.pngArray[this.getShoot().getY()][this.getShoot().getX()+1] = 'M';
            fireDirection = "RIGHT";
            }
        if(getLastMove() == "LEFT"){
            this.getShoot().setY(this.getHero().getY());
            this.getShoot().setX(this.getHero().getX()-1);
            canShoot = 0;
            this.pngArray[this.getHero().getY()][this.getHero().getX()-1] = 'M';
            fireDirection = "LEFT";
        }
        if(getLastMove() == "UP"){
            this.getShoot().setY(this.getHero().getY()-1);
            this.getShoot().setX(this.getHero().getX());
            canShoot = 0;
            this.pngArray[this.getHero().getY()-1][this.getHero().getX()] = 'M';
            fireDirection = "UP";
        }
        if(getLastMove() == "DOWN"){
            this.getShoot().setY(this.getHero().getY()+1);
            this.getShoot().setX(this.getHero().getX());
            canShoot = 0;
            this.pngArray[this.getHero().getY()+1][this.getHero().getX()] = 'M';
            fireDirection = "DOWN";
        }
    }

    public void moveLEFT() {
        if(isPurse(getHero().getY(), getHero().getX() - 1)){
            Score += 100;
        }
        if(openGate(getHero().getY(), getHero().getX() -1)){
            pngArray[getGateC().getY()][gateC.getX()] = 'O';
        }
        if(onGate(getHero().getY(), getHero().getX() -1)){
            verifyMapDoor();
        }
        if(isMovePossible(getHero().getY(), getHero().getX() - 1)){
            lastHP();
            getHero().moveLEFT();
            newHP();
        }
    }

    public void monster1(){
        int mx = getMonster1().getX();
        int hx = getHero().getX();
        int my = getMonster1().getY();
        int hy = getHero().getY();

        if(mx < hx && mMovePossible(getMonster1().getY(), getMonster1().getX() +1)){
            lastMP();
            getMonster1().moveRIGHT();
            newMP();
        }
        if(mx > hx && mMovePossible(getMonster1().getY(),getMonster1().getX() -1)){
            lastMP();
            getMonster1().moveLEFT();
            newMP();
        }
        if (my < hy && mMovePossible(getMonster1().getY() +1,getMonster1().getX())){
            lastMP();
            getMonster1().moveDOWN();
            newMP();
        }
        if(my > hy && mMovePossible(getMonster1().getY() -1,getMonster1().getX())){
            lastMP();
            getMonster1().moveUp();
            newMP();
        }
    }

    private void verifyMapDoor() {
        switch(this.getMapnumber()) {
            case 1:
                this.loadMap("MAP2");
                this.setMapnumber(2);
                break;
            case 2:
                this.loadMap("MAP3");
                this.setMapnumber(3);
                break;
            case 3:
                this.loadMap("MAP4");
                this.setMapnumber(4);
                break;
            case 4:
                this.loadMap("MAP5");
                this.setMapnumber(5);
                break;
            case 5:
                OnGate = 1;
                break;
            case 6:
                this.loadMap("MAP1");
                this.setMapnumber(1);
                break;
            default:
                break;
        }
    }
}
