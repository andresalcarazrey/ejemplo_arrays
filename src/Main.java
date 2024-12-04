import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        double notasProg[];
        //int n = leerValorNum(1,100,"tamaño array");
        int opcion=-1;
        notasProg = new double[100];

        do {
            mostrarMenu();
            opcion = leerValorNum(0,6,"Opción:");
            realizaTrabajo(opcion,notasProg);
        } while (opcion!=0);

    }

    public static void mostrarMenu() {
        System.out.println("Ejemplo de trabajo con arrays");
        System.out.println("0. Salir");
        System.out.println("1. Inicializar una sola posición");
        System.out.println("2. Inicializar todo el array");
        System.out.println("3. Mostrar suma total");
        System.out.println("4. Buscar y contar un determinado rango de valores");
        System.out.println("5. Mostrar el valor de una posición");
        System.out.println("6. Mostrar un rango de posiciones");
    }

    public static void realizaTrabajo(int iOpcion, double[] lista) {
        switch (iOpcion) {
            case 1: inicializaPosicion(lista);
            break;
            case 2: inicializaTodo(lista);
            break;
            case 3: mostrarSuma(lista);
            break;
            case 4: encontrarRangoValores(lista);
            break;
            case 5: muestraPosicion(lista);
            break;
            case 6: mostrarRango(lista);
            break;
            case 0: return;
            default:
                System.out.println("Opción no programada");
        }
    }

    public static String leerValor(String nombreValor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el " + nombreValor + ":");
        return sc.nextLine();
    }


    public static int leerValorNum(int iMin, int iMax, String sValor) {
        Scanner sc = new Scanner(System.in);
        if (iMin>iMax) return 0;
        int valor;
        do {
            System.out.println("Introduzca " + sValor + ":");
            valor = sc.nextInt();
        } while(valor < iMin || valor > iMax);
        return valor;
    }

    public static double leerDoubleValor() {
        Scanner sc = new Scanner(System.in);
        double dValor;
        dValor = sc.nextDouble();
        return dValor;
    }

    //Funciones de trabajo del menú
    public static void inicializaPosicion(double[] lista) {
        System.out.println("Introduzca el valor:");
        double dValor = leerDoubleValor();
        int iPos = leerValorNum(0, lista.length-1,"Posición");
        lista[iPos] = dValor;

    }

    public static void inicializaTodo(double[] lista) {
        double dValorInicial;
        System.out.println("Introduzca el valor de formateo:");
        dValorInicial = leerDoubleValor();
        for(int i=0;i< lista.length;i++) {
            lista[i] = dValorInicial;
        }
        System.out.println("Formateo con éxito, " + lista.length + " elementos asignados");
    }

    public static void mostrarSuma(double[] lista) {
        double dTotal=0.0;
        for(int i=0;i< lista.length;i++) {
            dTotal+=lista[i];
        }
        System.out.println("El total es: " + dTotal + " . Hemos sumado " + lista.length + " valores");
    }


    public static void  encontrarRangoValores(double[] lista) {
        double dMin, dMax;
        System.out.println("Valor mínimo:");
        dMin = leerDoubleValor();
        System.out.println("Valor máximo:");
        dMax = leerDoubleValor();
        int contador = 0;

        for(int i=0;i<lista.length;i++) {
            //si el elemento de la posición i está en el rango, contador++
            if(lista[i] >= dMin && lista[i]<=dMax) {
                contador++;
            }
        }

        System.out.println("Tenemos entre el " + dMin + " y el " + dMax + ": " + contador + " valor/es");

    }

    public static void mostrarRango(double[] lista) {
        System.out.println("Introduzca el inicio del rango:");
        int iIni = leerValorNum(0,lista.length,"Posición");
        System.out.println("Introduzca el final del rango:");
        int iFin = leerValorNum(0,lista.length,"Posición");

        for(int i=iIni;i<iFin;i++) {
            System.out.println("Posición " + i + " == " + lista[i]);
        }
    }

    public static void muestraPosicion(double[] lista) {
        System.out.println("Introduzca la posición");
        System.out.println("EL valor es: " + lista[leerValorNum(0,lista.length-1,"Posición")]);
    }
}