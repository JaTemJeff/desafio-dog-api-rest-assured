@all @breeds @smoke @contract
Feature: List all breeds - Deve listar todas as raças de cães

  @list-all-breeds
  Scenario: Listar todas as raças de cachorro com sucesso
    Given a api "/breeds/list/all" está disponível
    When enviar uma requisição GET para
    Then deve retornar status code 200
    And a resposta deve conter o status "success"
    And a resposta deve seguir o contrato definido
    And os nomes das raças devem estar em minúsculas
    And todas as sub-raças devem ser listas
    And o tempo de resposta deve ser menor que 2 segundos
    And a lista de raças deve conter pelo menos um item

