/*
 * Banking Utilities Application
 * This is a banking application server for (A) calculating monthly payments of homeowners' mortgages and (B) validating payment card numbers.
 *
 * OpenAPI spec version: 1.0.0-oas3
 * Contact: gr.szalay@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * MortgageCalculatorResult
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-26T15:28:42.066Z[GMT]")
public class MortgageCalculatorResult {
    @JsonProperty("mortgageMonthlyPayment")
    private String mortgageMonthlyPayment = null;

    @JsonProperty("mortgageCalculatorMessage")
    private String mortgageCalculatorMessage = null;

    public MortgageCalculatorResult mortgageMonthlyPayment(String mortgageMonthlyPayment) {
        this.mortgageMonthlyPayment = mortgageMonthlyPayment;
        return this;
    }

    /**
     * Get mortgageMonthlyPayment
     *
     * @return mortgageMonthlyPayment
     **/
    @JsonProperty("mortgageMonthlyPayment")
    @Schema(example = "4997", description = "")
    public String getMortgageMonthlyPayment() {
        return mortgageMonthlyPayment;
    }

    public void setMortgageMonthlyPayment(String mortgageMonthlyPayment) {
        this.mortgageMonthlyPayment = mortgageMonthlyPayment;
    }

    public MortgageCalculatorResult mortgageCalculatorMessage(String mortgageCalculatorMessage) {
        this.mortgageCalculatorMessage = mortgageCalculatorMessage;
        return this;
    }

    /**
     * Get mortgageCalculatorMessage
     *
     * @return mortgageCalculatorMessage
     **/
    @JsonProperty("mortgageCalculatorMessage")
    @Schema(example = "Calculation was successful!", description = "")
    public String getMortgageCalculatorMessage() {
        return mortgageCalculatorMessage;
    }

    public void setMortgageCalculatorMessage(String mortgageCalculatorMessage) {
        this.mortgageCalculatorMessage = mortgageCalculatorMessage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MortgageCalculatorResult mortgageCalculatorResult = (MortgageCalculatorResult) o;
        return Objects.equals(this.mortgageMonthlyPayment, mortgageCalculatorResult.mortgageMonthlyPayment) &&
                Objects.equals(this.mortgageCalculatorMessage, mortgageCalculatorResult.mortgageCalculatorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mortgageMonthlyPayment, mortgageCalculatorMessage);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MortgageCalculatorResult {\n");

        sb.append("    mortgageMonthlyPayment: ").append(toIndentedString(mortgageMonthlyPayment)).append("\n");
        sb.append("    mortgageCalculatorMessage: ").append(toIndentedString(mortgageCalculatorMessage)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
