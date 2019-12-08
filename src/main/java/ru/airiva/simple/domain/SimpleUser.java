package ru.airiva.simple.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "simple_user")
@SequenceGenerator(name = "simple_user_gen", sequenceName = "simple_user_seq", allocationSize = 1)
public class SimpleUser {

  @Id
  @GeneratedValue(generator = "simple_user_gen", strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password")
  private String password;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "simple_user_authority",
    joinColumns = @JoinColumn(name = "simple_user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
  )
  private Set<Authority> authorities;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "simple_user_role",
    joinColumns = @JoinColumn(name = "simple_user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
  )
  private Set<Role> roles;

}
