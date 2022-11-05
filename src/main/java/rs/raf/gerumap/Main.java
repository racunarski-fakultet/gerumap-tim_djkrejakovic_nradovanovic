package rs.raf.gerumap;

import com.formdev.flatlaf.FlatDarkLaf;
import rs.raf.gerumap.gui.swing.view.MainWindow;

public class Main {
    public static void main(String[] args) {
        System.out.println("Class: Main | Method: main");

        FlatDarkLaf.setup();

        MainWindow.instance.setVisible(true);

    }
}
