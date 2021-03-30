package hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi;

import java.math.BigDecimal;

public interface CurrencyParserApi {

    BigDecimal parseAmount(String currencyAmountString) throws CurrencyParserException;

}
