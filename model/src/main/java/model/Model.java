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
    private String lastMove = "RIGHT";
    private String fireDirection = "RIGHT";
    private int canShoot = 1;
    private int death1 = 0;
    private int death2 = 0;
    private int death3 = 0;
    private int death4 = 0;
    private int mapnumber = 1;

    private Shoot shoot;
    private Hero hero;
    private GateC gateC;
    private Monster1 monster1;
    private Monster2 monster2;
    private Monster3 monster3;
    private Monster4 monster4;

    private int thatmap = 0;
    private int OnGate = 0;
    private int o = 0; /** Timer for monsters, incremented to 3 to moves monsters then reset to 0 **/
    private int Score;  /** ingame score **/

    /** The array of objects **/
    private final int height = 12;
    private final int width = 21;
    private char[][] pngArray = new char[this.getHeight()][this.getWidth()];

    /** The map */
    private String map;

    public int getMapnumber() {
        return this.mapnumber;
    }

    public void setMapnumber(int mapnumber) {
        this.mapnumber = mapnumber;
    }

    /** getters and setters **/

    public int getOnGate() {
        return OnGate;
    }

    public Hero  getHero()  { return this.hero;}

    public GateC getGateC() { return this.gateC;}

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

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public int getThatmap() {
        return thatmap;
    }

    public void setThatmap(int thatmap) {
        this.thatmap = thatmap;
    }

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
        shoot = new Shoot(11,21);
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
     * Set the map when changed
     * @param map
     */
    private void setMap(final String map) {;
        this.map = map;
        this.setChanged();
        this.notifyObservers();
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

    private void setDBplayer(final String[] name, final int[] score) {
        this.setDBplayerName(name);
        this.setDBplayerScore(score);
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
     * Fire ball
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

    public void fireAnimation() {
        if (canShoot == 0) {
            if (getFireDirection() == "RIGHT" ) {
                if (this.fMovePossible(this.getShoot().getY(), this.getShoot().getX() + 1)) {
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

    public void fireBall() {
        if (canShoot == 1) {
            canShoot = 0;
            if (getLastMove() == "RIGHT") {
                this.getShoot().setY(this.getHero().getY());
                this.getShoot().setX(this.getHero().getX() + 1);
                this.pngArray[this.getHero().getY()][this.getHero().getX() + 1] = 'M';
                fireDirection = "RIGHT";
            }
            if (getLastMove() == "LEFT") {
                this.getShoot().setY(this.getHero().getY());
                this.getShoot().setX(this.getHero().getX() - 1);
                this.pngArray[this.getHero().getY()][this.getHero().getX() - 1] = 'M';
                fireDirection = "LEFT";
            }
            if (getLastMove() == "UP") {
                this.getShoot().setY(this.getHero().getY() - 1);
                this.getShoot().setX(this.getHero().getX());
                this.pngArray[this.getHero().getY() - 1][this.getHero().getX()] = 'M';
                fireDirection = "UP";
            }
            if (getLastMove() == "DOWN") {
                this.getShoot().setY(this.getHero().getY() + 1);
                this.getShoot().setX(this.getHero().getX());
                this.pngArray[this.getHero().getY() + 1][this.getHero().getX()] = 'M';
                fireDirection = "DOWN";
            }
        }
    }

    /**
     * Lorann's moves
     */

    private void lastHP(){
        pngArray[getHero().getY()][getHero().getX()] = ' ';
    }

    private void newHP(){
        pngArray[getHero().getY()][getHero().getX()] = 'L';
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

    /**
     * Monsters IA
     * They compare their own position with lorann's position then change their position
     */

    public void monster1() {
        if (this.getO() == 3) {
            if (this.death1 == 0) {
                int mx = getMonster1().getX();
                int hx = getHero().getX();
                int my = getMonster1().getY();
                int hy = getHero().getY();
                /** if x is lower than lorann's increments it**/
                if (mx < hx && mMovePossible(getMonster1().getY(), getMonster1().getX() + 1)) {
                    pngArray[getMonster1().getY()][getMonster1().getX()] = ' ';
                    getMonster1().moveRIGHT();
                    pngArray[getMonster1().getY()][getMonster1().getX()] = '1';
                }
                /** if x is higher than lorann's decrement it**/
                if (mx > hx && mMovePossible(getMonster1().getY(), getMonster1().getX() - 1)) {
                    pngArray[getMonster1().getY()][getMonster1().getX()] = ' ';
                    getMonster1().moveLEFT();
                    pngArray[getMonster1().getY()][getMonster1().getX()] = '1';
                }
                /** if y is lower than lorann's increments it**/
                if (my < hy && mMovePossible(getMonster1().getY() + 1, getMonster1().getX())) {
                    pngArray[getMonster1().getY()][getMonster1().getX()] = ' ';
                    getMonster1().moveDOWN();
                    pngArray[getMonster1().getY()][getMonster1().getX()] = '1';
                }
                /** if y is higher than lorann's decrement it **/
                if (my > hy && mMovePossible(getMonster1().getY() - 1, getMonster1().getX())) {
                    pngArray[getMonster1().getY()][getMonster1().getX()] = ' ';
                    getMonster1().moveUp();
                    pngArray[getMonster1().getY()][getMonster1().getX()] = '1';
                }
            }
        }
    }

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

    public void monster3() {
        if (this.getO() == 3) {
            if (this.death3 == 0) {
                int m3x = getMonster3().getX();
                int h3x = getHero().getX();
                int m3y = getMonster3().getY();
                int h3y = getHero().getY();

                if (m3x < h3x && mMovePossible(getMonster3().getY(), getMonster3().getX() + 1)) {
                    pngArray[getMonster3().getY()][getMonster3().getX()] = ' ';
                    getMonster3().moveRIGHT();
                    pngArray[getMonster3().getY()][getMonster3().getX()] = '3';
                }
                if (m3x > h3x && mMovePossible(getMonster3().getY(), getMonster3().getX() - 1)) {
                    pngArray[getMonster3().getY()][getMonster3().getX()] = ' ';
                    getMonster3().moveLEFT();
                    pngArray[getMonster3().getY()][getMonster3().getX()] = '3';
                }
                if (m3y < h3y && mMovePossible(getMonster3().getY() + 1, getMonster3().getX())) {
                    pngArray[getMonster3().getY()][getMonster3().getX()] = ' ';
                    getMonster3().moveDOWN();
                    pngArray[getMonster3().getY()][getMonster3().getX()] = '3';
                }
                if (m3y > h3y && mMovePossible(getMonster3().getY() - 1, getMonster3().getX())) {
                    pngArray[getMonster3().getY()][getMonster3().getX()] = ' ';
                    getMonster3().moveUp();
                    pngArray[getMonster3().getY()][getMonster3().getX()] = '3';
                }
            }
        }
    }

    public void monster4() {
        if (this.getO() == 3) {
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
     * Load next level
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
