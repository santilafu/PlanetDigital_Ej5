package org.planetdigital;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idempresa;

    @Column(name = "nombreempresa")
    private String nombreEmpresa;

    @Column(name = "pais")
    private String pais;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<PersonaContacto> contactos = new ArrayList<>();

    public Empresa() {}

    public Empresa(String nombreEmpresa, String pais) {
        this.nombreEmpresa = nombreEmpresa;
        this.pais = pais;
    }

    public void addContacto(PersonaContacto pc) {
        contactos.add(pc);
        pc.setEmpresa(this);
    }

    @Override
    public String toString() {
        return "Empresa{id=" + idempresa +
                ", nombre='" + nombreEmpresa + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    // Getters y setters
    public int getIdempresa() {
        return idempresa;
    }
    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

}
