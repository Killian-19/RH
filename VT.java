package RH.FolhaDePagamento;

public class VT {
    public static float calcularVT(float sal, float valorTarifa, int viagensDiarias, int diasTrabalhados) {
        float custoTransporte = valorTarifa * viagensDiarias * diasTrabalhados;
        float descontoMaximo = sal * 0.06f;
        return Math.min(custoTransporte, descontoMaximo);
    }
}