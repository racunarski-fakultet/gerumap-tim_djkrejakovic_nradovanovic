package rs.raf.gerumap.gui.swing.event;

import rs.raf.gerumap.gui.swing.util.PreferenceUtils;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GRMapComponentListener extends ComponentAdapter {

    @Override
    public void componentResized(ComponentEvent e) {
        if (!PreferenceUtils.getWindowMaximized())
            PreferenceUtils.putWindowSize(e.getComponent().getSize());
    }

}
