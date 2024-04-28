package views;

import clients.ExchangeRateClient;
import controllers.ExchangeRateController;
import enums.PairConversion;
import exceptions.HttpRequestFailedException;
import services.ExchangeRateConversionService;

import java.io.IOException;
import java.util.Scanner;

public class ExchangesMenuView {
    private final int exitOption;

    public ExchangesMenuView() {
        this.exitOption = PairConversion.values().length + 1;
    }

    private void showMenu() {
        System.out.println("*****************************");
        System.out.println("Bienvenido(a) al conversor de monedas de antoncocox");
        for (PairConversion pairConversionOption : PairConversion.values()) {
            int numberOfPairConversion = pairConversionOption.ordinal();
            System.out.println(
                    (++numberOfPairConversion)
                             + ") "
                             + pairConversionOption.getCoinBase().getCoinName()
                             + " => "
                             + pairConversionOption.getCoinTarget().getCoinName()
            );
        }
        System.out.println((this.exitOption) + ") Salir");
    }

    public void executeConversionUI() {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateController controller = new ExchangeRateController(
                new ExchangeRateClient(),
                new ExchangeRateConversionService()
        );
        int menuOption = 0, amountToConvert;
        do {
            this.showMenu();
            try {
                System.out.println("Escoge la conversión que desees realizar:");
                System.out.println("*****************************");
                menuOption = scanner.nextInt();
                if (menuOption < 1 || menuOption > this.exitOption) {
                    System.out.println("La opción seleccionada no existe...\nIntente de nuevo.");
                    continue;
                }
                if (menuOption == this.exitOption) {
                    System.out.println("Programa finalizado. ¡Adiós!");
                    break;
                }
                System.out.println("Ingrese el valor que deseas convertir:");
                amountToConvert = scanner.nextInt();
                PairConversion pairConversionSelected = PairConversion.values()[menuOption - 1];
                double conversionResult = controller
                        .getExchangeResultWithPairConversion(amountToConvert, pairConversionSelected);
                System.out.println(
                        "El valor "
                                + amountToConvert
                                + "[" + pairConversionSelected.getCoinBase().name()+"]"
                                +  " corresponde al valor final de => "
                                + conversionResult
                                + " [" + pairConversionSelected.getCoinTarget().name()+"]");
            } catch (HttpRequestFailedException e) {
                System.out.println("No se ha podido acceder a la API para convertir monedas: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Ocurrío un error al enviar los datos o al recibir el resultado: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Algo salió mal y se detuvo la conversión: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido no es un número.");
            } catch (Exception e) {
                System.out.println("El sistema ha fallado: " + e.getMessage());
            }
        }while(menuOption != this.exitOption);
        scanner.close();
    }
}
