/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Dimension;

/**
 *
 * @author root
 */
@SuppressWarnings("PublicField")
public class RozmeryPlochy {
    private static boolean originalniHodnoty=true;
    
    private static float scalingFactor=1.0f;
    
    private static final int    plochaSirka=700,
                                plochaVyska=700,

                                stredSirka=100,
                                stredVyska=700,

                                pravaSirka=480,
                                pravaVyska=700,

                                statusSirka=700,
                                statusVyska=50,

                                stredDolniSirka=100,
                                stredDolniVyska=50,

                                tlacitkaSirka=480,
                                tlacitkaVyska=50,

                                ukoncitSirka=218,
                                ukoncitVyska=50,

                                prodatSirka=140,
                                prodatVyska=50,

                                vzdatSirka=122,
                                vzdatVyska=50;
    
    //plocha,stred,prava,status,stredDolni,tlacitka,ukoncit,prodat,vzdat
    
    public static  Dimension plocha() {
        return new Dimension(getPlochaSirka(), getPlochaVyska());
    }
    public static  Dimension stred() {
        return new Dimension(getStredSirka(), getStredVyska());
    }
    public static  Dimension prava() {
        return new Dimension(getPravaSirka(), getPravaVyska());
    }
    public static  Dimension status() {
        return new Dimension(getStatusSirka(), getStatusVyska());
    }
    public static  Dimension stredDolni() {
        return new Dimension(getStredDolniSirka(), getStredDolniVyska());
    }
    public static  Dimension tlacitka() {
        return new Dimension(getTlacitkaSirka(), getTlacitkaVyska());
    }
    public static  Dimension ukoncit() {
        return new Dimension(getUkoncitSirka(), getUkoncitVyska());
    }
    public static  Dimension prodat() {
        return new Dimension(getProdatSirka(), getProdatVyska());
    }
    public static  Dimension vzdat() {
        return new Dimension(getVzdatSirka(), getVzdatVyska());
    }
    
    public static boolean isOriginalniHodnoty() {
        return originalniHodnoty;
    }
    
    
    public static void setOriginalniHodnoty(boolean aOriginalniHodnoty) {
        originalniHodnoty = aOriginalniHodnoty;
    }

    
    public static void setScalingFactor(float aScalingFactor) {
        scalingFactor = aScalingFactor;
    }
    
    public static float getScalingFactor() {
        return scalingFactor;
    }

    //<editor-fold defaultstate="collapsed" desc="GET">    
    public static int getPlochaSirka() {
        if (isOriginalniHodnoty()) {
            return plochaSirka;
        }
        return (int)(plochaSirka*scalingFactor);
    }

    public static int getPlochaVyska() {
        if (isOriginalniHodnoty()) {
            return plochaVyska;
        }
        return (int)(plochaVyska*scalingFactor);
    }

    public static int getStredSirka() {
        if (isOriginalniHodnoty()) {
            return stredSirka;
        }
        return (int)(stredSirka*scalingFactor);
    }

    public static int getStredVyska() {
        if (isOriginalniHodnoty()) {
            return stredVyska;
        }
        return (int)(stredVyska*scalingFactor);
    }

    public static int getPravaSirka() {
        if (isOriginalniHodnoty()) {
            return pravaSirka;
        }
        return (int)(pravaSirka*scalingFactor);
    }

    public static int getPravaVyska() {
        if (isOriginalniHodnoty()) {
            return pravaVyska;
        }
        return (int)(pravaVyska*scalingFactor);
    }

    public static int getStatusSirka() {
        if (isOriginalniHodnoty()) {
            return statusSirka;
        }
        return (int)(statusSirka*scalingFactor);
    }

    public static int getStatusVyska() {
        if (isOriginalniHodnoty()) {
            return statusVyska;
        }
        return (int)(statusVyska*scalingFactor);
    }

    public static int getStredDolniSirka() {
        if (isOriginalniHodnoty()) {
            return stredDolniSirka;
        }
        return (int)(stredDolniSirka*scalingFactor);
    }

    public static int getStredDolniVyska() {
        if (isOriginalniHodnoty()) {
            return stredDolniVyska;
        }
        return (int)(stredDolniVyska*scalingFactor);
    }

    public static int getTlacitkaSirka() {
        if (isOriginalniHodnoty()) {
            return tlacitkaSirka;
        }
        return (int)(tlacitkaSirka*scalingFactor);
    }

    public static int getTlacitkaVyska() {
        if (isOriginalniHodnoty()) {
            return tlacitkaVyska;
        }
        return (int)(tlacitkaVyska*scalingFactor);
    }

    public static int getUkoncitSirka() {
        if (isOriginalniHodnoty()) {
            return ukoncitSirka;
        }
        return (int)(ukoncitSirka*scalingFactor);
    }

    public static int getUkoncitVyska() {
        if (isOriginalniHodnoty()) {
            return ukoncitVyska;
        }
        return (int)(ukoncitVyska*scalingFactor);
    }

    public static int getProdatSirka() {
        if (isOriginalniHodnoty()) {
            return prodatSirka;
        }
        return (int)(prodatSirka*scalingFactor);
    }

    public static int getProdatVyska() {
        if (isOriginalniHodnoty()) {
            return prodatVyska;
        }
        return (int)(prodatVyska*scalingFactor);
    }

    public static int getVzdatSirka() {
        if (isOriginalniHodnoty()) {
            return vzdatSirka;
        }
        return (int)(tlacitkaSirka*scalingFactor)-(int)(ukoncitSirka*scalingFactor)-(int)(prodatSirka*scalingFactor);
    }

    public static int getVzdatVyska() {
        if (isOriginalniHodnoty()) {
            return vzdatVyska;
        }
        return (int)(vzdatVyska*scalingFactor);
    }

    //</editor-fold>
    
    
        
}
