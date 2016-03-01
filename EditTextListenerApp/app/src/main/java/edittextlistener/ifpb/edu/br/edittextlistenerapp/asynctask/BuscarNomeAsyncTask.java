package edittextlistener.ifpb.edu.br.edittextlistenerapp.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.util.HttpService;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.util.Response;

/**
 * Created by Rhavy on 24/02/2016.
 */
public class BuscarNomeAsyncTask extends AsyncTask<JSONObject, Void, Response> {





    @Override
    protected Response doInBackground(JSONObject... jsons) {

        Response response = null;

        JSONObject json = jsons[0];
        Log.i("EditTextListener", "doInBackground (JSON): " + json);

        try {

            response = HttpService.sendJSONPostResquest("get-byname", json);

        } catch (IOException e) {

            Log.e("EditTextListener", e.getMessage());
        }

        return response;

    }

    @Override
    protected void onPostExecute(Response response) {

        String nome = null;
        List <String> nomes = new ArrayList <String>();

        int cont = 0;

        try{

            JSONArray InfJsonArray = new JSONArray(response.getContentValue());

            for (cont = 0; cont < InfJsonArray.length(); cont++ ){

                JSONObject JObject = new JSONObject(InfJsonArray.getString(cont));
                nome = JObject.getString("fullName");
                nomes.add(nome);
                cont++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
