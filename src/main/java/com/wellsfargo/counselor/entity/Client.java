package com.wf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "client",
       indexes = @Index(name="ix_client_advisor", columnList="advisor_id"))
public class Client {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long clientId;

  @ManyToOne(optional = false)
  @JoinColumn(name = "advisor_id", nullable = false)
  private FinancialAdvisor advisor;

  @Column(nullable = false) private String firstName;
  @Column(nullable = false) private String lastName;
  @Column private String address;
  @Column private String phone;
  @Column private String email;

  @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
  private Portfolio portfolio;

  protected Client() {}

  public Client(FinancialAdvisor advisor, String firstName, String lastName,
                String address, String phone, String email) {
    this.advisor   = advisor;
    this.firstName = firstName;
    this.lastName  = lastName;
    this.address   = address;
    this.phone     = phone;
    this.email     = email;
  }

  public Long getClientId() { return clientId; }
  public FinancialAdvisor getAdvisor() { return advisor; }
  public void setAdvisor(FinancialAdvisor v) { this.advisor = v; }
  public String getFirstName() { return firstName; }
  public void setFirstName(String v) { this.firstName = v; }
  public String getLastName() { return lastName; }
  public void setLastName(String v) { this.lastName = v; }
  public String getAddress() { return address; }
  public void setAddress(String v) { this.address = v; }
  public String getPhone() { return phone; }
  public void setPhone(String v) { this.phone = v; }
  public String getEmail() { return email; }
  public void setEmail(String v) { this.email = v; }
  public Portfolio getPortfolio() { return portfolio; }
  public void setPortfolio(Portfolio v) { this.portfolio = v; }
}