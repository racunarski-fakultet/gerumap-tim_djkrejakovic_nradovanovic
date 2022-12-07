package rs.raf.gerumap.gui.swing.view.user.view;

import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.user.controller.UserCancelActionListener;
import rs.raf.gerumap.gui.swing.view.user.controller.UserCaretListener;
import rs.raf.gerumap.gui.swing.view.user.controller.UserConfirmActionListener;
import rs.raf.gerumap.gui.swing.view.user.controller.UserDialogKeyListener;
import rs.raf.gerumap.gui.swing.view.user.model.User;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;

public class UserDialog extends JDialog {

    private final JTextField userField = new JTextField();
    private final JButton confirmButton = new JButton("OK");
    private final JButton cancelButton = new JButton("Cancel");

    private boolean validName = true;

    public UserDialog() {
        super(MainWindow.window);

        initialize();
        setupComponents();
        addListeners();
    }

    private void initialize() {
        setModal(true);
        setSize(new Dimension(210, 210));
        setUndecorated(true);
        setLocationRelativeTo(MainWindow.window);
    }

    private void setupComponents() {
        userField.putClientProperty("JTextField.placeholderText", "Enter username");

        if (MainWindow.window.getEditor().getAuthor() != null)
            userField.setText(MainWindow.window.getEditor().getAuthor().getName());

        userField.setBorder(createRegularBorder());

        JPanel container = new JPanel(new GridBagLayout());

        container.setBackground(new Color(66, 69, 72));
        container.setBorder(BorderFactory.createLineBorder(new Color(86, 89, 92)));

        JLabel userImage = new JLabel(ImageUtils.loadIcon("UserHigh"));

        container.add(userImage, new GridBagConstraints(0, 0, 3, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.NONE,
                                                        new Insets(10, 0, 20, 0), 0, 0));
        container.add(userField, new GridBagConstraints(0, 1, 3, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL,
                                                        new Insets(0, 0, 10, 0), 0, 0));
        container.add(confirmButton, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.NONE,
                                                            new Insets(20, 0, 10, 10), 0, 0));
        container.add(cancelButton, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.NONE,
                                                           new Insets(20, 10, 10, 0), 0, 0));

        add(container);
    }

    private void addListeners() {
        confirmButton.addActionListener(new UserConfirmActionListener(this));
        cancelButton.addActionListener(new UserCancelActionListener(this));
        userField.addCaretListener(new UserCaretListener(this));
        userField.addKeyListener(new UserDialogKeyListener(this));
    }

    /**
     * Updates the user field based on whether the content is valid.
     */
    public void update() {
        setValidName(userField.getText().toLowerCase().trim().length() != 0);
    }

    /**
     * Sets true if the name is valid, otherwise false.
     * @param isValid valid
     */
    public void setValidName(boolean isValid) {
        if (validName == isValid)
            return;

        userField.setBorder(isValid ? createRegularBorder() : createErrorBorder());

        validName = isValid;
    }

    /**
     * Returns the border of the text field when the name is not valid.
     * @return border
     */
    private Border createErrorBorder() {
        return BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(86, 89, 92), 1),
                                                                                     BorderFactory.createMatteBorder(0,0, 2,0, new Color(200, 20, 20))),
                                                  BorderFactory.createEmptyBorder(3, 4, 2, 4));
    }

    /**
     * Returns the border of the text field when the name is valid.
     * @return border
     */
    private Border createRegularBorder() {
        return BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(86, 89, 92), 1), BorderFactory.createEmptyBorder(3,4,4,4));
    }

    /**
     * Sets the author.
     */
    public void setAuthor() {
        if (!validName)
            return;

        MainWindow.window.getEditor().setAuthor(new User(userField.getText()));
    }

    /**
     * Returns whether the name is valid.
     * @return true if name is valid, otherwise false
     */
    public boolean isValidName() {
        return validName;
    }

    /**
     * Returns the content of a user field.
     * @return username
     */
    public String getValue() {
        return userField.getText();
    }

    /**
     * Closes the dialog.
     */
    public void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
