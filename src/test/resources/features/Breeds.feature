@all @breeds @smoke @contract
Feature: List all breeds - Deve listar todas as raças de cães

  @list-all-breeds
  Scenario: Listar todas as raças de cachorro com sucesso
    When enviar uma requisição GET para listar todas as raças
    Then deve retornar status code 200
    And a resposta deve conter o status "success"
    And a resposta deve seguir o contrato "schemas/breeds-schema.json"
    And os nomes das raças devem estar em minúsculas
    And todas as sub-raças devem ser listas
    And o tempo de resposta deve ser menor que 2 segundos
    And a lista de raças deve conter pelo menos um item

  @get-image-by-breed
  Scenario Outline: Deve listar imagens de uma raça específica com sucesso
    Given que tenho a raça "<BREED>" para consulta
    When enviar uma requisição GET para listar uma imagem por raça
    Then deve retornar status code 200
    And a resposta deve conter o status "success"
    And a resposta deve seguir o contrato "schemas/breed-images-schema.json"
    And todas as imagens retornadas devem ser URLs válidas
    And a lista de imagens deve conter pelo menos um item
    And o tempo de resposta deve ser menor que 2 segundos

    Examples:
      | BREED       |
      | akita       |
      | appenzeller |

  @get-random-image
  Scenario: Deve retornar uma imagem aleatória de cachorro com sucesso
    When enviar uma requisição GET para listar uma imagem aleatória
    Then deve retornar status code 200
    And a resposta deve conter o status "success"
    And a resposta deve seguir o contrato "schemas/random-image-schema.json"
    And a resposta deve conter uma URL de imagem válida
    And o tempo de resposta deve ser menor que 2 segundos


  @get-image-by-breed
  Scenario Outline: Deve listar imagens de uma raça específica com erro
    Given que tenho a raça "<BREED>" para consulta
    When enviar uma requisição GET para listar uma imagem por raça
    Then deve retornar status code <STATUS_CODE>

    Examples:
      | BREED      | STATUS_CODE |
      |            | 404         |
      | nao_existe | 404         |

