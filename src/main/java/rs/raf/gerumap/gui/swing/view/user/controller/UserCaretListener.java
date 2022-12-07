package rs.raf.gerumap.gui.swing.view.user.controller;

import rs.raf.gerumap.gui.swing.view.user.view.UserDialog;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class UserCaretListener implements CaretListener {

    private final UserDialog window;

    public UserCaretListener(UserDialog window) {
        this.window = window;
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        window.update();
    }

}
