package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.util.FileUtils;
import rs.raf.gerumap.gui.swing.view.dialog.OpenProjectDialog;

import java.awt.event.ActionEvent;

public class OpenProjectAction extends GRMapAction {

    public OpenProjectAction() {
        super(OpenProjectAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        OpenProjectDialog.showDialog();

        FileUtils.loadFromProjectFile(OpenProjectDialog.getSelectedFile());
    }

}
