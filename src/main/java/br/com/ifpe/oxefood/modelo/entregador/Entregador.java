package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel {
    
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column
    private String rg;
    
    @Column
    private LocalDate dataNascimento;
    
    @Column(nullable = false, length = 20)
    private String foneCelular;
    
    @Column(length = 20)
    private String foneFixo;

    @Column
    private Integer qtdEntregasRealizadas;
    
    @Column
    private Double valorFrete;

    @Embedded 
    private Endereco endereco;
}