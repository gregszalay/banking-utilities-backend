package hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi.impl;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.currencyparserapi.CurrencyParserException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CurrencyParserTest {

    @Test
    void parseAmount_ShouldParseNumberFromString_WhenStringContainsNumber() {
        BigDecimal expectedNumber = new BigDecimal("5.44");
        BigDecimal actualNumber = new CurrencyParser().parseAmount("hl k5.442$kkli");
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    void parseAmount_ShouldThrowIllegalArgumentException_WhenStringIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new CurrencyParser().parseAmount(null));
    }

    @Test
    void parseAmount_ShouldThrowMoneyParserException_WhenStringDoesntContainNumbers() {
        assertThrows(CurrencyParserException.class, () ->
                new CurrencyParser().parseAmount("This string doesn't contain numbers"));
    }

}