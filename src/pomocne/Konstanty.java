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

        public static final String ENABLE_BUTTON = "Enable_button";
        public static final String DISABLE_BUTTON = "Disable_button";
        public static final String SLIDER_ACTUALIZATION = "Slider_actualization";
        public static final String MARK_FIELD_PREFIX = "mark-";
        public static final String MESSAGE_PREFIX = "msg-";
    }

    public static class Sound {

        public static final String DICEROLL = "diceroll";
        public static final String HORSE = "horse";
        public static final String END = "end";
        public static final String STABLES = "stables";
        public static final String TRANSPORT = "transport";
    }

    public static class Graphics {

        public static final String MAIN_BOARD = "plocha";
        public static final String MIDDLE_BOARD = "stred";
        public static final String RIGHT_BOARD_INACTIVE = "prava";
        public static final String RIGHT_BOARD_ACTIVE = "prava_aktiv";
        public static final String BOTTOM_BAR = "spodek_lista";
        public static final String STATUS_BAR = "status";

        public static class Icons {

            public static final String SLIDER = "slider";
            public static final String END_ROUND_BUTTON_INACTIVE = "ukoncit";
            public static final String END_ROUND_BUTTON_ACTIVE = "ukoncit_aktiv";
            public static final String SELL_BUTTON = "prodat";
            public static final String GIVE_UP_BUTTON = "vzdat";
            public static final String CARD = "karta";

        }
    }

}
