package Entidades;

public class Usuario {

    private Integer id;
    private String name;
    private String addres;
    private String password;
    private Integer telefono;
    private String email;

    public Usuario(Integer id, String name, String addres, String password, Integer telefono, String email) {
        this.id = id;
        this.name = name;
        this.addres = addres;
        this.password = password;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddres() {
        return addres;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

