package com.springvalidate.model;

import com.springvalidate.service.validate.constraints.SpelAssert;

import javax.validation.constraints.NotNull;

@SpelAssert( value="agreementType == AgreementType.AVTALEGIRO ? not ( (beneficiaryAccount == null and beneficiaryName == null) or ( beneficiaryName == null and searchCriteria == null ) ) : true",
message="Valid searches are beneficiaryAccount, beneficiaryName or beneficiaryName and a search criteria" )
public class User {

    public interface Adult{};
    
    @NotNull(groups={Adult.class})
    private String isAdult;
    
    @NotNull
    private String fistName;
    
    @NotNull
    private String lastName;

    public String getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(String isAdult) {
        this.isAdult = isAdult;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
