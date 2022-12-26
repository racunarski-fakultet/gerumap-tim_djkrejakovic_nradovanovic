package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;

public class ChangeCentralConceptCommand extends BaseCommand {

    private final GraphicConcept newCentralConcept;
    private final GraphicConcept oldCentralConcept;

    public ChangeCentralConceptCommand(GraphicConcept newCentralConcept) {
        this.newCentralConcept = newCentralConcept;
        this.oldCentralConcept = editor.getActivePage().getCentralConcept();
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        if (oldCentralConcept != null)
            oldCentralConcept.setCentral(false);

        newCentralConcept.setCentral(true);

        editor.render();
    }

    @Override
    public void undoCommand() {
        if (oldCentralConcept != null)
            oldCentralConcept.setCentral(true);

        newCentralConcept.setCentral(false);

        editor.render();
    }

}
