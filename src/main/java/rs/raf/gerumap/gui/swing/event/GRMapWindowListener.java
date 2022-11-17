package rs.raf.gerumap.gui.swing.event;

import rs.raf.gerumap.gui.swing.util.PreferenceUtils;
import rs.raf.gerumap.log.Logger;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GRMapWindowListener extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        Logger.clear();
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        PreferenceUtils.putWindowMaximized(e.getNewState() == Frame.MAXIMIZED_BOTH);
    }

}
