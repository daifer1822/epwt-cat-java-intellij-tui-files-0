import java.io.*;
import java.util.Arrays;

public class    App {

    public static void main(String[] args) throws IOException{
        //Creem l'array d'estudiants:
        Student students[] = init();

        File file = new File("students.out");

        String message = "Llista desordenada:";

        //Imprimeix tots els estudiants
        //de forma desordenada
        printStudents(students, message);

        //TODO Guardar la llista d'estudiants al fitxer students.out
        saveToFile(students,"!Agregando a un fichero!",file,false);


        //TODO Torna a imprimir la llista d'estudiants
        //però ara llegint-la del fitxer students.out
        //uso un funcion para pasar de texto a objetos y luego imprimirlos
        printStudents(converStudent(file), message);
    }

    static String readFromFile(File file) throws IOException{
        //TODO Implementar usant FileReader
        //Creamos un file reader para leer "file"
        FileReader fw = new FileReader(file);
        int c  = fw.read();
        //guarda los caracteres en un string
        String contents = "";
        //while para recorrer el archivo y recuperar los caracteres del string
        while(c != -1) {
            //Cal fer cast de int a char i concatenem pera formar un String al final
            contents += (char)c;
            c = fw.read(); //llegim el siguiente caràcter

        }
        fw.close();
        //No podeu usar BufferedReader
        return contents;
    }

    static void saveToFile(Student[] students, String message,
                           File file, boolean append)
            throws IOException {
        //TODO Implementar usant FileWriter
        System.out.println(message);
        //Creamos un FileWriter para escribir en el archivo
        //El booleano como segundo parámetro significa:
        //true: lo que escribimos se añadirá a los contenidos ya existentes
        //false: lo que escribimos sustituirá a los contenidos ya existentes
        //Crea un enlace a un archivo para modificarlo
        FileWriter fw = new FileWriter(file, append);
        //Convierto una lista en un string para luego agregarla al archivo
        //agrega el contenido al archivo

        for (int i = 0; i < students.length; i += 1 ){

            fw.write(String.valueOf(students[i] + "\n"));

        }

        //cierra el archivo, para terminar las modificaciones
        fw.close();
        //No podeu usar BufferedWriter
    }

    //Mètode que imprimeix la llista d'estudiants
    //Delega la creació de l'String al mètode
    //buildStudentListString

    static Student[] converStudent(File file) throws IOException {

        //guarda el string con los datos
        String data = readFromFile(file);
        //elimino esto del string "[]" para hacer un split
        data = data.substring(1, data.length() - 1);
        //Creo un array de strings plara un split
        String[] lines = data.split("\n");
        //Creo un array de students para guardar los estudiantes
        Student[] tempStudent = new Student[lines.length];

        //bucle para conseguir cada linea con los valores de los estudiantes
        for (int i = 0; i < lines.length ; i += 1 ){
            //guarda la linea en la que esta
            String[] parts = lines[i].split("\\s+");
            //crea un studiante para añadir sus valores
            Student s0 = new Student();
            //añade el nombre
            s0.name = parts[1];
            //añade la edad
            s0.age = Integer.parseInt(parts[3]);
            //añade las materias
            s0.amountOfEnrolledSubjects = Integer.parseInt(parts[5]);
            //lo añade a la array de estudiantes
            tempStudent[i] = s0;

        }

        //lo añade a la array de estudiantes
        return tempStudent;
    }

    static void printStudents(Student [] students,
                              String message){
        System.out.println(buildListString(students, message));
    }

    //Mètode que genera un String amb la llista d'estudiants
    static String buildListString(Student[] students, String message){
        StringBuffer sb = new StringBuffer();
        sb.append("\n****");
        sb.append(" ");
        sb.append(message);
        sb.append("\n");
        for(Student s: students){
            sb.append(s.toString());
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    //Mètode que genera un array d'estudiants
    static public Student[] init() {

        Student students[] = new Student[10];

        Student s0 = new Student();
        s0.name = "Laura";
        s0.age = 25;
        s0.amountOfEnrolledSubjects = 6;
        students[0] = s0;

        Student s1 = new Student();
        s1.name = "Joan";
        s1.age = 29;
        s1.amountOfEnrolledSubjects = 7;
        students[1] = s1;

        Student s2 = new Student();
        s2.name = "Carme";
        s2.age = 38;
        s2.amountOfEnrolledSubjects = 4;
        students[2] = s2;

        Student s3 = new Student();
        s3.name = "Oriol";
        s3.age = 21;
        s3.amountOfEnrolledSubjects = 9;
        students[3] = s3;

        Student s4 = new Student();
        s4.name = "Sergi";
        s4.age = 36;
        s4.amountOfEnrolledSubjects = 7;
        students[4] = s4;

        Student s5 = new Student();
        s5.name = "Laia";
        s5.age = 31;
        s5.amountOfEnrolledSubjects = 5;
        students[5] = s5;

        Student s6 = new Student();
        s6.name = "Abril";
        s6.age = 41;
        s6.amountOfEnrolledSubjects = 4;
        students[6] = s6;

        Student s7 = new Student();
        s7.name = "Jordi";
        s7.age = 30;
        s7.amountOfEnrolledSubjects = 7;
        students[7] = s7;

        Student s8 = new Student();
        s8.name = "Carla";
        s8.age = 32;
        s8.amountOfEnrolledSubjects = 6;
        students[8] = s8;

        Student s9 = new Student();
        s9.name = "Ritxi";
        s9.age = 28;
        s9.amountOfEnrolledSubjects = 3;
        students[9] = s9;

        return students;
    }
}

