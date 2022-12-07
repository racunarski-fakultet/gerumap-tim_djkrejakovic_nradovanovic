package rs.raf.gerumap.gui.swing.view.user.model;

/**
 * Stores user data.
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    /**
     * Sets a name for the user.
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the user.
     * @return name
     */
    public String getName() {
        return name;
    }

}
