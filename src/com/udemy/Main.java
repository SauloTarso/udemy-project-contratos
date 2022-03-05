package com.udemy;

import com.udemy.entities.ContratoHora;
import com.udemy.entities.Departamento;
import com.udemy.entities.Trabalhador;
import com.udemy.enums.NivelTrabalhador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.print("Nome do departamento: ");
        String departamento = sc.nextLine();
        System.out.println("Dados do trabalhador:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Nivel: ");
        String nivel = sc.nextLine();
        System.out.print("Salário base: ");
        Double salarioBase = sc.nextDouble();
        Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase, new Departamento(departamento));

        System.out.print("Quantos contratos para este trabalhador? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Insira os dados do #" + i + " contrato");
            System.out.print("Data (DD/MM/AAAA): ");
            Date contratoData = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();
            System.out.print("Duração (horas): ");
            int horas = sc.nextInt();

            ContratoHora contratos = new ContratoHora(valorPorHora, horas, contratoData);
            trabalhador.addContrato(contratos);
        }

        System.out.println();
        System.out.print("Insira o mês e o ano para calcular a renda (MM/AAAA): ");
        String mesAno = sc.next();

        int mes = Integer.parseInt(mesAno.substring(0, 2));
        int ano = Integer.parseInt(mesAno.substring(3));
        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        System.out.println("Ganho de " + mesAno + ": " + String.format("%.2f", trabalhador.ganho(ano, mes)));
    }
}
