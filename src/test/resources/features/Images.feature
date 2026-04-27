@smoke @contract @images @epic:BDD
Feature: BDD - Images

  @get-image-by-breed
  Scenario Outline: Deve listar imagens de uma raça específica com sucesso
    Given que tenho a raça "<BREED>" para consulta
    When enviar uma requisição GET para listar uma imagem por raça
    Then deve retornar status code 200
    And a resposta deve conter o status "success"
    And a resposta deve seguir o contrato "schemas/breed-images-schema.json"
    And todas as imagens retornadas devem ser URLs válidas
    And a lista de imagens deve conter pelo menos um item
    And o tempo de resposta deve ser menor que 5 segundos

    Examples:
      | BREED       |
      | akita       |
      | appenzeller |

  @get-image-by-breed-negative
  Scenario Outline: Deve retornar erro ao buscar imagens de uma raça inválida
    Given que tenho a raça "<BREED>" para consulta
    When enviar uma requisição GET para listar uma imagem por raça
    Then deve retornar status code <STATUS_CODE>
    And a resposta deve conter o status "error"

    Examples:
      | BREED      | STATUS_CODE |
      | nao_existe | 404         |

  @get-random-image
  Scenario: Deve retornar uma imagem aleatória de cachorro com sucesso
    When enviar uma requisição GET para listar uma imagem aleatória
    Then deve retornar status code 200
    And a resposta deve conter o status "success"
    And a resposta deve seguir o contrato "schemas/random-image-schema.json"
    And a resposta deve conter uma URL de imagem válida
    And o tempo de resposta deve ser menor que 5 segundos


