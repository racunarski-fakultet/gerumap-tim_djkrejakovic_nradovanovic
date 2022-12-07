package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.user.view.UserDialog;

import java.awt.event.ActionEvent;

public class UserAction extends GRMapAction {

    public UserAction() {
        super(UserAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new UserDialog().setVisible(true);
    }

}
