package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DAOLoadMap.
 * I JUST CHANGED HelloWorld BY LoadMap EVERYWHERE TO MAKE IT CLEAR and added some stuff
 * @author Cedric Meyer
 */
public class DAOLoadMap extends DAOEntity<LoadMap> {

    /**
     * Instantiates a new DAO Load Map.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOLoadMap(final Connection connection) throws SQLException {
        super(connection);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#create(model.Entity)
     */
    @Override
    public boolean create(final LoadMap entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#delete(model.Entity)
     */
    @Override
    public boolean delete(final LoadMap entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#update(model.Entity)
     */
    @Override
    public boolean update(final LoadMap entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#find(int)
     */
    @Override
    public LoadMap find(final int id) {
        LoadMap loadmap = new LoadMap();

        try {
            final String sql = "{call loadmapById(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                loadmap = new LoadMap(id, resultSet.getString("key"), resultSet.getString("map"));

            }
            return loadmap;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#find(java.lang.String)
     */
    @Override
    public LoadMap find(final String key) {
        LoadMap loadMap = new LoadMap();

        try {
            final String sql = "{call loadmapByKey(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setString(1, key);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                loadMap = new LoadMap(resultSet.getInt("id"), key, resultSet.getString("map"));
            }
            return loadMap;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public LoadHighscores putHighscores() {
        LoadHighscores loadHighscores = new LoadHighscores();
        try {
            String[] name = new String[6];
            int[] score = new int[6];
            final String sql = "{call sortHighscoreByDescendingOrder()}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                for (int m = 0; m < 6; m++) {
                    name[m] = resultSet.getString("nickname");
                    score[m] = resultSet.getInt("score");
                    resultSet.next();
                    System.out.println(name[m]+"   "+score[m]);
                }
                loadHighscores = new LoadHighscores(name, score);
            }

            return loadHighscores;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

