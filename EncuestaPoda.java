package PracticasParcialTHP;

import java.util.Scanner;

public class EncuestaPoda {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		//Variables que almacenarán las entradas de los participantes.
		String nombreJugadorA = "undefined";
		String nombreJugadorB = "undefined";
		int rondasMaximas = 0;
		int numeroA = 0;
		int numeroB = 0;
		
		//Constantes que almacenarán los números límites que podrán ingresar los participantes.
		final int NUMERO_MAXIMO = 10;
		final int NUMERO_MINIMO = 1;
		
		//Variables que se evaluarán en el while que ejecuta el programa si se debe continuar.
		int rondasActuales = 0; //Almacenará las rondas iteradas parcialmente.
		boolean acierto = false; //Almacenará si se acertó el número aleatorio.
		
		
		//Numero aleatorio que deberán adivinar, lo generaremos después de obtener los números ingresados por ellos, ya que los requerimos.
		int numeroAleatorio = 0;
		
		

		//Pedimos los nombres de los jugadores.
		System.out.println("Ingresa el nombre de los jugadores.");
		nombreJugadorA = scanner.nextLine();
		nombreJugadorB = scanner.nextLine();
		
		//Pedimos las rondas a jugar.
		System.out.println("Ingresa las rondas máximas");
		rondasMaximas = scanner.nextInt();
		
		//Evaluamos que se haya ingresado para jugar al menos una ronda. Si rondas maximas es menor a 1, repetimos el ingreso pedido.
		while(rondasMaximas < 1) 
		{
			System.out.println("Las rondas a jugar deben ser mayores a 0. Reingresa el dato.");
			rondasMaximas = scanner.nextInt();
		}
		
		//Do..While
		do 
		{	
			//Ahora le pediremos a los participantes los dos números.
			System.out.println("Ahora diganme, ¿que número creen que saldra?");
			numeroA = scanner.nextInt();
			numeroB = scanner.nextInt();
			
			while((numeroA > NUMERO_MAXIMO || numeroA < NUMERO_MINIMO) && (numeroB > NUMERO_MAXIMO || numeroB < NUMERO_MINIMO)) 
			{
				System.out.println("Los numeros ingresados deben estar entre 1 y 10. Reingresalos.");
				numeroA = scanner.nextInt();
				numeroB = scanner.nextInt();
			}
			
			rondasActuales++; //Aumentamos el conteo de las rondas ya que acabamos de comprobar que se ingresaron correctamente las rondas a jugar y los n.
			
			//numeroAleatorio = (int)Math.floor((Math.random() * (NUMERO_MAXIMO - NUMERO_MINIMO + 1)));
			//Obtenemos el numero aleatorio que debieron adivinar los participantes.
			numeroAleatorio = NUMERO_MINIMO + (int)(Math.random() * (NUMERO_MAXIMO - NUMERO_MINIMO + 1));
			numeroAleatorio = 10;
			
			//En un if verificaremos si lo adivinaron para acabar el programa por encontrar un ganador.
			if(numeroAleatorio == numeroA && numeroAleatorio == numeroB) 
			{
				System.out.println("Hubo empate, ambos adivinaron.");
				acierto = true;
			}
			else if(numeroAleatorio == numeroA) 
			{
				acierto = true;
				System.out.println("El jugador " + nombreJugadorA + " acertó el número y ganó..");
			}
			else if(numeroAleatorio == numeroB) 
			{
				acierto = true;
				System.out.println("El jugador " + nombreJugadorB + " acertó el número y ganó..");
			}
		}
		while(rondasActuales < rondasMaximas && !acierto);
		//Mientaras las rondas actuales no hayan llegado a las máximas indicadas por el usuario y no se haya acertado el número, sigue la competencia.
	}
	
}
