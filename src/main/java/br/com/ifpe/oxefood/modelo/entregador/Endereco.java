package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable 
public class Endereco {

    @Column
    private String rua;

    @Column
    private String numero;

    @Column
    private String bairro;
    
    @Column
    private String cidade;

    @Column
    private String cep;
    
    @Column
    private String uf;

    @Column
    private String complemento;
}