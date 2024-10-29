/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "PessoasFisicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoasFisicas.findAll", query = "SELECT p FROM PessoasFisicas p"),
    @NamedQuery(name = "PessoasFisicas.findByPessoasIDPessoa", query = "SELECT p FROM PessoasFisicas p WHERE p.pessoasIDPessoa = :pessoasIDPessoa"),
    @NamedQuery(name = "PessoasFisicas.findByCpf", query = "SELECT p FROM PessoasFisicas p WHERE p.cpf = :cpf")})
public class PessoasFisicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pessoas_IDPessoa")
    private Integer pessoasIDPessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CPF")
    private String cpf;
    @JoinColumn(name = "Pessoas_IDPessoa", referencedColumnName = "IDPessoa", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoas pessoas;

    public PessoasFisicas() {
    }

    public PessoasFisicas(Integer pessoasIDPessoa) {
        this.pessoasIDPessoa = pessoasIDPessoa;
    }

    public PessoasFisicas(Integer pessoasIDPessoa, String cpf) {
        this.pessoasIDPessoa = pessoasIDPessoa;
        this.cpf = cpf;
    }

    public Integer getPessoasIDPessoa() {
        return pessoasIDPessoa;
    }

    public void setPessoasIDPessoa(Integer pessoasIDPessoa) {
        this.pessoasIDPessoa = pessoasIDPessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoas getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoasIDPessoa != null ? pessoasIDPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoasFisicas)) {
            return false;
        }
        PessoasFisicas other = (PessoasFisicas) object;
        if ((this.pessoasIDPessoa == null && other.pessoasIDPessoa != null) || (this.pessoasIDPessoa != null && !this.pessoasIDPessoa.equals(other.pessoasIDPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.PessoasFisicas[ pessoasIDPessoa=" + pessoasIDPessoa + " ]";
    }
    
}
