package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import rs.raf.gerumap.gui.swing.view.MainWindow;

public class GraphicConfigurations {

    public static final int DEFAULT_ZOOM_PERCENT = 100;
    public static final int MAX_ZOOM_PERCENT     = 400;
    public static final int MIN_ZOOM_PERCENT     = 25;

    public static final double DEFAULT_SCALE_FACTOR = DEFAULT_ZOOM_PERCENT / 100.0;
    public static final double MAX_SCALE_FACTOR     = MAX_ZOOM_PERCENT     / 100.0;
    public static final double MIN_SCALE_FACTOR     = MIN_ZOOM_PERCENT     / 100.0;

    private GraphicConfigurations savedConfigurations = null;

    private double scaleFactor;

    public GraphicConfigurations() {
        resetConfigurations();
    }

    /**
     * Sets the scale factor for all graphic elements.<br>
     * <ul>
     *     <li>The default value is {@value #DEFAULT_SCALE_FACTOR} and represents a zoom of {@value #DEFAULT_ZOOM_PERCENT}%</li>
     *     <li>The highest allowed value for the scale factor is {@value #MAX_SCALE_FACTOR} and represents a zoom of {@value #MAX_ZOOM_PERCENT}%</li>
     *     <li>The smallest allowed value for the scale factor is {@value #MIN_SCALE_FACTOR} and represents a zoom of {@value #MIN_ZOOM_PERCENT}%</li>
     * </ul>
     * @param scale scale factor
     */
    public void setScaleFactor(double scale) {
        if (scale == scaleFactor)
            return;

        scale = Math.min(scale, MAX_SCALE_FACTOR);
        scale = Math.max(scale, MIN_SCALE_FACTOR);

        scaleFactor = scale;

        updateConfigurators();
    }

    /**
     * Updates the graphic configurators.
     */
    public void updateConfigurators() {
        MainWindow.window.getEditor().getStatusBar().setZoomValue((int) (scaleFactor * 100));
        MainWindow.window.getEditor().getDiagram().updateScaledSize();
    }

    /**
     * Returns the scale factor.
     * @return scale factor
     */
    public double getScaleFactor() {
        return scaleFactor;
    }

    /**
     * Saves the current graphic configurations.
     */
    public void saveConfigurations() {
        savedConfigurations = new GraphicConfigurations();

        savedConfigurations.scaleFactor = scaleFactor;
    }

    /**
     * Restores the saved graphic configurations.
     */
    public void restoreConfigurations() {
        scaleFactor =  savedConfigurations.scaleFactor;

        savedConfigurations = null;
    }

    /**
     * Resets graphics configurations to default values.
     */
    public void resetConfigurations() {
        scaleFactor = DEFAULT_SCALE_FACTOR;
    }

}
