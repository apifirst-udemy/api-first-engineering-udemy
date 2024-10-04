

# Build
# mvn clean install

# Full build + tests
# mvn test-compile -f "/workspaces/api-first-engineering-udemy/src/pom.xml"

# Start the server
# mvn spring-boot:run -f "./src/apifirst-server/pom.xml"

# Customers
curl -s  localhost:8080/v1/customers | jq .
curl -s  localhost:8080/v1/customers/636fd29c-f92a-4aca-b3e8-7f673b40d8d9 | jq .

# Products
curl -s  localhost:8080/v1/products | jq .[].id
curl -s  localhost:8080/v1/products/58cf8dd5-848d-4cfd-8ae9-97ea521175ce | jq .

# Orders
curl -s  localhost:8080/v1/orders | jq .[].id
curl -s  localhost:8080/v1/orders/73cf38e6-89a7-4859-a34f-52f0f2b48993 | jq .

