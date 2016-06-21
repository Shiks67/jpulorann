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
 */
public class Model extends Observable implements IModel {

    /** The array */
    private char[][] pngArray = new char[this.getHeight()][this.getWidth()];
    private final int height = 12;
    private final int width = 21;

    /** other variables **/

    /**
     * lower random for monster 3AI
     */
    int lower = 1;

    /**
     * Higer random for monster 3 AI (actually it will be 4)
     */
    int higher = 5;

    /**
     * Player name from the DB
     */
    private String[] DBplayerName = new String[6];
    /**
     * Player score from the DB
     */
    private int[] DBplayerScore = new int[6];
    /**
     * Saving of the last move
     */
    private String lastMove = "RIGHT";
    /**
     * Saving of fire direction
     */
    private String fireDirection = "RIGHT";
    /**
     * Boolean shoot able or not
     */
    private int canShoot = 1;
    /**
     * If monster 1 is dead
     */
    private int death1 = 0;
    /**
     * If monster 2 is dead
     */
    private int death2 = 1;
    /**
     * If monster 3 is dead
     */
    private int death3 = 1;
    /**
     * If monster 4 is dead
     */
    private int death4 = 1;
    /**
     * Level number
     */
    private int mapnumber = 1;
    /**
     * Used for the choice of map to be done only once
     */
    private int thatmap = 0;
    /**
     * Boolean if the player is on a gate
     */
    private int OnGate = 0;
    /**
     * Timer for monsters, incremented to 3 to moves monsters then reset to 0
     */
    private int o = 0;
    /**
     * Ingame score
     */
    private int Score;

    /** The objects **/
    /**
     * Fireball
     */
    private Shoot shoot;
    /**
     * Hero
     */
    private Hero hero;
    /**
     * Gate closed
     */
    private GateC gateC;
    /**
     * Monster 1
     */
    private Monster1 monster1;
    /**
     * Monster 2
     */
    private Monster2 monster2;
    /**
     * Monster 3
     */
    private Monster3 monster3;
    /**
     * Monster 4
     */
    private Monster4 monster4;


    /**
     * The map from the DB
     */
    private String map;

    /** getters **/
    /**
     * Get the observalbe
     * @return
     */
    public Observable getObservable() {
        return this;
    }

    /**
     * Get boolean onGate
     * @return
     */
    public int getOnGate() {
        return OnGate;
    }

    /**
     * Get the Hero
     * @return
     */
    public Hero  getHero()  { return this.hero;}

    /**
     * Get gate closed
     * @return
     */
    public GateC getGateC() { return this.gateC;}

    /**
     * Get the fireball
     * @return
     */
    public Shoot getShoot() { return this.shoot;}

    /**
     * Get monster n°1
     * @return
     */
    public Monster1 getMonster1() {
        return monster1;
    }

    /**
     * Get monster n°2
     * @return
     */
    public Monster2 getMonster2() {
        return monster2;
    }

    /**
     * Get monster n°3
     * @return
     */
    public Monster3 getMonster3() {
        return monster3;
    }

    /**
     * Get monster n°4
     * @return
     */
    public Monster4 getMonster4() {
        return monster4;
    }

    /**
     * Get the char[][] containing the map
     * @return
     */
    public char[][] getMap() {  /** return chat 2d array used to display images in view by copy **/
        return pngArray;
    }

    /**
     * Get timer o
     * @return
     */
    public int getO() {
        return o;
    }

    /**
     * Get the thatmap
     * @return
     */
    public int getThatmap() {
        return thatmap;
    }

    /**
     * Get the actual map number
     * @return
     */
    public int getMapnumber() {
        return this.mapnumber;
    }

    /**
     * Get map height
     * @return
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Get map width
     * @return
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Get the score
     * @return
     */
    public int getScore() {
        return Score;
    }

    /**
     * Get the player name from the DB
     * @param i
     * @return
     */
    public String getDBplayerName(int i) {
        return this.DBplayerName[i];
    }

    /**
     * Get the player score from the DB
     * @param i
     * @return
     */
    public int getDBplayerScore(int i) {
        return this.DBplayerScore[i];
    }

    /**
     * Get the last player move
     * @return
     */
    public String getLastMove(){
        return this.lastMove;
    }

    /**
     * Get the direction of the shot
     * @return
     */
    public String getFireDirection(){
        return this.fireDirection;
    }

    /** setters **/

