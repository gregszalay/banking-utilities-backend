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
 * MortgageInput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-26T15:28:42.066Z[GMT]")
public class MortgageInput {
    @JsonProperty("principalAmountBorrowed")
    private String principalAmountBorrowed = null;

    @JsonProperty("downPayment")
    private String downPayment = null;

    @JsonProperty("loanTermInYears")
    private String loanTermInYears = null;

    @JsonProperty("annualInterestRatePercent")
    private String annualInterestRatePercent = null;

    @JsonProperty("monthlyPropertyTaxes")
    private String monthlyPropertyTaxes = null;

    @JsonProperty("monthlyPropertyInsurance")
    private String monthlyPropertyInsurance = null;

    @JsonProperty("monthlyHomeownersAssociationFee")
    private String monthlyHomeownersAssociationFee = null;

    public MortgageInput principalAmountBorrowed(String principalAmountBorrowed) {
        this.principalAmountBorrowed = principalAmountBorrowed;
        return this;
    }

    /**
     * Get principalAmountBorrowed
     *
     * @return principalAmountBorrowed
     **/
    @JsonProperty("principalAmountBorrowed")
    @Schema(example = "1000000", description = "")
    public String getPrincipalAmountBorrowed() {
        return principalAmountBorrowed;
    }

    public void setPrincipalAmountBorrowed(String principalAmountBorrowed) {
        this.principalAmountBorrowed = principalAmountBorrowed;
    }

    public MortgageInput downPayment(String downPayment) {
        this.downPayment = downPayment;
        return this;
    }

    /**
     * Get downPayment
     *
     * @return downPayment
     **/
    @JsonProperty("downPayment")
    @Schema(example = "300000", description = "")
    public String getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(String downPayment) {
        this.downPayment = downPayment;
    }

    public MortgageInput loanTermInYears(String loanTermInYears) {
        this.loanTermInYears = loanTermInYears;
        return this;
    }

    /**
     * Get loanTermInYears
     *
     * @return loanTermInYears
     **/
    @JsonProperty("loanTermInYears")
    @Schema(example = "15", description = "")
    public String getLoanTermInYears() {
        return loanTermInYears;
    }

    public void setLoanTermInYears(String loanTermInYears) {
        this.loanTermInYears = loanTermInYears;
    }

    public MortgageInput annualInterestRatePercent(String annualInterestRatePercent) {
        this.annualInterestRatePercent = annualInterestRatePercent;
        return this;
    }

    /**
     * Get annualInterestRatePercent
     *
     * @return annualInterestRatePercent
     **/
    @JsonProperty("annualInterestRatePercent")
    @Schema(example = "2.8", description = "")
    public String getAnnualInterestRatePercent() {
        return annualInterestRatePercent;
    }

    public void setAnnualInterestRatePercent(String annualInterestRatePercent) {
        this.annualInterestRatePercent = annualInterestRatePercent;
    }

    public MortgageInput monthlyPropertyTaxes(String monthlyPropertyTaxes) {
        this.monthlyPropertyTaxes = monthlyPropertyTaxes;
        return this;
    }

    /**
     * Get monthlyPropertyTaxes
     *
     * @return monthlyPropertyTaxes
     **/
    @JsonProperty("monthlyPropertyTaxes")
    @Schema(example = "80", description = "")
    public String getMonthlyPropertyTaxes() {
        return monthlyPropertyTaxes;
    }

    public void setMonthlyPropertyTaxes(String monthlyPropertyTaxes) {
        this.monthlyPropertyTaxes = monthlyPropertyTaxes;
    }

    public MortgageInput monthlyPropertyInsurance(String monthlyPropertyInsurance) {
        this.monthlyPropertyInsurance = monthlyPropertyInsurance;
        return this;
    }

    /**
     * Get monthlyPropertyInsurance
     *
     * @return monthlyPropertyInsurance
     **/
    @JsonProperty("monthlyPropertyInsurance")
    @Schema(example = "100", description = "")
    public String getMonthlyPropertyInsurance() {
        return monthlyPropertyInsurance;
    }

    public void setMonthlyPropertyInsurance(String monthlyPropertyInsurance) {
        this.monthlyPropertyInsurance = monthlyPropertyInsurance;
    }

    public MortgageInput monthlyHomeownersAssociationFee(String monthlyHomeownersAssociationFee) {
        this.monthlyHomeownersAssociationFee = monthlyHomeownersAssociationFee;
        return this;
    }

    /**
     * Get monthlyHomeownersAssociationFee
     *
     * @return monthlyHomeownersAssociationFee
     **/
    @JsonProperty("monthlyHomeownersAssociationFee")
    @Schema(example = "50", description = "")
    public String getMonthlyHomeownersAssociationFee() {
        return monthlyHomeownersAssociationFee;
    }

    public void setMonthlyHomeownersAssociationFee(String monthlyHomeownersAssociationFee) {
        this.monthlyHomeownersAssociationFee = monthlyHomeownersAssociationFee;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MortgageInput mortgageInput = (MortgageInput) o;
        return Objects.equals(this.principalAmountBorrowed, mortgageInput.principalAmountBorrowed) &&
                Objects.equals(this.downPayment, mortgageInput.downPayment) &&
                Objects.equals(this.loanTermInYears, mortgageInput.loanTermInYears) &&
                Objects.equals(this.annualInterestRatePercent, mortgageInput.annualInterestRatePercent) &&
                Objects.equals(this.monthlyPropertyTaxes, mortgageInput.monthlyPropertyTaxes) &&
                Objects.equals(this.monthlyPropertyInsurance, mortgageInput.monthlyPropertyInsurance) &&
                Objects.equals(this.monthlyHomeownersAssociationFee, mortgageInput.monthlyHomeownersAssociationFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(principalAmountBorrowed, downPayment, loanTermInYears, annualInterestRatePercent, monthlyPropertyTaxes, monthlyPropertyInsurance, monthlyHomeownersAssociationFee);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MortgageInput {\n");

        sb.append("    principalAmountBorrowed: ").append(toIndentedString(principalAmountBorrowed)).append("\n");
        sb.append("    downPayment: ").append(toIndentedString(downPayment)).append("\n");
        sb.append("    loanTermInYears: ").append(toIndentedString(loanTermInYears)).append("\n");
        sb.append("    annualInterestRatePercent: ").append(toIndentedString(annualInterestRatePercent)).append("\n");
        sb.append("    monthlyPropertyTaxes: ").append(toIndentedString(monthlyPropertyTaxes)).append("\n");
        sb.append("    monthlyPropertyInsurance: ").append(toIndentedString(monthlyPropertyInsurance)).append("\n");
        sb.append("    monthlyHomeownersAssociationFee: ").append(toIndentedString(monthlyHomeownersAssociationFee)).append("\n");
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
