import java.util.Scanner;
import static java.lang.Math.*;
import java.io.*;

public class macierze
{
//det1
	public static double wyznacznikmacierz1(double[][] macierz1, int wys1, int szer1){
		double detmac1=0;
		int znak=1;
		if(wys1==1){
			detmac1 = macierz1[0][0];
		}
		else{
			double[][] b = new double[wys1-1][szer1-1];
			for(int x=0; x<wys1; x++){
				int p=0;
				int q=0;
				for(int i=1; i<wys1; i++){
					for(int j=0; j<szer1; j++){
						if(j != x){
							b[p][q++] = macierz1[i][j];
							if(q%(wys1-1) == 0){
								p++;
								q=0;
							}
						}
					}
				}
			detmac1 += macierz1[0][x] * wyznacznikmacierz1(b, wys1-1, szer1-1) * znak;
			znak = -znak;
			}
		}

		return detmac1;
	}
//det2
	public static double wyznacznikmacierz2(double[][] macierz2, int wys2, int szer2){
		double detmac2=0;
		int znak=1;
		if(wys2==1){
			detmac2 = macierz2[0][0];
		}
		else{
			double[][] b = new double[wys2-1][szer2-1];
			for(int x=0; x<wys2; x++){
				int p=0;
				int q=0;
				for(int i=1; i<wys2; i++){
					for(int j=0; j<szer2; j++){
						if(j != x){
							b[p][q++] = macierz2[i][j];
							if(q%(wys2-1) == 0){
								p++;
								q=0;
							}
						}
					}
				}
			detmac2 += macierz2[0][x] * wyznacznikmacierz2(b, wys2-1, szer2-1) * znak;
			znak = -znak;
			}
		}

		return detmac2;
	}
//kalkulator
	public static void main ( String[] args )
	{
		int wys1, szer1, wys2, szer2, i, j, menu;
		InputStreamReader load = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(load);
		StreamTokenizer check = new StreamTokenizer(buffer);

		int[] wymiary = new int[4];
		int correct = 0;
	//wys1	
		while (correct == 0) {
			try {
				Scanner scan1 = new Scanner(System.in);
				System.out.println("Podaj wysokoœæ macierzy 1. (liczba wierszy): ");
				wymiary[0] = scan1.nextInt();
				if (wymiary[0] < 1) 	{
					System.out.println("\nProszê wprowadziæ poprawn¹ wysokoœæ macierzy 1.");
				}
				correct = 1;
				if (correct == 1) break;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("\nProszê wprowadziæ poprawn¹ wysokoœæ macierzy 1.");
				correct = 0;
			}
		}

	//szer1
		while (correct == 1) {
			try {
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Podaj szerokoœæ macierzy 1. (liczba kolumn): ");
				wymiary[1] = scan2.nextInt();
				if (wymiary[1] < 1) 	{
					System.out.println("\nProszê wprowadziæ poprawn¹ szerokoœæ macierzy 1.");
				}
				correct = 2;
				if (correct == 2) break;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("\nProszê wprowadziæ poprawn¹ szerokoœæ macierzy 1.");
				correct = 1;
			}
		}

	//wys2
		while (correct == 2) {
			try {
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Podaj wysokoœæ macierzy 2. (liczba wierszy): ");
				wymiary[2] = scan3.nextInt();
				if (wymiary[2] < 1) 	{
					System.out.println("\nProszê wprowadziæ poprawn¹ wysokoœæ macierzy 2.");
				}
				correct = 3;
				if (correct == 3) break;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("\nProszê wprowadziæ poprawn¹ wysokoœæ macierzy 2.");
				correct = 2;
			}
		}

	//szer2
		while (correct == 3) {
			try {
				Scanner scan4 = new Scanner(System.in);
				System.out.println("Podaj szerokoœæ macierzy 2. (liczba kolumn): ");
				wymiary[3] = scan4.nextInt();
				if (wymiary[3] < 1) 	{
					System.out.println("\nProszê wprowadziæ poprawn¹ szerokoœæ macierzy 2.");
				}
				correct = 4;
				if (correct == 4) break;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("\nProszê wprowadziæ poprawn¹ szerokoœæ macierzy 2.");
				correct = 3;
			}
		}
		
		correct = 0;
		wys1 = wymiary[0];
		szer1 = wymiary[1];
		wys2 = wymiary[2];
		szer2 = wymiary[3];
	
	//wyrazy macierzy
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
				}
				catch (java.util.InputMismatchException e) {
					System.out.println("Proszę wprowadzić poprawne wartości");
					if (i == 0) {
						j--;
						break;
					}
					else {
						if (i != 0 && j == 0) {
							i--;
							j = szer2 - 1;
							break;
						}
					}
				}
					System.out.printf("% -9.2f", macierz2[i][j]);
			}
			System.out.println();
		}
		
	

	//menu obliczeñ
	while(true){
		int[] menuwejscie = new int[1];
		int correct5 = 0;
		while(correct5==0){
			try 	{
				System.out.println("\nWybierz dzia³anie, które chcesz wykonaæ: \n1  - dodawanie\n2  - odejmowanie macierzy drugiej od pierwszej\n3  - odejmowanie macierzy pierwszej od drugiej\n4  - mno¿enie macierzy pierwszej razy drug¹\n5  - mno¿enie macierzy drugiej razy pierwsz¹\n6  - mno¿enie macierzy pierwszej przez skalar\n7  - mno¿enie macierzy drugiej przez skalar\n8  - transpozycja macierzy pierwszej\n9  - transpozycja macierzy drugiej\n10 - wyznacznik macierzy pierwszej\n11 - wyznacznik macierzy drugiej\n12 - wyjœcie");
				Scanner scan5 = new Scanner(System.in);
				menuwejscie[0] = scan5.nextInt();
				if (menuwejscie[0] <= 0) {
					System.out.println("Proszê wprowadziæ poprawn¹ wartoœæ.");}
				correct5 = 1;
				if (correct5 == 1 ){break;}
				}
			catch(java.util.InputMismatchException e) 	{
			System.out.println("error");	
			correct5 = 0;  	}
		}	
		menu = menuwejscie[0];



		switch (menu) {
	//case1 - dodawanie
			case 1: if(wys1==wys2 && szer1==szer2) {
					for(i=0; i < wys1; i++) {
						for (j=0; j < szer1; j++) {
							wynik[i][j] = macierz1[i][j] + macierz2[i][j];			
							}
						}
					System.out.println("\nSuma macierzy 1 i 2 to macierz: ");
					for(i=0; i < wys1; i++) {
						for (j=0; j < szer1; j++) {
							System.out.printf("% -9.2f", wynik[i][j]);}
						System.out.println();
						}
					}
				else System.out.println("Macierze maj¹ ró¿ne wielkoœci. Nie mo¿na wykonaæ dzia³ania.");
				break;

	//case2 - odejmowanie macierzy drugiej od pierwszej
			case 2: if(wys1==wys2 && szer1==szer2) {
					for(i=0; i < wys1; i++) {
						for (j=0; j < szer1; j++) {
							wynik[i][j] = macierz1[i][j] - macierz2[i][j];			
							}
						}
					System.out.println("\nRó¿nica przy odejmowaniu drugiej macierzy od pierwszej to macierz: ");
					for(i=0; i < wys1; i++) {
						for (j=0; j < szer1; j++) {
							System.out.printf("% -9.2f", wynik[i][j]);}
						System.out.println();
						}
					}
				else System.out.println("Macierze maj¹ ró¿ne wielkoœci. Nie mo¿na wykonaæ dzia³ania.");
				break;
			
	//case3 - odejmowanie macierzy pierwszej od drugiej
			case 3: if(wys1==wys2 && szer1==szer2) {
					for(i=0; i < wys1; i++) {
						for (j=0; j < szer1; j++) {
							wynik[i][j] = macierz2[i][j] - macierz1[i][j];			
							}
						}
					System.out.println("\nRó¿nica przy odejmowaniu pierwszej macierzy od drugiej to macierz: ");
					for(i=0; i < wys1; i++) {
						for (j=0; j < szer1; j++) {
							System.out.printf("% -9.2f", wynik[i][j]);}
						System.out.println();
						}
					}
				else System.out.println("Nie mo¿na wykonaæ dzia³ania. Macierze maj¹ ró¿ne wielkoœci.");
				break;
			
	//case4	- mno¿enie macierzy pierwszej razy drug¹
			case 4: if(szer1==wys2) {
					for(i=0; i < wys1; i++) {
						for (j=0; j < szer2; j++) {
							for (int k=0; k < szer1; k++) {
								mnoz1[i][j] += macierz1[i][k] * macierz2[k][j];
								}
							}
						}
					System.out.println("\nIloczyn macierzy pierwszej i drugiej to macierz: ");
					for(i=0; i < wys1; i++) {
						for (j=0; j < szer2; j++) {
							System.out.printf("% -9.2f", mnoz1[i][j]);}
						
						System.out.println();
						}
					}
				else System.out.println("Nie mo¿na wykonaæ dzia³ania. Szerokoœæ macierzy pierwszej nie jest równa wysokoœci macierzy drugiej.");
				break;
				
	//case5	- mno¿enie macierzy drugiej razy pierwsz¹
			case 5: if(szer2==wys1) {
					for(i=0; i < wys2; i++) {
						for (j=0; j < szer1; j++) {
							for (int k=0; k < szer2; k++) {
								mnoz2[i][j] += macierz2[i][k] * macierz1[k][j];
								}
							}
						}
					System.out.println("\nIloczyn macierzy pierwszej i drugiej to macierz: ");
					for(i=0; i < wys2; i++) {
						for (j=0; j < szer1; j++) {
							System.out.printf("% -9.2f", mnoz2[i][j]);}
						
						System.out.println();
						}
					}
				else System.out.println("Nie mo¿na wykonaæ dzia³ania. Szerokoœæ macierzy drugiej nie jest równa wysokoœci macierzy pierwszej.");
				break;				
				
	//case6	- mno¿enie macierzy pierwszej przez skalar
			case 6: try	{
					System.out.println("\nWprowadŸ skalar.\nWartoœci nieca³kowite zapisz z u¿yciem kropki: ");
					while (check.nextToken()!=StreamTokenizer.TT_NUMBER) {
					System.out.print("Podaj poprawny skalar: "); }
					double a = check.nval;
		
					for(i=0; i < wys1; i++) {
						for (j=0; j < szer1; j++) {
							wynik[i][j] = macierz1[i][j] * a;
							}
						}
					System.out.println("\nWartoœci macierzy pierwszej pomno¿ej przez skalar to macierz: ");
					for(i=0; i < wys1; i++) {
						for (j=0; j < szer1; j++) {
							System.out.printf("% -9.2f", wynik[i][j]);}
						
						System.out.println();
						}
					}
				catch(IOException e) 	{
					System.out.println("error");	}				
				break;			

	//case7	- mno¿enie macierzy drugiej przez skalar
			case 7: try	{
					System.out.println("\nWprowadŸ skalar.\nWartoœci nieca³kowite zapisz z u¿yciem kropki: ");
					while (check.nextToken()!=StreamTokenizer.TT_NUMBER) {
					System.out.print("Podaj poprawny skalar: "); }
					double a = check.nval;
		
					for(i=0; i < wys2; i++) {
						for (j=0; j < szer2; j++) {
							wynik[i][j] = macierz2[i][j] * a;
							}
						}
					System.out.println("\nWartoœci macierzy drugiej pomno¿ej przez skalar to macierz: ");
					for(i=0; i < wys2; i++) {
						for (j=0; j < szer2; j++) {
							System.out.printf("% -9.2f", wynik[i][j]);}
						
						System.out.println();
						}
					}
				catch(IOException e) 	{
					System.out.println("error");	}				
				break;		

	//case8	- transpozycja macierzy pierwszej
			case 8: double[][] transpozycja = new double[szer1][wys1];
				for(i=0; i < wys1; i++) {
					for (j=0; j < szer1; j++) {
						transpozycja[j][i] = macierz1[i][j];
							}
						}	
				System.out.println("\nTranspozycja macierzy pierwszej to macierz: ");
				for(i=0; i < szer1; i++) {
					for (j=0; j < wys1; j++) {
						System.out.printf("% -9.2f", transpozycja[i][j]);}
					System.out.println();	
					}		
				break;		
		
	//case9	- transpozycja macierzy drugiej
			case 9: double[][] transpozycja2 = new double[szer2][wys2];
				for(i=0; i < wys2; i++) {
					for (j=0; j < szer2; j++) {
						transpozycja2[j][i] = macierz2[i][j];
							}
						}	
				System.out.println("\nTranspozycja macierzy drugiej to macierz: ");
				for(i=0; i < szer2; i++) {
					for (j=0; j < wys2; j++) {
						System.out.printf("% -9.2f", transpozycja2[i][j]);}
					System.out.println();	
					}		
				break;

	//case10 - wyznacznik macierzy pierwszej
			case 10: 
				if(wys1==szer1) {
					System.out.print("\nWyznacznik macierzy pierwszej wynosi: ");
					System.out.println(wyznacznikmacierz1(macierz1, wys1, szer1));
				}
				else {
					System.out.println("\nNie mo¿na wykonaæ dzia³ania. Macierz nie jest kwadratowa.");
				}
				break;	

	//case11 - wyznacznik macierzy drugiej
			case 11:
				if(wys2 == szer2){
					System.out.print("\nWyznacznik macierzy drugiej wynosi: ");
					System.out.println(wyznacznikmacierz2(macierz2, wys2, szer2));
				}	
				else{
					System.out.println("\nNie mo¿na wykonaæ dzia³ania. Macierz nie jest kwadratowa.");
				}
				break;

								
	//case12
			case 12: System.exit(0);	
			
			default:	System.out.println("\nProszê wprowadziæ poprawn¹ wartoœæ.");
					break;
		}
	
	
		}
	}
}