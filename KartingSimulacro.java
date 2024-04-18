package PracticasParcialTHP;

import java.util.Scanner;

public class KartingSimulacro {
	

	public static void main(String[] args) 
	{
	
		Scanner scanner = new Scanner(System.in);
		
		//Resultado de la vuelta que ingresará el usuario
		char resultado = 0;
		//Almacenará en cada iteración los pianitosPisados por el ganador de la vuelta.
		int pianitosPisados = 0; 		
		//Contadores de vueltas para cada auto y de contadores de pianitos pisados.
		double vueltasRojo = 0;
		double vueltasVerde = 0; 
		int pianitosPisadosRojoTotal = 0;
		int pianitosPisadosVerdeTotal = 0;
		//Variable booleana que almacenará si hubo un accidente o no.
		boolean	huboAccidente = false; 
		//Ganador de cada vuelta. Tendrá un valor por cada iteración del bucle.
		String ganadorVuelta = "undefined"; 
		
		//Un do..while sería más "correcto" pero me gusta usar whiles y simplemente asegurarme con las inicializaciones de que no haya problemas y se ejecute el programa.
		
		//While que recorrerá el total de la carrera, hasta q un auto llegue a 5 vueltas o haya un accidente.
		while(vueltasRojo < 5 && vueltasVerde < 5 && huboAccidente == false) 
		{
			//Instrucción y almacen de entrada del usuario.
			System.out.println("Dime que karting dió la vuelta en esta iteración");
			resultado = scanner.next().charAt(0);
			
			//Con un while comprobamos que haya ingresado una de las 3 opciones disponibles.
			while(!(resultado == 'R' || resultado == 'V' || resultado == 'F')) 
			{
				System.out.println("Ingresa un char válido por favor. [R, V, F]");
				resultado = scanner.next().charAt(0);
			}
			
				//Si uno de los autos dió la vuelta
				if(resultado == 'R' || resultado == 'V') 
				{
					System.out.println("Ingresa los pianitos pisados por el auto");
					pianitosPisados = scanner.nextInt(); //Pedimos los pianitos pisados por el mismo.
					
					//Bifurcamos el código en 2 para manejar las variables correspondientes según el ganador de la vuelta.
					if(resultado == 'R') 
					{
						vueltasRojo++;
						pianitosPisadosRojoTotal += pianitosPisados;
						ganadorVuelta = "rojo";
					}
					else 
					{
						vueltasVerde++;
						pianitosPisadosVerdeTotal += pianitosPisados;
						ganadorVuelta = "verde";
					}
					
				}
				else //Si no se ingresó uno de los dos autos, hubo un accidente.
				{
					huboAccidente = true;
				}
				
				//Devolvemos que auto ganó la vuelta de esta iteración y cuántos pianitos pisó.. Lo hacemos acá y no en el primer if porque en ese momento aún no habiamos obtenido el valor de ganadorVuelta.
				if(!huboAccidente) 
				{
					System.out.println("El auto que dió la vuelta fue el " + ganadorVuelta);
					
					if(pianitosPisados >= 0) 
					{
						System.out.println("Pisó el pianito " + pianitosPisados + " veces");	
						System.out.println(""); //Espacio para separar ingresos. No lo ubicamos en el while para que no se ejecute ese espacio en caso de F y devolver "Indefinido" quedá feo con espacio ese caso.
					}
				}
		}
		//Fin del while por ende del programa por accidente o ganador. (vueltasX == 5 o huboAccidente == true;)
		
		
		//Devolvemos la información final con los datos obtenidos en el while. (Ganador o accidente) 3 opciones posibles.
		if(vueltasRojo == 5) 
		{
			System.out.println("El karting ganador fue el rojo");
		}
		else if(vueltasVerde == 5)
		{
			System.out.println("El karting ganador fue el verde");
		}
		else if(huboAccidente == true)
		{
			System.out.println("Indefinido");
		}
		
		//Declaramos que el cálculo y la impresión del promedio se hagan si no hubo accidente. Esto para evitar salidas indeseadas cuando lo haya.
		if(!huboAccidente) 
		{
			//Realizamos el promedio de los pianitos pisados por cada auto según sus vueltas para averiguar quién tuvo el mejor promedio.
			double promedioPianitosRojo = pianitosPisadosRojoTotal/vueltasRojo;
			double promedioPianitosVerde = pianitosPisadosVerdeTotal/vueltasVerde;
			
			//Evaluamos que promedio es mejor y devolvemos ese.
			if(promedioPianitosRojo > promedioPianitosVerde) 
			{
				System.out.println("El mejor promedio fue de " + promedioPianitosVerde + " pianitos y le corresponde al auto verde");
			}
			else 
			{
				System.out.println("El mejor promedio fue de " + promedioPianitosRojo + " pianitos y le corresponde al auto rojo.");
			}
		}
		
	}
}
