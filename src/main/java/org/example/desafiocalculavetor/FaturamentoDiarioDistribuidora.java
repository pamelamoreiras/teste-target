package org.example.desafiocalculavetor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FaturamentoDiarioDistribuidora {

    public static void main(String[] args) {

        jsonToList();

        List<Double> listaDeValoresDeFaturamento = jsonToList();
        var maiorValorDeFaturamento = listaDeValoresDeFaturamento.get(0);
        var menorValorDeFaturamento = listaDeValoresDeFaturamento.get(0);
        var mediaDeFaturamento = 0.0;
        var somaTotalDoFaturamento = 0.0;
        var diasSemFaturamento = 0;
        var diasDeFaturamentoMaiorQueAMedia = 0;

        maiorValorDeFaturamento = calculaMaiorValorDeFaturamento(listaDeValoresDeFaturamento, maiorValorDeFaturamento);

        menorValorDeFaturamento = calculaMenorValorDeFaturamento(listaDeValoresDeFaturamento, menorValorDeFaturamento);

        diasSemFaturamento = getDiasSemFaturamento(listaDeValoresDeFaturamento, diasSemFaturamento);

        mediaDeFaturamento = calculaMediaDeFaturamento(listaDeValoresDeFaturamento, mediaDeFaturamento, somaTotalDoFaturamento, diasSemFaturamento);

        diasDeFaturamentoMaiorQueAMedia = getDiasDeFaturamentoMaiorQueAMedia(listaDeValoresDeFaturamento, mediaDeFaturamento, diasDeFaturamentoMaiorQueAMedia);

        System.out.println("O maior valor de faturamento ocorrido em um dia do mês: " + maiorValorDeFaturamento );
        System.out.println("O menor valor de faturamento ocorrido em um dia do mês: " + menorValorDeFaturamento);
        System.out.println(diasDeFaturamentoMaiorQueAMedia + " dias no mês em que o valor de faturamento diário foi superior à média mensal, já que a média mensal foi " + mediaDeFaturamento);

    }

    private static double calculaMediaDeFaturamento(List<Double> listaDeValoresDeFaturamento, double mediaDeFaturamento, double somaTotalDoFaturamento, int diasSemFaturamento) {
        for (Double valor : listaDeValoresDeFaturamento) {

            somaTotalDoFaturamento += valor;
            mediaDeFaturamento = somaTotalDoFaturamento / (listaDeValoresDeFaturamento.size() - diasSemFaturamento);
        }
        return mediaDeFaturamento;
    }

    private static int getDiasSemFaturamento(List<Double> listaDeValoresDeFaturamento, int diasSemFaturamento) {
        for (Double valor : listaDeValoresDeFaturamento) {

            if (valor == 0) {
                diasSemFaturamento++;
            }
        }
        return diasSemFaturamento;
    }

    private static int getDiasDeFaturamentoMaiorQueAMedia(List<Double> listaDeValoresDeFaturamento, double mediaDeFaturamento, int diasDeFaturamentoMaiorQueAMedia) {
        for (Double valor : listaDeValoresDeFaturamento) {
            if (valor > mediaDeFaturamento) {
                diasDeFaturamentoMaiorQueAMedia++;
            }
        }
        return diasDeFaturamentoMaiorQueAMedia;
    }

    private static Double calculaMenorValorDeFaturamento(List<Double> listaDeValoresDeFaturamento, Double menorValorDeFaturamento) {
        for (Double valor : listaDeValoresDeFaturamento) {
            if (valor < menorValorDeFaturamento && valor != 0) {
                menorValorDeFaturamento = valor;
            }
        }
        return menorValorDeFaturamento;
    }

    private static Double calculaMaiorValorDeFaturamento(List<Double> listaDeValoresDeFaturamento, Double maiorValorDeFaturamento) {
        for (Double valor : listaDeValoresDeFaturamento) {
            if (valor > maiorValorDeFaturamento) {
                maiorValorDeFaturamento = valor;
            }
        }
        return maiorValorDeFaturamento;
    }

    private static List<Double> jsonToList() {
        JSONParser parser = new JSONParser();
        List<Double> faturamentos = new ArrayList<>();

        try (FileReader reader = new FileReader("dados_faturamento.json")){

            Object obj = parser.parse(reader);
            JSONArray listaFaturamento = (JSONArray) obj;

            for (Object object : listaFaturamento) {
                JSONObject json = (JSONObject) object;
                faturamentos.add((Double) json.get("valor"));
            }

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        return faturamentos;
    }
}
