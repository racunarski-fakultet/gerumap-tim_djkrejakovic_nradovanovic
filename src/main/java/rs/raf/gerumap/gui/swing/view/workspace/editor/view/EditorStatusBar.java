package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import com.formdev.flatlaf.extras.components.FlatButton;
import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.ZoomInAction;
import rs.raf.gerumap.gui.swing.controller.action.ZoomOutAction;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.custom.GRMapZoomSlider;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.text.MessageFormat;
import java.util.Timer;
import java.util.TimerTask;

public class EditorStatusBar extends JToolBar {

    private final JLabel labelCursorIcon  = new JLabel(ImageUtils.loadIcon("StatusBarCursor"));
    private final JLabel labelCoordinates = new JLabel(" 0, 0");
    private final JLabel labelMessage     = new JLabel();
    private final JLabel labelZoom        = new JLabel();

    private Timer messageTimer = new Timer();

    private final GRMapZoomSlider sliderZoom = new GRMapZoomSlider();

    private final FlatButton buttonZoomIn  = new FlatButton();
    private final FlatButton buttonZoomOut = new FlatButton();

    public EditorStatusBar() {
        buttonZoomIn.setAction(ActionManager.getAction(ZoomInAction.class));
        buttonZoomIn.setButtonType(FlatButton.ButtonType.toolBarButton);
        buttonZoomOut.setAction(ActionManager.getAction(ZoomOutAction.class));
        buttonZoomOut.setButtonType(FlatButton.ButtonType.toolBarButton);

        labelCoordinates.setPreferredSize(new Dimension(80, 16));

        labelMessage.setForeground(new Color(89, 165, 216));

        updateZoomLabel();

        add(labelCursorIcon);
        addSeparator();
        add(labelCoordinates);

        add(Box.createHorizontalGlue());

        add(labelMessage);

        add(Box.createHorizontalGlue());

        add(labelZoom);
        add(buttonZoomOut);
        add(sliderZoom);
        add(buttonZoomIn);
    }

    /**
     * Sets the x and y coordinates.
     * @param coordinates coordinates
     */
    public void setCoordinates(Point coordinates) {
        double scale = MainWindow.window.getEditor().getGraphicConfigurations().getScaleFactor();
        labelCoordinates.setText(MessageFormat.format(" {0}, {1}", Math.round(coordinates.getX() / scale), Math.round(coordinates.getY() / scale)));
    }

    /**
     * Changes the zoom value by the passed value.
     * @param value value
     */
    public void updateZoomValueBy(int value) {
        sliderZoom.setValue(sliderZoom.getValue() + value);
        updateZoomLabel();
    }

    /**
     * Sets the zoom value to the passed value.
     * @param value value
     */
    public void setZoomValue(int value) {
        sliderZoom.setValue(value);
        updateZoomLabel();
    }

    /**
     * Displays the current zoom value.
     */
    private void updateZoomLabel() {
        labelZoom.setText(MessageFormat.format("{0}% ", sliderZoom.getValue()));
    }

    /**
     * Displays a message for a short time.
     * @param message message
     */
    public void addMessage(String message) {
        messageTimer.cancel();
        messageTimer.purge();

        messageTimer = new Timer();

        labelMessage.setText(message);
        labelMessage.setForeground(getNewAlpha(labelMessage.getForeground(), 255));

        messageTimer.schedule(new MessageTimerTask(), 2000, 20);
    }

    /**
     * Returns a new color with the modified alpha value.
     * @param color color
     * @param alpha alpha
     * @return color
     */
    private Color getNewAlpha(Color color, int alpha) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }

    private class MessageTimerTask extends TimerTask {

        private final int decrement = 10;

        @Override
        public void run() {
            int alpha = labelMessage.getForeground().getAlpha() - decrement;

            labelMessage.setForeground(getNewAlpha(labelMessage.getForeground(), alpha));

            if (alpha < decrement) {
                labelMessage.setText("");

                messageTimer.cancel();
                messageTimer.purge();
            }

            repaint();
        }

    }

}
