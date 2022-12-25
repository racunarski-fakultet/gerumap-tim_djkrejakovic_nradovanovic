package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.controller.CommandManager;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorFocusMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Element;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.MindMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class EditorPage extends JPanel implements IEditorComponent {

    private static final IEditor editor = MainWindow.window.getEditor();

    private final CommandManager commandManager = new CommandManager();

    private final MindMap mindMap;

    private final EditorDiagram diagram;

    private final JPanel diagramContainer = new JPanel(new GridBagLayout());

    private final JScrollPane scrollPane = new JScrollPane();

    private final EditorStatusBar statusBar = new EditorStatusBar();

    private boolean isOpen = false;

    private final List<EditorElement> elements = new ArrayList<>();

    public EditorPage(MindMap mindMap) {
        this(mindMap, new EditorDiagram());
    }

    /**
     * Creates a mindmap document.
     * @param mindMap mind map
     * @param diagram diagram
     */
    public EditorPage(MindMap mindMap, EditorDiagram diagram) {
        super(new BorderLayout());

        this.mindMap = mindMap;
        this.diagram = diagram;

        initialize();
        addListeners();
    }

    /**
     * Initializes components.
     */
    private void initialize() {
        diagramContainer.setBackground(new Color(66, 69, 72));
        diagramContainer.setPreferredSize(new Dimension(diagram.getScaledWidth() + 200, diagram.getScaledHeight() + 200));
        diagramContainer.add(this.diagram);

        scrollPane.getVerticalScrollBar().setUnitIncrement(12);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(12);
        scrollPane.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(52, 53, 54)));
        scrollPane.setViewportView(diagramContainer);

        add(scrollPane, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    /**
     * Assigns listeners to components.
     */
    private void addListeners() {
        diagramContainer.addMouseListener(new EditorFocusMouseListener());
    }

    @Override
    public void load() {
        if (!editor.getActiveProject().contains(this))
            editor.setActiveProject((EditorProject) MainWindow.window.getExplorer().getComponent(mindMap.getParent()));

        editor.setActivePage(editor.getActiveProject().getPage(this.getMindMap()));
    }

    @Override
    public void rename(String oldName) {
        if (!isOpen)
            return;

        editor.renameTab(getTitle(), oldName);
    }

    /**
     * Adds an editor element.
     * @param element element
     */
    public void addElement(EditorElement element) {
        if (!elements.contains(element))
            elements.add(element);

        element.load();
    }

    /**
     * Sets whether the page is open.
     * @param open open state
     */
    public void setOpen(boolean open) {
        isOpen = open;
    }

    /**
     * Removes an editor element.
     * @param element element
     */
    public void removeElement(EditorElement element) {
        if (element == null)
            return;

        elements.remove(element);
        editor.render();
    }

    /**
     * Removes an editor element.
     * @param element element
     */
    public void removeElement(Element element) {
        removeElement(getEditorElement(element));
    }

    /**
     * Returns the editor element.
     * @param element element
     * @return editor element
     */
    public EditorElement getEditorElement(Element element) {
        for (EditorElement editorElement : elements)
            if (editorElement.getGraphicElement().equals(element))
                return editorElement;

        return null;
    }

    public GraphicElement getGraphicElement(UUID identifier) {
        for (EditorElement editorElement : elements)
            if (editorElement.getGraphicElement().getIdentifier().equals(identifier))
                return editorElement.getGraphicElement();

        return null;
    }

    /**
     * Returns the last added editor element.
     * @return editor element
     */
    public EditorElement getLastEditorElement() {
        return elements.get(elements.size() - 1);
    }

    /**
     * Returns the editor elements.
     * @return editor elements
     */
    public List<EditorElement> getEditorElements() {
        return elements;
    }

    /**
     * Generates new identifiers for this component and all descendants.
     */
    public void generateNewIdentifiers() {
        mindMap.generateNewIdentifier();

        for (EditorElement element : elements)
            element.generateNewIdentifiers();
    }

    /**
     * Updates the container dimensions.
     */
    public void updateContainerDimensions() {
        diagramContainer.setPreferredSize(new Dimension(diagram.getScaledWidth() + 200, diagram.getScaledHeight() + 200));
    }

    /**
     * Returns whether the page is open.
     * @return true if open, otherwise false
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Returns the page diagram.
     * @return diagram.
     */
    public EditorDiagram getDiagram() {
        return diagram;
    }

    /**
     * Returns the page status bar.
     * @return status bar
     */
    public EditorStatusBar getStatusBar() {
        return statusBar;
    }

    /**
     * Returns the page command manager.
     * @return command manager
     */
    public CommandManager getCommandManager() {
        return commandManager;
    }

    /**
     * Returns the mind map associated with this page.
     * @return mind map
     */
    public MindMap getMindMap() {
        return mindMap;
    }

    /**
     * Returns the title of the page.
     * @return title
     */
    public String getTitle() {
        return mindMap.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EditorPage page))
            return false;

        return Objects.equals(page.mindMap, this.mindMap);
    }

}
