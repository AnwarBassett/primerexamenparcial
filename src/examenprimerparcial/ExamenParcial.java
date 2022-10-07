package examenprimerparcial;
import java.util.*;
public class ExamenParcial {
	public static void main(String[] args) {
		Scanner lec=new Scanner(System.in);
		int menu;
		System.out.println("Bienvenido al sistema de depreciacion de la UNI");
		System.out.println("Que metodo desea utilizar?  "
				+ "\n1. Metodo de linea"
				+ "\n2. Metodo de la suma de los digitos por año"
				+ "\n3. Metodo de las unidades producidas"
				+ "\n4. Metodo de reduccion de saldo"); 
		menu=lec.nextInt();
		switch(menu) {
		case 1:
			int CA, VD, VU, i;
			double DA, VL, DPA;
			System.out.println("Por favor, Digite el valor del activo");
			CA=lec.nextInt();
			System.out.println("Digite el valor de desecho/residual");
			VD=lec.nextInt();
			System.out.println("Digite la vida util del activo");
			VU=lec.nextInt();
			
			DA=((CA-VD)/VU);
			VL=CA-DA;
			DPA=0;
			System.out.println("Costo del activo: C$"+CA
					+ "\nValor de Desecho/Residual: C$"+VD+""
					+ "\nVida Util: C$"+VU+""
					+ "\nDepresiacion Anual: C$"+DA);
			
			 for(i=1;i<=VU;i++) {
				DPA=DPA+DA;
				System.out.println(i+". Depreciacion Acumulada="+DPA+" | Valor en libros="+VL);
				VL=VL-DA;
			 }
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}

	}
}
