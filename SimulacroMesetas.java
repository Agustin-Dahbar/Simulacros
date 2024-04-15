package PracticasParcialTHP;

import java.util.Scanner;

public class SimulacroMesetas {

	public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        // mensaje que imprimiremos en ciertas ocasiones al usuario. Lo guardamos en una variable para no tener que reescribirlo.
        final String MENSAJE = "Ingrese un numero entre 1 y 100 inclusives. Si quiere terminar ingrese 0. ";

        // Declaramos todas las variables a usar.
        int numero = 0; 
        int numeroAnterior = 0;
        int cantidadMesetas = 0;
        int largoMeseta = 1; //La inicializamos en uno para contar el primer numero de la meseta de forma preventiva en caso de que asi lo termine siendo. Si no termina siendo meseta, ese uno no habrá causado problemas.
        int mesetaMasLarga = 0;
        
        // Do While donde pedimos el ingreso del numero inicial.
        do 
        {
            System.out.println(MENSAJE); // Pedimos que ingrese entre 0 y 100 para continuar o terminar.
            numero = Integer.parseInt(scanner.nextLine());
        } while ((numero < 0 || numero > 100) && numero != 0); // Mientras el número no esté entre 0 y 100 se repetirá el pedido.

        
        // While externo que continuará el programa, se ejecutará cuando se ingrese [1-100]. Para llegar a el se tuvo que haber ingresado [0-100]
        while (numero != 0) 
        {
            //En la primer iteración del while se comenzará por el else. Ya que es el primer número ingresado. No se cumplirá la sentencia if identificadora de mesetas.
            if (numero == numeroAnterior) // Si el numero ingresado por el usuario es igual al anterior formamos una meseta.
            {
                largoMeseta++; // Le sumamos el largo.
                System.out.println("Ingresaste el mismo numero por lo tanto le sumamos un largo a la meseta.");
                
                //If que identifica cuando se creó una nueva meseta. Esta condición solo se cumplirá cuando numero == numeroAnterior POR PRIMERA VEZ desde que largoMeseta valga 0.
                if(largoMeseta == 2) // Si el largo es de 2, encontramos el segundo número igual, por ende una nueva meseta, la contamos entonces.
                {
                    cantidadMesetas++;
                }
            } 
            else //Else que maneja la situación en la que se haya cortado la meseta (numero != numeroAnterior)
            {
                // Evaluamos la meseta finalizada. Averiguamos si fue la más larga. 
                if (largoMeseta > mesetaMasLarga) 
                {           
                    mesetaMasLarga = largoMeseta; // Sobreescribimos la info de la meseta más larga, almacenamos la cantidad de números que posee.
                }
                
                largoMeseta = 1; //Reiniciamos el conteo del largo de la meseta para que la siguiente no este afectada con estadísticas de la anterior.
            }
            
            numeroAnterior = numero; // El numero ingresado se convierte en el anterior para compararlo con el siguiente.
            
            // Do while interno en el que pedimos el numero siguiente, al ingresarlo se evaluará la línea 33 por comienzo de nueva iteración de bucle.
            // En la primer iteración se ejecutará esto directamente, ya que como no hay numeroAnterior no se comprueba lo anterior. A partir de la segudna iteración lo hara gracias a la línea 50.
            do 
            {
                System.out.println("2da salida: " + MENSAJE);
                numero = Integer.parseInt(scanner.nextLine());
            } while ((numero < 0 || numero > 100) && numero != 0); 
            // Mientras el numero ingresado por el usuario no este entre 0 y 100 pedimos su reingreso.
        }
        
        // Fin del while que evalúa los numeros para descubrir si son mesetas. 
        //Saldremos de el cuando se ingrese un 0. Al ingresar < 100 se repetirá el pedido, al ingresar > 100 || < 0 continuará el programa.
        
        //Si el usuario quiso salir del programa entrando 0, devolvemos la cantidad de mesetas.
        System.out.println("La cantidad de mesetas fue de " + cantidadMesetas);
        
        if (cantidadMesetas > 0) // Si obtuvimos mesetas imprimimos cuál fue la más larga.
        {
            System.out.println("La mayor extension de una meseta fue de " + (mesetaMasLarga + 1) + " numeros"); 
        }
            
        scanner.close();
    }
	
}