    /**
     * Set the player name from the DB
     * @param DBplayerName
     */
    public void setDBplayerName(String DBplayerName[]) {
        this.DBplayerName = DBplayerName;
    }

    /**
     * Set the score of the player from the DB
     * @param DBplayerScore
     */
    public void setDBplayerScore(int DBplayerScore[]) {
        this.DBplayerScore = DBplayerScore;
    }

    /**
     * Set the map number to display it at the bottom of the screen
     * @param mapnumber
     */
    public void setMapnumber(int mapnumber) {
        this.mapnumber = mapnumber;
    }

    /**
     * Set the timer o
     * @param o
     */
    public void setO(int o) {
        this.o = o;
    }

    /**
     * Set the variable for the map selection to be done only once in the beginning of the game
     * @param thatmap
     */
    public void setThatmap(int thatmap) {
        this.thatmap = thatmap;
    }

    /**
     * Set the last move done ingame
     * @param lastMove
     */
    public void setLastMove(String lastMove){
        this.lastMove = lastMove;
    }

    /**
     * Set the player name from the DB
     * @param name
     * @param score
     */
    private void setDBplayer(final String[] name, final int[] score) {
        this.setDBplayerName(name);
        this.setDBplayerScore(score);
    }

    /**
     * Set the map when changed
     * @param map
     */
    private void setMap(final String map) {;
        this.map = map;
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Instantiates a new model.
     */
    public Model() {
        this.map = "";
        hero = new Hero(1,1);
        gateC = new GateC(0,0);
        shoot = new Shoot(11,21);
        monster1 = new Monster1(0,0);
        monster2 = new Monster2(0,0);
        monster3 = new Monster3(0,0);
        monster4 = new Monster4(0,0);
    }

    /** i added the map functions in general here **/

    /**
     * Puts the char corresponding to a png name in a char[][]
     * @param i
     * @param j
     * @param pngName
     */
    public void putPngName(int i, int j, char pngName) {    /** puts the right character at the right position in the 2d char array, used in getTabInMap() **/
        pngArray[i][j]= pngName;
    }

    /**
     * first spmlits the string from the DB into String[] at \n
     * then puts the String[] into a char[]
     */
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

    /**
     * Load the map
     * @param key
     */
    public void loadMap(String key) {
        try {
            final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
            this.setMap(daoLoadMap.find(key).getMap());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load the HighScore
     */
    public void loadHighscores() {
        try {
            final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
            this.setDBplayer(daoLoadMap.putHighscores().getName(),daoLoadMap.putHighscores().getScore());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if the next sprite is a movable sprite for monsters
     * @param x
     * @param y
     * @return
     */
    private boolean mMovePossible(final int x, final int y){
        return (pngArray[x][y] == ' ' || pngArray[x][y] == 'L');
    }

    /**
     * Check if the next sprite is not blocking the fireball
     * @param x
     * @param y
     * @return
     */

    private boolean fMovePossible(final int x, final int y) {
        return (pngArray[x][y] != 'V' && pngArray[x][y] != 'H'
                && pngArray[x][y] != 'B' && pngArray[x][y] != 'C'
                && pngArray[x][y] != 'O' && pngArray[x][y] != 'P'
                && pngArray[x][y] != 'K');
    }

    /**
     * Check if lorann is on the crystal to open the gate
     * @param x
     * @param y
     * @return
     */
    private boolean openGate(final int x, final int y){
        return (pngArray[x][y] == 'K');
    }

    /**
     * check if lorann is on the purse to get +100 score
     * @param x
     * @param y
     * @return
     */
    private boolean isPurse(final int x, final int y){
        return (pngArray[x][y] == 'P');
    }

    /**
     * If lorann is on the gate
     * @param x
     * @param y
     * @return
     */
    private boolean onGate(final int x, final int y){
        return (pngArray[x][y] == 'O');
    }

    /**
     * Check if lorann can move
     * if there isn't the wrong sprite to the next position
     * @param x
     * @param y
     * @return
     */
    private boolean isMovePossible(final int x, final int y){
        return (pngArray[x][y] != 'V' && pngArray[x][y] != 'H'
             && pngArray[x][y] != 'B' && pngArray[x][y] != 'C'
             && pngArray[x][y] != '1' && pngArray[x][y] != '2'
             && pngArray[x][y] != '3' && pngArray[x][y] != '4');
    }

    /**
     * check if lorann is dead or not
     * @return
     */
    public boolean isDead(){
        if (getMonster1().getX() == getHero().getX() && getMonster1().getY() == getHero().getY()){
            pngArray[getHero().getY()][getHero().getX()] = ' ';
            return true;
        }if (getMonster2().getX() == getHero().getX() && getMonster2().getY() == getHero().getY()){
            pngArray[getHero().getY()][getHero().getX()] = ' ';
            return true;
        }if (getMonster3().getX() == getHero().getX() && getMonster3().getY() == getHero().getY()){
            pngArray[getHero().getY()][getHero().getX()] = ' ';
            return true;
        }if (getMonster4().getX() == getHero().getX() && getMonster4().getY() == getHero().getY()){
            pngArray[getHero().getY()][getHero().getX()] = ' ';
            return true;
        }

        return false;
    }

    /**
     * Check fire-ball's position compared to monster / hero position (to kill ennemies and stuff)
     */
    public void checkFireball(){
        if (getShoot().getX() == getHero().getX() && getShoot().getY() == getHero().getY()) {
            pngArray[getHero().getY()][getHero().getX()] = 'L';
            canShoot = 1;
        }
        else if (getShoot().getX() == getMonster1().getX() && getShoot().getY() == getMonster1().getY()) {
            pngArray[getMonster1().getY()][getMonster1().getX()] = ' ';
            canShoot = 1;
            this.death1 = 1;
            this.getMonster1().setX(0);
            this.getMonster1().setY(0);
            this.getShoot().setX(11);
            this.getShoot().setY(21);

        }
        else if (getShoot().getX() == getMonster2().getX() && getShoot().getY() == getMonster2().getY()) {
            pngArray[getMonster2().getY()][getMonster2().getX()] = ' ';
            canShoot = 1;
            this.death2 = 1;
            this.getMonster2().setX(0);
            this.getMonster2().setY(0);
            this.getShoot().setX(11);
            this.getShoot().setY(21);
        }
        else if (getShoot().getX() == getMonster3().getX() && getShoot().getY() == getMonster3().getY()) {
            pngArray[getMonster3().getY()][getMonster3().getX()] = ' ';
            canShoot = 1;
            this.death3 = 1;
            this.getMonster3().setX(0);
            this.getMonster3().setY(0);
            this.getShoot().setX(11);
            this.getShoot().setY(21);
        }
        else if (getShoot().getX() == getMonster4().getX() && getShoot().getY() == getMonster4().getY()) {
            pngArray[getMonster4().getY()][getMonster4().getX()] = ' ';
            canShoot = 1;
            this.death4 = 1;
            this.getMonster4().setX(0);
            this.getMonster4().setY(0);
            this.getShoot().setX(11);
            this.getShoot().setY(21);
        }
    }
    /**
     * Used to animate the Fireball at the good position
     */
    public void fireAnimation() {
        if (canShoot == 0) {
            if (getFireDirection() == "RIGHT" ) { /** If the firedirection is right ,this fireball will go right **/
                if (this.fMovePossible(this.getShoot().getY(), this.getShoot().getX()+1)) {
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                    this.getShoot().moveRIGHT();
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                } else {
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                    this.getShoot().moveLEFT();
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                    fireDirection = "LEFT";
                }
            } else if (getFireDirection() == "LEFT") {
                if (this.fMovePossible(this.getShoot().getY(), this.getShoot().getX() - 1)) {
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                    this.getShoot().moveLEFT();
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                } else {
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = ' ';
                    this.getShoot().moveRIGHT();
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                    fireDirection = "RIGHT";

                }
            } else if (getFireDirection() == "UP") {
                if (this.fMovePossible(this.getShoot().getY() - 1, this.getShoot().getX())) {
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
                if (this.fMovePossible(this.getShoot().getY() + 1, this.getShoot().getX())) {
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

    /**
     * Used to place the Fireball at the good position
     */

    public void fireBall() {
        if (canShoot == 1) {
            canShoot = 0;
            if (getLastMove() == "RIGHT") {
                if(this.fMovePossible(this.getHero().getY(), this.getHero().getX()+1)) {
                    this.getShoot().setY(this.getHero().getY());
                    this.getShoot().setX(this.getHero().getX() + 1);
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                    fireDirection = "RIGHT";
                }
                else {
                    this.getShoot().setY(this.getHero().getY());
                    this.getShoot().setX(this.getHero().getX() - 1);
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                    fireDirection = "LEFT";
                }
            }
            if (getLastMove() == "LEFT") {
                if(this.fMovePossible(this.getHero().getY(), this.getHero().getX()-1)) {
                    this.getShoot().setY(this.getHero().getY());
                    this.getShoot().setX(this.getHero().getX() - 1);
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                    fireDirection = "LEFT";
                }
                else {
                    this.getShoot().setY(this.getHero().getY());
                    this.getShoot().setX(this.getHero().getX() + 1);
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                    fireDirection = "RIGHT";
                }
            }
            if (getLastMove() == "UP") {
                if (this.fMovePossible(this.getHero().getY() - 1, this.getHero().getX())) {
                    this.getShoot().setY(this.getHero().getY() - 1);
                    this.getShoot().setX(this.getHero().getX());
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                    fireDirection = "UP";
                }
                else {
                    this.getShoot().setY(this.getHero().getY() + 1);
                    this.getShoot().setX(this.getHero().getX());
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                    fireDirection = "DOWN";
                }

            }
            if (getLastMove() == "DOWN") {
                if (this.fMovePossible(this.getHero().getY() + 1, this.getHero().getX())) {
                    this.getShoot().setY(this.getHero().getY() + 1);
                    this.getShoot().setX(this.getHero().getX());
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                    fireDirection = "DOWN";
                }
                else {
                    this.getShoot().setY(this.getHero().getY() - 1);
                    this.getShoot().setX(this.getHero().getX());
                    this.pngArray[this.getShoot().getY()][this.getShoot().getX()] = 'M';
                    fireDirection = "UP";
                }
            }
        }
    }

    /**
     * Last hero position
     */
    /**
     * Lorann's last position (Hero Position)
     */
    private void lastHP(){
        pngArray[getHero().getY()][getHero().getX()] = ' ';
    }

    /**
     * New Hero Position
     */
    /**
     * New lorann's position
     */
    private void newHP(){
        pngArray[getHero().getY()][getHero().getX()] = 'L';
    }

    /**
     * Lorann moves right
     */
    /**
     * Move right if he can + if there is a purse get +100score if it's a crystal he will open the door and if it's the opened door go to the next level
     */
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

    /**
     * Move rup if he can + if there is a purse get +100score if it's a crystal he will open the door and if it's the opened door go to the next level
     */
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

    /**
     * Move down if he can + if there is a purse get +100score if it's a crystal he will open the door and if it's the opened door go to the next level
     */
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

    /**
     * Move left if he can + if there is a purse get +100score if it's a crystal he will open the door and if it's the opened door go to the next level
     */
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

    public void moveDIAGONALUPLEFT() {
        if(isPurse(getHero().getY() - 1, getHero().getX() - 1)){
            Score += 100;
        }
        if(openGate(getHero().getY() - 1, getHero().getX() -1)){
            pngArray[getGateC().getY()][gateC.getX()] = 'O';
        }if(onGate(getHero().getY()-1, getHero().getX() -1)){
            verifyMapDoor();
        }
        if(isMovePossible(getHero().getY() - 1, getHero().getX() - 1)){
            lastHP();
            getHero().moveDIAGONALUPLEFT();
            newHP();
        }
    }

    public void moveDIAGONALUPRIGHT() {
        if(isPurse(getHero().getY() - 1, getHero().getX() + 1)){
            Score += 100;
        }
        if(openGate(getHero().getY() - 1, getHero().getX() + 1)){
            pngArray[getGateC().getY()][gateC.getX()] = 'O';
        }
        if(onGate(getHero().getY()-1, getHero().getX() +1)){
            verifyMapDoor();
        }
        if(isMovePossible(getHero().getY() - 1, getHero().getX() + 1)){
            lastHP();
            getHero().moveDIAGONALUPRIGHT();
            newHP();
        }
    }

    public void moveDIAGONALDOWNLEFT() {
        if(isPurse(getHero().getY() + 1, getHero().getX() - 1)){
            Score += 100;
        }
        if(openGate(getHero().getY() + 1, getHero().getX() - 1)){
            pngArray[getGateC().getY()][gateC.getX()] = 'O';
        }
        if(onGate(getHero().getY()+1, getHero().getX() -1)){
            verifyMapDoor();
        }
        if(isMovePossible(getHero().getY() + 1, getHero().getX() - 1)){
            lastHP();
            getHero().moveDIAGONALDOWNLEFT();
            newHP();
        }
    }

    public void moveDIAGONALDOWNRIGHT() {
        if(isPurse(getHero().getY() + 1, getHero().getX() + 1)){
            Score += 100;
        }
        if(openGate(getHero().getY() + 1, getHero().getX() + 1)){
            pngArray[getGateC().getY()][gateC.getX()] = 'O';
        }
        if(onGate(getHero().getY()+1, getHero().getX() +1)){
            verifyMapDoor();
        }
        if(isMovePossible(getHero().getY() + 1, getHero().getX() + 1)){
            lastHP();
            getHero().moveDIAGONALDOWNRIGHT();
            newHP();
        }
    }


    /**
     * Monsters AI
     * They compare their own position with Lorann's position then change their position to get closer then kill Lorann
     */
    public void monster1() {
        if (this.getO() == 3) {
            if (this.death1 == 0) {
                int mx = getMonster1().getX();
                int hx = getHero().getX();
                int my = getMonster1().getY();
                int hy = getHero().getY();

                /** if monster's x is lower than lorann's increments it**/
                if (mx < hx && mMovePossible(getMonster1().getY(), getMonster1().getX() + 1)) {
                    pngArray[getMonster1().getY()][getMonster1().getX()] = ' ';
                    getMonster1().moveRIGHT();
                    pngArray[getMonster1().getY()][getMonster1().getX()] = '1';
                }
                /** if monster's x is higher than lorann's decrement it**/
                if (mx > hx && mMovePossible(getMonster1().getY(), getMonster1().getX() - 1)) {
                    pngArray[getMonster1().getY()][getMonster1().getX()] = ' ';
                    getMonster1().moveLEFT();
                    pngArray[getMonster1().getY()][getMonster1().getX()] = '1';
                }
                /** if monster's y is lower than lorann's increments it**/
                if (my < hy && mMovePossible(getMonster1().getY() + 1, getMonster1().getX())) {
                    pngArray[getMonster1().getY()][getMonster1().getX()] = ' ';
                    getMonster1().moveDOWN();
                    pngArray[getMonster1().getY()][getMonster1().getX()] = '1';
                }
                /** if monster's y is higher than lorann's decrement it **/
                if (my > hy && mMovePossible(getMonster1().getY() - 1, getMonster1().getX())) {
                    pngArray[getMonster1().getY()][getMonster1().getX()] = ' ';
                    getMonster1().moveUp();
                    pngArray[getMonster1().getY()][getMonster1().getX()] = '1';
                }
            }
        }
    }

    /**
     * Monster 2 IA
     * They compare their own position with lorann's position then change their position
     */
    public void monster2() {
        if (this.getO() == 3) {
            if (this.death2 == 0) {
                int m2x = getMonster2().getX();
                int h2x = getHero().getX();
                int m2y = getMonster2().getY();
                int h2y = getHero().getY();

                if (m2x < h2x && mMovePossible(getMonster2().getY(), getMonster2().getX() + 1)) {
                    pngArray[getMonster2().getY()][getMonster2().getX()] = ' ';
                    getMonster2().moveRIGHT();
                    pngArray[getMonster2().getY()][getMonster2().getX()] = '2';
                }
                if (m2x > h2x && mMovePossible(getMonster2().getY(), getMonster2().getX() - 1)) {
                    pngArray[getMonster2().getY()][getMonster2().getX()] = ' ';
                    getMonster2().moveLEFT();
                    pngArray[getMonster2().getY()][getMonster2().getX()] = '2';
                }
                if (m2y < h2y && mMovePossible(getMonster2().getY() + 1, getMonster2().getX())) {
                    pngArray[getMonster2().getY()][getMonster2().getX()] = ' ';
                    getMonster2().moveDOWN();
                    pngArray[getMonster2().getY()][getMonster2().getX()] = '2';
                }
                if (m2y > h2y && mMovePossible(getMonster2().getY() - 1, getMonster2().getX())) {
                    pngArray[getMonster2().getY()][getMonster2().getX()] = ' ';
                    getMonster2().moveUp();
                    pngArray[getMonster2().getY()][getMonster2().getX()] = '2';
                }
            }
        }
    }

    /**
     * Monster 3 IA
     * They compare their own position with lorann's position then change their position
     */
    public void monster3() {
        if (this.getO() == 3) {
            if (this.death3 == 0) {
                int random = (int)(Math.random()*(higher-lower)) +lower;
                switch (random){
                    case 1 :
                        if(mMovePossible(getMonster3().getY(), getMonster3().getX() + 1)){
                            pngArray[getMonster3().getY()][getMonster3().getX()] = ' ';
                            getMonster3().moveRIGHT();
                            pngArray[getMonster3().getY()][getMonster3().getX()] = '3';
                        }
                        break;
                    case 2 :
                        if(mMovePossible(getMonster3().getY(), getMonster3().getX() - 1)){
                            pngArray[getMonster3().getY()][getMonster3().getX()] = ' ';
                            getMonster3().moveLEFT();
                            pngArray[getMonster3().getY()][getMonster3().getX()] = '3';
                        }
                        break;
                    case 3 :
                        if(mMovePossible(getMonster3().getY(), getMonster3().getX())){
                            pngArray[getMonster3().getY()][getMonster3().getX()] = ' ';
                            getMonster3().moveUp();
                            pngArray[getMonster3().getY()][getMonster3().getX()] = '3';
                        }
                        break;
                    case 4 :
                        if(mMovePossible(getMonster3().getY()+1, getMonster3().getX())){
                            pngArray[getMonster3().getY()][getMonster3().getX()] = ' ';
                            getMonster3().moveDOWN();
                            pngArray[getMonster3().getY()][getMonster3().getX()] = '3';
                        }
                        break;
                }
            }
        }
    }

    /**
     * Monster 4 IA
     * They compare their own position with lorann's position then change their position
     */
    public void monster4() {
        if (this.getO() == 4) {
            if (this.death4 == 0) {
                int m4x = getMonster4().getX();
                int h4x = getHero().getX();
                int m4y = getMonster4().getY();
                int h4y = getHero().getY();

                if (m4x < h4x && mMovePossible(getMonster4().getY(), getMonster4().getX() + 1)) {
                    pngArray[getMonster4().getY()][getMonster4().getX()] = ' ';
                    getMonster4().moveRIGHT();
                    pngArray[getMonster4().getY()][getMonster4().getX()] = '4';
                }
                if (m4x > h4x && mMovePossible(getMonster4().getY(), getMonster4().getX() - 1)) {
                    pngArray[getMonster4().getY()][getMonster4().getX()] = ' ';
                    getMonster4().moveLEFT();
                    pngArray[getMonster4().getY()][getMonster4().getX()] = '4';
                }
                if (m4y < h4y && mMovePossible(getMonster4().getY() + 1, getMonster4().getX())) {
                    pngArray[getMonster4().getY()][getMonster4().getX()] = ' ';
                    getMonster4().moveDOWN();
                    pngArray[getMonster4().getY()][getMonster4().getX()] = '4';
                }
                if (m4y > h4y && mMovePossible(getMonster4().getY() - 1, getMonster4().getX())) {
                    pngArray[getMonster4().getY()][getMonster4().getX()] = ' ';
                    getMonster4().moveUp();
                    pngArray[getMonster4().getY()][getMonster4().getX()] = '4';
                }
            }
            this.setO(0);
        }
    }

    /**
     * Load next level after map and door verification
     */
    private void verifyMapDoor() {
        switch(this.getMapnumber()) {
            case 1:
                this.loadMap("MAP2");
                this.setMapnumber(2);
                this.death1 = 1;
                this.death2 = 0;
                this.death3 = 0;
                this.death4 = 0;
                break;
            case 2:
                this.loadMap("MAP3");
                this.setMapnumber(3);
                this.death1 = 0;
                this.death2 = 0;
                this.death3 = 0;
                this.death4 = 0;
                break;
            case 3:
                this.loadMap("MAP4");
                this.setMapnumber(4);
                this.death1 = 0;
                this.death2 = 0;
                this.death3 = 0;
                this.death4 = 0;
                break;
            case 4:
                this.loadMap("MAP5");
                this.setMapnumber(5);
                this.death1 = 0;
                this.death2 = 1;
                this.death3 = 0;
                this.death4 = 0;
                break;
            case 5:
                OnGate = 1;
                break;
            case 6:
                this.loadMap("MAP1");
                this.setMapnumber(1);
                this.death1 = 0;
                this.death2 = 1;
                this.death3 = 1;
                this.death4 = 1;
                break;
            default:
                break;
        }

        /**
         * FireBall remover when lvl up
         */
        this.getShoot().setY(this.getHero().getY());
        this.getShoot().setX(this.getHero().getX());
    }
}
