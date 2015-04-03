package org.stilavia.tdd;

/**
 * Created by guillermoblascojimenez on 02/04/15.
 */
public interface Function<I, O> {

    O eval(I input);

}
