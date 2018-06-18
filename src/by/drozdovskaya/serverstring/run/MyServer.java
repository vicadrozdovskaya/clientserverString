package by.drozdovskaya.serverstring.run;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.drozdovskaya.serverstring.text.Text;



//Клиент запрашивает у пользователя номер изменяемого символа и символ, 
//на который требуется выполнить замену. Клиент отправляет введённые данные на сервер. 
//Сервер обращается к файлу (файл на сервере, в файле набор предложений), берёт из файла предложение
//и выполняет замену каждого К символа в слове на новый (который получил от клиент). 
//�?зменённое предложение сервер отправляет клиенту и клиент записывает результат в файл (отдельный файл, который хранится на стороне клиента)

public class MyServer {

	public static void main(String[] args) throws IOException {
		
		
		ServerSocket server = new ServerSocket(9595);
		try {
			System.out.println("Server start: ");
			
			Socket socket = server.accept();
			
			System.out.println("Client connected:");
			OutputStream os = socket.getOutputStream();
			
			os.write("Введите к и символ на который заменить в формате к,символ".getBytes());
			InputStreamReader is = new InputStreamReader(socket.getInputStream());
			char[] data = new char[1024];
			System.out.println("Data recieved: ");
			is.read(data);
			System.out.println(data);
			int k = Integer.valueOf(String.valueOf(data[0]));
			System.out.println("k: " + data[0]);
			System.out.println("data[2]: " + data[2]);
			Text text = new Text();
			text.doChange(k, data[2]);
			os.write(text.getText().getBytes());
			//System.out.println(text.getText());

			
			

			System.out.println(data);


			

			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		finally {
			server.close();
		}


	}
	}


