package by.drozdovskaya.clientstring.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import by.drozdovskaya.clientstring.file.WorkWithFile;

public class MyClient {
	
	//Клиент запрашивает у пользователя номер изменяемого символа и символ, 
	//на который требуется выполнить замену. Клиент отправляет введённые данные на сервер. 
	//Сервер обращается к файлу (файл на сервере, в файле набор предложений), берёт из файла предложение
	//и выполняет замену каждого К символа в слове на новый (который получил от клиент). 
	//�?зменённое предложение сервер отправляет клиенту и клиент записывает результат в файл (отдельный файл, который хранится на стороне клиента)

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner sc = new Scanner(System.in);
		Socket socket = new Socket("localhost", 9595);
		InputStreamReader is = new InputStreamReader(socket.getInputStream());
		OutputStream os = socket.getOutputStream();
		char[] massege = new char[2048];
		is.read(massege);
		
		System.out.println(massege);
		String str = sc.nextLine();
		System.out.println(str);
		os.write(str.getBytes());
		
		is.read(massege);
		System.out.println(massege);
		WorkWithFile file = new WorkWithFile();
		file.writeToFile("Text", String.valueOf(massege));

	}

}
