package rs.raf.gerumap.gui.swing.util.model;

public enum GFont {

    MONTSERRAT_REGULAR   ("Montserrat-Regular"  ),
    MONTSERRAT_MEDIUM    ("Montserrat-Medium"   ),
    MONTSERRAT_SEMI_BOLD ("Montserrat-SemiBold" ),
    MONTSERRAT_BOLD      ("Montserrat-Bold"     ),
    MONTSERRAT_EXTRA_BOLD("Montserrat-ExtraBold"),
    MONTSERRAT_BLACK     ("Montserrat-Black"    );

    private String name;

    GFont(String name) {
        this.name = name;
    }

    /**
     * Returns a font name.
     * @return name
     */
    public String getName() {
        return name;
    }

}
