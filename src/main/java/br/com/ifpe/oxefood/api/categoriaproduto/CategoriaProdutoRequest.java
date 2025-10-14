package br.com.ifpe.oxefood.api.categoriaproduto;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProduto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

    @NotBlank(message = "A descrição é de preenchimento obrigatório")
    @Length(max = 100, message = "A descrição deverá ter no máximo {max} caracteres")
    private String descricao;

    public CategoriaProduto build() {
        return CategoriaProduto.builder()
                .descricao(descricao)
                .build();
    }
}