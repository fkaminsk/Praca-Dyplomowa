package pl.edu.wszib.student.fkaminsk.enm;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_REGULAR("ROLE_REGULAR"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    @Override
    public String getAuthority() {
        return getDisplayName();
    }
}
