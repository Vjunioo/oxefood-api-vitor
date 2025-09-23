package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import br.com.ifpe.oxefood.modelo.entregador.Endereco;
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String foneCelular;
    private String foneFixo;

   
    private Integer qtdEntregasRealizadas;
    private Double valorFrete;

    
    private Endereco endereco;

    public Entregador build() {
        return Entregador.builder()
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .dataNascimento(dataNascimento)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .qtdEntregasRealizadas(qtdEntregasRealizadas)
                .valorFrete(valorFrete)
                .endereco(endereco) 
                .build();
    }
}