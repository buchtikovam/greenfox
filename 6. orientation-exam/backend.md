# Green Fox Fashion Web Store

Build a webshop that people can use to order some merchandise from the Green Fox
store.

## Highlights

### It has a frontend page which can:

  - lists all items
  - summary page of the basket

### It has a backend which can:

  - list all the items
  - process selected items from form
  - list selected items
  - filter items by query paramaters
  - delete an item by id and payload

## Database

There are two tables, one is "manufacturer" and another is "item".
In this application, item can have only one manufacturer, but manufacturer can
have more items assigned.

- Manufacturer:
  - id, name

- Item:
  - id, name, category, size, unit_price, manufacturer_id

## Endpoints

Create the following endpoints:

## Endpoints

### GET `/shoppingplanner`
- The endpoint should render an HTML displaying
  the full list of clothes(explained above)

![main](assets/backend-main.png)
  - a heading with the title of the site
  - drop-down list with all unique name options
  - drop-down list with all unique size options
  - input field to set the quantity of clothes
  - a GET TOTAL button which redirects to the `Summary` page
  - list the clothing items from the database in table


### POST `/shoppingplanner/summary`

- this endpoint should receive all the information of the selected item
- redirect to another HTML page  `/shoppingplanner/summary` after receiving
the data.
- process the input data so the output will contain:
  - item name
  - manufacturer
  - category
  - quantity
  - sub-total price of the item (based on the number of selected items)

- Note: this summary data aren't saved into the database

### GET `/shoppingplanner/summary`

![summary](assets/backend-summary-page.png)

The page displays:
  - a heading with the title of the page
  - a link back to the main page
  - selected item with the properties:
    - Item name
    - Manufacturer
    - Category
    - Quantity
    - Sub-total price

### GET `/shoppingplanner/query`

- this endpoint should return all the clothes which has **higher/lower/equal**
price than the given parameter

Example query:

`http://localhost:8080/shoppingplanner/query?price=50&type=lower`

- this should return a DTO in json format with every cloth where
the unit price is lower than 50:

```json
{
    "result": "ok",
    "clothes":
    [
        {
            "id": 21,
            "item_name": "Strecth Steamed Pencil Skirt",
            "manufacturer": "Calvin Klein",
            "category": "skirts",
            "size": "s",
            "unit_price": 39.0
        },
        {
            "id": 24,
            "item_name": "Strecth Steamed Pencil Skirt",
            "manufacturer": "Calvin Klein",
            "category": "skirts",
            "size": "m",
            "unit_price": 39.0
        }
    ]
}
```

In the case of empty list it should return:

```json
{
    "result": "no clothes available",
    "clothes": []
}
```

### DELETE `/api/item/{id}`

This endpoint delete the item based on its id and payload.
Payload must contain correct manufacturer name of the item.
In case of incorrect id or manufacturer name, return an error message.

- example uri: /item/1
- payload:
```json
{
    "manufacturer":"Gucci"
}
```
- this should return 200.
- example error message:
```json
{
    "error-message":"Incorrect provided data"
}
```
- this should return 404



## Question

Given the following table named `carsForSale`

| carForSaleID | manufacturerName | modelName | acquisitionPrice | dataAcquired |
|:------------:|:----------------:|:---------:|:----------------:|:------------:|
|      1       |    Volkswagen    |   Jetta   |      13300       |  2007-01-07  |
|      2       |     Renault      |  Laguna   |      14700       |  2007-02-12  |
|      3       |       Ford       |   Focus   |      13600       |  2007-03-09  |
|      4       |      Daewoo      |   Tico    |       1100       |  2007-04-17  |
|      5       |      Toyota      |  Avensis  |      14500       |  2007-05-04  |
|      6       |    Alfa Romeo    |    156    |       8700       |  2007-06-23  |
|      7       |    Volkswagen    |  Passat   |      22000       |  2007-07-16  |
|      8       |     Renault      |   Clio    |       6400       |  2007-08-22  |
|      9       |       Ford       |  Fiesta   |       6900       |  2007-09-11  |
|      10      |      Daewoo      |   Cielo   |       3600       |  2007-10-18  |
|      11      |      Toyota      |   Rav4    |      24900       |  2007-11-11  |
|      12      |    Alfa Romeo    |    147    |       7500       |  2007-12-25  |
|      13      |    Volkswaen     |   Golf    |      16700       |  2008-01-14  |
|      14      |     Renault      |  Megane   |      11400       |  2008-02-24  |
|      15      |       Ford       |  Mondeo   |      14600       |  2008-03-18  |
|      16      |      Daewoo      |   Matiz   |       1700       |  2008-04-08  |
|      17      |      Toyota      |   Yaris   |       7400       |  2008-05-02  |
|      18      |    Alfa Romeo    |    159    |      17000       |  2008-06-12  |
|      19      |    Volkswagen    |   Polo    |       6500       |  2008-07-30  |
|      20      |     Renault      |  Scenic   |       6800       |  2008-08-11  |
|      21      |       Ford       |  Escort   |       2000       |  2008-09-22  |
|      22      |      Daewoo      |  Espero   |       2500       |  2008-10-09  |
|      23      |      Toyota      |  Corolla  |      103000      |  2008-11-05  |
|      24      |    Alfa Romeo    |    166    |       5200       |  2008-12-24  |

- Write an SQL query to get all `Renault` cars which are more expensive than
  8000

```sql

```

- Write an SQL query to decrease all `Volkswagen` car's price by 100 units
  
```sql

```

- Find the total number of cars acquired in each month of 2007.

```sql

```

- Find out the month and year which had cars acquired with an average price greater than $10,000.

```sql

```
  
