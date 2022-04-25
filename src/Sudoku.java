import java.util.ArrayList;

public class Sudoku {
    private int[][] cuadricula;

    public Sudoku(){

    }
    public Sudoku (int[][] cuadricula){
        this.cuadricula=cuadricula;



    }

    @Override
    public String toString() {
        StringBuilder imprimible= new StringBuilder("+-------+-------+-------+\n");
        String cActual;

        int contador=0,contadorj=0;
        for (int[] ints : cuadricula) {
            imprimible.append("|");
            for (int anInt : ints) {
                if (anInt == 0) {
                    cActual = " .";
                } else {
                    cActual = " " + anInt;
                }
                imprimible.append(cActual);

                contadorj++;
                if (contadorj == 3) {
                    imprimible.append(" |");
                    contadorj = 0;
                }

            }
            imprimible.append("\n");
            contador++;
            if (contador == 3) {
                imprimible.append("+-------+-------+-------+\n");
                contador = 0;
            }
        }
        return imprimible.toString();
    }

    private boolean resuelto() {
        boolean resuelto=true;
        int i =0,j=0;
        while(resuelto&&i<cuadricula.length){
            j=0;
            while(resuelto&&j<cuadricula[i].length){
                resuelto=cuadricula[i][j]!=0&&unicoEnCasilla(cuadricula[i][j], i,j);
                j++;
            }
            i++;
        }
        return resuelto;
    }

    private boolean unicoEnCasilla(int numero, int i, int j) {
        return unicoEnVertical( numero,  i,  j)&&unicoEnHorizontal( numero,  i,  j)&&unicoEnCuadrado( numero,  i,  j);
    }

    private boolean unicoEnHorizontal(int numero, int i, int j) {
        boolean unicoHorizontal=true;
        int k = 0;
        while(unicoHorizontal&&k < 9){

            if(k!=j){
            unicoHorizontal=numero!=cuadricula[i][k];
            }
            k++;
        }

        return unicoHorizontal;
    }

    private boolean unicoEnVertical(int numero, int i, int j) {
        boolean unicoVertical=true;
        int k = 0;
        while(unicoVertical&&k < 9){

            if(k!=i){
                unicoVertical=numero!=cuadricula[k][j];
            }
            k++;
        }

        return unicoVertical;
    }

    private boolean unicoEnCuadrado(int numero, int i, int j) {
        boolean unicoCuadrado=true;

        int empiezai=i-i%3, empiezaj=j-j%3;
        int k = empiezai;
        while(unicoCuadrado&&k <empiezai+3 ){
            int l = empiezaj;
            while (unicoCuadrado&& l < empiezaj+3){

                if(k!=i&&l!=j){
                    unicoCuadrado=numero!=cuadricula[k][l];
                }

                l++ ;
            }
            k++;
        }

        return unicoCuadrado;
    }

    public void resolverBactraking() {

        resolverBactrakingAux(new Booleano(false));
    }
    public void resolverBactrakingAux(Booleano exito) {

        if (resuelto()) {
            exito.setValor(true);
        } else {

            for (int i = 0; i <9 ; i++) {
                for (int j = 0; j <9 ; j++) {
                    for (int k = 1; k < 10; k++) {

                        if (cuadricula[i][j]==0&& unicoEnCasilla(k,i,j)){

                            cuadricula[i][j]=k;
                            System.out.println("numero: "+k+" i: "+i+" j: "+j+"\n"+this);
                            resolverBactrakingAux(exito);
                            if (!exito.getValor()) {
                                cuadricula[i][j]=0;
                            }

                        }
                        if(cuadricula[i][j]!=0){
                            k=11;

                        }else if(k==9){
                            j=11;
                            i=11;
                        }
                    }
                }
            }

        } /*else*/

    }
}

