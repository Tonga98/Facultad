import java.util.Scanner;
public class TodoTp7 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        //Este algoritmo..

        //Declaracion de variables
        int[] arreglo;
        int numero, opcion;

        //Asignacion de variables y ejecucion
        System.out.println("Seleccione la opcion deseada:");
        System.out.println("1: Busqueda Sequencial");
        System.out.println("2: Busqueda Binaria");
        System.out.println("3: Ordenamiento por incersion");
        System.out.println("4: Ordenamiento seleccion");
        System.out.println("5: Ordenamiento por burbuja");
        System.out.println("6: Ordenamiento por burbuja mejorado");
        System.out.println("7: Ordenamiento por mergeSort (Todavia no anda)");
        System.out.println("8: Ordenamiento por quickSort");
        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                arreglo = cargarArreglo();
                System.out.println("Ingrese el numero a buscar");
                numero = sc.nextInt();
                System.out.println("El numero esta en la posicion: " + busSeq(arreglo, numero));
                break;
            case 2:
                arreglo = cargarArreglo();
                System.out.println("Ingrese el numero a buscar");
                numero = sc.nextInt();
                System.out.println("El numero esta en la posicion: " + busBin(arreglo, numero));
                break;
            case 3:
                arreglo = cargarArreglo();
                insercion(arreglo);
                System.out.println("El arreglo ordenado por insercion es: " + mostrarArreglo(arreglo));
                break;
            case 4:
                arreglo = cargarArreglo();
                seleccion(arreglo);
                System.out.println("El arreglo ordenado por seleccion es: " + mostrarArreglo(arreglo));
                break;
            case 5:
                arreglo = cargarArreglo();
                burbuja(arreglo);
                System.out.println("El arreglo ordenado por burbuja es: " + mostrarArreglo(arreglo));
                break;
            case 6:
                arreglo = cargarArreglo();
                burbujaMejorado(arreglo);
                System.out.println("El arreglo ordenado por burbuja mejorado es: " + mostrarArreglo(arreglo));
                break;
            case 7:
                arreglo = cargarArreglo();
                mergeSort(arreglo,0,arreglo.length-1);
                System.out.println("El arreglo ordenado por merge sort es: " + mostrarArreglo(arreglo));
                break;
            case 8:
                arreglo = cargarArreglo();
                quickSort(arreglo,0,arreglo.length-1);
                System.out.println("El arreglo ordenado por quick sort es: " + mostrarArreglo(arreglo));
                break;
        }
    }

    public static int busSeq(int[] arreglo, int numero) {             //Se puede aplicar en arreglos ordenados o desordenados.
        //Este modulo es un algoritmo de busqueda secuencial.         //Fuerza Bruta(Realiza busqueda exhaustiva)
        //arreglo: Se refiere al arreglo en el cual se buscara.
        //numero: Se refiere al numero que se desea buscar.

        //Declaracion de variables
        int i = 0, posicion = -1;
        boolean encontrado = false;

        //Asignacion de variables y ejecucion
        do {
            if (arreglo[i] == numero) {
                encontrado = true;
                posicion = i;
            } else {
                i++;
            }
        } while ((!encontrado) && (arreglo.length - 1 >= i));
        return posicion;
    }
    public static int busBin(int[] arreglo, int numero){          //Se aplica solo en arreglos ordenados.
        //Este modulo es un algoritmo de busqueda binaria.        //Disminuye y venceras.
        //arreglo: Se refiere al arreglo en el cual se buscara.
        //numero: Se refiere al numero que se desea buscar.

        //Declaracion de variables
        boolean encontrado = false;
        int medio, inicio = 0, fin = arreglo.length-1;

        //Asignacion de variables y ejecucion
        do {
            medio = (inicio + fin)/2;
            if (arreglo[medio] == numero){
                encontrado = true;
            }else{
                if (arreglo[medio] > numero){
                    fin = medio-1;
                }else{
                    inicio = medio+1;
                }
            }
        }while(!encontrado && inicio <= fin);
        return medio;
    }

    public static void insercion(int[] arreglo){
        //Este modulo es un algoritmo de ordenamiento por insercion
        //arreglo: Se refiere al arreglo el cual hay q ordenar

        //Declaracion de variables
        int posicion, j , numAComparar, longitud = arreglo.length;

        //Asignacion de variables y ejecucion
        for (posicion = 1; posicion < longitud; posicion++) {
            numAComparar = arreglo[posicion];
            j = posicion;
            while (j>0 && numAComparar < arreglo[j-1]){
                arreglo[j] = arreglo[j-1];
                j = j-1;
            }
            arreglo[j] = numAComparar;
        }
    }

    public static void seleccion(int[] arreglo){
        //Este modulo es un algoritmo de ordenamiento por seleccion
        //arreglo: Se refiere al arreglo a ordenar

        //Declaracion de variables
        int i,j,min, longitud = arreglo.length, aux;

        //Asignacion de variables y ejecucion
        for (i = 0; i < longitud-1; i++) {
            min = i;
            for (j = i+1; j < longitud; j++) {
                if (arreglo[j] < arreglo[min]){
                    min = j;
                }
            }
            aux = arreglo[i];
            arreglo[i] = arreglo[min];
            arreglo[min] = aux;
        }
    }

    public static void burbuja(int[] arreglo){
        //Este modulo es un algoritmo de ordenamiento por burbuja
        //arreglo: Se refiere al arreglo a ordenar

        //Declaracion de variables
        int i, j, longitud = arreglo.length-1, aux;

        //Asignacion de variables y ejecucion
        for (i = 0; i < longitud; i++) {
            for (j = 0; j < longitud - i; j++) {
                if (arreglo[j+1] < arreglo[j]){
                    aux = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = aux;
                }
            }
        }
    }

    public static void burbujaMejorado(int[] arreglo){
        //Este modulo es un algoritmo de burbuja mejorado
        //arreglo: Se refiere al arreglo a ordenar

        //Declaracion de variables
        int i=0, j, longitud = arreglo.length-1, aux;
        boolean cambio = false;

        //Asignacion de variables y ejecucion
        do {
            for (j = 0; j < longitud - i; j++) {
                if (arreglo[j+1] < arreglo[j]){
                    aux = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = aux;
                    cambio = true;
                }
            }
            i++;
        }while(i < longitud && cambio);
    }

   public static void mergeSort(int[] arreglo, int izq, int der){
       //Este modulo es un algoritmo mergeSort
       //arreglo: Se refiere al arreglo original a ordenar
       //izq: Se refiere al limite izquierdo del arreglo/sub arreglo
       //der: Se refiere al limite derecho del arreglo/sub arreglo

       //Declaracion de variables
       int centro;

       //Asignacion de variables y ejecucion
       if (izq < der){
           centro = (izq + der) / 2;
           mergeSort(arreglo, izq, centro);
           mergeSort(arreglo, centro+1, der);
           mezclar(arreglo, izq, centro, der);
       }
   }
   public static void mezclar(int[] arreglo, int limIzq,int centro, int limDer) {
       //Este modulo mezcla las mitades del arreglo ordenandolas de menor a mayor
       //arreglo: Se refiere al arreglo original a ordenar
       //izq: Se refiere a la posicion donde comienza el sub arreglo que se ordenara
       //centro: Se refiere a la posicion central del sub arreglo que se ordenara
       //der: Se refiere a la posicion final del sub arreglo que se ordenara

       //Declaracion de variables
       int posAuxIzq = limIzq, posAuxDer = centro+1,z = limIzq, i, numElementos = limDer - limIzq + 1;
       int [] arregloAux = new int[arreglo.length];

       //Asignacion de variables y ejecucion
       // Bucle Principal
       while (posAuxIzq <= centro && posAuxDer <= limDer) {
           if (arreglo[posAuxIzq] <= arreglo[posAuxDer]) {
               arregloAux[z++] = arreglo[posAuxIzq++];
           } else {
               arregloAux[z++] = arreglo[posAuxDer++];
           }
       }

       //Copia el resto de la primera mitad
       while (posAuxIzq <= centro) {
           arregloAux[z++] = arreglo[posAuxIzq++];
       }
       //Copia el resto de la segunda mitad
       while (posAuxDer <= limDer) {
           arregloAux[z++] = arreglo[posAuxDer++];
       }
       //Copia el arreglo temporal en el original
       i = 0;
       while (i < numElementos) {
           arreglo[limDer] = arregloAux[limDer];
           i++;
           limDer--;
       }
   }

    public static void quickSort(int[] arreglo, int izquierda, int derecha) {
        //Este modulo es un algoritmo de quickSort
        //arreglo: Se refiere al arreglo a ordenar
        //izq: Se refiere al limite izquierdo del arreglo
        //der: Se refiere al limite derecho del arreglo

        //Declaracion de variables
        int pivote;

        //Asignacion de variables y ejecucion
        if(izquierda < derecha) {
            pivote = particion(arreglo, izquierda, derecha);
            quickSort(arreglo, izquierda, pivote-1);
            quickSort(arreglo, pivote+1, derecha);
        }
    }
    public static int particion(int[] arreglo, int izquierda, int derecha) {
        //Este modulo coloca los elementos del arreglo que sean menor al pivote a su izquierda y los mayores al pivote a su derecha
        //arreglo: Se refiere al arreglo al cual se ordenara de acuerdo al pivote
        //izquierda: Se refiere al limite izquierdo a partir del cual se comenzaran a ordenar los valores y la posicion del pivote
        //derecha: Se refiere al limite derecho del cual se organizaran los valores

        //Declaracion de variables
        int pivote = arreglo[izquierda];

        //Asignacion de varaibles y ejecucion
        while (izquierda < derecha) {

            //Recorrido lado derecho
            while (izquierda < derecha && pivote <= arreglo[derecha]) {
                derecha--;
            }
             if (pivote >= arreglo[derecha]) {
                 intercambiar(arreglo, izquierda, derecha);
             }

            //Recorrido lado izquierdo
            while (izquierda < derecha && arreglo[izquierda] <= pivote) {
                izquierda++;
            }
             if (pivote <= arreglo[izquierda]) {
                 intercambiar(arreglo, izquierda, derecha);
             }
        }
        return izquierda;
    }
    private static void intercambiar(int[] arreglo, int a, int b) {
        //Este modulo intercambia dos valores del arreglo recibido
        //arreglo: Se refiere al arreglo del cual se intercambiaran dos valores
        //a: Se refiere al primer valor a cambiar
        //b: Se refiere al segundo valor a cambiar

        //Declaracion de variables
        int aux;

        //Asignacion de variables y ejecucion
        aux = arreglo[a];
        arreglo[a] = arreglo[b];
        arreglo[b] = aux;
    }

    public static int[] cargarArreglo(){
        Scanner sc = new Scanner(System.in);
        int j;
        int[] arreglo;
        System.out.println("Ingrese el largo del arreglo:");
        j = sc.nextInt();
        arreglo = new int[j];
        for (int i = 0; i < j; i++) {
            System.out.println("Elemento posicion "+i);
            arreglo[i] = sc.nextInt();
        }
        return arreglo;
    }
    public static String mostrarArreglo(int[] arreglo){
        //Este modulo muestra el arreglo recibido por parametro formal
        //arreglo: Se refiere al arreglo a mostrar.

        //Declaracion de variables
        int i, longitud = arreglo.length;
        String arregloAString="";

        //Asignacion de variables y ejecucion
        for (i = 0; i < longitud; i++) {
            arregloAString = arregloAString + arreglo[i];
        }
        return arregloAString;
    }
}

