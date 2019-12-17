# AppClient (Model-View-Presenter)

## O que é?

Este é um app para estudar desenvolvimento Android e o Design Pattern  de Model-View-Presenter (MVP).

## Para que é?

Estou aprendendo estas tecnologias no trabalho. Isto serve para que eu possa estudar as mesmas. Não só no front-end de MVP, mas no back-end também.

## TO-DO

- [x] Criar lista com cards que retornam nome, sobrenome, cpf e idade
- [x] Fazer com que, ao clicar no button, eu retorne uma nova activity com detalhes da pessoa selecionada
  - [x] Criar novo método no `Repository` 
  - [x] Criar nova `Activity` para retornar as informações do usuário (chamaremos de `DetailsActivity`)
  - [x] Criar novo `Presenter` para a `Activity` (chamaremos de `DetailsPresenter`)
  - [x] Criar novo `Service` para a `Activity`  (chamaremos de `DetailsService`)
  - [x] Criar novo `Callback` para  a`Activity` (chamaremos de `DetailsActivityCallback`)
- [ ] Retornar, da Activity de detalhes pra Activity principal, o state que a tela principal estava antes de entrar na tela de detalhes.