package rs.raf.gerumap.gui.swing.view;

import rs.raf.gerumap.gui.swing.event.GRMapComponentListener;
import rs.raf.gerumap.gui.swing.event.GRMapWindowListener;
import rs.raf.gerumap.gui.swing.event.GRMapWindowStateListener;
import rs.raf.gerumap.gui.util.ImageUtils;
import rs.raf.gerumap.gui.util.PreferenceUtils;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

    public static final MainWindow instance = instantiate();

    private static MainWindow instantiate() {
        MainWindow instance = new MainWindow();
        instance.initialize();

        return instance;
    }

    private MainWindow() { }

    private void initialize() {
        setSize();
        setLocation();
        setAttributes();

        addListeners();

        addMainMenu();
        addToolbar();
        addWorkspace();
    }

    //region Set settings

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

    //region Add components

    private void addMainMenu() { }

    private void addToolbar() { }

    private void addWorkspace() { }

    //endregion

}
