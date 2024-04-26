import java.io.IOException;
import java.util.Scanner;

public class MoneyMorpherApp {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        ConsultaApi consultaApi = new ConsultaApi();
        Moeda novaMoeda = consultaApi.buscaMoeda("usd");

        System.out.println("Bem-vindo ao Conversor de Moedas!");

        while (continuar) {
            System.out.println("Escolha a moeda de origem:");
            System.out.println("1 - Dólar para real");
            System.out.println("2 - Real para dólar");
            System.out.println("3 - Euro para real");
            System.out.println("4 - Real para euro");
            System.out.println("5 - Libras para real");
            System.out.println("6 - Dólar canadense para real");
            System.out.println("7 - Real para Peso argentino");
            System.out.println("0 - Sair do programa");
            System.out.print("Digite sua opção: ");

            int opcaoOrigem = scanner.nextInt();
            if (opcaoOrigem == 0) {
                continuar = false;
                continue;
            }



            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();
            if (valor < 0) {
                System.out.println("INSIRA UM VALOR POSITIVO");
            }

            double resultado = 0;

            switch (opcaoOrigem) {
                case 1:
                    novaMoeda = consultaApi.buscaMoeda("USD");
                    resultado = valor * novaMoeda.conversionRates().get("BRL"); // Dólar para Real
                    System.out.println("Valor em Real: " + String.format("%.2f", resultado));
                    break;
                case 2:
                    novaMoeda = consultaApi.buscaMoeda("BRL");
                    resultado = valor * novaMoeda.conversion_rates().get("USD"); // Real para Dólar
                    System.out.println("Valor em Dólar: " + String.format("%.2f", resultado));
                    break;
                case 3:
                    novaMoeda = consultaApi.buscaMoeda("EUR");
                    resultado = valor * novaMoeda.conversion_rates().get("BRL"); // Euro para Real
                    System.out.println("Valor em Dólar: " + String.format("%.2f", resultado));
                    break;
                case 4:
                    novaMoeda = consultaApi.buscaMoeda("BRL");
                    resultado = valor * novaMoeda.conversion_rates().get("EUR");  // Real para Euro
                    System.out.println("Valor em Real: " + String.format("%.2f", resultado));
                    break;
                case 5:
                    novaMoeda = consultaApi.buscaMoeda("GBP");
                    resultado = valor * novaMoeda.conversion_rates().get("BRL"); // Libras para Real
                    System.out.println("Valor em Real: " + String.format("%.2f", resultado));
                    break;
                case 6:
                    novaMoeda = consultaApi.buscaMoeda("CAD");
                    resultado = valor * novaMoeda.conversion_rates().get("BRL"); // Dólar canadense para Real (valor hipotético)
                    System.out.println("Valor em Real: " + String.format("%.2f", resultado));
                    break;
                case 7:
                    novaMoeda = consultaApi.buscaMoeda("BRL");
                    resultado = valor * novaMoeda.conversion_rates().get("ARS"); // Real para Peso argentino
                    System.out.println("Valor em Real: " + String.format("%.2f", resultado));
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println("Obrigado por utilizar o Conversor de Moedas!");
            System.out.println("---------------------------------------------");
        }




        System.out.println("-------Encerrado-------");
        System.out.println("Taxa de câmbio atual:");
        System.out.println("ARS - Peso argentino: " + novaMoeda.conversionRates().get("ARS"));
        System.out.println("BRL - Real brasileiro: " + novaMoeda.conversionRates().get("BRL"));
        System.out.println("CAD - Dólar canadense: " + novaMoeda.conversionRates().get("CAD"));
        System.out.println("EUR - Euro: " + novaMoeda.conversionRates().get("EUR"));
        System.out.println("GBP - Libra Esterlina(UK): " + novaMoeda.conversionRates().get("GBP"));
        System.out.println("USD - Dólar americano: " + novaMoeda.conversionRates().get("USD"));

    }


}
