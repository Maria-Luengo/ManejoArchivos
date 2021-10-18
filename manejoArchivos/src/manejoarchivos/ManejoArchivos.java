package manejoarchivos;

/*import java.io.File;
import java.io.PrintWriter;*/
import java.io.*;

public class ManejoArchivos {
    
    //Métodos CRUD de forma estática
    
    //1. CREAR
    public static void crearArchivo(String nombreArchivo) {
        //1) Declaramos obj de tipo archivo
        //Constructor con argumento que es el nombre del archivo, si no creo try catch me avisa el editor
        var archivo = new File(nombreArchivo);
        try {
            //2) creamos el archivo y cerramos
            var salida = new PrintWriter(archivo); //método para escribir
            // Ya está crado el archivo
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException e) { //si no está el fichero
            e.printStackTrace(System.out); //excepcion para 
        }
    }

    //2. ESCRIBIR, es = que el de crear
    //la clase PrintWriter abre un puntero a mi fichero
    public static void escribirArchivo(String nombreArchivo, String contenido) {
        //Declarar objeto tipo File
        var archivo = new File(nombreArchivo); //File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close(); //cierro mi fichero
            System.out.println("Se ha escrito el contenido en el archivo");
        } catch (FileNotFoundException e) { //si no está el fichero
            e.printStackTrace(System.out);
        }
    }

    //3. AGRAGAR ARCHIVO
    public static void agregarArchivo(String nombreArchivo, String contenido) {
        //Declaramos obj tipo File
        File archivo = new File(nombreArchivo);
        try {
            //Invocamos al FileWriter para poder anexar la información y no spobreeescribir
            PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, true));
            //true xa que anaxe info
            salida.println(contenido);
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) { //excepciones de E/S (lectura y escritura)
            e.printStackTrace(System.out);
        }
    }

    //4. LEER 
    public static void leerArchivo(String nombreArchivo) {
        var archivo = new File(nombreArchivo);
        try {
            //entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));//Buffer permite leer una l´´inea, por eso le añado el FileReader(para leer todo)
            var lectura = entrada.readLine(); //devuelve la primera línea
            while (lectura != null) {//Bucle while para recorrer todasd las líneas
                //Mostramos cada línea
                System.out.println("lectura = " + lectura);
                //Avanzamos en la lectura
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);

        } catch (IOException e) { //excepciones de E/S (lectura y escritura)
            e.printStackTrace(System.out);
        }
    }
}
