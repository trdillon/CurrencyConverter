package enums;

import javafx.scene.image.Image;
import javafx.util.StringConverter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public enum Currency {
    AED("United Arab Emirates dirham", "uae.png"),
    AFN("Afghan afghani", "afghanistan.png"),
    ALL("Albanian lek", "albania.png"),
    AMD("Armenian dram", "armenia.png"),
    ANG("Netherlands Antillean guilder", "curacao.png"),
    AOA("Angolan kwanza", "angola.png"),
    ARS("Argentine peso", "argentina.png"),
    AUD("Australian dollar", "australia.png"),
    AWG("Aruban florin", "aruba.png"),
    AZN("Azerbaijani manat", "azerbaijan.png"),
    BAM("Bosnia and Herzegovina convertible mark", "bosnia.png"),
    BBD("Barbados dollar", "barbados.png"),
    BDT("Bangladeshi taka", "bangladesh.png"),
    BGN("Bulgarian lev", "bulgaria.png"),
    BHD("Bahraini dinar", "bahrain.png"),
    BIF("Burundian franc", "burundi.png"),
    BMD("Bermudian dollar", "bermuda.png"),
    BND("Brunei dollar", "brunei.png"),
    BOB("Boliviano", "bolivia.png"),
    BRL("Brazilian real", "brazil.png"),
    BSD("Bahamian dollar", "bahamas.png"),
    BTC("Bitcoin", "bitcoin.png"),
    BTN("Bhutanese ngultrum", "bhutan.png"),
    BWP("Botswana pula", "botswana.png"),
    BYN("Belarusian ruble", "belarus.png"),
    BYR("Belarusian ruble", "belarus.png"),
    BZD("Belize dollar", "belize.png"),
    CAD("Canadian dollar", "canada.png"),
    CDF("Congolese franc", "congo_democratic.png"),
    CHF("Swiss franc", "switzerland.png"),
    CLF("Unidad de Fomento", "chile.png"),
    CLP("Chilean peso", "chile.png"),
    CNY("Chinese yuan", "china.png"),
    COP("Colombian peso", "colombia.png"),
    CRC("Costa Rican colon", "costa_rica.png"),
    CUC("Cuban convertible peso", "cuba.png"),
    CUP("Cuban peso", "cuba.png"),
    CVE("Cape Verdean escudo", "cape_verde.png"),
    CZK("Czech koruna", "czech_republic.png"),
    DJF("Djiboutian franc", "djibouti.png"),
    DKK("Danish krone", "denmark.png"),
    DOP("Dominican peso", "dominican_republic.png"),
    DZD("Algerian dinar", "algeria.png"),
    EGP("Egyptian pound", "egypt.png"),
    ERN("Eritrean nakfa", "eritrea.png"),
    ETB("Ethiopian birr", "ethiopia.png"),
    EUR("Euro", "eu.png"),
    FJD("Fiji dollar", "fiji.png"),
    FKP("Falkland Islands pound", "montserrart.png"),
    GBP("Pound sterling", "uk.png"),
    GEL("Georgian lari", "georgia.png"),
    GGP("Guernsey pound", "england.png"),
    GHS("Ghanaian cedi", "ghana.png"),
    GIP("Gibraltar pound", "gibraltar.png"),
    GMD("Gambian dalasi", "gambia.png"),
    GNF("Guinean franc", "guinea.png"),
    GTQ("Guatemalan quetzal", "guatemala.png"),
    GYD("Guyanese dollar", "guyana.png"),
    HKD("Hong Kong dollar", "hong_kong.png"),
    HNL("Honduran lempira", "honduras.png"),
    HRK("Croatian kuna", "croatia.png"),
    HTG("Haitian gourde", "haiti.png"),
    HUF("Hungarian forint", "hungary.png"),
    IDR("Indonesian rupiah", "indonesia.png"),
    ILS("Israeli new shekel", "israel.png"),
    IMP("Isle of Man pound", "england.png"),
    INR("Indian rupee", "india.png"),
    IQD("Iraqi dinar", "iraq.png"),
    IRR("Iranian rial", "iran.png"),
    ISK("Icelandic króna", "iceland.png"),
    JEP("Jersey pound", "england.png"),
    JMD("Jamaican dollar", "jamaica.png"),
    JOD("Jordanian dinar", "jordan.png"),
    JPY("Japanese yen", "japan.png"),
    KES("Kenyan shilling", "kenya.png"),
    KGS("Kyrgyzstani som", "kyrgyzstan.png"),
    KHR("Cambodian riel", "cambodia.png"),
    KMF("Comoro franc", "comoros.png"),
    KPW("North Korean won", "north_korea.png"),
    KRW("South Korean won", "south_korea.png"),
    KWD("Kuwaiti dinar", "kuwait.png"),
    KYD("Cayman Islands dollar", "cayman_islands.png"),
    KZT("Kazakhstani tenge", "kazakhstan.png"),
    LAK("Lao kip", "laos.png"),
    LBP("Lebanese pound", "lebanon.png"),
    LKR("Sri Lankan rupee", "sri_lanka.png"),
    LRD("Liberian dollar", "liberia.png"),
    LSL("Lesotho loti", "lesotho.png"),
    LVL("Latvian lats", "latvia.png"),
    LYD("Libyan dinar", "libya.png"),
    MAD("Moroccan dirham", "morocco.png"),
    MDL("Moldovan leu", "moldova.png"),
    MGA("Malagasy ariary", "madagascar.png"),
    MKD("Macedonian denar", "macedonia.png"),
    MMK("Myanmar kyat", "myanmar.png"),
    MNT("Mongolian tögrög", "mongolia.png"),
    MOP("Macanese pataca", "macau.png"),
    MRO("Mauritanian ouguiya", "mauritania.png"),
    MUR("Mauritian rupee", "mauritius.png"),
    MVR("Maldivian rufiyaa", "maldives.png"),
    MWK("Malawian kwacha", "south_sudan.png"),
    MXN("Mexican peso", "mexico.png"),
    MYR("Malaysian ringgit", "malaysia.png"),
    MZN("Mozambican metical", "mozambique.png"),
    NAD("Namibian dollar", "namibia.png"),
    NGN("Nigerian naira", "nigeria.png"),
    NIO("Nicaraguan córdoba", "nicaragua.png"),
    NOK("Norwegian krone", "norway.png"),
    NPR("Nepalese rupee", "nepal.png"),
    NZD("New Zealand dollar", "new_zealand.png"),
    OMR("Omani rial", "oman.png"),
    PAB("Panamanian balboa", "panama.png"),
    PEN("Peruvian sol", "peru.png"),
    PGK("Papua New Guinean kina", "papua_new_guinea.png"),
    PHP("Philippine peso", "philippines.png"),
    PKR("Pakistani rupee", "pakistan.png"),
    PLN("Polish złoty", "poland.png"),
    PYG("Paraguayan guaraní", "paraguay.png"),
    QAR("Qatari riyal", "qatar.png"),
    RON("Romanian leu", "romania.png"),
    RSD("Serbian dinar", "serbia.png"),
    RUB("Russian ruble", "russia.png"),
    RWF("Rwandan franc", "rwanda.png"),
    SAR("Saudi riyal", "saudi_arabia.png"),
    SBD("Solomon Islands dollar", "solomon_islands.png"),
    SCR("Seychelles rupee", "seychelles.png"),
    SDG("Sudanese pound", "sudan.png"),
    SEK("Swedish krona", "sweden.png"),
    SGD("Singapore dollar", "singapore.png"),
    SHP("Saint Helena pound", "montserrart.png"),
    SLL("Sierra Leonean leone", "sierra_leone.png"),
    SOS("Somali shilling", "somali.png"),
    SRD("Surinamese dollar", "suriname.png"),
    STD("São Tomé and Príncipe dobra", "sao_tome_and_principe.png"),
    SVC("Salvadoran colón", "el_salvador.png"),
    SYP("Syrian pound", "syria.png"),
    SZL("Swazi lilangeni", "swaziland.png"),
    THB("Thai baht", "thailand.png"),
    TJS("Tajikistani somoni", "tajikistan.png"),
    TMT("Turkmenistan manat", "turkmenistan.png"),
    TND("Tunisian dinar", "tunisia.png"),
    TOP("Tongan paʻanga", "tonga.png"),
    TRY("Turkish lira", "turkey.png"),
    TTD("Trinidad and Tobago dollar", "trinidad_and_tobago.png"),
    TWD("New Taiwan dollar", "taiwan.png"),
    TZS("Tanzanian shilling", "tanzania.png"),
    UAH("Ukrainian hryvnia", "ukraine.png"),
    UGX("Ugandan shilling", "uganda.png"),
    USD("United States dollar", "usa.png"),
    UYU("Uruguayan peso", "uruguay.png"),
    UZS("Uzbekistan som", "uzbekistan.png"),
    VEF("Venezuelan bolívar soberano", "venezuela.png"),
    VND("Vietnamese đồng", "vietnam.png"),
    VUV("Vanuatu vatu", "vanuatu.png"),
    WST("Samoan tala", "american_samoa.png"),
    XAF("CFA franc BEAC", "cameroon.png"),
    XAG("Silver", "bitcoin.png"),
    XCD("East Caribbean dollar", "antigua_and_barbuda.png"),
    XDR("Special drawing rights", "bitcoin.png"),
    XOF("CFA franc BCEAO", "senegal.png"),
    XPF("CFP franc", "france.png"),
    YER("Yemeni rial", "yemen.png"),
    ZAR("South African rand", "south_africa.png"),
    ZMK("Zambian kwacha", "zambia.png"),
    ZMW("Zambian kwacha", "zambia.png"),
    ZWL("Zimbabwean dollar", "zimbabwe.png");

    private final String currencyName;
    private final Image currencyImage;

    Currency(String currencyName, String imageName) {
        this.currencyName = currencyName;

        String imageFile = "/img/flags/" + imageName;
        try (InputStream in = getClass().getResourceAsStream(imageFile)) {
            if (in == null)
                throw new IllegalStateException("Image not available for this currency. Error: " + currencyName);
            this.currencyImage = new Image(in);
        }
        catch (IOException e) {
            throw new IllegalStateException("Error loading images for currencies.", e);
        }
    }

    public String getCurrencyName() {
        return currencyName;
    }
    //TODO - fix bitcoin (white background) and euro (too small) flag images
    public Image getCurrencyImage() {
        return this.currencyImage;
    }

    public static class CurrencyNameConverter extends StringConverter<Currency> {
        @Override
        public String toString (Currency currency) {
            if (currency == null) {
                return "Please select a currency";
            }
            return currency.getCurrencyName();
        }

        @Override
        public Currency fromString (String string) {
            return Arrays.stream (Currency.values())
                    .filter(currency -> currency.currencyName.equalsIgnoreCase(string))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
