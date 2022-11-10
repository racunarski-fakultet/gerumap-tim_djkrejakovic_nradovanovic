package rs.raf.gerumap.gui.swing.view;

import rs.raf.gerumap.gui.swing.event.GRMapComponentListener;
import rs.raf.gerumap.gui.swing.event.GRMapWindowListener;
import rs.raf.gerumap.gui.swing.event.GRMapWindowStateListener;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.util.PreferenceUtils;
import rs.raf.gerumap.gui.swing.view.menu.MenuBar;
import rs.raf.gerumap.gui.swing.view.toolbar.Toolbar;
import rs.raf.gerumap.gui.swing.view.workspace.Workspace;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {

    public static final MainWindow instance = instantiate();

    private static MainWindow instantiate() {
        MainWindow instance = new MainWindow();
        instance.initialize();

        return instance;
    }

    private MainWindow() { }

    private void initialize() {
        setSettings();
        addComponents();
    }

    //region Set Settings

    private void setSettings() {
        setSize();
        setLocation();
        setAttributes();
        addListeners();
    }

    private void setSize() {
        setSize(PreferenceUtils.getWindowSize());

        if (PreferenceUtils.getWindowMaximized())
            setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void setLocation() {
        setLocationRelativeTo(null);
    }

    private void addListeners() {
        addWindowListener(new GRMapWindowListener());
        addComponentListener(new GRMapComponentListener());
        addWindowStateListener(new GRMapWindowStateListener());
    }

    private void setAttributes() {
        setTitle("GeRuMap");
        setIconImage(ImageUtils.loadImage("logo"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //endregion

    //region Add Components

    private void addComponents() {
        addMenuBar();
        addToolbar();
        addWorkspace();
    }

    private void addMenuBar() {
        setJMenuBar(new MenuBar());
    }

    private void addToolbar() {
        add(new Toolbar(), BorderLayout.NORTH);
    }

    private void addWorkspace() {
        add(new Workspace());
    }

    //endregion

    public void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
