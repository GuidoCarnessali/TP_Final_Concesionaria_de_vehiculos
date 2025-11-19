package Manager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class OperacionLectoEscritura {

    //metodos


    public static void writeFile(String filename, JSONObject jsonObject) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(jsonObject.toString(4));
        } catch (IOException e) {
            System.err.println("Error escribiendo archivo JSON: " + filename);
            e.printStackTrace();
        }
    }


    public static void writeFile(String filename, JSONArray jsonArray) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(jsonArray.toString(4));
        } catch (IOException e) {
            System.err.println("Error escribiendo archivo JSON: " + filename);
            e.printStackTrace();
        }
    }


    public static JSONTokener readFile(String filename) {

        File file = new File(filename);

        try {

            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                fw.write("{}");
                fw.close();
            }


            if (file.length() == 0) {
                FileWriter fw = new FileWriter(file);
                fw.write("{}");
                fw.close();
            }

            return new JSONTokener(new FileReader(filename));

        } catch (IOException e) {
            System.err.println("Error leyendo archivo JSON: " + filename);
            e.printStackTrace();
        }

        return new JSONTokener("{}");
    }
}





