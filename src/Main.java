import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExchangeRateClient client = new ExchangeRateClient();
        String jsonResponse = client.getExchangeRates();

        if (jsonResponse == null) {
            System.out.println("No se pudieron obtener los datos de cambio.");
            return;
        }

        ExchangeRateResponse rates = ExchangeRateResponse.fromJson(jsonResponse);
        if (rates == null || !"success".equalsIgnoreCase(rates.getResult())) {
            System.out.println("Hubo un problema al obtener o parsear los datos de la API.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("**************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("**************************************************");
            System.out.println("1) Dólar => Peso mexicano");
            System.out.println("2) Peso mexicano => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida, intente de nuevo.");
                continue;
            }

            double cantidad, resultado;

            switch(opcion) {
                case 1:
                    System.out.print("Ingrese cantidad en Dólar: ");
                    cantidad = Double.parseDouble(scanner.nextLine());
                    resultado = CurrencyConverter.convert(cantidad, "USD", "MXN", rates);
                    System.out.printf("%.2f USD equivalen a %.2f MXN\n", cantidad, resultado);
                    break;
                case 2:
                    System.out.print("Ingrese cantidad en Peso Mexicano: ");
                    cantidad = Double.parseDouble(scanner.nextLine());
                    resultado = CurrencyConverter.convert(cantidad, "MXN", "USD", rates);
                    System.out.printf("%.2f MXN equivalen a %.2f USD\n", cantidad, resultado);
                    break;
                case 3:
                    System.out.print("Ingrese cantidad en Dólar: ");
                    cantidad = Double.parseDouble(scanner.nextLine());
                    resultado = CurrencyConverter.convert(cantidad, "USD", "BRL", rates);
                    System.out.printf("%.2f USD equivalen a %.2f BRL\n", cantidad, resultado);
                    break;
                case 4:
                    System.out.print("Ingrese cantidad en Real brasileño: ");
                    cantidad = Double.parseDouble(scanner.nextLine());
                    resultado = CurrencyConverter.convert(cantidad, "BRL", "USD", rates);
                    System.out.printf("%.2f BRL equivalen a %.2f USD\n", cantidad, resultado);
                    break;
                case 5:
                    System.out.print("Ingrese cantidad en Dólar: ");
                    cantidad = Double.parseDouble(scanner.nextLine());
                    resultado = CurrencyConverter.convert(cantidad, "USD", "COP", rates);
                    System.out.printf("%.2f USD equivalen a %.2f COP\n", cantidad, resultado);
                    break;
                case 6:
                    System.out.print("Ingrese cantidad en Peso colombiano: ");
                    cantidad = Double.parseDouble(scanner.nextLine());
                    resultado = CurrencyConverter.convert(cantidad, "COP", "USD", rates);
                    System.out.printf("%.2f COP equivalen a %.2f USD\n", cantidad, resultado);
                    break;
                case 7:
                    System.out.println("Saliendo... ¡Gracias por usar el conversor!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}