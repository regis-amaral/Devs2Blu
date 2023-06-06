CREATE OR REPLACE PROCEDURE exemplo_procedure(parametro INT)
LANGUAGE plpgsql
AS $$
BEGIN
    --Lógica da procedure aqui
    RAISE NOTICE 'O valor do parametro é: % ', parametro;
END;
$$;

call exemplo_procedure(10);

CREATE OR REPLACE PROCEDURE calcularMaxPessoasMesas()
LANGUAGE plpgsql
AS $$
DECLARE
    qtdPessoas SMALLINT;
BEGIN
    qtdPessoas := (SELECT quantidadeMaximaPessoas from mesa where id = 1);
    CALL exemplo_procedure(qtdPessoas);
END;
$$;

CALL calcularMaxPessoasMesas();