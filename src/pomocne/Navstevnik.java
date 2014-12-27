/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocne;

import hra.Hrac;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public abstract class Navstevnik implements Serializable {
    public abstract void navstiv (Hrac h);
}
