package rs.raf.gerumap.gui.swing.controller.comands;

public class ChangeDiagramWidthCommand extends BaseCommand {

    private final int newWidth;
    private final int oldWidth;

    public ChangeDiagramWidthCommand(int newWidth) {
        this.newWidth = newWidth;
        this.oldWidth = editor.getDiagram().getActualWidth();
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        editor.getDiagram().setActualWidth(newWidth);

        editor.updateProperties();
    }

    @Override
    public void undoCommand() {
        editor.getDiagram().setActualWidth(oldWidth);

        editor.updateProperties();
    }

}
