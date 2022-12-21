package rs.raf.gerumap.gui.swing.controller.comands;

public class ChangeDiagramHeightCommand extends BaseCommand {

    private final int newHeight;
    private final int oldHeight;

    public ChangeDiagramHeightCommand(int newHeight) {
        this.newHeight = newHeight;
        this.oldHeight = editor.getDiagram().getActualHeight();
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        editor.getDiagram().setActualHeight(newHeight);

        editor.updateProperties();
    }

    @Override
    public void undoCommand() {
        editor.getDiagram().setActualHeight(oldHeight);

        editor.updateProperties();
    }

}
