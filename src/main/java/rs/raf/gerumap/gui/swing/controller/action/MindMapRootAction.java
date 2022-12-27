package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.controller.comands.ChangeCentralConceptCommand;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

import java.awt.event.ActionEvent;
import java.util.List;

public class MindMapRootAction extends GRMapAction {

    public MindMapRootAction() {
        super(MindMapRootAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        List<GraphicElement> graphicElements = SelectionManager.getSelectedElements();

        if (graphicElements.size() != 1) {
            Logger.log(Message.EDITOR_ONE_CENTRAL_CONCEPT);
            return;
        }

        if (!(graphicElements.get(0) instanceof GraphicConcept graphicConcept)) {
            Logger.log(Message.EDITOR_CONNECTION_NOT_CENTRAL);
            return;
        }

        MainWindow.window.getEditor().getCommandManager().addCommand(new ChangeCentralConceptCommand(graphicConcept));
    }

}
