package rs.raf.gerumap.gui.swing.view.user.controller;

import rs.raf.gerumap.gui.swing.view.user.view.UserDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserCancelActionListener implements ActionListener {

    private final UserDialog window;

    public UserCancelActionListener(UserDialog window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.close();
    }

}
