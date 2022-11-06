package Juego;

import java.util.Scanner;

public class CaraSello {

    /**
     * @param args the command line arguments
     */
    //Colores en Consola
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println("Bienvenido a tu juego de cara o sello favorito ");
        System.out.println("Comenzemos con una nueva partida :3");
        System.out.println(" ");
        Scanner eleccion = new Scanner(System.in);
        Scanner monto = new Scanner(System.in);
        Scanner continuar = new Scanner(System.in);

        System.out.println(ANSI_RED + "           ///////////////////////////" + ANSI_RESET);
        System.out.println(ANSI_RED + "           ///////" + ANSI_RESET + ANSI_BLACK + " IMPORTANTE " + ANSI_RESET + ANSI_RED + "////////" + ANSI_RESET);
        System.out.println(ANSI_RED + "           ///////////////////////////" + ANSI_RESET);
        System.out.println(ANSI_RED + " La apuesta inicial tiene que ser mayor a 2 creditos" + ANSI_RESET);
        System.out.println(" ");
        System.out.println(ANSI_BLUE + "¿Digite la cantidad de creditos que quiere apostar para comenzar?, " + ANSI_RESET);

        int creditos = 0;
        creditos = monto.nextInt();
        int moneda = (int) (Math.random() * 2) + 1;
        int seguir = 0;
        int cantidad = 0;
        int mas = 0;
        int acumulado = 0;
        int juegos = 0;

        while (creditos < 2) {
            System.out.println("No puedes jugar con menos de 2 créditos ingresa mas para poder jugar.");
            mas = monto.nextInt();
            creditos = creditos + mas;
        }
        if (creditos >= 2) {
            System.out.println("Su total de creditos es " + creditos);

            System.out.println("Seleccione la cara de la moneda a la que le quiere apostar:" + "\n" + "Digite: 1 para Sello " + " \n" + "Digite: 2 para Cara");
            int eleccionUsuario = eleccion.nextInt();

            while (eleccionUsuario >= 3) {
                System.out.println("Error elija el numero 1 o 2");
                eleccionUsuario = eleccion.nextInt();
            }

            if (eleccionUsuario <= 2) {
                System.out.println("  \n \n Lanzando la moneda espere un momento... \n  \n");
                if (moneda == 1) {
                    System.out.println("Ha salido Sello");
                } else if (moneda == 2) {
                    System.out.println("Ha salido Cara");
                }

                if (eleccionUsuario != moneda) {
                    System.out.println("Usted ha perdido");
                    creditos = (creditos / 2);
                    acumulado = acumulado + creditos;
                    juegos++;
                    System.out.println("Ahora tiene " + creditos + " créditos");

                } else if (eleccionUsuario == moneda) {
                    System.out.println("Usted ha ganado");
                    creditos = creditos + (creditos / 2);
                    acumulado = acumulado + creditos;
                    juegos++;
                    System.out.println("lleva " + juegos + "  juegos ");
                    System.out.println("Ahora tiene " + creditos + " créditos");
                }
            }

        }
        if (creditos >= 2 || creditos < 2) {
            System.out.println("¿Desea seguir jugando?  en este momento tiene " + creditos + " creditos ");
            System.out.println("Escriba 1 para si \nEscriba 2 para no ");
            seguir = continuar.nextInt();

        }

        while (seguir >= 3) {
            System.out.println("¡Error ingrese el numero 1 o 2!");
            seguir = continuar.nextInt();
        }

        while (seguir == 1) {

            System.out.println("¿Cuántos de sus créditos desea apostar?, a partir de aquí ganará el doble  de lo que apueste o perderá lo que apostó. Recuerde que tiene " + creditos + " créditos disponibles");
            if (cantidad > creditos) {
                System.out.println("No puede apostar esta cantidad de creditos");
                System.out.println("¿Cuántos de sus créditos desea apostar?, a partir de aquí ganará el doble  de lo que apueste o perderá lo que apostó. Recuerde que tiene " + creditos + " créditos disponibles");

            }
            cantidad = monto.nextInt();
            if (cantidad <= creditos) {
                creditos = creditos - cantidad;
                acumulado = acumulado + creditos;

                if (cantidad <= creditos) {
                    System.out.println("Para jugar, ingrese la cara de la moneda a la cual quiere apostar:" + "\n" + "oprima: 1 para Cara " + " \n" + "oprima: 2 para Sello");
                    System.out.println("Ok,  se le descontaron " + cantidad + " créditos y ahora tiene " + creditos + " creditos disponibles ");
                    int eleccionUsuario = eleccion.nextInt();
                    System.out.println("  \n \n Lanzando la moneda espere un momento... \n  \n");
                    if (eleccionUsuario >= 3) {
                        System.out.println(ANSI_RED+"Error elija el numero 1 o 2" + ANSI_RESET);
                    }
                    if (eleccionUsuario <= 2) {
                        if (moneda == 1) {
                            System.out.println("Ha salido Sello");
                        } else if (moneda == 2) {
                            System.out.println("Ha salido Cara");
                        }

                        if (eleccionUsuario != moneda) {
                            System.out.println("Usted ha perdido");
                            juegos++;
                            System.out.println("Le quedan " + creditos + " créditos");

                        } else if (eleccionUsuario == moneda) {
                            System.out.println("Usted ha ganado");
                            juegos++;
                            creditos = cantidad * 2 + creditos;
                            acumulado = acumulado + creditos;
                            System.out.println("Ahora tiene " + creditos + " créditos");
                        }
                        if (creditos >= 2) {
                            System.out.println("¿Quiere continuar el juego? Su acumulado en este momento es de " + creditos + " creditos ");
                            System.out.println("Escriba 1 para si \nEscriba 2 para no ");
                            seguir = continuar.nextInt();

                        }

                        if (seguir >= 3) {
                            System.out.println("¡Error ingrese un numero valido!");
                            seguir = continuar.nextInt();
                        }

                    }
                }
            } else {
                System.out.println("Ingrese una cantidad disponible para descontarle de sus créditos");

            }

        }

        if (seguir == 2) {
            System.out.println(ANSI_GREEN + "----------MUCHAS GRACIAS POR JUGAR, VUELVA PRONTO-----" + ANSI_RESET);
            System.out.println(ANSI_GREEN + " " + ANSI_RESET);
            System.out.println(ANSI_BLUE + "---------------ESTADISTICAS---------------" + ANSI_RESET);
            System.out.println(ANSI_BLUE +"------ " +ANSI_RESET + "Total de partidas jugadas: " + juegos);
            System.out.println(ANSI_BLUE +"------ " +ANSI_RESET + "El balance final es de " + acumulado + " créditos ");
            monto.close();
            eleccion.close();
            continuar.close();

        }

    }
}
