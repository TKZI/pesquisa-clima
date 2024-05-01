alter table pergunta add constraint fk_pergunta_pesquisa
foreign key(pesquisa_id) references pesquisa(id);

alter table resposta add constraint fk_resposta_pergunta
foreign key(pergunta_id) references pergunta(id);

alter table resposta add constraint fk_resposta_funcionario
foreign key(funcionario_id) references funcionario(id);