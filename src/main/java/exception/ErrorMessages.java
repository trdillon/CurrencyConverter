package exception;

public class ErrorMessages {

    public static final String API_KEY_ERROR = "The API key being used is invalid or not entered. Please check the " +
            "settings page to ensure your API key is correct.";
    public static final String SERVICE_OUTAGE = "There is no service available to handle this request. " +
            "Please try again later. If the problem persists please create an issue on GitHub at" +
            "github.com/trdillon/CurrencyConverter or email to tim@itsdits.com to resolve this.";

    public static String getNetworkErrorMsg(String serviceError) {
        return "This service is currently unavailable. Error code: " + serviceError;
    }

    public static String getServiceOutageMsg(String serviceName) {
        return "The API for " + serviceName + " is not currently available. Please try again later. If the problem" +
                "persists please create at issue on GitHub at github.com/trdillon/CurrencyConverter " +
                "or email to tim@itsdits.com to resolve this.";
    }

    public static String getServiceUnavailableMsg(String serviceName) {
        return "The API for " + serviceName + " has been changed. Please create at issue on GitHub " +
                "at github.com/trdillon/CurrencyConverter or email to tim@itsdits.com to resolve this.";
    }
}
