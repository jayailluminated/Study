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
public class LineCallbackCalculator {

	public Integer lineReadTemplate(String filepath, LineCallback callback, int initVal) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filepath));
			Integer res = initVal;
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


	public int calSum(String filepath) throws IOException {
		LineCallback sumCallback = new LineCallback() {

			@Override
			public Integer doSomethingWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}

		};
		return lineReadTemplate(filepath, sumCallback, 0);
	}

	public Integer calcMultiply(String filepath) throws IOException {
		LineCallback multiplyCallback = new LineCallback() {

			@Override
			public Integer doSomethingWithLine(String line, Integer value) {
				return value * Integer.valueOf(line);
			}
		};
		return lineReadTemplate(filepath, multiplyCallback, 1);
	}

}
