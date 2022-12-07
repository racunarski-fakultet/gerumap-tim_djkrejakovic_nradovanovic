package rs.raf.gerumap.gui.swing.view.user.controller;

import rs.raf.gerumap.gui.swing.view.user.view.UserDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserConfirmActionListener implements ActionListener {

    private final UserDialog window;

    public UserConfirmActionListener(UserDialog window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (window.getValue().equals(""))
            window.setValidName(false);

        if (!window.isValidName())
            return;

        window.setAuthor();
        window.close();
    }

}
