1. O Caixa Eletrônico (Saque Blindado)
O Cenário: Você está programando a lógica de um caixa eletrônico. O sistema recebe um pedido de saque e deve verificar se o cliente tem saldo e se o caixa possui cédulas suficientes.

A Regra: O sistema deve subtrair o valor do saldo apenas se houver notas disponíveis na máquina.

Uso Obrigatório de Exceções:

Se o usuário pedir R$ 100,00 mas só tiver R$ 80,00, o sistema deve disparar um erro de Saldo Insuficiente.

Se o usuário tiver saldo, mas o caixa estiver sem notas de R$ 10,00 para completar o valor, deve disparar um erro de Falta de Cédulas.

O Desafio Técnico: Garanta que, se faltar nota no meio do processo, o saldo que já foi "reservado" volte para a conta do cliente imediatamente (no tratamento do erro).
