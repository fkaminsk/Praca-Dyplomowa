package pl.edu.wszib.student.fkaminsk.enm;

public enum Category {
    GUITARS("guitars"),
    DRUMS("drums"),
    BASSGUITARS("basguitars"),
    VIOLINS("violins"),
    AMPS("amps"),
    SPEAKERS("speakers");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
