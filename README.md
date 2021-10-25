# Warehouse-Service-6093
### POST /api/warehouse/income
Регистрирует приход товара на склад
Параметры запроса:
* UUID id - идентификатор товара
* Integer amount - количесиво товара

### POST /api/warehouse/outcome
Регистрирует отход товара со склада
Параметры запроса:
* UUID id - идентификатор товара
* Integer amount - количесиво товара

### POST /api/warehouse/book
Регистрирует резерв товара на складе
Параметры запроса:
* UUID id - идентификатор товара
* Integer amount - количесиво товара

### POST /api/warehouse/unbook
Регистрирует снятие резерва товара на складе
Параметры запроса:
* UUID id - идентификатор товара
* Integer amount - количесиво товара

### POST /api/warehouse/addItem
Добавляет товар в список товаров
Параметры запроса:
* String title - название товара
* String description - описание товара
* Integer price - цена товара

### GET /api/warehouse/getItems
Возвращает список товаров

### GET /api/warehouse/getItem
Возвращает товар
Параметры запроса в URL:
UUID id - идентификатор товара

### GET /api/warehouse/getItemQuantity
Возвращает количество товара на складе
Параметры запроса в URL:
UUID id - идентификатор товара
