package item.infrastructure.transformer.Matrix;

import shared.domain.MatrixService;
import item.domain.Item;
import item.application.ItemTransformer;
import item.domain.ItemsCollection;

import java.util.ArrayList;

final public class ItemTransformerImpl implements ItemTransformer {

    private final String[] COLUMNS = {"ID", "Name", "Description"};

    private final MatrixService matrixService;

    public ItemTransformerImpl(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public String[][] assemble(ItemsCollection collection) {
        ArrayList<Item> items = collection.getItems();
        String[][] matrix = matrixService.generate(COLUMNS, items.size());

        for (int i = 0; i < items.size(); i++) {
            matrix[i+1][0] = String.valueOf(items.get(i).getId());
            matrix[i+1][1] = items.get(i).getName();
            matrix[i+1][2] = items.get(i).getDescription();
        }

        return matrixService.beautify(matrix);
    }
}
