package PROJETO_01.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import PROJETO_01.database.Entity.ProdutoEntity;
import PROJETO_01.modelo.Produto;

public class ProdutoDAO {

    private final String SQL_LISTAR_TODOS = "SELECT * FROM " + ProdutoEntity.TABLE_NAME;
    private final DBGateway dbGateway;

    public ProdutoDAO(Context context){
        dbGateway = DBGateway.getInstance(context);
    }

    public boolean salvar(Produto produto) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ProdutoEntity.COLUNN_NAME_NAME, produto.getNome());
        contentValues.put(ProdutoEntity.COLUNN_NAME_VALOR, produto.getValor());
        long id = dbGateway.getDatabase().insert(ProdutoEntity.TABLE_NAME, null, contentValues);
        return id>0;
    }

    public List<Produto> listar(){
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = dbGateway.getDatabase().rawQuery(SQL_LISTAR_TODOS, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(ProdutoEntity._ID));
            String nome = cursor.getString(cursor.getColumnIndex(ProdutoEntity.COLUNN_NAME_NAME));
            float valor = cursor.getFloat(cursor.getColumnIndex(ProdutoEntity.COLUNN_NAME_VALOR));
            produtos.add(new Produto(id, nome, valor));
        }
        cursor.close();
        return produtos;

    }
}
