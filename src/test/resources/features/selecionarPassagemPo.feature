Feature:  Selecionar Passagem
  Scenario: Selecionar Passsagem com Sucesso PO
    Given que acesso a pagina inicial PO
    When seleciono origem "São Paolo" e destino "Berlim" PO
    When clico no botao Find Flights PO
    Then exibe pagina de voos entre origem e destino disponiveis PO