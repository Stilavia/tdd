package org.stilavia.tdd;


import java.math.BigDecimal;

/**
 * Power series class.
 * Reference: http://en.wikipedia.org/wiki/Power_series
 *
 * This class encapsulates an immutable power series function.
 * A power series is:
 *
 * f(x) = sum {i from 0 to k} (a_i * (x)^i)
 *
 * Mathematically k tends to infinity, but for this case let have a fixed k.
 *
 * The a_i elements are constants {a_0, a_1, a_2, ...} and usually
 * are functions on i, a_i = h(i), for example a_i = 1/(i!) for the case of exponential function.
 *
 */
public class PowerSeries {

    private final Function<Integer, BigDecimal> a;

    /**
     * Builds a new power series with the given function as generator of constant factors.
     * @param a Function that generates the constants of the power series.
     */
    public PowerSeries(Function<Integer, BigDecimal> a) {
        assert a != null;
        this.a = a;
    }

    /**
     * Evaluates the power series for the given x value and k steps. That is:
     * f(x) = sum {i from 0 to k} (a_i * (x)^i)
     * @param x Number to evaluate.
     * @param k Amount of steps to do.
     * @return The evaluation of
     */
    public BigDecimal eval(BigDecimal x, int k) {
        throw new UnsupportedOperationException("org.stilavia.tdd.PowerSeries.of");
    }

}
