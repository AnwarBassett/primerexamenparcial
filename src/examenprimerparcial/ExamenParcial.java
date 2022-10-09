package examenprimerparcial;
import java.util.*;
import java.util.Scanner;
public class ExamenParcial {
	public static void main(String[] args) {
		Scanner lec=new Scanner(System.in);
		char salida;
		int menu,  VU;
		double CA, VD,DA, VL, DPA;
		System.out.println("Bienvenido al sistema de depreciacion de la UNI"
				+ "\n ");
		do {
		do{System.out.println("Que metodo desea utilizar?  "
				+ "\n1. Metodo de linea"
				+ "\n2. Metodo de las unidades producidas"
				+ "\n3. Metodo de reduccion de saldo"
				+ "\n4. Metodo de la suma de los digitos por año"); 
        while(!lec.hasNextInt()){lec.next();System.out.println("Solo numeros puede ingresar");}
		menu=lec.nextInt();}while(menu<1 || menu>4);
		
		do{System.out.print("Por favor, Digite el valor del activo: ");
        while(!lec.hasNextInt()){lec.next();System.out.println("Solo numeros puede ingresar");}
		CA=lec.nextInt();}while(CA<1000 || CA>10000000);
		do{System.out.print("Digite el valor de desecho/residual: ");
        while(!lec.hasNextInt()){lec.next();System.out.println("Solo numeros puede ingresar");}
		VD=lec.nextInt();}while(VD<1000 || VD>10000000);
		do{System.out.print("Digite la vida util del activo: ");
        while(!lec.hasNextInt()){lec.next();System.out.println("Solo numeros puede ingresar");}
		VU=lec.nextInt();}while(VU<1 || VU>15);
		switch(menu) {
		
		case 1:
			DA=((CA-VD)/VU);
			VL=CA-DA;
			DPA=0;
			System.out.println("Costo del activo: C$"+CA
					+ "\nValor de Desecho/Residual: C$"+VD+""
					+ "\nVida Util: C$"+VU
					+ "\n ");
			    System.out.println("Depreciacion Anual | Depreciacion Acumulada | Valor Libros");
			    System.out.println("----------------------------------------------------------");
			 for(int i=1;i<=VU;i++) {
				DPA=DPA+DA;
				System.out.println(DA+"            | "+DPA+"                | "+VL);
				VL=VL-DA;
			 }
			break;
		case 2:
			  int []datos = new int[VU];
			  int suma=0;
			  double nw;
				System.out.println("Ingrese los valores de cada año de vida util");
				  for (int i = 0; i<VU; i++) {
					  System.out.print((i+1)+" Año: ");
				      while(!lec.hasNextInt()){lec.next();System.out.println("Solo numeros puede ingresar");}
					  datos[i] = lec.nextInt();
				  }
				  for (int i = 0; i < VU; i++) {
					  suma+= datos[i];
				  }
				  DA=(CA-VD)/suma;
				  System.out.println("+=================================================+");
					System.out.println("|Costo del activo:                      C$"+CA+"|"
							+ "\n|Valor de Desecho/Residual:             C$"+VD+"  |"
							+ "\n|Vida Util:                             "+VU+" Años    |"
							+ "\n|Vida util en unidades:                 C$"+suma+"  |"
							+ "\n|Depreciacion por unidad de produccion: C$"+DA+" |");
					System.out.println("+=================================================+");
					  VL=CA;
					  DPA=0;
					      System.out.println("Depreciacion Anual | Depreciacion Acumulada | Valor en libros ");
					      System.out.println("--------------------------------------------------------------");
					  for(int i=0;i<VU;i++) {
						  nw=datos[i]*DA;
						  VL=(VL-nw);
						  DPA=DPA+nw;
						  System.out.println("C$"+nw+"          | "+"C$"+DPA+"              | "+"C$"+VL);
					  }
			break;
		case 3:
			  double []datoss = new double[7];
			  int sumas=0;
			double VUA, DTD, TD;
			VUA=1.0/VU;
			DTD=VUA*2;
			TD=1-(Math.pow((VD/CA), VUA));
			System.out.println(TD);
			DA=((CA-VD)/VU);
			VL=CA;
			DPA=0;
			System.out.println("Costo del activo: C$"+CA
					+ "\nValor de Desecho/Residual: C$"+VD
					+ "\nVida Util: C$"+VU
					+ "\nTasa del doble saldo: "+DTD+"%");
		    System.out.println("Valor Libros  |Deprecion Anual   |Depresion Acumulada");
		    System.out.println("-----------------------------------------------------");
		    for(int i=0;i<=VU;i++) {
			     VL=VL-DPA;
			     DPA=VL*DTD;
			     datoss[i]=DPA;
			     sumas+= datoss[i];
			     System.out.println(Math.round(VL)+"        | "+Math.round(DPA)+"            | "+Math.round(sumas));
		    }
			
			break;
		case 4:
			int NVU;
			do{System.out.println("Por favor, Digite el valor del activo");
			CA=lec.nextInt();}while(CA<1000 || CA>1000000);
			do{System.out.println("Digite el valor de desecho/residual");
			VD=lec.nextInt();}while(VD<1000 || VD>1000000);
			do{System.out.println("Digite la vida util del activo");
			VU=lec.nextInt();}while(VU<1 || VU>20);
		    int i,suma,fraccion;  
		    suma=0;
				  for(i=0;i<=VU;i++){    
				      suma=suma+i;    
				  }    

				    DA=(((CA-VD)*VU)/suma);
					System.out.println("Costo del activo: C$"+CA
							+ "\nValor de Desecho/Residual: C$"+VD+""
							+ "\nVida Util: C$"+VU+""
							+ "\nDepresiacion Anual: C$"+DA);
					NVU=VU;
					 for(int j=1;j<=VU;j++) {
					    VL=CA-DA;
					    DA=(((VL-VD)*NVU)/suma);
             System.out.println(j+". Depreciacion Anual="+DA+" | Valor en libros="+VL);
                        NVU=VU-1;
						VL=VL-DA;
					 }
		    
		    
		    
		    
			break;
		}

	}
}
