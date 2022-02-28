package net.arcano.arcana2plus.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class JsonGenerator {

    public static Config readConfig(){
        Gson gson = new Gson();
        Config config = new Config();

        try(Reader reader = new FileReader("..\\run\\config\\arcanaplusplus.json")){
            config = gson.fromJson(reader, Config.class);
        }catch (IOException e){
            System.out.println("Arquivo de configuração não encontrado");
            createConfig();
            System.out.println("Arquivo de configuração criado");
        }

        return config;
    }

    public static void createConfig(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Config config = new Config();
        String json = gson.toJson(config);

        try(FileWriter writer = new FileWriter("..\\run\\config\\arcanaplusplus.json")){
            gson.toJson(config, writer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
