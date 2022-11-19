package rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.util.List;

public abstract class ExplorerDialogBase extends JDialog {

    protected final JPanel             panel        = new JPanel(new GridBagLayout());
    protected final GridBagConstraints constraints  = new GridBagConstraints();
    protected final JLabel             titleLabel   = new JLabel();
    protected final JTextField         nameField    = new JTextField();
    protected final JLabel             invalidLabel = new JLabel();

    protected List<String> names;

    protected boolean discarded = false;
    protected boolean validName = true;

    protected ExplorerDialogBase(Frame owner, String title, List<String> names) {
        super(owner);
        setModal(true);
        setUndecorated(true);
        setSize(new Dimension(180, 49));
        setLocationRelativeTo(owner);
        setLocation(getLocation().x, getLocation().y - MainWindow.window.getSize().height / 16);

        this.names = names;

        panel.setBackground(new Color(66, 69, 72));

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.gridx = 0;

        titleLabel.setText(title);
        titleLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, new Color(86, 89, 92)),
                                                                BorderFactory.createEmptyBorder(3,3,5,3)));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);

        invalidLabel.setText("This name already exist!");
        invalidLabel.setForeground(new Color(210, 72, 25));
        invalidLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(86, 89, 92)),
                                                                  BorderFactory.createEmptyBorder(3,3,5,3)));

        invalidLabel.setHorizontalAlignment(SwingConstants.CENTER);
        invalidLabel.setVerticalAlignment(SwingConstants.CENTER);


        nameField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(86, 89, 92), 1),
                                                               BorderFactory.createEmptyBorder(3,3,3,3)));

        panel.add(titleLabel, constraints);
        panel.add(nameField, constraints);

        add(panel);
    }

    public void update() {
        setValidName(!names.contains(nameField.getText().toLowerCase().trim()));
    }

    public Object getValue() {
        return isDiscarded() ? null : nameField.getText();
    }

    public boolean isDiscarded() {
        return discarded;
    }

    public void setDiscarded(boolean discarded) {
        this.discarded = discarded;
    }

    public void setValidName(boolean isValid) {
        if (validName == isValid)
            return;

        if (isValid) {
            panel.remove(invalidLabel);
            setSize(getWidth(), getHeight() - (int) invalidLabel.getPreferredSize().getHeight());
        }
        else {
            panel.add(invalidLabel, constraints);
            setSize(getWidth(), getHeight() + (int) invalidLabel.getPreferredSize().getHeight());
        }

        panel.validate();
        panel.repaint();

        validName = isValid;
    }

    public boolean isValidName() {
        return validName;
    }

    public void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
