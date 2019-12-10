# AppClient (Model-View-Presenter)

## O que é?

Este é um app para estudar desenvolvimento Android e o Design Pattern  de Model-View-Presenter (MVP).

## Para que é?

Estou aprendendo estas tecnologias no trabalho. Isto serve para que eu possa estudar as mesmas. Não só no front-end de MVP, mas no back-end também.

## TO-DO

- [x] Criar lista com cards que retornam nome, sobrenome, cpf e idade

- [ ] Fazer com que, ao clicar no button, eu retorne uma nova activity com detalhes da pessoa selecionada
  - [ ] Criar novo método no `Repository` 
  - [ ] Criar nova `Activity` para retornar as informações do usuário (chamaremos de `DetailsActivity`)
  - [ ] Criar novo `Presenter` para a `Activity` (chamaremos de `DetailsPresenter`)
  - [ ] Criar novo `Service` para a `Activity`  (chamaremos de `DetailsService`)
  - [ ] Criar novo `Callback` para  a`Activity` (chamaremos de `DetailsActivityCallback`)