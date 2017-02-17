package domain;

import domain.model.Country;

public interface Expression {

    Destination sale(Company company, Country country);

    Expression plus(Expression destination);

    Expression times(int multiplier);
}
