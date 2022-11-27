package rs.raf.gerumap.gui.swing.event;

import rs.raf.gerumap.gui.swing.util.PreferenceUtils;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GRMapComponentListener extends ComponentAdapter {

    @Override
    public void componentResized(ComponentEvent event) {
        //Whenever the window is resized, the new size is saved
        if (!PreferenceUtils.getWindowMaximized())
            PreferenceUtils.putWindowSize(event.getComponent().getSize());
    }

}
