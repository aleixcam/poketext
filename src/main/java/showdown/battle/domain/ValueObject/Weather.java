package showdown.battle.domain.ValueObject;

final public class Weather {

    private final String value;

    private Weather(String value) {
        this.value = value;
    }

    public static Weather clear() {
        return new Weather("Clear skies");
    }

    public static Weather harshSunlight() {
        return new Weather("Harsh sunlight");
    }

    public static Weather extremelyHarshSunlight() {
        return new Weather("Extremely harsh sunlight");
    }

    public static Weather rain() {
        return new Weather("rain");
    }

    public static Weather heavyRain() {
        return new Weather("Heavy rain");
    }

    public static Weather sandstorm() {
        return new Weather("Sandstorm");
    }

    public static Weather hail() {
        return new Weather("Hail");
    }

    public static Weather fog() {
        return new Weather("Fog");
    }

    public static Weather strongWinds() {
        return new Weather("Strong winds");
    }

    public boolean equals(Weather weather) {
        return this.value.equals(weather.value);
    }
}
