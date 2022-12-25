package rs.raf.gerumap.gui.swing.util;

import com.google.gson.GsonBuilder;
import rs.raf.gerumap.gui.swing.controller.adapters.ProjectAdapterFactory;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    /**
     * Returns true if the file has the given extension, false otherwise.
     * @param file file
     * @param extension extension
     * @return true if it has given extension, false otherwise
     */
    public static boolean isFileExtension(File file, String extension) {
        return getFileExtension(file.getName()).toLowerCase().equals(extension.toLowerCase());
    }

    /**
     * Returns the file extension if it exists, otherwise an empty string.
     * @param fileName file name
     * @return extension
     */
    public static String getFileExtension(String fileName) {
        int pointIndex = fileName.lastIndexOf('.') + 1;

        if (pointIndex == 0 || pointIndex == fileName.length())
            return "";

        return fileName.substring(pointIndex, fileName.length());
    }

    /**
     * Saves the project to a file.
     * @param editorProject project
     */
    public static void saveToProjectFile(EditorProject editorProject) {
        if (editorProject.getProject().getFileLocation() == null)
            return; //NOTE: Error

        try {
            FileWriter fileWriter = new FileWriter(editorProject.getProject().getFileLocation(), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write(new GsonBuilder().setPrettyPrinting()
                                          .serializeNulls()
                                          .registerTypeAdapterFactory(new ProjectAdapterFactory())
                                          .create()
                                          .toJson(editorProject)
                        );

            writer.close();
            fileWriter.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Loads a project file.
     * @param file file
     * @return project
     */
    public static EditorProject loadFromProjectFile(File file) {
        if (file == null)
            return null; //NOTE: no file is selected

        EditorProject editorProject = null;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            editorProject =  new GsonBuilder().setPrettyPrinting()
                                              .serializeNulls()
                                              .registerTypeAdapterFactory(new ProjectAdapterFactory())
                                              .create()
                                              .fromJson(reader, EditorProject.class);

            editorProject.getProject().setFileLocation(file.getAbsolutePath());

            reader.close();
            fileReader.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        return editorProject;
    }

    /**
     * Saves the mind map to a file as a template.
     * @param editorPage mind map page
     */
    public static void saveToMindMapFile(EditorPage editorPage) {
        if (editorPage.getMindMap().getFileLocation() == null)
            return; //NOTE: Error

        try {
            FileWriter fileWriter = new FileWriter(editorPage.getMindMap().getFileLocation(), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write(new GsonBuilder().setPrettyPrinting()
                                          .serializeNulls()
                                          .registerTypeAdapterFactory(new ProjectAdapterFactory())
                                          .create()
                                          .toJson(editorPage)
                        );

            writer.close();
            fileWriter.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Loads a mind map file.
     * @param file file
     * @return mind map page
     */
    public static EditorPage loadFromMindMapFile(File file) {
        if (file == null)
            return null; //NOTE: no file is selected

        EditorPage editorPage = null;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            editorPage =  new GsonBuilder().setPrettyPrinting()
                                           .serializeNulls()
                                           .registerTypeAdapterFactory(new ProjectAdapterFactory())
                                           .create()
                                           .fromJson(reader, EditorPage.class);
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return editorPage;
    }

    /**
     * Appends an extension to the file if the file does not have one.
     * @param file file
     * @param extension extension
     */
    public static void appendExtension(File file, String extension) {
        if (file == null)
            return;

        if(!isFileExtension(file, extension))
            file.renameTo(new File(file.getAbsolutePath() + '.' + extension));
    }

}
