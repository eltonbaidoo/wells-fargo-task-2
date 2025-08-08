package com.wf.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "security",
       indexes = @Index(name="ix_security_portfolio", columnList="portfolio_id"))
public class Security {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long securityId;

  @ManyToOne(optional = false)
  @JoinColumn(name = "portfolio_id", nullable = false)
  private Portfolio portfolio;

  @Column(nullable = false) private String name;
  @Column(nullable = false) private String category;
  @Column(nullable = false) private LocalDate purchaseDate;
  @Column(nullable = false, precision = 19, scale = 4) private BigDecimal purchasePrice;
  @Column(nullable = false, precision = 19, scale = 4) private BigDecimal quantity;

  protected Security() {}

  public Security(Portfolio portfolio, String name, String category,
                  LocalDate purchaseDate, BigDecimal purchasePrice, BigDecimal quantity) {
    this.portfolio = portfolio;
    this.name = name;
    this.category = category;
    this.purchaseDate = purchaseDate;
    this.purchasePrice = purchasePrice;
    this.quantity = quantity;
  }

  public Long getSecurityId() { return securityId; }
  public Portfolio getPortfolio() { return portfolio; }
  public void setPortfolio(Portfolio v) { this.portfolio = v; }
  public String getName() { return name; }
  public void setName(String v) { this.name = v; }
  public String getCategory() { return category; }
  public void setCategory(String v) { this.category = v; }
  public LocalDate getPurchaseDate() { return purchaseDate; }
  public void setPurchaseDate(LocalDate v) { this.purchaseDate = v; }
  public BigDecimal getPurchasePrice() { return purchasePrice; }
  public void setPurchasePrice(BigDecimal v) { this.purchasePrice = v; }
  public BigDecimal getQuantity() { return quantity; }
  public void setQuantity(BigDecimal v) { this.quantity = v; }
}