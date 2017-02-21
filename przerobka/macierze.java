import java.util.Scanner;
import static java.lang.Math.*;
import java.io.*;

public class macierze
{
	public static double wyznacznik(double[][] macierz, int wys, int szer){
		double det = 0;
		int znak = 1;
		if (wys == 1){
			det = macierz[0][0];
		}
		else{
			double[][] b = new double[wys-1][szer-1];
			for(int x=0; x<wys; x++){
				int p=0;
				int q=0;
				for(int i = 1; i<wys; i++){
					for(int j = 0; j<szer; j++){
						if(j != x){
							b[p][q++] = macierz[i][j];
							if (q % (wys - 1) == 0){
								p++;
								q=0;
							}
						}
					}
				}
			det += macierz[0][x] * wyznacznik(b, wys-1, szer-1) * znak;
			znak = -znak;
			}
		}

		return det;
	}
    
    public static int[] sizeOfMatrixes(){
    	int[] wymiary = new int[4];
		int correct = 0;
		while (correct != 1) {
			try {
				Scanner scan1 = new Scanner(System.in);
				System.out.println("Podaj wysokoœæ macierzy 1. (liczba wierszy): ");
				wymiary[0] = scan1.nextInt();
				if (wymiary[0] < 1) {
					System.out.println("\nProszê wprowadziæ poprawn¹ wysokoœæ macierzy 1.");
				}
				correct += 1;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("\nProszê wprowadziæ poprawn¹ wysokoœæ macierzy 1: ");
			}
        }

	//szer1
        while (correct != 2){
			try {
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Podaj szerokoœæ macierzy 1. (liczba kolumn): ");
				wymiary[1] = scan2.nextInt();
				if (wymiary[1] < 1) 	{
					System.out.println("\nProszê wprowadziæ poprawn¹ szerokoœæ macierzy 1.");
				}
				correct += 1;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("\nProszê wprowadziæ poprawn¹ szerokoœæ macierzy 1.");
			}
        } 

	//wys2
        while (correct != 3){
			try {
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Podaj wysokoœæ macierzy 2. (liczba wierszy): ");
				wymiary[2] = scan3.nextInt();
				if (wymiary[2] < 1) 	{
					System.out.println("\nProszê wprowadziæ poprawn¹ wysokoœæ macierzy 2.");
				}
				correct += 1;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("\nProszê wprowadziæ poprawn¹ wysokoœæ macierzy 2.");
			}
        }

	//szer2
        while (correct != 4){
			try {
				Scanner scan4 = new Scanner(System.in);
				System.out.println("Podaj szerokoœæ macierzy 2. (liczba kolumn): ");
				wymiary[3] = scan4.nextInt();
				if (wymiary[3] < 1) 	{
					System.out.println("\nProszê wprowadziæ poprawn¹ szerokoœæ macierzy 2.");
				}
				correct += 1;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("\nProszê wprowadziæ poprawn¹ szerokoœæ macierzy 2.");
			}
		}
        correct = 0;
		return wymiary;
	}

	public static void matrixesValues(int wys1, int szer1, int wys2, int szer2){
		double[][] macierz1 = new double[wys1][szer1];
		double[][] macierz2 = new double[wys2][szer2];
		double[][] wynik = new double[wys1][szer1];
		double[][] mnoz1 = new double[wys1][szer2];
		double[][] mnoz2 = new double[wys2][szer1];
		Scanner wartosc = new Scanner(System.in);

		System.out.println("\nWprowadŸ wyrazy pierwszej macierzy oddzielaj¹c je spacj¹.\nWartoœci nieca³kowite wprowadŸ z u¿yciem przecinka.\nUwaga! Wprowadzenie niepoprawnych wartoœci spowoduje b³¹d programu! ");
		for(i=0; i < wys1; i++) {
			for (j=0; j < szer1; j++) {
				macierz1[i][j] = wartosc.nextDouble();
				System.out.printf("% -9.2f", macierz1[i][j]);
				}
			System.out.println();
		}

		System.out.println("\nWprowadŸ wyrazy drugiej macierzy oddzielaj¹c je spacj¹.\nWartoœci nieca³kowite wprowadŸ z u¿yciem przecinka.\nUwaga! Wprowadzenie niepoprawnych wartoœci spowoduje b³¹d programu! ");
		for(i=0; i < wys2; i++) {
			for (j=0; j < szer2; j++) {
				try {
					macierz2[i][j] = wartosc.nextDouble();
					System.out.printf("% -9.2f", macierz2[i][j]);
					}
				catch (java.util.InputMismatchException e) {
					System.out.println("Wyjątek");
					if ((i == 0) && (j != 0)) {
						j--;
						i = wys2 - 1;
					}
					else {
						i--;
					}
				}
			}
			System.out.println();
		}
	}

	public static void dodawanie(){
		if(wys1==wys2 && szer1==szer2) {
			for(i=0; i < wys1; i++) {
				for (j=0; j < szer1; j++) {
					wynik[i][j] = macierz1[i][j] + macierz2[i][j];			
				}
			}
			System.out.println("\nSuma macierzy 1 i 2 to macierz: ");
			for(i=0; i < wys1; i++) {
				for (j=0; j < szer1; j++) {
					System.out.printf("% -9.2f", wynik[i][j]);
				}
				System.out.println();
			}
		}
		else System.out.println("Macierze maj¹ ró¿ne wielkoœci. Nie mo¿na wykonaæ dzia³ania.");
		break;
	}

	public static void main(String[] args){
		int[] wymiary = sizeOfMatrixes();
		int wys1 = wymiary[0];
		int szer1 = wymiary[1];
		int wys2 = wymiary[2];
		int szer2 = wymiary[3];
		matrixesValues(wys1,szer1,wys2,szer2);
	}
}