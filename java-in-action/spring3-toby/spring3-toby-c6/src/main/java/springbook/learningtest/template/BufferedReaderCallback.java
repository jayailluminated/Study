package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author moretajoo
 * 
 *         템플릿이 파일을 열고 BufferedReader를 만들어서 콜백에게 전달<br>
 *         콜백이 각 라인을 읽어서 처리하고 최종결과만 템플릿에게 돌려줌
 * 
 */
public interface BufferedReaderCallback {
	Integer doSomethingWithReader(BufferedReader br) throws NumberFormatException, IOException;
}
