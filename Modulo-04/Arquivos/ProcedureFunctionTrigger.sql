-- FUNCTION
CREATE OR REPLACE FUNCTION calcularValorTotalComandaProduto()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
DECLARE
    valorProduto float8;
    valorTotalComandaProduto float8;
BEGIN
    valorProduto := (SELECT precoVenda FROM produto WHERE produto.id = NEW.produtoId);
    valorTotalComandaProduto := (valorProduto * NEW.quantidade);
    NEW.valortotal := valorTotalComandaProduto;
    RETURN NEW;
END;
$$;

-- TRIGGER
CREATE OR REPLACE TRIGGER atualizaValorTotalComandaProduto
BEFORE INSERT OR UPDATE ON comandaProduto
FOR EACH ROW
EXECUTE FUNCTION calcularValorTotalComandaProduto();



INSERT INTO comandaproduto (
                            comandaid,
                            produtoid, 
                            statuscomandaprodutoid,
                            quantidade, 
                            valortotal, 
                            criadoem, 
                            criadopor, 
                            alteradoem, 
                            alteradopor
                            )
                      values(
                            5,
                            10,
                            2,
                            2,
                            0,
                            now(),
                            'Admin',
                            now(),
                            'Admin'
                            );

SELECT * from comandaproduto ORDER BY comandaproduto.id DESC limit 1;


