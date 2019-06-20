package item.application;

import item.application.GetItems.GetItemsUseCase;
import item.infrastructure.ItemInfrastructureInjector;

final public class ItemApplicationInjector {

    public static GetItemsUseCase injectGetItemsUseCase() {
        return new GetItemsUseCase(
            ItemInfrastructureInjector.injectItemRepository(),
                ItemInfrastructureInjector.injectItemTransformer()
        );
    }
}
