package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.util.ArrayList;
import java.util.List;

public class GraphicUtils {

    public static List<GraphicConnection> getGraphicConnectionsFrom(List<GraphicElement> graphicElements) {
        List<GraphicConnection> graphicConnections = new ArrayList<>();

        for (GraphicElement graphicElement : graphicElements)
            if (graphicElement instanceof  GraphicConnection graphicConnection)
                graphicConnections.add(graphicConnection);


        return graphicConnections;
    }

    public static List<GraphicConcept> getGraphicConceptsFrom(List<GraphicElement> graphicElements) {
        List<GraphicConcept> graphicConcepts = new ArrayList<>();

        for (GraphicElement graphicElement : graphicElements)
            if (graphicElement instanceof GraphicConcept graphicConcept)
                graphicConcepts.add(graphicConcept);

        return graphicConcepts;
    }

}
