package indexer.item.infrastructure.injector;

import indexer.item.application.GetItems.GetItemsUseCase;

final public class ItemApplicationInjector {

    public static GetItemsUseCase injectGetItemsUseCase() {
        return new GetItemsUseCase(
            ItemInfrastructureInjector.injectItemRepository(),
                ItemInfrastructureInjector.injectItemTransformer()
        );
    }
}
