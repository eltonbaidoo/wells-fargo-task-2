package com.wf.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "portfolio",
       uniqueConstraints = @UniqueConstraint(name="uq_portfolio_client", columnNames="client_id"))
public class Portfolio {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long portfolioId;

  @OneToOne
  @JoinColumn(name = "client_id", nullable = false, unique = true)
  private Client client;

  @Column(nullable = false)
  private LocalDate creationDate;

  @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Security> securities = new ArrayList<>();

  protected Portfolio() {}

  public Portfolio(Client client, LocalDate creationDate) {
    this.client = client;
    this.creationDate = creationDate;
  }

  public Long getPortfolioId() { return portfolioId; }
  public Client getClient() { return client; }
  public void setClient(Client v) { this.client = v; }
  public LocalDate getCreationDate() { return creationDate; }
  public void setCreationDate(LocalDate v) { this.creationDate = v; }
  public List<Security> getSecurities() { return securities; }
  public void setSecurities(List<Security> v) { this.securities = v; }
}