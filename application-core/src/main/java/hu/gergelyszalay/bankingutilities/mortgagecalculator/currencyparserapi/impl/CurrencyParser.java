package hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi.impl;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi.CurrencyParserException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyParser implements hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi.CurrencyParserApi {

    @Override
    public BigDecimal parseAmount(String currencyAmountString) throws CurrencyParserException {

        if (currencyAmountString == null || currencyAmountString.isEmpty()) {
            throw new IllegalArgumentException("String containing currency and amount cannot be null or empty!");
        }

        String everythingButNumbers = "[^-0-9.]+";
        String cleanString = currencyAmountString.trim().replaceAll(everythingButNumbers, "");

        if (cleanString.isEmpty()) {
            throw new CurrencyParserException("Currency and amount string must contain a valid number!");
        }

        BigDecimal result = new BigDecimal(cleanString);
        return result.setScale((result.scale() == 0) ? 0 : 2, RoundingMode.HALF_EVEN);
    }

}
