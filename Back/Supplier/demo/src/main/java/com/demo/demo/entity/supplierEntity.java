package com.demo.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "suppliers")
public class supplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100)
    @NotBlank
    @Size(min = 10, max = 100)
    private String name;

    @Column(name = "email", length = 255, unique = true)
    @NotBlank
    @Size(min = 20, max = 255)
    @JsonProperty(access = Access.WRITE_ONLY)
    private String email;

    @Column(name = "address", length = 255)
    @NotBlank
    private String address;

    @Column(name = "telephone", length = 11, unique = true)
    @NotBlank
    @JsonProperty(access = Access.WRITE_ONLY)
    private String telephone;

    @Column(name = "cnpjcpf", length = 14, unique = true)
    @NotBlank
    @JsonProperty(access = Access.WRITE_ONLY)
    private String cnpjcpf;

    @Column(name = "corporatereason", length = 255)
    @NotBlank
    @Size(min = 12, max = 255)
    private String corporatereason;

    public supplierEntity() {}

    public supplierEntity(Long id, String name, String email, String address, String telephone, String cnpjcpf, String corporatereason) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.cnpjcpf = cnpjcpf;
        this.corporatereason = corporatereason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCnpjCpf() {
        return cnpjcpf;
    }

    public void setCnpjCpf(String cnpjcpf) {
        this.cnpjcpf = cnpjcpf;
    }

    public String getCorporateReason() {
        return corporatereason;
    }

    public void setCorporateReason(String corporatereason) {
        this.corporatereason = corporatereason;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
        result = prime * result + ((cnpjcpf == null) ? 0 : cnpjcpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        supplierEntity other = (supplierEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (telephone == null) {
            if (other.telephone != null)
                return false;
        } else if (!telephone.equals(other.telephone))
            return false;
        if (cnpjcpf == null) {
            if (other.cnpjcpf != null)
                return false;
        } else if (!cnpjcpf.equals(other.cnpjcpf))
            return false;
        return true;
    }
}