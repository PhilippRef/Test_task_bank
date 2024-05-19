Use MySQL for DB.

Postman:
Get all products and rules:
GET: http://localhost:8080/api/products

Get all rules by the product:
GET: http://localhost:8080/api/products/{id}/rules

Delete the rule in the product: 
DELETE: http://localhost:8080/api/products/{id}/rules/{id}

Add rule for product:
POST: http://localhost:8080/api/products/{id}/rules
Example:
{
"name": "second_rule_for_first_product",
"minSalary": 100,
"maxSalary": 200,
"productDB": "first_product",
"active": true
}

Get product by borrower:
POST: http://localhost:8080/api/products/apply
Example:
{
"salary": 60000,
"claim": 300000,
"debtor": false
}