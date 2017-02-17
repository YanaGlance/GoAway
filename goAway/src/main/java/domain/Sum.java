package domain;

import domain.model.Country;
import domain.Destination;

public class Sum implements Expression {

    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Destination sale(Company company, Country country) {
        return new Destination(
                addend.sale(company, country).amount
                        + augend.sale(company, country).amount
                , country);
    }

    public Sum plus(Expression destination) {
        return new Sum(this, destination);
    }

    public Expression times(int multiplier) {
        return new Sum(
                this.augend.times(multiplier),
                this.addend.times(multiplier)
        );
    }
}
