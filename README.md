# MC322-2026 / Projeto
# Repositório para MC322, Unicamp, 2026 de Arthur Midon (247271) e Gabriel Castro (280869)

## Bem vindo ao Shrek 2077: a volta dos que não foram!!!

## Como rodar o jogo:

- Pelo terminal:
    - navegue até o endereço: ~/MC322-2026
    - digite: ./gradlew run 
- Pelo VSCode
   - abra o arquivo App.java
   - selecine "Run main" abaixo de "public class App"

## Inicie o jogo:

- Insira o nome do seu jogador
- Selecione sua próxima ação
- A cada ação, um mapa é gerado com suas escolhas

## O objetivo e suas escolhas:

- Você deve derrotar os 3 invasores para ganhar: A Dragão, a Morte e o Burro
- Você pode escolher em qual ordem irá enfrentá-los
- Além dos combates, você pode escolher à qualquer momento tomar um banho (recupera a vida) ou se aquecer (desbloqueia uma carta nova)

## A economia:

- O jogo possui 3 recursos que você precisa gerenciar:
   - Vida: quando ela chega à zero, o combatente é derrotado. Tome um banho para recuperá-la;
   - Escudo: toda rodada os combatentes começam com o escudo zerado. Crie escudos para evitar receber dano à vida;
   - Energia: toda rodada você começa com 5 de energia. Usar cartas gasta energia. Quando sua energia chega à zero, seu turno acaba. Caso não consiga mais usar nenhuma carta com a energia que possui, você pode encerrar sua rodada com a opção [0].

## As cartas:

- Cartas de Dano: causam dano ao inimigo. Existem 3 tipos. Quanto maior o custo, mais dano inflingem;
- Cartas de Escudo: levantam escudo ao jogador. Existem 3 tipos. Quanto maior o custo, mais escudo levantam;
- Cartas de Efeito: jogam um efeito em você (se for positivo) ou em seu inimigo (se for negativo). Existem 2 efeitos:
   - Força: aumenta o dano base (todos os ataques ficam mais fortes)
   - Fraqueza: diminui o dano base (todos os ataques ficam mais fracos)
   - Efeitos duram 3 rodadas. Eles podem se acumular, cada acúmulo faz o efeito ser mais forte e durar mais 2 rodadas
- Cartas podem fazer mais de uma coisa (dar dano e levantar escudo, ou jogar 2 efeitos) 
- Ao se aquecer e ganhar batalhas você desbloqueia cartas novas

## Seus inimigos:

- Cada oponente tem características diferentes, variando sua vida, dano base ou ambos
- Todos os inimigos agem da mesma forma. Toda rodada, os inimigos escolhem aleatoriamente uma ação para realizar 
- Dica: No começo da cada rodada você é avisado de qual será a ação de seu inimigo
