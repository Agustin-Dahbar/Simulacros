package PracticasParcialTHP;

import java.util.Scanner;

public class MesetasFinal {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		//Variables que serán evaluadas entre sí para desarollar la lógica más importante del programa (si se creó o se continuo una meseta)(if línea 33)
		int numeroIngresado = 0; 
		int numeroAnterior = 0;
		
		int mesetasCreadas = 0; //Representará el conteo de mesetas creadas. Solo se ejecutará cuando la duración de una meseta sea 2, es decir cuando se haya recien creado (linea 39)
		int lengthMeseta = 0; //Representará en diferentes iteraciones el valor de cada meseta que encontremos.
		int lengthMesetaMasLarga = 0; //Variable que almacenará el valor de la meseta mas larga al finalizar el programa. 
		boolean nuevaMeseta = true; //Variable que controlará la identificación de una nueva meseta.
		
		//Le pedimos al usuario ingresar un numero entre 1 y 100 y continuar con el programa. Manejamos el caso en que brinde un numero 
		System.out.println("Ingresa números entre 1 y 100. Cuando quieras acabar el programa, 0. Tendrás info sobre las mesetas.");
		numeroIngresado = scanner.nextInt();
		
			do {
				//En el siguiente ef evaluaremos si se ingreso [1-100] para continuar con el programa. Si se ingreso negativo o < 100 lo manejamos en el else de la línea 54.
				//If que desarrolla la lógica para evaluar si se creo (linea 35) o continuo una meseta (linea 30 a partir del 2do caso), según eso aumentar el conteo correspondiente. 
				//Luego evaluaremos si  la meseta creada o continuada es la más larga hasta ahora. (linea 41)
				if(numeroIngresado > 0 && numeroIngresado < 101) //Si numero esta entre 1 y 100
				{
					//If que maneja el caso en el que hayamos ingresado un número igual al anterior, por lo tanto o creamos una meseta o la continuamos.
					if(numeroIngresado == numeroAnterior) 
					{
						lengthMeseta++; //Sumamos la duración de la meseta.
						
						//En el caso de que la meseta se haya creado en esta iteración 
						if(lengthMeseta == 1) //Este if evita que aumentemos el conteo de nuevas mesetas en caso en que se continúe una ya creada, ya que al crearse una el lengthMeseta valdrá uno.
						{
							mesetasCreadas++; //Contamos la meseta creada.
						}
						
						//Evaluamos si es la meseta más larga
						if(lengthMeseta > lengthMesetaMasLarga) 
						{
							lengthMesetaMasLarga = lengthMeseta; //Si lo es la declaramos como la más larga.
						}
						
					}
					else //Si los números son != se acabó la meseta. 
					{
						lengthMeseta = 0; //Reiniciamos el valor de lengthMeseta para que en la próxima meseta que se cree no haya problemas por herencias indeseadas.
					}
					
					//Ya habiendo finalizado de las ejecuciones con respecto a la creación, continuación y evaluación de si es o no la más larga continuamos con el programa.
					numeroAnterior = numeroIngresado; //Nos preparamos para la siguiente iteración del while
					
					//Pedimos ingreso del siguiente número.
					System.out.println("Continua con el siguiente numero");
					numeroIngresado = scanner.nextInt();

				}
				else //Else que se ejecutará cuando el numero ingresado sea negativos o mayor a 100. (if linea 30 descartó a [1-100] y while linea 25 descartó a 0))
				{
					System.out.println("Por favor, el numero debe estar entre 1 y 100. Reingresalo.");
					numeroIngresado = scanner.nextInt();
				}

			}
			while(numeroIngresado != 0);
			//Bucle que se repetirá mientras el numero ingresado sea diferente a 0. Es decir no acabaremos el programa y volveremos a pedir un reingreso de número.
			//ya sea por continuarlo [1-100] o por ingresar numeros incorrectos (negativos o mayores a 100) es decir (n < 0 || n > 100).
			
		//FIN DEL DO..WHILE QUE MANEJABA LOS CASOS != 0.
		
		if (lengthMeseta > lengthMesetaMasLarga) 
		{
            lengthMesetaMasLarga = lengthMeseta;
        }
	
		//Ahora fuera de el continuaremos con el caso final, cuando el programa se acaba.
		System.out.println("La cantidad de mesetas encontradas fue de " + mesetasCreadas);
		System.out.println("La meseta mas larga tuvo una duración de " + (lengthMesetaMasLarga + 1) + " numeros"); //Sumamos uno para que de el valor esperado, ya que inicializamos las vars en 0 por convencia en la ejecución del código.
		
	}
}
