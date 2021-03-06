/*
 * TickType.java
 *
 */
package com.ib.client;

public class TickType {
    // constants - tick types
    public static final int BID_SIZE = 0;
    public static final int BID = 1;
    public static final int ASK = 2;
    public static final int ASK_SIZE = 3;
    public static final int LAST = 4;
    public static final int LAST_SIZE = 5;
    public static final int HIGH = 6;
    public static final int LOW = 7;
    public static final int VOLUME = 8;
    public static final int CLOSE = 9;
    public static final int BID_OPTION = 10;
    public static final int ASK_OPTION = 11;
    public static final int LAST_OPTION = 12;
    public static final int MODEL_OPTION = 13;
    public static final int OPEN = 14;
    public static final int LOW_13_WEEK = 15;
    public static final int HIGH_13_WEEK = 16;
    public static final int LOW_26_WEEK = 17;
    public static final int HIGH_26_WEEK = 18;
    public static final int LOW_52_WEEK = 19;
    public static final int HIGH_52_WEEK = 20;
    public static final int AVG_VOLUME = 21;
    public static final int OPEN_INTEREST = 22;
    public static final int OPTION_HISTORICAL_VOL = 23;
    public static final int OPTION_IMPLIED_VOL = 24;
    public static final int OPTION_BID_EXCH = 25;
    public static final int OPTION_ASK_EXCH = 26;
    public static final int OPTION_CALL_OPEN_INTEREST = 27;
    public static final int OPTION_PUT_OPEN_INTEREST = 28;
    public static final int OPTION_CALL_VOLUME = 29;
    public static final int OPTION_PUT_VOLUME = 30;
    public static final int INDEX_FUTURE_PREMIUM = 31;
    public static final int BID_EXCH = 32;
    public static final int ASK_EXCH = 33;
    public static final int AUCTION_VOLUME = 34;
    public static final int AUCTION_PRICE = 35;
    public static final int AUCTION_IMBALANCE = 36;
    public static final int MARK_PRICE = 37;

    public static String getField(int tickType) {
        switch (tickType) {
            case BID_SIZE:
                return "bidSize";
            case BID:
                return "bidPrice";
            case ASK:
                return "askPrice";
            case ASK_SIZE:
                return "askSize";
            case LAST:
                return "lastPrice";
            case LAST_SIZE:
                return "lastSize";
            case HIGH:
                return "high";
            case LOW:
                return "low";
            case VOLUME:
                return "volume";
            case CLOSE:
                return "close";
            case BID_OPTION:
                return "bidOptComp";
            case ASK_OPTION:
                return "askOptComp";
            case LAST_OPTION:
                return "lastOptComp";
            case MODEL_OPTION:
                return "modelOptComp";
            case OPEN:
                return "open";
            case LOW_13_WEEK:
                return "13WeekLow";
            case HIGH_13_WEEK:
                return "13WeekHigh";
            case LOW_26_WEEK:
                return "26WeekLow";
            case HIGH_26_WEEK:
                return "26WeekHigh";
            case LOW_52_WEEK:
                return "52WeekLow";
            case HIGH_52_WEEK:
                return "52WeekHigh";
            case AVG_VOLUME:
                return "AvgVolume";
            case OPEN_INTEREST:
                return "OpenInterest";
            case OPTION_HISTORICAL_VOL:
                return "OptionHistoricalVolatility";
            case OPTION_IMPLIED_VOL:
                return "OptionImpliedVolatility";
            case OPTION_BID_EXCH:
                return "OptionBidExchStr";
            case OPTION_ASK_EXCH:
                return "OptionAskExchStr";
            case OPTION_CALL_OPEN_INTEREST:
                return "OptionCallOpenInterest";
            case OPTION_PUT_OPEN_INTEREST:
                return "OptionPutOpenInterest";
            case OPTION_CALL_VOLUME:
                return "OptionCallVolume";
            case OPTION_PUT_VOLUME:
                return "OptionPutVolume";
            case INDEX_FUTURE_PREMIUM:
                return "IndexFuturePremium";
            case BID_EXCH:
                return "bidExch";
            case ASK_EXCH:
                return "askExch";
            case AUCTION_VOLUME:
                return "auctionVolume";
            case AUCTION_PRICE:
                return "auctionPrice";
            case AUCTION_IMBALANCE:
                return "auctionImbalance";
            case MARK_PRICE:
                return "markPrice";
            default:
                return "unknown";
        }
    }
}
