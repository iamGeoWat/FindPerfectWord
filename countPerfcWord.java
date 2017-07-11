import java.io.*;
import java.util.*;

class countPerfcWord {
	public static int countWordWeight(String word) {
		int wordWeight = 0;
		for (int j = 0; j < word.length(); j++) {
			wordWeight += word.charAt(j)-96;
		}
		return wordWeight;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner inputScan = new Scanner(System.in);
		System.out.println("全小写单词，与释义间只有一个空格，一个单词与释义占一行，必须为 txt 文件");
		System.out.println("例：abbreviation n.缩写，节略");
		System.out.println("输入同目录下的带txt后缀的文件名：");
		String fileName = inputScan.next();
		File f = new File(fileName);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String temp = br.readLine();
		do {
			int spacePosi = 0;
			while (temp.charAt(spacePosi) != 32) {
				spacePosi++;
			}
			String word = temp.substring(0, spacePosi);
			if (countWordWeight(word) == 100) {
				System.out.println(word);
			}
			temp = br.readLine();
		} while (temp != null);
		fr.close();
		br.close();
	}
}