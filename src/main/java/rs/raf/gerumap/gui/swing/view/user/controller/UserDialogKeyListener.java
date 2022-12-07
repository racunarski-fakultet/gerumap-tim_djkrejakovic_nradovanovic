package rs.raf.gerumap.gui.swing.view.user.controller;

import rs.raf.gerumap.gui.swing.view.user.view.UserDialog;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserDialogKeyListener extends KeyAdapter {

    private final UserDialog window;

    public UserDialogKeyListener(UserDialog window) {
        this.window = window;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        boolean isValid  = window.isValidName();
        boolean isEnter  = event.getKeyCode() == KeyEvent.VK_ENTER;
        boolean isEscape = event.getKeyCode() == KeyEvent.VK_ESCAPE;

        if (isEnter && window.getValue().equals(""))
            window.setValidName(isValid = false);

        if (!isEscape && (!isEnter || !isValid))
            return;

        if (!isEscape)
            window.setAuthor();

        window.close();
    }

}
