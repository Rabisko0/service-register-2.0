package br.com.rodrigocarvalho.service_register.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "atendimetos")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Profissional profissional;

    @OneToMany
    private List<Procedimento> procedimentos = new ArrayList<Procedimento>();

    private LocalDateTime dataAtendimento;
    private String observacao;

    public Atendimento(Cliente cliente, Profissional profissional, LocalDateTime dataAtendimento, String observacao){
        this.cliente = cliente;
        this.profissional = profissional;
        this.dataAtendimento = dataAtendimento;
        this.observacao = observacao;

    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public void adiconarProcedimento(Procedimento procedimento){
        procedimentos.add(procedimento);
    }

    public void removerProcedimento(Procedimento procedimento){
        procedimentos.removeIf(a -> a.getId() == procedimento.getId());
    }

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
