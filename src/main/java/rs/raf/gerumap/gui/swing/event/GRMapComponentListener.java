package rs.raf.gerumap.gui.swing.event;

import rs.raf.gerumap.gui.util.PreferenceUtils;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GRMapComponentListener implements ComponentListener {

    @Override
    public void componentResized(ComponentEvent e) {
        if (!PreferenceUtils.getWindowMaximized())
            PreferenceUtils.putWindowSize(e.getComponent().getSize());
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) { }

    @Override
    public void componentHidden(ComponentEvent e) { }

}
