/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekce;

import java.io.Serializable;

/**
 *
 * @author wentsa
 * @param <T>
 */
public interface KolekceKaret<T> extends Serializable {
    int pocet();
    void vloz(T o);
    boolean vyjmi(T o);
    boolean obsahuje(T o);
    Object[] naPole();
    T vratNahodny() throws IllegalAccessException;
}
