package rs.raf.gerumap.gui.swing;

import rs.raf.gerumap.gui.Gui;
import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.UIManager;
import rs.raf.gerumap.gui.swing.util.PreferenceUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;

public class SwingGui implements Gui {

    @Override
    public void start() {
        PreferenceUtils.clear(); //TODO Remove on release

        UIManager.setup();

        MainWindow.window.setVisible(true);
    }

}
