package view;

import java.util.TimerTask;

/**
 * Created by Ahmed on 21/06/2016.
 */
public class manage_keyboard extends TimerTask{
    public void run() {
        int p = ViewFrame.l.size();

        if (p == 1) {
            if (ViewPanel.m == 0) {
                ViewPanel.m = 1;
            }
            else {
                ViewFrame.getController().orderPerform(View.keyCodeToControllerOrder((Integer) ViewFrame.l.get(0)));
                System.out.print("1");
                ViewPanel.m = 0;
            }
        } else if (p == 2) {
            int i = 0;
            i = (Integer) ViewFrame.l.get(0) * (Integer) ViewFrame.l.get(1);
            ViewFrame.getController().orderPerform(View.keyCodeToControllerOrder(i));
        }
    }
}
