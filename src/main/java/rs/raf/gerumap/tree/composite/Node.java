package rs.raf.gerumap.tree.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Node extends BaseNode {

    private List<BaseNode> children = new ArrayList<>();

    public Node(String name, BaseNode parent) {
        super(name, parent);
    }

    public abstract void addChild(BaseNode child);

    public List<BaseNode> getChildren() {
        return children;
    }

}
