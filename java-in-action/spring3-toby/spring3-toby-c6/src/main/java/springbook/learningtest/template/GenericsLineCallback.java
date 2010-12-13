package springbook.learningtest.template;


/**
 * @author moretajoo
 * 
 *         ライン毎の作業を定義するCallback
 */
public interface GenericsLineCallback<T> {

	T doSomethingWithLine(String line, T value);

}
