package rs.raf.gerumap.gui.swing.view;

import rs.raf.gerumap.gui.swing.event.GRMapComponentListener;
import rs.raf.gerumap.gui.swing.event.GRMapWindowListener;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.util.PreferenceUtils;
import rs.raf.gerumap.gui.swing.view.menu.MenuBar;
import rs.raf.gerumap.gui.swing.view.toolbar.Toolbar;
import rs.raf.gerumap.gui.swing.view.workspace.Workspace;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.IExplorer;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {

    public static final MainWindow window = instantiate();

    //region Singleton

    private static MainWindow instantiate() {
        MainWindow instance = new MainWindow();
        instance.initialize();

        return instance;
    }

    private MainWindow() { }

    //endregion

    private MenuBar menuBar;

    private Toolbar toolbar;

    private Workspace workspace;

    private IExplorer explorer;

    private void initialize() {
        setSettings();
        initializeComponents();
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
        addWindowStateListener(new GRMapWindowListener());
    }

    private void setAttributes() {
        setTitle("GeRuMap");
        setIconImage(ImageUtils.loadImage("logo"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //endregion

    //region Initialize Components

    private void initializeComponents() {
        menuBar   = new MenuBar();
        toolbar   = new Toolbar();
        workspace = new Workspace();

        explorer = workspace.getExplorer();
    }

    //endregion

    //region Add Components

    private void addComponents() {
        addMenuBar();
        addToolbar();
        addWorkspace();
    }

    private void addMenuBar() {
        setJMenuBar(menuBar);
    }

    private void addToolbar() {
        add(toolbar, BorderLayout.NORTH);
    }

    private void addWorkspace() {
        add(workspace);
    }

    //endregion

    //region Get Components

    public MenuBar getMainMenu() {
        return menuBar;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public IExplorer getExplorer() {
        return explorer;
    }

    //endregion

    public void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
