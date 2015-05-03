/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocne;

import java.util.Locale;

/**
 *
 * @author wentsa
 */
public class Konstanty {

    public static int sirkaPlochy;
    public static int vyskaPlochy;

    public final static int SHOUT_DELAY = 200;
    public static Locale DEFAULT_LOCALE;
    public static String FONT_NAME = "Ubuntu Mono Regular";

    public static class Shout {

        public static String ENABLE_BUTTON = "Enable_button";
        public static String DISABLE_BUTTON = "Disable_button";
        public static String SLIDER_ACTUALIZATION = "Slider_actualization";
        public static String MARK_FIELD_PREFIX = "mark-";
        public static String MESSAGE_PREFIX = "msg-";
    }

    public static class Sound {

        public static String DICEROLL = "diceroll";
        public static String HORSE = "horse";
        public static String END = "end";
        public static String STABLES = "stables";
        public static String TRANSPORT = "transport";
    }

    public static class Graphics {

        public static String MAIN_BOARD = "plocha";
        public static String MIDDLE_BOARD = "stred";
        public static String RIGHT_BOARD_INACTIVE = "prava";
        public static String RIGHT_BOARD_ACTIVE = "prava_aktiv";
        public static String BOTTOM_BAR = "spodek_lista";
        public static String STATUS_BAR = "status";

        public static class Icons {

            public static String SLIDER = "slider";
            public static String END_ROUND_BUTTON_INACTIVE = "ukoncit";
            public static String END_ROUND_BUTTON_ACTIVE = "ukoncit_aktiv";
            public static String SELL_BUTTON = "prodat";
            public static String GIVE_UP_BUTTON = "vzdat";
            public static String CARD = "karta";

        }
    }

}
