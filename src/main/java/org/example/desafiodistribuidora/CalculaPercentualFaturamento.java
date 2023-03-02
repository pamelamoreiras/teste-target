package org.example.desafiodistribuidora;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CalculaPercentualFaturamento {

    public static void main(String[] args) {

        calculaPercent();
    }

    private static void calculaPercent() {
        List<String> estados = List.of("SP", "RJ", "MG", "ES", "Outros");
        List<Double> faturamentos = List.of(67836.43, 36678.66, 29229.88, 27165.48, 19849.53);

        Map<String, Double> relacaoEstadoFaturamento = new LinkedHashMap<>();

        var faturamentoTotal = 0.0;
        var percentual = 0.0;

        faturamentoTotal = somaDoFaturamentoTotal(faturamentos, faturamentoTotal);

        for (int i = 0; i < faturamentos.size(); i++) {
            percentual = (faturamentos.get(i) * 100) / faturamentoTotal;
            relacaoEstadoFaturamento.put(estados.get(i), percentual);
        }

        System.out.println(relacaoEstadoFaturamento);
    }

    private static double somaDoFaturamentoTotal(List<Double> faturamentos, double faturamentoTotal) {
        for (Double faturamento : faturamentos) {
            faturamentoTotal += faturamento;
        }
        return faturamentoTotal;
    }
}
