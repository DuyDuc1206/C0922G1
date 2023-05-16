package com.example.case_study_furama.dto;

import com.example.case_study_furama.model.contract.AttachFacility;
import com.example.case_study_furama.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ContractDetailDto implements Validator {

    private Integer id;
    @Min(value = 0)
    @Max(value = 20)
    private Integer quantity;

    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    @JoinColumn(name = "attach_facility_id", referencedColumnName = "id")
    private AttachFacility attachFacility;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Integer id, Integer quantity, Contract contract, AttachFacility attachFacility) {
        this.id = id;
        this.quantity = quantity;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        ContractDetailDto contractDetailDto = (ContractDetailDto) target;
//        String quantity = String.valueOf(contractDetailDto.getQuantity());
//        if (!quantity.matches("^[1-9]+$")) {
//            errors.rejectValue("quantity", "a", "Loi");
//        }
    }
}
