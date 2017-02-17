package domain;

import domain.model.Country;

import java.util.Hashtable;

public class Company {

    private Hashtable<Pair, Integer> sales = new Hashtable<Pair, Integer>();

    public Destination sale(Expression expression, Country country) {

        return expression.sale(this, country);
    }

    public void addPrice(Country countryFrom, Country countryTo, int price) {
        sales.put(new Pair(countryFrom, countryTo), price);
    }

    public int price(Country country, Country to) {
        if (country == to)
            return 1;
        return sales.get(new Pair(country, to));
    }
}

class Pair {

    private Country countryFrom;
    private Country countryTo;

    Pair(Country countryFrom, Country countryTo) {
        this.countryFrom = countryFrom;
        this.countryTo = countryTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        return countryFrom == pair.countryFrom && countryTo == pair.countryTo;

    }

    @Override
    public int hashCode() {
        return 0;
    }
}


