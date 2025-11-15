package org.planetdigital;

import jakarta.persistence.*;

@Entity
@Table(name = "personacontacto")
public class PersonaContacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcontacto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    public PersonaContacto() {}

    public PersonaContacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "PersonaContacto{id=" + idcontacto +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    // Getters y setters
    public int getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(int idcontacto) {
        this.idcontacto = idcontacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
}
