package PROJETO_01.database.Contract;

import PROJETO_01.database.Entity.ProdutoEntity;

public class ProdutoContract {

    private ProdutoContract(){}

    public static final String criarTabela(){
        return "CREATE TABLE" + ProdutoEntity.TABLE_NAME + "( +" +
                ProdutoEntity._ID + "INTEGER PRIMARY KEY, " +
                ProdutoEntity.COLUNN_NAME_NAME + "TEXT," +
                ProdutoEntity.COLUNN_NAME_VALOR + "REAL)";
    }

    public static final String removerTabela(){
        return "DROP TABLE IF EXISTS" + ProdutoEntity.TABLE_NAME;
    }
}
