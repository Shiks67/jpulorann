package model;

/**
 * The Class LoadMap.
 *
 * @author cyril SNIADACH
 */
class LoadMap extends Entity {

    /** The id. */
    private int			id;

    /** The key. */
    private String	key;

    /** The map content. */
    private String	map;

    /**
     * Instantiates a new hello world.
     *
     * @param id
     *          the id
     * @param key
     *          the key
     * @param map
     *          the map content
     */
    public LoadMap(final int id, final String key, final String map) {
        this.setId(id);
        this.setKey(key);
        this.setMap(map);
    }

    /**
     * Instantiates a new Load Map.
     */
    public LoadMap() {
        this(0, "", "");
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *          the new id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *          the new key
     */
    public void setKey(final String key) {
        this.key = key;
    }

    /**
     * Gets the map content.
     *
     * @return the map content
     */
    public String getMap() {
        return this.map;
    }

    /**
     * Sets the map content.
     *
     * @param map
     *          the new map content
     */
    public void setMap(final String map) {
        this.map = map;
    }

}

