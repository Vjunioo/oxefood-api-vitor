package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Endereco;
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
    private String nome;

    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    @CPF
    private String cpf;

    private String rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank(message = "O Fone Celular é de preenchimento obrigatório")
    @Length(min = 8, max = 20, message = "O Fone Celular tem que ter entre {min} e {max} caracteres")
    private String foneCelular;

    @Length(max = 20, message = "O Fone Fixo deverá ter no máximo {max} caracteres")
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