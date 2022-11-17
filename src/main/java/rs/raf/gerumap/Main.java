package rs.raf.gerumap;

import rs.raf.gerumap.core.Application;
import rs.raf.gerumap.gui.swing.SwingGui;

public class Main {

    public static void main(String[] args) {
        Application.run(args, new SwingGui());
    }

}
