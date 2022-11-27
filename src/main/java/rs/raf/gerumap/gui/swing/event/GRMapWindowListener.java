package rs.raf.gerumap.gui.swing.event;

import rs.raf.gerumap.gui.swing.util.PreferenceUtils;
import rs.raf.gerumap.log.Logger;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GRMapWindowListener extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        //Close all loggers
        Logger.clear();
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        //Whenever window state changes, the new state is saved
        PreferenceUtils.putWindowMaximized(e.getNewState() == Frame.MAXIMIZED_BOTH);
    }

}
