package rs.raf.gerumap.gui.swing.event;

import rs.raf.gerumap.gui.swing.util.PreferenceUtils;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class GRMapWindowStateListener implements WindowStateListener {

    @Override
    public void windowStateChanged(WindowEvent e) {
        PreferenceUtils.putWindowMaximized(e.getNewState() == Frame.MAXIMIZED_BOTH);
    }

}
