package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConnection;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorDiagram;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Element;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.MindMap;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Project;

import java.awt.Color;

public class ProjectAdapterFactory implements TypeAdapterFactory {

    @Override
    @SuppressWarnings("unchecked")
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (EditorDiagram.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new EditorDiagramAdapter(gson);

        if (EditorElement.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new EditorElementAdapter(gson);

        if (EditorPage.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new EditorPageAdapter(gson);

        if (EditorProject.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new EditorProjectAdapter(gson);

        if (GraphicConcept.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new GraphicConceptAdapter(gson);

        if (GraphicConnection.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new GraphicConnectionAdapter(gson);

        if (Element.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new NodeElementAdapter(gson);

        if (MindMap.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new NodeMindMapAdapter(gson);

        if (Project.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new NodeProjectAdapter(gson);

        if (Color.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new ColorAdapter(gson);

        if (String.class.isAssignableFrom(typeToken.getRawType()))
            return (TypeAdapter<T>) new StringAdapter(gson);

        return null;
    }

}
