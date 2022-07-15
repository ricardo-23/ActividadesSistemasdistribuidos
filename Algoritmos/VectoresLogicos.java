public class VectoresLogicos {

    public static void main(String[] args) {
        // Proceso 1:   P1          P2          P3          P4          P5
        //                           \
        //                              \
        //                                \
        // Proceso 2:   P1                 P2       P3          P4          P5
        //                                                                    \
        //                                                                     \
        //                                                                      \
        // Proceso 3:   P1        P2         P3          P4                      P5
        //Iniciando Procesos
        int proceso1[][] = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
        int proceso2[][] = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
        int proceso3[][] = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
        
        //Asignacion valores a los vectores del proceso 1
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                proceso1[i][0] = i + 1;
            }
        }
        
        //Asignacion valores a los vectores del proceso 2
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==1){
                    for (int k = i; k < 5; k++) {
                        proceso2[k][0] = proceso1[i][0];
                    }
                        proceso2[i][1] = i+ 1;
                }else{
                    proceso2[i][1] = i + 1;
                }
                
            }
        }
        
        //Asignacion valores a los vectores del proceso 3
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==4){
                    for (int k = i; k < 5; k++) {
                        proceso3[k][0] = proceso2[i][0];
                        proceso3[k][1] = proceso2[i][1];
                    }
                        proceso3[i][2] = i + 1;
                }else{
                    proceso3[i][2] = i + 1;
                }
                
            }
        }
        
        //Presentacion de los vectores del proceso 1
        System.out.print("P1: ");
        for (int i = 0; i < 5; i++) {
            System.out.print("{");
            for (int j = 0; j < 3; j++) {
                if(j == 2){
                    System.out.print(""+proceso1[i][j]);
                }else{
                    System.out.print(""+proceso1[i][j]+",");
                }
                
            }
            System.out.print("}");
            System.out.print(" | ");
        }
        System.out.println("");
        
        //Presentacion de los vectores del proceso 2
        System.out.print("P2: ");
        for (int i = 0; i < 5; i++) {
            System.out.print("{");
            for (int j = 0; j < 3; j++) {
                if(j == 2){
                    System.out.print(""+proceso2[i][j]);
                }else{
                    System.out.print(""+proceso2[i][j]+",");
                }
            }
            System.out.print("}");
            System.out.print(" | ");
        }
        System.out.println("");
        
        //Presentacion de los vectores del proceso 3
        System.out.print("P3: ");
        for (int i = 0; i < 5; i++) {
            System.out.print("{");
            for (int j = 0; j < 3; j++) {
                if(j == 2){
                    System.out.print(""+proceso3[i][j]);
                }else{
                    System.out.print(""+proceso3[i][j]+",");
                }
            }
            System.out.print("}");
            System.out.print(" | ");
        }
        System.out.println("");
        
    }
    
}
