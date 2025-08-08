package com.wf.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "advisor")
public class FinancialAdvisor {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long advisorId;

  @Column(nullable = false) private String firstName;
  @Column(nullable = false) private String lastName;
  @Column private String address;
  @Column private String phone;
  @Column(nullable = false, unique = true) private String email;

  @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Client> clients = new ArrayList<>();

  // JPA needs a no-args constructor
  protected FinancialAdvisor() {}

  // Required constructor initializing all fields (except id which is auto-gen)
  public FinancialAdvisor(String firstName, String lastName, String address,
                          String phone, String email) {
    this.firstName = firstName;
    this.lastName  = lastName;
    this.address   = address;
    this.phone     = phone;
    this.email     = email;
  }

  // Getters/setters (omit setter for id)
  public Long getAdvisorId() { return advisorId; }
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
  public List<Client> getClients() { return clients; }
  public void setClients(List<Client> v) { this.clients = v; }
}