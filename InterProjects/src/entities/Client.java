package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    public static SimpleDateFormat sdfb = new SimpleDateFormat("dd/MM/yyyy");
    private String name;
    private String email;
    private Date birthDate;

    public Client(String name, String email, Date birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Client: " + getName()  + " ("+sdfb.format(getBirthDate())+") " + " - " + getEmail();
    }
}
