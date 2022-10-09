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
		VD=lec.nextInt();}while(VD<0 || VD>10000000);
		do{System.out.print("Digite la vida util del activo: ");
        while(!lec.hasNextInt()){lec.next();System.out.println("Solo numeros puede ingresar");}
		VU=lec.nextInt();}while(VU<1 || VU>20);
		
		switch(menu) {
		
		case 1:
			if(VD==0) {
				DA=(CA/VU);
			}else {
				DA=((CA-VD)/VU);
			}
			VL=CA-DA;DPA=0;
			System.out.println("+===============================+"
					+ "\nCosto del activo: C$"+CA
					+ "\nValor de Desecho/Residual: C$"+VD+""
					+ "\nVida Util: C$"+VU
					+ "\nCuota de Amortizacion: C$"+DA
					+ "\n+===============================+"
					+ "\n");
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
					if(VD==0) {
						DA=(CA/suma);
					}else {
						DA=(CA-VD)/suma;
					}
				  System.out.println("+=================================================+");
					System.out.println("Costo del activo:                      C$"+CA+""
							+ "\nValor de Desecho/Residual:             C$"+VD+"  "
							+ "\nVida Util:                             "+VU+" Años    "
							+ "\nVida util en unidades:                 C$"+suma+"  "
							+ "\nDepreciacion por unidad de produccion: C$"+DA+" ");
					System.out.println("+=================================================+"+"\n");
					  VL=CA;DPA=0;
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
			double VUA, DTD;
			VUA=1.0/VU;
			DTD=VUA*2;
			VL=CA;DPA=0;
			System.out.println("+=====================================+"
					+ "\nCosto del activo: C$"+CA
					+ "\nValor de Desecho/Residual: C$"+VD
					+ "\nVida Util: C$"+VU
					+ "\nTasa del doble saldo: "+DTD+"%"
					+ "\n+=====================================+");
		    System.out.println("Deprecion Anual   |Depresion Acumulada  |Valor Libros");
		    System.out.println("-----------------------------------------------------");
		    for(int i=0;i<=VU;i++) {
			     VL=VL-DPA;
			     DPA=VL*DTD;
			     datoss[i]=DPA;
			     sumas+= datoss[i];
			     System.out.println(Math.round(DPA)+"             | "+Math.round(sumas)+"               | "+Math.round(VL));
		    }
			
			break;
		case 4:
			double NVU, IM, sumatoria, fraccion;
			 sumatoria=0;
	for (int i=VU;i>0;i--){
	    sumatoria=sumatoria+i;
	}
	if(VD==0) {
		IM=(CA);
	}else {
		IM=CA-VD;
	}
		fraccion=(Math.round((VU/sumatoria) * 10000d) / 10000d);
		System.out.println("+=====================================+"
				    + "Costo del activo: C$"+CA
					+ "\nValor de Desecho/Residual: C$"+VD+""
					+ "\nVida Util: C$"+VU
					+"\n+=====================================+");
		NVU=VU;VL=CA;DPA=0;
		System.out.println("Fraccion | Importe depreciable | Depr. Anual | Depr. Acumulada | Valor Libros");
	for(int j=1;j<=VU;j++) {
		fraccion=(Math.round((NVU/sumatoria) * 10000d) / 10000d);
		NVU=NVU-1;
		DA=Math.round(IM*fraccion);
		DPA=DPA+DA;
		VL=VL-DA;
		System.out.println((NVU+1)+"/"+sumatoria+" |"+IM+"             |"+DA+"      |"+DPA+"          |"+VL); 
	}
			break;
		}
		System.out.println("\n"
		+"Desea usar otro metodo y/o ingresar nuevos datos?(S/N)");
		salida=lec.next().charAt(0);
	}while(salida=='s' || salida=='S');
		lec.close();


	}
}
