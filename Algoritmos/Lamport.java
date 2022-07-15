import java.util.Arrays;

public class Lamport {

    public static void main(String[] args) {
        // Proceso 1:   P1          P2          P3          P4          P5
        //                           \
        //                              \
        //                                \
        // Proceso 2:   P1     P2       P3          P4          P5
        //                                                       \
        //                                                           \
        //                                                            \
        // Proceso 3:   P1        P2         P3          P4            P5
        //Iniciando Procesos
        int proceso1[] = {0, 0, 0, 0, 0};
        int proceso2[] = {0, 0, 0, 0, 0};
        int proceso3[] = {0, 0, 0, 0, 0};
        
        //Asignacion valores al proceso 1
        for (int i = 0; i < 5; i++) {
            proceso1[i] = i + 1;
        }
        
        //Asignacion valores al proceso 2
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                if (proceso1[i - 1] > proceso2[i - 1]) {
                    proceso2[i] = proceso1[i - 1] + 1;
                } else {
                    proceso2[i] = i + 1;
                }
            } else {
                proceso2[i] = i + 1;
            }

        }

        //Asignacion valores al proceso 3
        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                if (proceso2[i] > proceso3[i - 1]) {
                    proceso3[i] = proceso2[i] + 1;
                } else {
                    proceso3[i] = i + 1;
                }
            } else {
                proceso3[i] = i + 1;
            }

        }

        //Presentacion de proceso con sus valores
        System.out.print("Proceso 1 valores: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(proceso1[i] + " ");
        }
        System.out.println("");
        System.out.print("Proceso 2 valores: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(proceso2[i] + " ");
        }
        System.out.println("");
        System.out.print("Proceso 3 valores: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(proceso3[i] + " ");
        }
        System.out.println("");
        
        double proceso1Ord = 0.1;
        double proceso2Ord = 0.2;
        double proceso3Ord = 0.3;
        
        double proceso1Aux[] = {0.0, 0.0, 0.0, 0.0, 0.0};
        double proceso2Aux[] = {0.0, 0.0, 0.0, 0.0, 0.0};
        double proceso3Aux[] = {0.0, 0.0, 0.0, 0.0, 0.0};
        double procesosOrdenados[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        
        //asignando valores #.# para luego ordenar
        for (int i = 0; i < 5; i++) {
            proceso1Aux[i] = proceso1[i] + proceso1Ord;
            proceso2Aux[i] = proceso2[i] + proceso2Ord;
            proceso3Aux[i] = proceso3[i] + proceso3Ord;
        }
        int j = 0, k = 0;
        
        //Asignando todos los valores a un solo arreglo
        for (int i = 0; i < 15; i++) {
            
            if (i >= 0 && i < 5) {
                procesosOrdenados[i] = proceso1Aux[i];
            }else if (i >= 5 && i < 10) {
                procesosOrdenados[i] = proceso2Aux[k];
                k++;
            }else if (i >= 10 && i < 15) {
                procesosOrdenados[i] = proceso3Aux[j];
                j++;
            }
        }
        //Ordenando de menor a mayor
        Arrays.sort(procesosOrdenados);
        
        //Presentar Arreglo Ordenado
        System.out.print("Procesos ordenados valores: ");
        for (int i = 0; i < 15; i++) {
            System.out.print(procesosOrdenados[i] + " | ");
        }
    }
}
