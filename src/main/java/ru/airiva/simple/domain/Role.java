package ru.airiva.simple.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@SequenceGenerator(name = "role_gen", sequenceName = "role_seq", allocationSize = 1)
public class Role {

  @Id
  @GeneratedValue(generator = "role_gen", strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "role_name", nullable = false, unique = true, length = 50)
  @Enumerated(EnumType.STRING)
  private SimpleRole roleName;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "role_authority",
    joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
  )
  private Set<Authority> authorities;

}
