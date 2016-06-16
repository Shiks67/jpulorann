package model;

/**
 * The Class LoadHighscores.
 *
 * @author Cedric Meyer
 */
class PutHighscoresInDB extends Entity {

    /** The name. */
    private String name;


    /** The scores. */
    private int score;

    /**
     * Instantiates a new hello world.
     *
     * @param lename
     *          the nickname
     * @param lescore
     *          the scores
     */
    public PutHighscoresInDB(String lename, int lescore) {
        this.setName(lename);
        this.setScore(lescore);
    }

    /**
     * Instantiates a new Load Map.
     */
    public PutHighscoresInDB() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

