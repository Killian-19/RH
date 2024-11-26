package RH.FolhaDePagamento;

public class INSS {

    public static float calcularINSS(float sal) {
        float desconto;

        // Faixa 1: até R$1.412,00
        // 7,5% para salários até R$ 1.412,00
        if (sal <= 1412.00f) {
            desconto = sal * 0.075f;
        }
        // Faixa 2: de R$1.412,01 até R$2.666,68
        // 9% com dedução de R$ 21,18
        else if (sal <= 2666.68f) {
            desconto = (1412.00f * 0.075f) + ((sal - 1412.00f) * 0.09f) - 21.18f;
        }
        // Faixa 3: de R$2.666,69 até R$4.000,03
        // 12% com dedução de R$ 101,18
        else if (sal <= 4000.03f) {
            desconto = (1412.00f * 0.075f) + (1254.68f * 0.09f) + ((sal - 2666.68f) * 0.12f) - 101.18f;
        }
        // Faixa 4: de R$4.000,04 até R$7.786,02
        // 14% com dedução de R$ 181,18
        else if (sal <= 7786.02f) {
            desconto = (1412.00f * 0.075f) + (1254.68f * 0.09f) + (1333.35f * 0.12f) + ((sal - 4000.03f) * 0.14f) - 181.18f;
        }
        // Acima de R$7.786,02: Teto máximo de desconto
        else {
            desconto = 876.97f;
        }

        // Garantir que o desconto não seja negativo
        return Math.max(desconto, 0);
    }
}
