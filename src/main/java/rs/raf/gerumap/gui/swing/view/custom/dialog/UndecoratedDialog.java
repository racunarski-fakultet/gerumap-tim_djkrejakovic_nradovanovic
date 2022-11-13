package rs.raf.gerumap.gui.swing.view.custom.dialog;

import javax.swing.JDialog;
import java.awt.Frame;
import java.awt.event.WindowEvent;

public abstract class UndecoratedDialog extends JDialog {

    private boolean discarded;

    public UndecoratedDialog(Frame owner) {
        super(owner);
        setModal(true);
        setUndecorated(true);
    }

    public abstract Object getValue();

    public boolean isDiscarded() {
        return discarded;
    }

    public void setDiscarded(boolean discarded) {
        this.discarded = discarded;
    }

    public void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
