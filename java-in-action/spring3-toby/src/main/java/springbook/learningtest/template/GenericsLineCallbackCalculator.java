package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author moretajoo
 * 
 *         lineReadTemplateメソッドはテンプレートとしての役割をする。
 * 
 */
public class GenericsLineCallbackCalculator {

	public <T> T lineReadTemplate(String filepath, GenericsLineCallback<T> callback, T initVal) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filepath));
			T res = initVal;
			String line = null;
			while ((line = br.readLine()) != null) {
				res = callback.doSomethingWithLine(line, res);
			}

			return res;

		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}


	public String concatenate(String filepath) throws IOException {
		GenericsLineCallback<String> callback = new GenericsLineCallback<String>() {
			@Override
			public String doSomethingWithLine(String line, String value) {
				return value + line;
			}
		};
		return lineReadTemplate(filepath, callback, "");
	}

	public int calSum(String filepath) throws IOException {
		GenericsLineCallback<Integer> sumCallback = new GenericsLineCallback<Integer>() {

			@Override
			public Integer doSomethingWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}

		};
		return lineReadTemplate(filepath, sumCallback, 0);
	}

	public Integer calcMultiply(String filepath) throws IOException {
		GenericsLineCallback<Integer> multiplyCallback = new GenericsLineCallback<Integer>() {

			@Override
			public Integer doSomethingWithLine(String line, Integer value) {
				return value * Integer.valueOf(line);
			}
		};
		return lineReadTemplate(filepath, multiplyCallback, 1);
	}

}
