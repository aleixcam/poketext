package item.infrastructure.transformer.Matrix;

import common.infrastructure.transformer.MatrixTransformer;
import item.domain.Item;
import item.application.ItemTransformer;
import item.domain.ItemsCollection;

import java.util.ArrayList;

final public class ItemTransformerImpl extends MatrixTransformer implements ItemTransformer {

    public String[][] assemble(ItemsCollection collection) {
        ArrayList<Item> items = collection.getItems();
        String[] columns = {"ID", "Name", "Description"};
        String[][] matrix = new String[items.size() + 1][columns.length];

        matrix[0] = columns;
        for (int i = 0; i < items.size(); i++) {
            matrix[i+1][0] = String.valueOf(items.get(i).getId());
            matrix[i+1][1] = items.get(i).getName();
            matrix[i+1][2] = items.get(i).getDescription();
        }

        return generate(matrix);
    }
}
