package rs.raf.gerumap.gui.swing.controller.comands;

import java.awt.Color;

public class ChangeDiagramBackgroundCommand extends BaseCommand {

    private final Color newBackground;
    private final Color oldBackground;

    public ChangeDiagramBackgroundCommand(Color newBackground) {
        this.newBackground = newBackground;
        this.oldBackground = editor.getDiagram().getBackground();
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        editor.getDiagram().setBackground(newBackground);

        editor.updateProperties();
    }

    @Override
    public void undoCommand() {
        editor.getDiagram().setBackground(oldBackground);

        editor.updateProperties();
    }

}
