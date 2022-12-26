package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.controller.comands.ChangeCentralConceptCommand;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;

import java.awt.event.ActionEvent;
import java.util.List;

public class MindMapRootAction extends GRMapAction {

    public MindMapRootAction() {
        super(MindMapRootAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        List<GraphicElement> graphicElements = SelectionManager.getSelectedElements();

        if (graphicElements.size() != 1 || !(graphicElements.get(0) instanceof GraphicConcept graphicConcept))
            return;

        MainWindow.window.getEditor().getCommandManager().addCommand(new ChangeCentralConceptCommand(graphicConcept));
    }

}
