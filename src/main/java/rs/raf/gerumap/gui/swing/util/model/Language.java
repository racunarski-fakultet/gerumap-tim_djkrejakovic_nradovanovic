package rs.raf.gerumap.gui.swing.util.model;

/**
 * Display language type
 */
public enum Language {

    /**
     * Language: English | Region: United States
     */
    ENGLISH_US      ("English (United States)", "en-US"),
    /**
     * Language: Serbian | Region: Republic of Serbia | Type: Cyrillic
     */
    SERBIAN_CYRILLIC("Serbian (Cyrillic)"     , "sr-Cyrl-RS"),
    /**
     * Language: Serbian | Region: Republic of Serbia | Type: Latin
     */
    SERBIAN_LATIN   ("Serbian (Latin)"        , "sr-Latn-RS");

    String name;
    String id;

    Language(String name, String id) {
        this.name = name;
        this.id   = id;
    }

    /**
     * Returns Language based on identifier.
     * @param languageId language id
     * @return language
     */
    public static Language getLanguage(String languageId) {
        for (Language language : Language.values())
            if (language.getId().equals(languageId))
                return language;

        System.err.println("Language not found: " + languageId);

        return ENGLISH_US;
    }

    /**
     * Returns the language display name.
     * @return language name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the language identifier.
     * @return language id
     */
    public String getId() {
        return id;
    }

}
