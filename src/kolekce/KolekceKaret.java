/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekce;

/**
 *
 * @author wentsa
 * @param <T>
 */
public interface KolekceKaret {
    int pocet();
    void vloz(Object o);
    boolean vyjmi(Object o);
    boolean obsahuje(Object o);
    void sesypat(KolekceKaret druha);
    Object[] naPole();
    Object vratNahodny() throws IllegalAccessException;
}
