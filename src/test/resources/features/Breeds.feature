@smoke @contract @breeds
Feature: BDD - Breeds

  @list-all-breeds
  Scenario: Deve listar todas as raças de cachorro com sucesso
    When enviar uma requisição GET para listar todas as raças
    Then deve retornar status code 200
    And a resposta deve conter o status "success"
    And a resposta deve seguir o contrato "schemas/breeds-schema.json"
    And os nomes das raças devem estar em minúsculas
    And todas as sub-raças devem ser listas
    And o tempo de resposta deve ser menor que 5 segundos
    And a lista de raças deve conter pelo menos um item


