package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.util.FileUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.dialog.SaveProjectDialog;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;

import java.awt.event.ActionEvent;
import java.io.File;

public class SaveProjectAsAction extends GRMapAction {

    public SaveProjectAsAction() {
        super(SaveProjectAsAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        EditorProject editorProject = MainWindow.window.getEditor().getActiveProject();

        if (editorProject == null)
            return; //TODO Warning - There is no project to save

        SaveProjectDialog.showDialog(editorProject.getProject());

        File file = SaveProjectDialog.getSelectedFile();

        if (file == null)
            return; //NOTE: no file is selected

        editorProject.getProject().setFileLocation(file.getAbsolutePath());
        editorProject.generateNewIdentifiers();

        FileUtils.saveToProjectFile(editorProject);
    }

}
