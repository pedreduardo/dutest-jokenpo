import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static ArrayList<Player> players = new ArrayList<Player>();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		JokenpoManager fm = new JokenpoManager();
		//Lendo os dados dos arquivos e inicia-se as rodadas
		fm.readRounds();
		//Divulgando os resultados
		fm.writeResults();

	}

}
