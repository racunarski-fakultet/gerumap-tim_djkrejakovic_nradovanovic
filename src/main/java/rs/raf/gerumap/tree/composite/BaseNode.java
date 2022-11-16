package rs.raf.gerumap.tree.composite;

import java.util.Objects;

public abstract class BaseNode {

    String name;

    BaseNode parent;

    public BaseNode(String name, BaseNode parent) {
        this.name   = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object object) { //TODO compare parents
        if (object == null || !(object instanceof BaseNode))
            return false;

        BaseNode component = (BaseNode) object;
        return Objects.equals(component.getName(), this.getName());
    }

    @Override
    public String toString() {
        return getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(BaseNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public BaseNode getParent() {
        return parent;
    }

}
