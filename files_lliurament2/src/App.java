import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class App {

    public static void main(String[] args) throws Exception {

        //TODO Crear un fitxer amb la classe File
        //el nom del fitxer serà testfile.html


        String str = urlReader("http://inslaguineueta.cat");

        //TODO cridar la funció perquè guardi str al fitxer
        //nuevo archivo para guardar los datos en texto
        File file = new File("files_lliu2.out");
        //usamos esta funcion para guardar el contenido de "str" en file y eliminando lo anterior
        saveToFile(str,file,false);

        //TODO LLegir el contingut del fitxer i imprimir-lo
        //per pantalla.
        //usamos esta funcion para leer el contenido de file y mostrarlo por pantalla
        System.out.println(readFromFile(file));;
    }

    static String readFromFile(File file) throws IOException {
        //TODO usant FileReader i BufferedReader
        //crea un File reader para leer el archivo
        FileReader fr = new FileReader(file);
        //crea un BufferedReader
        BufferedReader bufr = new BufferedReader(fr);
        //crea un StringBuilder
        StringBuilder sb = new StringBuilder();
        //creamos estoe string para guardar lineas
        String line;
        //mientras line no sea null esto se ejecutara
        while((line = bufr.readLine()) != null){
            //agregamos la linea a sb
            sb.append(line);
        }
        //cerramos bufr
        bufr.close();
        //hacemos return a sb convertido en string
        return sb.toString();
    }

    static void saveToFile(String str, File file, boolean append)
            throws IOException {
        //TODO usant FileWriter i BufferedWriter
        //crea un FileWriter para escribir en el archivo fw
        FileWriter fw = new FileWriter(file, append);
        //crea un BufferedWriter para escribir en el archivo fw
        BufferedWriter bufw = new BufferedWriter(fw);
        //se añade la linea o el string al bufw
        bufw.write(str);
        //cerramos el bufw
        bufw.close();
    }

    public static String urlReader(String url) throws Exception {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();
            return sb.toString();
    }

}

