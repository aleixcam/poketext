package indexer.item.infrastructure.transformer.Matrix;

import shared.domain.MatrixService;
import indexer.item.domain.Item;
import indexer.item.application.ItemTransformer;
import indexer.item.domain.ItemsCollection;

import java.util.ArrayList;

final public class ItemTransformerImpl implements ItemTransformer<String[][]> {

    private final String[] COLUMNS = {"ID", "Name", "Description"};

    private final MatrixService matrixService;

    public ItemTransformerImpl(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public String[][] transform(ItemsCollection collection) {
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
