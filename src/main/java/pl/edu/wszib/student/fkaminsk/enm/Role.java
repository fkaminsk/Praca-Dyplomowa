package pl.edu.wszib.student.fkaminsk.enm;



public enum Role {
    REGULAR("regular"),
    ADMIN("admin");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
