package ua.home.javagroovytest.exception;

/**
 * @author tsv@ciklum.net (Tsukanov Vladimir)
 */
public class BaseException extends Exception {

    public BaseException(Throwable cause, String frmt, Object... params) {
        super(String.format(frmt, params), cause);
    }
    public BaseException(String frmt, Object... params) {
        super(String.format(frmt, params));
    }
}
