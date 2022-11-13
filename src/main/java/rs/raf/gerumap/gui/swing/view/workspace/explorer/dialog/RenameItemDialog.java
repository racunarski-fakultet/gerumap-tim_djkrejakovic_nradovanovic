package rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.custom.dialog.UndecoratedDialog;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.event.ExplorerDialogKeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class RenameItemDialog extends UndecoratedDialog {

    private final JPanel             panel        = new JPanel(new GridBagLayout());
    private final GridBagConstraints constraints  = new GridBagConstraints();
    private final JLabel             titleLabel   = new JLabel();
    private final JTextField         projectField = new JTextField();

    public RenameItemDialog(Frame owner, String defaultName) {
        super(owner);

        setSize(new Dimension(180, 49));
        setLocationRelativeTo(owner);
        setLocation(getLocation().x, getLocation().y - MainWindow.window.getSize().height / 16);

        projectField.addKeyListener(new ExplorerDialogKeyListener(this));

        panel.setBackground(new Color(66, 69, 72));

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.gridx = 0;

        titleLabel.setText("Rename");
        titleLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, new Color(86, 89, 92)),
                                                                BorderFactory.createEmptyBorder(3,3,5,3)));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);

        projectField.setText(defaultName);
        projectField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(86, 89, 92), 1),
                                                                  BorderFactory.createEmptyBorder(3,3,3,3)));

        panel.add(titleLabel, constraints);
        panel.add(projectField, constraints);

        add(panel);
    }

    @Override
    public Object getValue() {
        return isDiscarded() ? null : projectField.getText();
    }

}
