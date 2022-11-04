package rs.raf.gerumap.gui.model;

public enum Language {

    ENGLISH_US      ("English (United States)", "en-US"),
    SERBIAN_CYRILLIC("Serbian (Cyrillic)"     , "sr-Cyrl-RS"),
    SERBIAN_LATIN   ("Serbian (Latin)"        , "sr-Latn-RS");

    String name;
    String id;

    Language(String name, String id) {
        this.name = name;
        this.id   = id;
    }

    public static Language getLanguage(String languageId) {
        for (Language language : Language.values())
            if (language.getId().equals(languageId))
                return language;

        System.err.println("Language not found: " + languageId);

        return ENGLISH_US;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
