package design_patterns.b_structural.adapter.example01;

import design_patterns.b_structural.adapter.example01.a.OracleUser;
import design_patterns.b_structural.adapter.example01.a.User;
import design_patterns.b_structural.adapter.example01.b.LdapAdapter;
import design_patterns.b_structural.adapter.example01.b.LdapUser;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = getUsersFromOracleDb();

        LdapUser ldapUser = new LdapUser("ppet1010", "Petkova", "Petya", "petya.petkova@mail.schwarz");

        users.add(new LdapAdapter(ldapUser));

        System.out.println(users);
    }

    private static List<User> getUsersFromOracleDb() {
        return new ArrayList<>() {
            {
                add(new OracleUser("sste1606", "Stefan", "Stefanov", "stefan.stefanov@mail.schwarz"));
                add(new OracleUser("mkru1006", "Martin", "Krumov", "martin.krumov@mail.schwarz"));
            }
        };
    }

}
