public class User {

    String vardas;
    String pavarde;
    String telefonoNumeris;
    String email;
    String adresas;
    String slaptazodis;

    public User(String vardas, String pavarde, String telefonoNumeris, String email, String adresas, String slaptazodis) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.telefonoNumeris = telefonoNumeris;
        this.email = email;
        this.adresas = adresas;
        this.slaptazodis = slaptazodis;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getTelefonoNumeris() {
        return telefonoNumeris;
    }

    public void setTelefonoNumeris(String telefonoNumeris) {
        this.telefonoNumeris = telefonoNumeris;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }
}
