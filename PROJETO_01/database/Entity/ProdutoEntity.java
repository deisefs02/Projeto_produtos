package PROJETO_01.database.Entity;

import android.provider.BaseColumns;


public final class ProdutoEntity implements BaseColumns {

    private ProdutoEntity(){

    }
    public static final String TABLE_NAME = "produto";
    public static final String COLUNN_NAME_NAME = "nome";
    public static final  String COLUNN_NAME_VALOR = "valor";
}
