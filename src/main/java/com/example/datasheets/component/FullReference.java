package com.example.datasheets.component;

public class FullReference {
    private String company, reference, packaging;

    public FullReference(String company, String reference, String packaging){
        this.company = company;
        this.reference = reference;
        this.packaging = packaging;
    }

    public FullReference(String reference) {
        this.reference = reference;
    }

    public FullReference(String reference, String packaging) {
        this.reference = reference;
        this.packaging = packaging;
    }

    public String getCompany() {
        return company;
    }

    public String getPackaging() {
        return packaging;
    }

    public String getReference() {
        return reference;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "FullReference{" +
                "company='" + company + '\'' +
                ", reference='" + reference + '\'' +
                ", packaging='" + packaging + '\'' +
                '}';
    }
}
