package controller;

import java.io.IOException;

/**
 * Created by Asus on 14/06/2016.
 */
public interface IOrderPerformed {
    void orderPerform(UserOrder userOrder) throws IOException;
}
