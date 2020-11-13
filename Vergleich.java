//Martin Tary

public class Vergleich
{
	public static int q_vergleich = 0;
	public static int q_tauschen = 0;
	public static int b_vergleich = 0;
	public static int b_tauschen = 0;

	public static void main(String[] args)
	{
		//Definiere Array mit n Stellen
		int n = 10; //auf 5 stellen für festes Array mit 5 Stellen
		int[] A  = new int[n];

		//für ein n langes Array mit Zufallszahlen 0-100
		
		// // * aendern um schon sortiertes Array zu nehmen
		for (int i = 0; i<n ; i++)
		{
			A[i] = (int) (Math.random()*100);
		}
		// // * aendern um schon sortiertes Array zu nehmen

		//Festes Array um sortiertes Anzugeben
		/* // * aendern um schon sortiertes Array zu nehmen
		A[0] = 1;
		A[1] = 2;
		A[2] = 3;
		A[3] = 4;
		A[4] = 5;
		*/ // * aendern um schon sortiertes Array zu nehmen

		int[] B = A.clone(); //erschafft eine Kopie von A an anderem Speicherplatz

		//Ausgabe des unsortiertem Array
		System.out.println("Unsortiertes Array:");
		for (int i=0;i<n;i++)
		{
			System.out.print(A[i] + " ");
		}

		System.out.println();
		
		Vergleich.Quick_Sort(A,0,n-1); // Quick_Sort Sortierung wird aufgerufen
		Vergleich.Bubble_Sort(B,n-1); // Bubble_Sort Sortierung wird aufgerufen

		//Ausgabe des sortierten Array A mit Quicksort
		System.out.println("Sortiert mit Quicksort:");
		for (int i=0;i<n;i++)
		{
			System.out.print(A[i] + " ");
		}
		System.out.println(); // Zeilenumbruch

		//Ausgabe des sortierten Array B mit Bubblesort
		System.out.println("Sortiert mit Bubblesort");
		for (int i=0;i<n;i++)
		{
			System.out.print(B[i] + " ");
		}

		System.out.println();
		System.out.println("Quicksort: Vergleiche: " + q_vergleich + " und Vertauscht: " + q_tauschen);	//Ausgabe der Zähler
		System.out.println("Bubblesort: Vergleiche: " + b_vergleich + " und Vertauscht: " + b_tauschen);	//Ausgabe der Zähler
	}

	public static void vertausche(int[] A, int a, int b) //Definition Vertauschfunktion
	{
		int temp;
		temp = A[a];
		A[a] = A[b]; 
		A[b] = temp;
	}


	//Definition Quick_Sort Funktion
	public static void Quick_Sort(int[] A, int l, int r) 
	{
		if (l<r)
		{
			int p = r; //Nehme rechtes Randinteger als Pivotelement
			int i = l; //setze i auf den linken Rand
			int j = r-1; //setze j auf das Element links neben dem Pivotelement

			//Schleife solange bis i>j, mindestens einen Durchlauf
			do
			{
				q_vergleich++;
				while ((i<=j) && (A[i] <= A[p])) 
				//Wenn die untersuchte Stelle i links von j steht, UND die Zahl an A[i] kleiner ist als Zahl vom Pivotelement, 
				{
					i++; //gehe zum nächsten Element
					q_vergleich++; //Vergleichszähler hochzählen
				}
				q_vergleich++;	
				while ((i<=j) && (A[j] >= A[p]))
				//Wenn aktuelle Zahl i links von j steht, UND die Zahl an A[i] größer ist als Zahl vom Pivotelement
				{
					j--; //verschiebe Rechten Rand
					q_vergleich++; //Vergleichzähler hochzählen
				}
				
				if (i<=j)
				{
					vertausche(A, i, j); //ruft die Vertauschfunktion auf
					q_tauschen++;
					i++;  //setze i hoch
					j--; //setze j runter
				}
				
			} while (i<=j);
			
			vertausche(A, i, r); //ruft Vertauschen auf und tauscht Element an i mit Element p (ganz rechts)
			q_tauschen++;
			Quick_Sort(A, l, i-1); //ruft Quicksort auf für linke Seite
			Quick_Sort(A, i+1, r); //ruft Quicksort auf für rechte Seite
		}
	}

	public static void Bubble_Sort(int[] B, int n)
	{
	
		boolean getauscht = false; //Element zum testen, ob getauscht wurde
		int c_durchgang = 0; //Zähler für Durchgang
		do
		{
			getauscht = false; //wird wieder auf falsch gesetzt
			for (int i=0; i<(n-c_durchgang); i++)
			{
				b_vergleich++;
				if (B[i]>B[i+1])
				{
					vertausche(B,i,i+1);
					b_tauschen++;
					getauscht = true; //wenn getauscht wurde, startet die do schleife erneut von vorne
				}
			}
			c_durchgang++; //Durchgangszähler erhöhen
		} while (getauscht);
	}
}
