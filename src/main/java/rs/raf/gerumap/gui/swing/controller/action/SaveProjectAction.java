package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.util.FileUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;

import java.awt.event.ActionEvent;

public class SaveProjectAction extends GRMapAction {

    public SaveProjectAction() {
        super(SaveProjectAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        EditorProject editorProject = MainWindow.window.getEditor().getActiveProject();

        if (editorProject == null)
            return; //TODO Warning - There is no project to save

        if (editorProject.getProject().getFileLocation() == null) {
            ActionManager.getAction(SaveProjectAsAction.class).actionPerformed(event);
            return;
        }

        FileUtils.saveToProjectFile(editorProject);
    }

}
