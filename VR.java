package RH.FolhaDePagamento;

public class VR {
    public static float calcularVR(float sal, float porcentagemDesconto, float valorFixoMensal) {
        float descontoPorcentagem = sal * (porcentagemDesconto / 100);
        return Math.min(descontoPorcentagem, valorFixoMensal);
    }
}