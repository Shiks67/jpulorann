package model;

import contract.IModel;
import element.mobile.*;
import element.motionless.GateC;


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

    int Death;

    private Hero hero;
    private GateC gateC;
    private Monster1 monster1;
    private Monster2 monster2;
    private Monster3 monster3;
    private Monster4 monster4;

    private int Score;  /** ingame score **/

    /** The array of objects **/
    private int height = 12;
    private int width = 21;
    private char[][] pngArray = new char[this.getHeight()][this.getWidth()];

    /** The message. */
    private String message;

    /** The map */
    private String map;

    /** getters **/
    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getScore() {
        return Score;
    }

    public String[] getDBplayerName() {
        return DBplayerName;
    }

    public void setDBplayerName(String DBplayerName[]) {
        this.DBplayerName = DBplayerName;
    }

    public int[] getDBplayerScore() {
        return DBplayerScore;
    }

    public void setDBplayerScore(int DBplayerScore[]) {
        this.DBplayerScore = DBplayerScore;
    }
    /**
     * Instantiates a new model.
     */
    public Model() {
        this.map = "";
        this.hero = new Hero(0,0);
        this.gateC = new GateC(0,0);
        this.monster1 = new Monster1(0,0);
        this.monster2 = new Monster2(0,0);
        this.monster3 = new Monster3(0,0);
        this.monster4 = new Monster4(0,0);
    }

    /*
     * (non-Javadoc)
     *
     * @see contract.IModel#getMessage()
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets the message.
     *
     * @param message
     *          the new message
     */
    private void setMessage(final String message) {
        this.message = message;
        this.setChanged();
        this.notifyObservers();
    }

    /*
     * (non-Javadoc)
     *
     * @see contract.IModel#getMessage(java.lang.String)
     */
    public void loadMessage(final String key) { /** loads TEXT map from DB into a String **/
        try {
            final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
            this.setMessage(daoHelloWorld.find(key).getMessage());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see contract.IModel#getObservable()
     */
    public Observable getObservable() {
        return this;
    }

    public String getDBplayerName(int i) {
        return this.DBplayerName[i];
    }

    public int getDBplayerScore(int i) {
        return this.DBplayerScore[i];
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
                        break;
                    case 'K' :
                        putPngName(i,j,'K');
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

    public Hero getHero() {
        return this.hero;
    }

    public GateC getGateC(){
        return this.gateC;
    }

    public Monster1 getMonster1() {
        return this.monster1;
    }

    public Monster2 getMonster2() {
        return this.monster2;
    }

    public Monster3 getMonster3() {
        return this.monster3;
    }

    public Monster4 getMonster4() {
        return this.monster4;
    }

    public char[][] getMap() {  /** return chat 2d array used to display images in view by copy **/
        return this.pngArray;
    }

    private void setMap(final String map) {
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
        return (this.pngArray[x][y] == ' ' || this.pngArray[x][y] == 'L');
    }

    private boolean openGate(final int x, final int y){
        return (this.pngArray[x][y] == 'K');
    }

    private boolean isPurse(final int x, final int y){
        return (this.pngArray[x][y] == 'P');
    }

    private boolean isMovePossible(final int x, final int y){
        return (this.pngArray[x][y] != 'V' && this.pngArray[x][y] != 'H'
        && this.pngArray[x][y] != 'B' && this.pngArray[x][y] != 'C'
        && this.pngArray[x][y] != '1' && this.pngArray[x][y] != '2'
        && this.pngArray[x][y] != '3' && this.pngArray[x][y] != '4');
    }

    public void lastHP(){
        this.pngArray[this.getHero().getY()][this.getHero().getX()] = ' ';
    }

    public void newHP(){
        this.pngArray[this.getHero().getY()][this.getHero().getX()] = 'L';
    }

    public void lastMP(){
        this.pngArray[this.getMonster1().getY()][this.getMonster1().getX()] = ' ';
    }

    public void newMP(){
        this.pngArray[this.getMonster1().getY()][this.getMonster1().getX()] = '1';
    }

    public void moveRIGHT() {
        if(this.isPurse(this.getHero().getY(), this.getHero().getX()+1)){
            Score += 100;
        }
        if(this.openGate(this.getHero().getY(), this.getHero().getX() +1)){
            this.pngArray[this.getGateC().getY()][this.gateC.getX()] = 'O';
        }
        if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()+1)){
            this.lastHP();
            this.getHero().moveRIGHT();
            this.newHP();        }
    }

    public void moveUP() {
        if(this.isPurse(this.getHero().getY() -1, this.getHero().getX())){
            Score += 100;
        }
        if(this.openGate(this.getHero().getY() -1, this.getHero().getX())){
            this.pngArray[this.getGateC().getY()][this.gateC.getX()] = 'O';
        }
        if(this.isMovePossible(this.getHero().getY() -1, this.getHero().getX())) {
            this.lastHP();
            this.getHero().moveUp();
            this.newHP();        }

    }

    public void moveDOWN() {
        if(this.isPurse(this.getHero().getY() +1, this.getHero().getX())){
            Score += 100;
        }
        if(this.openGate(this.getHero().getY()+1, this.getHero().getX())){
            this.pngArray[this.getGateC().getY()][this.gateC.getX()] = 'O';
        }
        if (this.isMovePossible(this.getHero().getY() +1, this.getHero().getX())) {
            this.lastHP();
            this.getHero().moveDOWN();
            this.newHP();
        }
    }

    public void moveLEFT() {
        if(this.isPurse(this.getHero().getY(), this.getHero().getX() - 1)){
            Score += 100;
        }
        if(this.openGate(this.getHero().getY(), this.getHero().getX() -1)){
            this.pngArray[this.getGateC().getY()][this.gateC.getX()] = 'O';
        }
        if(isMovePossible(this.getHero().getY(), this.getHero().getX() - 1)){
            this.lastHP();
            this.getHero().moveLEFT();
            this.newHP();
        }
    }

    public void monster1(){
        int mx = this.getMonster1().getX();
        int hx = this.getHero().getX();
        int my = this.getMonster1().getY();
        int hy = this.getHero().getY();

        if(mx < hx && this.mMovePossible(this.getMonster1().getY(), this.getMonster1().getX() +1)){
            this.lastMP();
            this.getMonster1().moveRIGHT();
            this.newMP();
        }
        if(mx > hx && this.mMovePossible(this.getMonster1().getY(), this.getMonster1().getX() -1)){
            this.lastMP();
            this.getMonster1().moveLEFT();
            this.newMP();
        }
        if (my < hy && this.mMovePossible(this.getMonster1().getY() +1, this.getMonster1().getX())){
            this.lastMP();
            this.getMonster1().moveDOWN();
            this.newMP();
        }
        if(my > hy && this.mMovePossible(this.getMonster1().getY() -1, this.getMonster1().getX())){
            this.lastMP();
            this.getMonster1().moveUp();
            this.newMP();
        }
        if (mx == hx && my == hy ){
            this.pngArray[this.getHero().getY()][this.getHero().getX()] = ' ';
            //Death += 1;
            //System.out.println(Death);
        }
    }
}
