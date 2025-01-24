package br.com.rodrigocarvalho.service_register.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String instagram;

    @OneToMany
    private List<Atendimento> atendimentos = new ArrayList<Atendimento>();

    public Cliente(String nome, String telefone, String instagram){
        this.nome = nome;
        this.telefone = telefone;
        this.instagram = instagram;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void adicionarAtendimento(Atendimento atendimento){
        atendimentos.add(atendimento);
    }

    public void removerAtendimento(Atendimento atendimento){
        atendimentos.removeIf(a -> a.getId() == atendimento.getId());
    }
}
