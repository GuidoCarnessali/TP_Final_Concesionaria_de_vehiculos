package Manager;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OperacionLectoEscritura {

    public void writeFile(String filename, JSONObject jsonObject) {

        try{

            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(jsonObject.toString(4));
            fileWriter.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONTokener readFile (String filename)
    {
        JSONTokener jsonTokener = null;

        try{
            jsonTokener = new JSONTokener(new FileReader(filename));
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        return jsonTokener;
    }




}
