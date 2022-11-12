package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class ExplorerModel extends DefaultTreeModel {

    public ExplorerModel(TreeNode root) {
        super(root); //TODO Error message - root has to be of type ProjectRoot
    }

}
