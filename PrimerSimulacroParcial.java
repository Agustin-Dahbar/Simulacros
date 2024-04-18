package PracticasParcialTHP;

import java.util.Scanner;

public class PrimerSimulacroParcial {

	public static void main(String[] args) 
	{	
		Scanner scanner = new Scanner(System.in);
		
		int dias = 0; //Se evalúará en la condición del while para respetar los 10 días de pruebas.
		double minutosPrueba = 0; //Almacenará los minutos que ingrese el usuario en cada iteración del do while.
		double minutosTotales = 0; //Almacenará el total de los minutos para sacar el promedio (uno de los requisitos). 
		//Las tipamos con double para aceptar segundos y que el promedio sea lo más exacto posible.
		
		//Variables que representan los requisitos del atleta para evaluar su aptitud. 
		boolean masDe20Minutos = false;   //Si finaliza en false el atleta aún puede estar apto, en true se descarta su aptitud.
		boolean menosDe15Minutos = false; //"     "     " true    "    "    "    "     "      ", "  false "  "        "     "  .
		double PROMEDIO = 0; //Almacenará el resultado del promedio de minutos tardados por el atleta en los dias recorridos.
		
		//Variables de salida final.
		double tiempoMinimo = Integer.MAX_VALUE; //La inicializamos con un max value para que cualquier dato ingresado al comienzo sea menor y se cumpla lo que deseamos que es que obtenga el primer valor con el que se comparen los siguientes minutos ingresados.
		int diasDeRecord = 0; //Almacenaremos númericamente el dias en el que se hizo el tiempo más bajo.
		
		
		do 
		{
			//Instrucciones e ingreso de los minutos que demoró el atleta en la prueba.
			System.out.println("Ingresa los minutos de la prueba realizada para el día " + (dias + 1) + " debe estar entre [1,99] inclusives");
			minutosPrueba = scanner.nextDouble();
			
			//While interno que repetirá el pedido de entrada si los minutos ingresados son incorrectos.
			while(!(minutosPrueba > 0 && minutosPrueba < 100)) //Explicación del ! en la condición del while: 
																	//-La condición dice: Si minutosPrueba es mayor a 0 y menor a 100 es decir entre 1 y 99 inclusives. Pero eso esta predecedido de un ! que indica invertir el caso. Entonces el while se ejecutará cuando NO SUCEDA lo de la condición es decir cuando sea DIFERENTE (!) a la condición que es entre 1 y 99, En resumen, cuando NO SEA entre 1 y 99.
			{
				System.out.println("Por favor ingresa minutos válidos para el dias " + (dias + 1) + " (desde 1 hasta 99)");
				minutosPrueba = scanner.nextInt();
			}
			
			//Si llegamos acá no se ejecutó el while anterior, entonces los minutos son correctos.
			dias++; //Aumentamos el conteo de los días en 1.
			minutosTotales += minutosPrueba; //Aumentamos el conteo de minutosTotales de la prueba a la suma total de minutos que servirá para obtener el promedio (3er requisito de aptitud)
	
			//Comprobamos si los minutos de esta iteración son los menores ingresados.
			if(tiempoMinimo < minutosPrueba ) 
			{
				tiempoMinimo = minutosPrueba; //Asignamos el nuevo tiempo record a la var correspondiente.
				diasDeRecord = dias ; //Obtenemos el dias en el que se hizo el record. 
			}
			
			
			//Ahora averiguaremos 2 de los 3 requisitos.
			if(minutosPrueba < 15) //Si hizo menos de 15 minutos.
			{
				menosDe15Minutos = true;
			}
			else if(minutosPrueba > 20) //Si hizo más de 20 minutos.
			{
				masDe20Minutos = true;
			}
			
			//Necesitamos que menos15 se cumple al menos una vez es decir finalice con TRUE.
			//y que Mas20 nunca suceda y se mantenga en false, ya que inicializamos ambas en FALSE.
		}
		while(dias < 10 && !masDe20Minutos);
		//While externo que ejecutará el programa. Siempre y cuando estemos entre los 10 días de prueba ( dias == [0..9] )
		//y el atleta no se haya demorado más de 20 minutos en alguna prueba ya que eso descartaria que este apto.
				
		//Si llegamos a esta línea de código se acabó el programa por alcanzar los 10 días o por el atleta tardar más de 20 minutos en alguna prueba.
		
		//Reasignando su variable, realizamos la obtención del promedio (el último requisito para conocer su aptitud).
		PROMEDIO = minutosTotales/dias; 
		
		//Ya obtenidos todos los datos necesarios hacemos la evaluación de aptitud fuera del while.
		if(menosDe15Minutos && !masDe20Minutos && PROMEDIO <= 18) //Si menosDe15Minutos == true y masDe20Minutos == false (por el ! que indica diferente o inverso) y PROMEDIO menor o igual a 18.
		{
			System.out.println("Esta apto."); //Ahora no necesitamos el -1 ya que esta es la variable que almacenaba el valor habiendo usado el menos uno, es dias a la que se le debe restar un valor.
			System.out.println("Su menor tiempo fue de " + tiempoMinimo + " minutos y lo logró en el día " + diasDeRecord);
			System.out.println("Su promedio fue de " + PROMEDIO + " minutos");
		}
		else //Si no cumple alguno de los 3 requisitos de la condición anterior se ejecuta este else.
		{
			System.out.println("El atleta no es apto.");
			
				//Ahora averiguaremos e imprimiriemos los motivos de su inaptitud (detalles, no es necesario)
				if(masDe20Minutos) //Si la variable es true.
				{
					System.out.println("Tardó más de 20 minutos en una prueba");
				}
				if(PROMEDIO > 18) //Si PROMEDIO es mayor 18.
				{
					System.out.println("No cumple con el promedio. Fue de " + PROMEDIO + " y no podia superar 18");
				}
				if(!menosDe15Minutos) //Si la variable es false.
				{
					System.out.println("Nunca hizo menos de 15 minutos.");
				}
		}
		
		
		
	}
}
