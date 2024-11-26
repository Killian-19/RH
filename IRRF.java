package RH.FolhaDePagamento;

public class IRRF {
    public static float calcularIRRF(float sal, float descontoPrevidencia, int numeroDependentes) {
        float valorPorDependente = 189.59f;
        
        float baseCalculo = sal - descontoPrevidencia - (numeroDependentes * valorPorDependente);

        // Faixas do IRRF (2024)
        if (baseCalculo <= 2112.00f){
            return 0.0f;
        } else if (baseCalculo <= 2826.65f){
            return (baseCalculo * 0.075f) - 158.40f; // 7,5% com dedução de R$158,40
        } else if (baseCalculo <= 3751.05f){
            return (baseCalculo * 0.15f) - 370.40f; // 15% com dedução de R$370,40
        } else if (baseCalculo <= 4664.68f){
            return (baseCalculo * 0.225f) - 651.73f; // 22,5% com dedução de R$651,73
        } else {
            return (baseCalculo * 0.275f) - 884.96f; // 27,5% com dedução de R$884,96
        }
    }
}