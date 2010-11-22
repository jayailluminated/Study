package springbook.learningtest.template;

import java.io.IOException;

/**
 * @author moretajoo
 * 
 *         ライン毎の作業を定義するCallback
 */
public interface LineCallback {

	Integer doSomethingWithLine(String line, Integer value);

}
