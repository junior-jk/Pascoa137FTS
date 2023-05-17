##language: pt
#  Funcionalidade:  Selecionar Passagem
#    Cenário: Selecionar Passagem com Sucesso
#      Dado que acesso o site Blazedemo
#      Quando seleciono a origem como "São Paolo" e destino "Berlin"
#      E clico em  Procurar Voo
#      Então exibe a frase indicando voo entre "São Paolo" e Berlin


Feature: Selecionar Passagem

  Scenario: Selecionar Passagem de "San Diego" para "Berlin"
    Given que acesso a pagina inicial
    When seleciono origem "San Diego" e destino "Berlin"
    And clico no botao Find Flights
    Then exibe pagina de voos entre "San Diego" e "Berlin" disponiveis