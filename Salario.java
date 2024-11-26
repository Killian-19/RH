package RH.FolhaDePagamento;

import java.util.Scanner;

public class Salario {
    public static void main(String[] args) {
        float sal, valorTarifa, porcentagemDesconto, valorFixoMensal;
        int viagensDiarias, diasTrabalhados, numeroDependentes;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Salário? R$");
            sal = scanner.nextFloat();
            System.out.print("Número dee dependentes? ");
            numeroDependentes = scanner.nextInt();
            System.out.print("Valor da tarifa de transporte? R$");
            valorTarifa = scanner.nextFloat();
            System.out.print("Número de viagens diárias? ");
            viagensDiarias = scanner.nextInt();
            System.out.print("Dias úteis trabalhados no mês? ");
            diasTrabalhados = scanner.nextInt();
            System.out.print("Valor fixo mensal máximo para VR? R$");
            valorFixoMensal = scanner.nextFloat();
            System.out.print("Qual a porcentagem do vale refeição? ");
            porcentagemDesconto = scanner.nextFloat();
        }
        System.out.println(" ");
        System.out.printf("O salário do funcionário é R$%.2f \n", sal);

        float descontoINSS = RH.FolhaDePagamento.INSS.calcularINSS(sal);
        System.out.printf("O desconto do INSS é R$%.2f \n", descontoINSS);

        float descontoIRRF = RH.FolhaDePagamento.IRRF.calcularIRRF(sal, descontoINSS, numeroDependentes);
        System.out.printf("O desconto do IRRF é R$%.2f \n", descontoIRRF);
        
        float descontoVT = RH.FolhaDePagamento.VT.calcularVT(sal, valorTarifa, viagensDiarias, diasTrabalhados);
        float valeTransporte = VT.calcularVT(sal, valorTarifa, viagensDiarias, diasTrabalhados);
        System.out.printf("O valor do VT a ser descontado é: R$%.2f \n", valeTransporte);
        
        float valeRefeicao = RH.FolhaDePagamento.VR.calcularVR(sal, porcentagemDesconto, valorFixoMensal); 
        System.out.printf("O valor do Vale Refeição a ser descontado é: R$%.2f \n", valeRefeicao);

        float salarioLiquido = sal - descontoINSS - descontoIRRF - descontoVT - valeRefeicao;
        System.out.printf("O salário líquido é R$%.2f \n", salarioLiquido);
    }
}