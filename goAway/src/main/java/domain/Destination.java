package domain;

import domain.model.Country;

public class Destination implements Expression {

    protected int amount;
    protected Country country;

    public Destination(int amount, Country country) {
        this.amount = amount;
        this.country = country;
    }

    public Country country() {
        return this.country;
    }

    public boolean equals(Object other) {
        Destination destination = (Destination) other;
        return destination.amount == this.amount
                && destination.country.equals(this.country);
    }

    public static Destination Italy(int amount) {
        return new Destination(amount, Country.ITA);
    }

    public static Destination Spain(int amount) {
        return new Destination(amount, Country.ESP);
    }
    
    public static Destination Egypt(int amount) {
        return new Destination(amount, Country.EGY);
    }

    public Destination times(int multiplier) {
        return new Destination(this.amount * multiplier, this.country);
    }

    public Sum plus(Expression money) {
        return new Sum(this, money);
    }


    public Destination sale(Company company, Country to){
        int price = company.price(country(), to);
        return new Destination(amount * price, to);
    }
}

