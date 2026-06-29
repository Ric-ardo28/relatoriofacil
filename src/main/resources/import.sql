INSERT INTO tb_cliente (nome, cnpj, telefone, email, ativo) VALUES ('Empresa Alfa LTDA', '12345678000199', '(11) 99999-1111', 'contato@empresaalfa.com', true);
INSERT INTO tb_cliente (nome, cnpj, telefone, email, ativo) VALUES ('Transportes Beta LTDA', '98765432000188', '(11) 98888-2222', 'contato@transportesbeta.com', true);
INSERT INTO tb_cliente (nome, cnpj, telefone, email, ativo) VALUES ('Comercial Gama LTDA', '45678912000177', '(11) 97777-3333', 'contato@comercialgama.com', false);

INSERT INTO tb_prestadora (razao_social, nome_fantasia, cnpj, inscricao_estadual, endereco, telefone, email, ativo) VALUES ('Alpha Monitoramento LTDA', 'Alpha Monitoramento', '11222333000144', '123456789', 'Rua das Flores, 100 - São Paulo/SP', '(11) 99999-0001', 'contato@alphamonitoramento.com', true);

INSERT INTO tb_prestadora (razao_social, nome_fantasia, cnpj, inscricao_estadual, endereco, telefone, email, ativo) VALUES ('Beta Escolta Armada LTDA', 'Beta Escolta', '22333444000155', '987654321', 'Avenida Brasil, 250 - Guarulhos/SP', '(11) 99999-0002', 'contato@betaescolta.com', true);

INSERT INTO tb_prestadora (razao_social, nome_fantasia, cnpj, inscricao_estadual, endereco, telefone, email, ativo) VALUES ('Gama Rastreamento e Segurança LTDA', 'Gama Rastreamento', '33444555000166', '456789123', 'Rua São Jorge, 45 - São Paulo/SP', '(11) 99999-0003', 'contato@gamarastreamento.com', true);

INSERT INTO tb_usuario (nome, email, senha, perfil_usuario, ativo, criado_em) VALUES ('Ricardo Santana', 'ricardo@email.com', '123456', 'ADMIN', true, TIMESTAMP '2026-06-24 22:30:00');
INSERT INTO tb_usuario (nome, email, senha, perfil_usuario, ativo, criado_em) VALUES ('Operador Sistema', 'operador@email.com', '123456', 'OPERADOR', true, TIMESTAMP '2026-06-24 22:31:00');
INSERT INTO tb_usuario (nome, email, senha, perfil_usuario, ativo, criado_em) VALUES ('Administrador Relatorio Facil', 'admin@relatoriofacil.com', 'admin123', 'ADMIN', true, TIMESTAMP '2026-06-24 22:32:00');