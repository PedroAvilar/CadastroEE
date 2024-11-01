/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "Produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByIDProduto", query = "SELECT p FROM Produtos p WHERE p.iDProduto = :iDProduto"),
    @NamedQuery(name = "Produtos.findByNomeProduto", query = "SELECT p FROM Produtos p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Produtos.findByQuantidadeProduto", query = "SELECT p FROM Produtos p WHERE p.quantidadeProduto = :quantidadeProduto"),
    @NamedQuery(name = "Produtos.findByPrecoVendaBase", query = "SELECT p FROM Produtos p WHERE p.precoVendaBase = :precoVendaBase")})
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDProduto")
    private Integer iDProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NomeProduto")
    private String nomeProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QuantidadeProduto")
    private int quantidadeProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecoVendaBase")
    private Float precoVendaBase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtosIDProduto")
    private Collection<Movimentos> movimentosCollection;

    public Produtos() {
    }

    public Produtos(Integer iDProduto) {
        this.iDProduto = iDProduto;
    }

    public Produtos(Integer iDProduto, String nomeProduto, int quantidadeProduto, Float precoVendaBase) {
        this.iDProduto = iDProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoVendaBase = precoVendaBase;
    }

    public Integer getIDProduto() {
        return iDProduto;
    }

    public void setIDProduto(Integer iDProduto) {
        this.iDProduto = iDProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Float getPrecoVendaBase() {
        return precoVendaBase;
    }

    public void setPrecoVendaBase(Float precoVendaBase) {
        this.precoVendaBase = precoVendaBase;
    }

    @XmlTransient
    public Collection<Movimentos> getMovimentosCollection() {
        return movimentosCollection;
    }

    public void setMovimentosCollection(Collection<Movimentos> movimentosCollection) {
        this.movimentosCollection = movimentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProduto != null ? iDProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.iDProduto == null && other.iDProduto != null) || (this.iDProduto != null && !this.iDProduto.equals(other.iDProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Produtos[ iDProduto=" + iDProduto + " ]";
    }
    
}
