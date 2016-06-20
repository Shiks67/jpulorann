package model;

/**
 * The Class LoadHighscores.
 *
 * @author Cedric Meyer
 */
class LoadHighscores extends Entity {

    /** getters */
    public int[] getScore() {
        return score;
    }

    public String[] getName() {
        return name;
    }

    /** setters */
    public void setName(String[] name) {
        this.name = name;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    /** The name. */
    private String[] name = new String[6];


    /** The scores. */
    private int[] score = new int[6];

    /**
     * Instantiates a new hello world.
     *
     * @param name
     *          the nickname
     * @param score
     *          the scores
     */
    public LoadHighscores(String[] name, int[] score) {
        this.setName(name);
        this.setScore(score);
    }

    /**
     * Instantiates a new Load Map.
     */
    public LoadHighscores() {
        //this(0, "", "");
    }
}

