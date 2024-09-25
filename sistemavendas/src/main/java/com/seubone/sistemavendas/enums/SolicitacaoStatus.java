package com.seubone.sistemavendas.enums;

public enum SolicitacaoStatus {
    PENDENTE("pendente"),
    APROVADO("aprovado"),
    RECUSADO("recusado");

    private String status;

    SolicitacaoStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
