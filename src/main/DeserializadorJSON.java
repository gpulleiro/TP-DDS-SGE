
public class DeserializadorJSON {

	//metodos
	
	public void deserializar (Object objeto) throws IOException {
		Gson gson = new Gson();
		InputStream is = GsonTes.class.getClassLoader().getResourceAsStream("json.txt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
		objeto nuevo = gson.fromJson(bufferedReader, objeto.class);
		bufferresReader.close();
		
	}
}
