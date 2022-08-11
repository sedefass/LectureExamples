package design_patterns.b_structural.adapter.example01.b;

import design_patterns.b_structural.adapter.example01.a.User;

public class LdapAdapter implements User {

    LdapUser ldapUser;

    public LdapAdapter(LdapUser ldapUser) {
        this.ldapUser = ldapUser;
    }

    @Override
    public String getId() {
        return ldapUser.getCn();
    }

    @Override
    public String getFirstName() {
        return ldapUser.getGivenName();
    }

    @Override
    public String getLastName() {
        return ldapUser.getSurname();
    }

    @Override
    public String getEmail() {
        return ldapUser.getMail();
    }

    @Override
    public String toString() {
        return ldapUser.getCn();
    }
}
