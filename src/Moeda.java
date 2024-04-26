import java.util.Map;

public record Moeda(String base_code, Map<String, Double> conversion_rates) {
    public Map<String, Double> conversionRates() {
        return conversion_rates;
    }
}
