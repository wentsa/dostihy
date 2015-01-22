/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekce;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author wentsa
 * @param <T>
 */
public class KolekceKaretImplementace<T> implements KolekceKaret<T>, Serializable {
    private static final long serialVersionUID = 1L;
    
    private ArrayList<T> karty;
    private int pocet;

    public KolekceKaretImplementace(int pocet) {
        if(pocet<0) {
            throw new IllegalArgumentException("Velikost mensi nez 0");
        }
        this.karty = new ArrayList<>(pocet);
        this.pocet = 0;
    }

    public KolekceKaretImplementace() {
        this(100);
    }

    @Override
    public int pocet() {
        return pocet;
    }

    
    @Override
    public void vloz(T o) {
        karty.add(o);
        pocet++;
    }

    @Override
    public boolean vyjmi(T o) {
        int idx=najdi(o);
        if(idx != -1) {
            karty.remove(idx);
            pocet--;
            return true;
        }
        return false;
    }
    
    private int najdi(T o) {
        for(int i=0;i<pocet;i++) {
            if(karty.get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean obsahuje(T o) {
        return najdi(o) != -1;
    }


    @Override
    public Object[] naPole() {
        return karty.toArray();
    }

    @Override
    public T vratNahodny() throws IllegalAccessException {
        if(pocet==0) {
            throw new IllegalAccessException("Prazdna kolekce");
        }
        Random random=new Random();
        int idx=random.nextInt(pocet);
        T tmp=karty.get(idx);
        karty.remove(idx);
        pocet--;
        return tmp;
    }
    
}
