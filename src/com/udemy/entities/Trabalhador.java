package com.udemy.entities;

import com.udemy.enums.NivelTrabalhador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {

    private String nome;
    private NivelTrabalhador nivel;
    private Double salarioBase;

    private Departamento departamento;
    private List<ContratoHora> contratoList = new ArrayList<>();

    public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoHora> getcontratoList() {
        return contratoList;
    }

    public void addContrato(ContratoHora contrato) {
        contratoList.add(contrato);
    }

    public void removerContrato(ContratoHora contrato) {
        contratoList.remove(contrato);
    }

    public double ganho(int ano, int mes) {
        double soma = salarioBase;
        Calendar calendario = Calendar.getInstance();

        for (ContratoHora contrato : contratoList) {
            calendario.setTime(contrato.getData());
            int contrato_ano = calendario.get(Calendar.YEAR);
            int contrato_mes = 1 + calendario.get(Calendar.MONTH);
            if (ano == contrato_ano && mes == contrato_mes){
                soma = soma + contrato.valorTotal();
            }
        }
        return soma;
    }
}
