/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.util.Scanner;

/**
 *
 * @author POWER
 */
public class CaraSello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Carisellazo");
        Scanner eleccion = new Scanner(System.in);
        Scanner monto = new Scanner(System.in);
        Scanner continuar = new Scanner(System.in);

        System.out.println("¿Cuánto desea apostar?, si gana, se le aumentará la mitad de su saldo, si pierde, se le quitará la mitad de su saldo ");
        System.out.println("Nota: Sus créditos deben ser de 2 en adelante para poder jugar");
        int creditos = 0;
        creditos = monto.nextInt();
        int ladomone = (int) (Math.random() * 2) + 1;
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
            System.out.println("Usted tiene " + creditos + " créditos");

            System.out.println("Para jugar, ingrese la cara de la moneda a la cual quiere apostar:" + "\n" + "oprima: 1 para Cara " + " \n" + "oprima: 2 para Sello");
            int eleccionUsuario = eleccion.nextInt();
            
            while(eleccionUsuario >=3){
                System.out.println("Error elija el numero 1 o 2");
                eleccionUsuario = eleccion.nextInt();
            }
          

            if (eleccionUsuario <= 2) {
                System.out.println("  \n \n Lanzando la moneda espere un momento... \n  \n");
                if (ladomone == 1) {
                    System.out.println("Ha salido cara");
                } else if (ladomone == 2) {
                    System.out.println("Ha salido Sello");
                }

                if (eleccionUsuario != ladomone) {
                    System.out.println("Usted ha perdido");
                    creditos = (creditos / 2);
                    acumulado = acumulado + creditos;
                    juegos++;
                    System.out.println("Ahora tiene " + creditos + " créditos");

                } else if (eleccionUsuario == ladomone) {
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
                cantidad = monto.nextInt();
                
            if (cantidad <= creditos) {
                creditos = creditos - cantidad;
                acumulado = acumulado + creditos;
                
                System.out.println("Ok,  se le descontaron " + cantidad + " créditos y ahora tiene " + creditos + " creditos disponibles ");

                if (cantidad <= creditos ) {
                    System.out.println("Para jugar, ingrese la cara de la moneda a la cual quiere apostar:" + "\n" + "oprima: 1 para Cara " + " \n" + "oprima: 2 para Sello");
                    int eleccionUsuario = eleccion.nextInt();
                    System.out.println("  \n \n Lanzando la moneda espere un momento... \n  \n");
                    if (eleccionUsuario >= 3) {
                        System.out.println("Error elija el numero 1 o 2");
                    }
                    if (eleccionUsuario <= 2) {
                        if (ladomone == 1) {
                            System.out.println("Ha salido cara");
                        } else if (ladomone == 2) {
                            System.out.println("Ha salido Sello");
                        }

                        if (eleccionUsuario != ladomone) {
                            System.out.println("Usted ha perdido");
                            juegos++;
                            System.out.println("Le quedan " + creditos + " créditos");

                        } else if (eleccionUsuario == ladomone) {
                            System.out.println("Usted ha ganado");
                            juegos++;
                            creditos = cantidad * 2 + creditos;
                            acumulado = acumulado + creditos;
                            System.out.println("Ahora tiene " + creditos + " créditos");
                        }
                        if (creditos >= 2) {
                            System.out.println("¿Desea seguir jugando?  en este momento tiene " + creditos + " creditos ");
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
            System.out.println("Ok, que tenga buen día");
            System.out.println("Jugó un total de " + juegos + " partidas");
            System.out.println("Y Entre ganancias y perdidas hay un total de " + acumulado + " créditos");
            monto.close();
            eleccion.close();
            continuar.close();

        }
       
    }
}

