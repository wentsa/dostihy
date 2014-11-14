/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekce;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author wentsa
 * @param <T>
 */
public class KolekceKaretImplementace implements KolekceKaret {
    
    private Object[] karty;
    int pocet;
    int max;

    public KolekceKaretImplementace(int pocet) {
        if(pocet<0) {
            throw new IllegalArgumentException("Velikost mensi nez 0");
        }
        this.karty = new Object[pocet];
        this.pocet = 0;
        max=pocet;
    }

    public KolekceKaretImplementace() {
        this(100);
        this.pocet=0;
        this.max=100;
    }

    @Override
    public int pocet() {
        return pocet;
    }

    @Override
    public void vloz(Object o) {
        karty[pocet++]=o;
    }

    @Override
    public boolean vyjmi(Object o) {
        int idx=najdi(o);
        if(idx != -1) {
            karty[idx]=karty[--pocet];
            karty[pocet]=null;
            return true;
        }
        return false;
    }
    
    private int najdi(Object o) {
        for(int i=0;i<pocet;i++) {
            if(karty[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean obsahuje(Object o) {
        if(najdi(o)==-1) return false;
        return true;
    }


    @Override
    public void sesypat(KolekceKaret druhy) {
        if(pocet+druhy.pocet() > karty.length) {
            throw new IllegalArgumentException("Mala delka");
        }
        System.arraycopy(druhy.naPole(), 0, karty, pocet, druhy.pocet());
    }

    @Override
    public Object[] naPole() {
        return Arrays.copyOfRange(karty, 0, pocet);
    }

    @Override
    public Object vratNahodny() throws IllegalAccessException {
        if(pocet==0) {
            throw new IllegalAccessException("Prazdna kolekce");
        }
        Random random=new Random();
        int idx=random.nextInt(pocet);
        Object tmp=karty[idx];
        karty[idx]=karty[--pocet];
        karty[pocet]=null;
        return tmp;
    }
    
}
